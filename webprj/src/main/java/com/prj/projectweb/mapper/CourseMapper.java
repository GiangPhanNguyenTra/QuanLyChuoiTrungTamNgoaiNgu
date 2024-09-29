package com.prj.projectweb.mapper;

import com.prj.projectweb.dto.request.CourseRequest;
import com.prj.projectweb.entities.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "giangVien", ignore = true)
    Course toCourse(CourseRequest courseRequest);

}
