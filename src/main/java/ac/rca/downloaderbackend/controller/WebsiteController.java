package ac.rca.downloaderbackend.controller;

import ac.rca.downloaderbackend.dto.WebsiteDto;
import ac.rca.downloaderbackend.model.Website;
import ac.rca.downloaderbackend.payload.ApiResponse;
import ac.rca.downloaderbackend.services.IWebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/websites")
public class WebsiteController {
    private final IWebsiteService websiteService;

    @Autowired
    public WebsiteController(IWebsiteService websiteService) {
        this.websiteService = websiteService;
    }


    @GetMapping
    public List<Website> getAllwebsites() {
        return this.websiteService.getAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Website> getById(@PathVariable(value = "id") UUID id) {
        return ResponseEntity.ok(this.websiteService.getById(id));
    }

    @PostMapping(path = "/")
    public ResponseEntity<ApiResponse> register(@RequestBody WebsiteDto dto) {

        System.out.println("Going to download website");

        Website website = new Website();

        website.setWebsiteName(dto.getName());

        Website entity = this.websiteService.create(website);

        System.out.println("Retrieved website: ");
        System.out.println(entity);

        return ResponseEntity.ok(new ApiResponse(true, entity));
    }

}