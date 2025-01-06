package vn.hoidanit.jobhunter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.hoidanit.jobhunter.domain.User;
import vn.hoidanit.jobhunter.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User handleCreateUser(User user){
        return this.userRepository.save(user);
    }

    public void handleDeleteUser(long id){
        this.userRepository.deleteById(id);
    }

    public User fetchUserById(long id){
        this.userRepository.findById(id);
        return null;
    }

    public List<User> fetchAllUser(){
        return this.userRepository.findAll();
    }

    public User handleUpdateUser(User userInfo){
        User currentUser = this.fetchUserById(userInfo.getId());
        if(currentUser != null){
            currentUser.setEmail(userInfo.getEmail());
            currentUser.setName(userInfo.getName());
            currentUser.setPassword(userInfo.getPassword());
            //save in database
            currentUser = this.userRepository.save(currentUser);
        }

        return currentUser;
    }
    
}
