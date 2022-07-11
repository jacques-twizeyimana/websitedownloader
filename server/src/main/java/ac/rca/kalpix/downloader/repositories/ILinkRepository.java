package ac.rca.kalpix.downloader.repositories;

import ac.rca.kalpix.downloader.models.Link;
import ac.rca.kalpix.downloader.models.Website;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ILinkRepository extends JpaRepository<Link, UUID> {
    List<Link> findByWebsite(Website website);
}
