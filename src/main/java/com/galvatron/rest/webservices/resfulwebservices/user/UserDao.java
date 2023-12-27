package com.galvatron.rest.webservices.resfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Component
public class UserDao {

    private static List<User> userList = new ArrayList<>();

    private static int userCount = 0;

    static {
        userList.add(new User(++userCount, "Galvatron", LocalDate.now().minusYears(20)));
        userList.add(new User(++userCount, "Megatron", LocalDate.now().minusYears(25)));
        userList.add(new User(++userCount, "Star Scream", LocalDate.now().minusYears(30)));
        userList.add(new User(++userCount, "Iron Fist", LocalDate.now().minusYears(35)));
    }

    public List<User> getAllUsers() {
        return userList;
    }

    public User findUserById(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        Optional<User> optionalUser = userList.stream().filter(predicate).findFirst();
        return optionalUser.isPresent() ? optionalUser.get() : null; // Approach 1
    }

    public User findUserByName(String name) {
        Predicate<? super User> predicate = user -> user.getName().equalsIgnoreCase(name);
        return userList.stream().filter(predicate).findFirst().orElse(null); // Approach 2
    }

    public User saveUser(User user) {
        user.setId(++userCount);
        userList.add(user);
        return user;
    }

}
