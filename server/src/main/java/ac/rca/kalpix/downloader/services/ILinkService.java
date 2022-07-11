package ac.rca.kalpix.downloader.services;

import ac.rca.kalpix.downloader.models.Link;
import ac.rca.kalpix.downloader.utils.dtos.CreateLinkDTO;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface ILinkService {

    List<Link> all();

    Link create(CreateLinkDTO course) throws IOException;

    List<Link> findByWebsite(UUID websiteId);

}
