package com.prj.projectweb.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApiRequest {
    // Getter và Setter
    private String email;
    private String password;

    // Constructor
    public ApiRequest() {}

}
