package com.prj.projectweb.service;

import com.prj.projectweb.entities.UserRole;
import com.prj.projectweb.repositories.UserRoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRoleService(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    // Lấy tất cả UserRole
    public List<UserRole> getAllUserRoles() {
        return userRoleRepository.findAll();
    }

    // Tìm UserRole theo ID
    public UserRole getUserRoleById(Long id) {
        Optional<UserRole> userRole = userRoleRepository.findById(id);
        return userRole.orElse(null); // Trả về null nếu không tìm thấy
    }

    // Tạo UserRole mới (gán user với role)
    public UserRole addUserRole(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    // Cập nhật UserRole
    public UserRole updateUserRole(Long id, UserRole userRoleDetails) {
        Optional<UserRole> optionalUserRole = userRoleRepository.findById(id);
        if (optionalUserRole.isPresent()) {
            UserRole userRole = optionalUserRole.get();
            userRole.setUser(userRoleDetails.getUser());
            userRole.setRole(userRoleDetails.getRole());
            return userRoleRepository.save(userRole);
        }
        return null; // Trả về null nếu không tìm thấy
    }

    // Xóa UserRole theo ID
    public void deleteUserRole(Long id) {
        userRoleRepository.deleteById(id);
    }
}

