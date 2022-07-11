package ac.rca.downloaderbackend.repository;


import ac.rca.downloaderbackend.model.Website;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IWebsiteRepository extends JpaRepository<Website, UUID> {
    Optional<Website> findById(UUID WebsiteID);
}