package com.prj.projectweb.controller;

import com.prj.projectweb.entities.UserRole;
import com.prj.projectweb.service.UserRoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-roles")
public class UserRoleController {

    private final UserRoleService userRoleService;

    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    // Lấy tất cả các UserRole
    @GetMapping
    public List<UserRole> getAllUserRoles() {
        return userRoleService.getAllUserRoles();
    }

    // Tìm UserRole theo ID
    @GetMapping("/{id}")
    public ResponseEntity<UserRole> getUserRoleById(@PathVariable Long id) {
        UserRole userRole = userRoleService.getUserRoleById(id);
        if (userRole != null) {
            return ResponseEntity.ok(userRole);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Tạo UserRole mới
    @PostMapping
    public UserRole createUserRole(@RequestBody UserRole userRole) {
        return userRoleService.addUserRole(userRole);
    }

    // Cập nhật UserRole
    @PutMapping("/{id}")
    public ResponseEntity<UserRole> updateUserRole(@PathVariable Long id, @RequestBody UserRole userRoleDetails) {
        UserRole updatedUserRole = userRoleService.updateUserRole(id, userRoleDetails);
        if (updatedUserRole != null) {
            return ResponseEntity.ok(updatedUserRole);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Xóa UserRole
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserRole(@PathVariable Long id) {
        userRoleService.deleteUserRole(id);
        return ResponseEntity.noContent().build();
    }
}
