package com.prj.projectweb.service;

import com.prj.projectweb.dto.request.CourseRequest;
import com.prj.projectweb.dto.request.GiangVienRequest;
import com.prj.projectweb.entities.Course;
import com.prj.projectweb.entities.GiangVien;
import com.prj.projectweb.mapper.CourseMapper;
import com.prj.projectweb.repositories.CourseRepository;
import com.prj.projectweb.repositories.GiangVienRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class CourseService {

    CourseRepository courseRepository;
    GiangVienRepository giangVienRepository;
    CourseMapper courseMapper;

    public String addCourse(CourseRequest courseRequest) throws Exception {
        log.info("in service add course");

        // Kiểm tra tên khóa học đã tồn tại chưa
        if (courseRepository.existsByCourseName(courseRequest.getCourseName())) {
            return "Course name existed";
        }

        Course course = courseMapper.toCourse(courseRequest);

        course.setStartTime(LocalDate.parse(courseRequest.getStartTime()));
        course.setEndTime(LocalDate.parse(courseRequest.getEndTime()));

        GiangVien giangVien = giangVienRepository.findById(courseRequest.getGiangVien().getId())
                .orElseThrow(() -> new Exception("GiangVien không tồn tại với id: " + courseRequest.getGiangVien().getId()));

        // Thiết lập mối quan hệ giữa Course và GiangVien
        course.setGiangVien(giangVien);
        giangVien.addCourse(course); // Phương thức tiện ích trong GiangVien

        // Lưu course vào database
        courseRepository.save(course);

        return course.getCourseName();
    }
}
