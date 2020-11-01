package com.brunopique.assignment14.web;

import com.brunopique.assignment14.domain.User;
import com.brunopique.assignment14.service.MessageService;
import com.brunopique.assignment14.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private MessageService messageService;

    @GetMapping("/")
    public String rootUrl() {
        return "redirect:/welcome";
    }

    @GetMapping("/welcome")
    public String getWelcome(ModelMap model) {
        return "welcome";
    }

    @PostMapping("/welcome")
    @ResponseBody
    public User postWelcome(@RequestBody String name) {
        return userService.saveUser(name);
    }

    @GetMapping("/channels/1")
    public String getGeneralChatroom() {
        return "general";
    }

    @PostMapping("/channels/1")
    @ResponseBody
    public String postToGeneralChatroom(@RequestBody String message) {
        messageService.createMessage(message);
        return "redirect:/general";
    }

    @GetMapping("/getMessages")
    @ResponseBody
    public String getMessages() {
        return messageService.getMessages();
    }
}
