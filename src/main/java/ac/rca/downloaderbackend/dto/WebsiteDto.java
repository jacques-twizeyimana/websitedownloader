package ac.rca.downloaderbackend.dto;

import java.net.MalformedURLException;
import java.net.URL;

public class WebsiteDto {
    private  String url;
    private String name;

    public WebsiteDto(String url) throws MalformedURLException {
        this.url = url;
        this.name = generateName();
    }

    public  String generateName() throws MalformedURLException {
        URL url1 = new URL(url);
        String name = url1.getHost();

        return  name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
