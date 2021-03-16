package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class RestApiController {

    private UserService userService;

    @Autowired
    public RestApiController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public List<User> getListUsers() {
        return userService.listUsers();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody User user) {
        userService.add(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody User editUser) {
        userService.update(id, editUser);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        userService.removeUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
