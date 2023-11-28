package com.example.midTermJava.Service;

import com.example.midTermJava.Model.User;
import com.example.midTermJava.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        return new User(user.getEmail(), user.getPassword());
    }
    public Boolean existsByEmail(String username){
        return this.userRepository.existsByEmail(username);
    }
}
