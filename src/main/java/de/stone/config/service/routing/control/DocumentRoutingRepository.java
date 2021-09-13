package de.stone.config.service.routing.control;

import de.stone.config.service.routing.entity.DocumentRouting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DocumentRoutingRepository extends JpaRepository<DocumentRouting, Long> {

    public Optional<List<DocumentRouting>> findByDocumentName(String documentName);
}
