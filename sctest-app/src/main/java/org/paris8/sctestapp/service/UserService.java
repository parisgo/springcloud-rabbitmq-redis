package org.paris8.sctestapp.service;

import org.paris8.sctestapp.model.User;

import java.util.List;

public interface UserService {
    public void add(User user);
    public void update(User user);
    public void delete(Long id);

    public User getById(Long id);
    public List<User> getAll();
}
