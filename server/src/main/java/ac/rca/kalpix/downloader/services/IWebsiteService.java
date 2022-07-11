package ac.rca.kalpix.downloader.services;

import ac.rca.kalpix.downloader.models.Website;

import java.io.IOException;
import java.util.List;
import java.net.URL;

public interface IWebsiteService {
    List<Website> all();

    Website create(URL url) throws IOException;
}
