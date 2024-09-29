package com.prj.projectweb.service;

import com.prj.projectweb.entities.User;
import com.prj.projectweb.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Lấy tất cả người dùng
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Tìm người dùng theo ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Thêm người dùng
    public User addUser(User user) {
        return userRepository.save(user);
    }

    // Cập nhật người dùng
    public Optional<User> updateUser(Long id, User userDetails) {
        return userRepository.findById(id).map(user -> {
            user.setUsername(userDetails.getUsername());
            user.setEmail(userDetails.getEmail());
            user.setFullName(userDetails.getFullName());
            user.setPhone(userDetails.getPhone());
            user.setAddress(userDetails.getAddress());
            user.setPassword(userDetails.getPassword());
            return userRepository.save(user);
        });
    }

    // Xóa người dùng
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Tìm người dùng bằng email
    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(userRepository.findByUsername(email));
    }
}


