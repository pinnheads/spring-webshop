package com.da.da_25_26.users;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

  @Override
  public Optional<User> getUserById(long id) {
    return User.getUsers().stream()
        .filter(user -> user.getId() == id).findFirst();
  }

  @Override
  public User createUser(String firstName, String lastName, String email, String address) {
    return User.createUser(firstName, lastName, email, address);
  }

  @Override
  public Long getUserId() {
    return 1L;
  }
}
