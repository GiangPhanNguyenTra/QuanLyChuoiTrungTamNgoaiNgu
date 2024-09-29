package com.prj.projectweb.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "user_roles")
public class UserRole {

    // Getter và Setter cho userRoleId (nếu cần)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userRoleId;

    // Getter và Setter cho user
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;  // Thay đổi từ public sang private để tuân thủ nguyên tắc đóng gói

    // Getter và Setter cho role
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}


