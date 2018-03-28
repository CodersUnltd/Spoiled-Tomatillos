package edu.northeastern.cs4500.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.northeastern.cs4500.models.User;
import edu.northeastern.cs4500.repositories.UserRepository;
import edu.northeastern.cs4500.utils.ResourceNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserService implements IUserService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    private UserRepository repository;

    @Override
    public User findByID(int id) {
        User user = repository.findOne(id);
        if (user == null) {
            throw new ResourceNotFoundException(User.class, "id", Integer.toString(id));
        }
        log.info("found user with id " + id);
        return user;
    }

    @Override
    public User findByUsername(String username) {
        User user = repository.findByUsername(username);
        if (user == null) {
            throw new ResourceNotFoundException(User.class, "username", username);
        }
        log.info("found user with username " + username);
        return user;
    }

    @Override
    public User create(User u) {
    	log.info("created user " + u);
        return repository.save(u);
    }

    @Override
    public User update(int id, User u) {
        User currentUser = repository.findOne(id);
        if (currentUser == null) {
            throw new ResourceNotFoundException(User.class, "id", Integer.toString(id));
        }
        
        currentUser.setUsername(u.getUsername());
        currentUser.setEmail(u.getEmail());
        currentUser.setFirstName(u.getFirstName());
        currentUser.setLastName(u.getLastName());
        currentUser.setRole(u.getRole());
        currentUser.setHometown(u.getHometown());
        
        log.info("Updated user " + u + " with id " + id);
        return repository.save(currentUser);
    }

    @Override
    public User delete(int id) {
        User userToDelete = repository.findOne(id);
        if (userToDelete == null) {
            throw new ResourceNotFoundException(User.class, "id", Integer.toString(id));
        }
        log.info("deleted user with id " + id);
        repository.delete(userToDelete);
        return userToDelete;
    }

}
