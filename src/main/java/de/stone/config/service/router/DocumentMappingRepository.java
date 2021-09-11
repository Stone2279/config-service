package de.stone.config.service.router;

import de.stone.config.service.entity.DocumentMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentMappingRepository extends JpaRepository<DocumentMapping, Long> {

    public List<DocumentMapping> findByDocumentName(String documentName);
}
