package net.stopno.service;

import net.stopno.domain.User;

import java.util.List;

public interface UserService {
    void create(User user);

    List<User> getUserByIds(List<String> ids);

    User getByUsername(String name);

    void update(User user);

    void delete(String id);

    User getUser(String id);
}
