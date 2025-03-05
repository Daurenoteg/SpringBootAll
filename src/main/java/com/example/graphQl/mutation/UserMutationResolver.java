package com.example.graphQl.resolver;

import com.example.graphQl.models.User;
import com.example.graphQl.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class UserMutationResolver {
    private final UserService userService;

    public UserMutationResolver(UserService userService) {
        this.userService = userService;
    }

    @MutationMapping
    public User createUser(@Argument String name, @Argument String email) {
        return userService.createUser(name, email);
    }

    @MutationMapping
    public User updateUser(@Argument Long id, @Argument String name, @Argument String email) {
        return userService.updateUser(id, name, email);
    }

    @MutationMapping
    public boolean deleteUser(@Argument Long id) {
        return userService.deleteUser(id);
    }
}
