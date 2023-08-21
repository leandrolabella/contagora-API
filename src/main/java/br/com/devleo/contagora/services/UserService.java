package br.com.devleo.contagora.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devleo.contagora.domain.User;
import br.com.devleo.contagora.dto.UserDTO;
import br.com.devleo.contagora.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(UserDTO data){
        User newUser = new User(data);
        userRepository.save(newUser);
        return newUser;
    }

    public User getUser(Long id){
        return userRepository.findById(id).orElse(null);
        
    }
    
}
