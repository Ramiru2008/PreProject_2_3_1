package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users")
    public String show(ModelMap model) {
        model.addAttribute("user", userService.getAllUsers());
        return "users";
    }

    @GetMapping("users/new")
    public String newUser(@ModelAttribute("user") User user, Model model) {
        return "new";
    }

    @PostMapping("users/new")
    public String create(@ModelAttribute("user") User user, Model model) {
        userService.add(user);
        return "redirect:/users";
    }


    @PatchMapping("/users/{id}/new")
    public String editUser(@ModelAttribute("user") User user) {
        userService.edit(user);
        return "redirect:/users";
    }


    @DeleteMapping("/people/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.removeUserById(id);
        return "redirect:/users";
    }
}
