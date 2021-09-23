package de.stone.config.service.locations.control;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.stone.config.service.locations.entity.LocationMapping;
import de.stone.config.service.locations.entity.LocationMappingId;

@Repository
public interface LocationMappingRepository extends JpaRepository<LocationMapping, LocationMappingId> {

}
