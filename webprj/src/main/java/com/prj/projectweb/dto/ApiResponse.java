package com.prj.projectweb.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApiResponse {
    // Getter và Setter
    private int code;
    private String message;

    // Constructor
    public ApiResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
