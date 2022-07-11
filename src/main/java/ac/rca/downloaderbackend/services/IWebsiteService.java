package ac.rca.downloaderbackend.services;

import ac.rca.downloaderbackend.model.Website;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.UUID;


public interface IWebsiteService {
    public List<Website> getAll();

    public Page<Website> getAll(Pageable pageable);

    public Website getById(UUID id);

    public Website create(Website Website);

    public Website update(UUID id, Website Website);

    public boolean delete(UUID id);

    public List<Website> searchWebsite(String searchKey);
}