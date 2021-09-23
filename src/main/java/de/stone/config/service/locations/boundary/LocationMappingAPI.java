package de.stone.config.service.locations.boundary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.stone.config.service.locations.control.LocationMappingRepository;
import de.stone.config.service.locations.entity.LocationMapping;
import de.stone.config.service.locations.entity.LocationMappingId;
import de.stone.config.service.routing.control.RoutingNotFoundException;

@RestController
@RequestMapping("api")
public class LocationMappingAPI {

	@Autowired
	private LocationMappingRepository repository;
	
	@GetMapping("location")
	public List<LocationMapping> getAllMappings() {
		return repository.findAll();
	}
	
	@GetMapping(value = "location/{alias}/{stage}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public LocationMapping findMapping(@PathVariable String alias, @PathVariable String stage) {
		
		return repository.findById(new LocationMappingId(alias, stage))
				.orElseThrow(() -> new RoutingNotFoundException(alias + "/" + stage));
	}
	
	@PutMapping(value = "location/{alias}/{stage}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public LocationMapping updateLocationMapping(@RequestBody LocationMapping locationMapping, @PathVariable String alias, @PathVariable String stage) {

        return repository.findById(new LocationMappingId(alias, stage))
            .map(result -> {
                result.merge(locationMapping);
                return repository.save(result);
            })
            .orElseThrow(() -> new RoutingNotFoundException(alias + "/" + stage));
    }
	
	@PostMapping(value = "location", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public LocationMapping createLocationMapping(@RequestBody LocationMapping locationMapping) {

        return repository.save(locationMapping);
    }
	
	@DeleteMapping("location/{id}")
    public void deleteMapping(@PathVariable String alias, @PathVariable String stage) {

        repository.deleteById(new LocationMappingId(alias, stage));
    }
}
