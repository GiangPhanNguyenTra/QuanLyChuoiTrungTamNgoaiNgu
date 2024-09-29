package com.prj.projectweb.repositories;

import com.prj.projectweb.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    // Không cần định nghĩa lại các phương thức findAll, findById, save, deleteById
    // Vì chúng đã có sẵn trong JpaRepository
}
