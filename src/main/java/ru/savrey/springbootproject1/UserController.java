package ru.savrey.springbootproject1;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String hello() {
        return "Privet Master!";
    }

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userRepository.getAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable long id) {
        return userRepository.getById(id);
    }

    @GetMapping
    public User getUserByName(@RequestParam(required = false) String name) {
        return userRepository.getByName(name);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable long id, @RequestBody User user) {
        User existsUser = userRepository.getById(id);
        if (existsUser == null) {
            throw new IllegalArgumentException();
        }
        existsUser.setName(user.getName());
        return existsUser;
    }

    @GetMapping(value = "/test", produces = MediaType.TEXT_HTML_VALUE)
    public String test() {
        return """
                <h1>Title</h1>
                """;
    }
}
