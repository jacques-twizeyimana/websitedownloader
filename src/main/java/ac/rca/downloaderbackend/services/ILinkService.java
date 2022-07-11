package ac.rca.downloaderbackend.services;

import ac.rca.downloaderbackend.model.Links;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.UUID;


public interface ILinkService {
    public List<Links> getAll();

    public Page<Links> getAll(Pageable pageable);

    public Links getById(UUID id);

    public Links create(Links Links);

    public Links update(UUID id, Links Links);

    public boolean delete(UUID id);

    public List<Links> searchLinks(String searchKey);
}