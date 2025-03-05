package com.example.graphQl.resolver;

import com.example.graphQl.models.User;
import com.example.graphQl.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class UserQueryResolver {
    private final UserService userService;

    public UserQueryResolver(UserService userService) {
        this.userService = userService;
    }

    @QueryMapping
    public List<User> users() {
        return userService.getAllUsers();
    }

    @QueryMapping
    public User userById(@Argument("id") Long id) {
        return userService.getUserById(id);
    }
}
