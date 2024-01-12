package ru.savrey.springbootproject1;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component("myUserRepo")
@Primary
//@Scope(ConfigurableListableBeanFactory.SCOPE_PROTOTYPE)
public class UserRepository {

    private final List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
        users.add(new User("User #1"));
        users.add(new User("User #2"));
        users.add(new User("User #3"));
        users.add(new User("User #4"));
        users.add(new User("User #5"));
    }

    public List<User> getAll() {
        return List.copyOf(users);
    }

    public User getById(long id) {
        return users.stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst()
                .orElse(null);
    }

    public User getByName(String name) {
        return users.stream().filter(it -> Objects.equals(it.getName(), name))
                .findFirst()
                .orElse(null);
    }
}
