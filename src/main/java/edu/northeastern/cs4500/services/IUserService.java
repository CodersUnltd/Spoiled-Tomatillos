package edu.northeastern.cs4500.services;

import edu.northeastern.cs4500.models.User;

public interface IUserService {

    User findByID(int id);

    User findByUsername(String username);

    User create(User u);

    User update(int id, User u);

    User delete(int id);

}
