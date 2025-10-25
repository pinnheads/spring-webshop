package com.da.da_25_26.users;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
  private IUserService userService;

  @Autowired
  public UserController(IUserService userService) {
    this.userService = userService;
  }

  @GetMapping("")
  public List<User> getAllUsers() {
    return User.getUsers();
  }

  @GetMapping("/{id}")
  public Optional<User> getUserWithId(@PathVariable long id) {
    return userService.getUserById(id);
  }

  @PostMapping("/create")
  public User createNewUser(@RequestParam String firstName, @RequestParam String lastName,
      @RequestParam String email, @RequestParam String address) {
    return userService.createUser(firstName, lastName, email, address);
  }
}
