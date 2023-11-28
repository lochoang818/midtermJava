package com.example.midTermJava.Controller;

import com.example.midTermJava.Dto.AuthResponseDTO;
import com.example.midTermJava.Dto.LoginDto;
import com.example.midTermJava.Dto.RegisterDto;
import com.example.midTermJava.Model.User;
import com.example.midTermJava.Repository.UserRepository;
import com.example.midTermJava.config.JWTGenerator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
//    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JWTGenerator jwtGenerator;
    @GetMapping("/login")
    public String login(){
        return "Auth/Login";
    }
    @GetMapping("/register")
    public String register(){
        return "Auth/Register";
    }
    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute LoginDto loginDto) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDto.getUsername(),
                            loginDto.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtGenerator.generateToken(authentication);

            if (token != null) {
                // Đăng nhập thành công, chuyển hướng đến trang chủ
                HttpSession session = request.getSession();
                session.setAttribute("email", loginDto.getUsername());
                return new ModelAndView("redirect:/Shop/Menu");
            }
        } catch (AuthenticationException e) {
            // Xử lý khi đăng nhập thất bại
            ModelAndView modelAndView = new ModelAndView("redirect:/auth/login");
            modelAndView.addObject("error", "Invalid username or password");
            return modelAndView;
        }

        // Xử lý trường hợp không xác định
        return new ModelAndView("redirect:/auth/login");
    }


    @PostMapping("register")
    public ModelAndView register(@ModelAttribute RegisterDto registerDto) {
        if (userRepository.existsByEmail(registerDto.getUsername())) {
            ModelAndView modelAndView = new ModelAndView("redirect:/auth/register");

            modelAndView.addObject("error", "Email was taken !!");

            return modelAndView;
        }

        User user = new User();
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode((registerDto.getPassword())));
        user.setPhone(registerDto.getPhone());
        user.setAddress(registerDto.getAddress());
        user.setUsername(registerDto.getUsername());
        user.setRole("user");

        userRepository.save(user);

        return new ModelAndView("redirect:/auth/login");
    }
}
