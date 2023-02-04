package io.back.polaris.controllers;

import io.back.polaris.models.database.tables.User;
import io.back.polaris.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @GetMapping("/user")
  public String test() {
    User user = new User("coco", "caca", "icici6", "cococaca@gmail.com", "francisHuster");
    userRepository.save(user);
    return userRepository.findAll().toString();
  }
}
