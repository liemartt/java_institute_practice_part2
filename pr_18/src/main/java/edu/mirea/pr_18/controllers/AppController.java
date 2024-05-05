package edu.mirea.pr_18.controllers;

import edu.mirea.pr_18.entities.User;
import edu.mirea.pr_18.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class AppController {
    private static final Logger log = LoggerFactory.getLogger(AppController.class);
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public ModelAndView registerForm() {
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public String processRegistration(User user) {
        user.setRole("ROLE_USER");
        userRepository.save(user);
        return "redirect:/customLogin";
    }

    @GetMapping("/customLogin")
    public String login() {
        return "login";
    }
    @PostMapping("/customLogin")
    public String processLogin(@RequestParam String username, @RequestParam String password) {
        // Получаем аутентификацию пользователя
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        // Проверяем, если пользователь уже аутентифицирован, то перенаправляем его на главную страницу
        if (auth != null && auth.isAuthenticated()) {
            log.info("Already logged in");
            return "home";
        }

        // Поиск пользователя в базе данных
        User user = userRepository.findByUsername(username);

        // Проверка наличия пользователя и правильности пароля
        if (user != null && user.getPassword().equals(password)) {
            log.info("Logged in");
            // Успешная аутентификация, перенаправляем на главную страницу
            return "redirect:/home";
        } else {
            log.info("Not logged in");
            // Неправильные учетные данные, возвращаем обратно на страницу входа с ошибкой
            return "redirect:/customLogin";
        }
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
