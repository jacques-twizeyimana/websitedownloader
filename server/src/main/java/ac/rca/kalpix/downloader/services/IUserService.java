package ac.rca.kalpix.downloader.services;

import ac.rca.kalpix.downloader.models.User;

import java.util.List;

public interface IUserService {

    List<User> getAllUsers();

    User save(User user);

    User getLoggedInUser();
}
