package com.prj.projectweb.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    String email;
    String username;
    String password;
    String fullName;
    String phone;
    String address;
    LocalDate dob;

    String role;

    List<ChildOfParentResponse> children;

    ParentResponse parent;
}
