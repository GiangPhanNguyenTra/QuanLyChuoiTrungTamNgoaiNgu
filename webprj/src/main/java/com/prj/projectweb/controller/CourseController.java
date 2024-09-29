package com.prj.projectweb.controller;

import com.prj.projectweb.dto.request.CourseRequest;
import com.prj.projectweb.dto.response.ApiResponse;
import com.prj.projectweb.service.CourseService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CourseController {
    CourseService courseService;

    @PostMapping
    ApiResponse<String> addCourse(@RequestBody CourseRequest courseRequest) throws Exception {
       log.info("in api add course");
        return ApiResponse.<String>builder()
                .message("create course successfully")
                .result(courseService.addCourse(courseRequest))
                .build();

    }
}
