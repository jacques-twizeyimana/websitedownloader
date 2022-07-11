package ac.rca.kalpix.downloader.utils.dtos;

import ac.rca.kalpix.downloader.models.Website;
import lombok.Data;

import java.net.URL;

@Data
public class CreateLinkDTO {

    private URL url;
    private String path;
    private Website website;
}
