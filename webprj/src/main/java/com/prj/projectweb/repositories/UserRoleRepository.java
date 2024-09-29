package com.prj.projectweb.repositories;

import com.prj.projectweb.entities.UserRole;
import com.prj.projectweb.entities.User;
import com.prj.projectweb.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByUser(User user);
    List<UserRole> findByRole(Role role);
}
