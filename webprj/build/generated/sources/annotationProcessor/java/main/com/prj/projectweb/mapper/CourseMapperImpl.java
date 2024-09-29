package com.prj.projectweb.mapper;

import com.prj.projectweb.dto.request.CertificateRequest;
import com.prj.projectweb.dto.request.CourseContentRequest;
import com.prj.projectweb.dto.request.CourseRequest;
import com.prj.projectweb.entities.Certificate;
import com.prj.projectweb.entities.Course;
import com.prj.projectweb.entities.CourseContent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-29T00:38:07+0700",
    comments = "version: 1.6.2, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.1.jar, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class CourseMapperImpl implements CourseMapper {

    @Override
    public Course toCourse(CourseRequest courseRequest) {
        if ( courseRequest == null ) {
            return null;
        }

        Course.CourseBuilder course = Course.builder();

        course.courseName( courseRequest.getCourseName() );
        course.courseContent( courseContentRequestListToCourseContentList( courseRequest.getCourseContent() ) );
        course.objective( courseRequest.getObjective() );
        course.duration( courseRequest.getDuration() );
        course.tuitionFee( courseRequest.getTuitionFee() );
        course.learningMethod( courseRequest.getLearningMethod() );
        course.certificate( certificateRequestToCertificate( courseRequest.getCertificate() ) );
        if ( courseRequest.getStartTime() != null ) {
            course.startTime( LocalDate.parse( courseRequest.getStartTime() ) );
        }
        if ( courseRequest.getEndTime() != null ) {
            course.endTime( LocalDate.parse( courseRequest.getEndTime() ) );
        }
        List<String> list1 = courseRequest.getSchedule();
        if ( list1 != null ) {
            course.schedule( new ArrayList<String>( list1 ) );
        }
        course.likes( courseRequest.getLikes() );
        course.image( courseRequest.getImage() );
        course.numberOfStudents( courseRequest.getNumberOfStudents() );
        course.object( courseRequest.getObject() );

        return course.build();
    }

    protected CourseContent courseContentRequestToCourseContent(CourseContentRequest courseContentRequest) {
        if ( courseContentRequest == null ) {
            return null;
        }

        CourseContent.CourseContentBuilder courseContent = CourseContent.builder();

        courseContent.session( courseContentRequest.getSession() );
        courseContent.title( courseContentRequest.getTitle() );
        List<String> list = courseContentRequest.getDetails();
        if ( list != null ) {
            courseContent.details( new ArrayList<String>( list ) );
        }

        return courseContent.build();
    }

    protected List<CourseContent> courseContentRequestListToCourseContentList(List<CourseContentRequest> list) {
        if ( list == null ) {
            return null;
        }

        List<CourseContent> list1 = new ArrayList<CourseContent>( list.size() );
        for ( CourseContentRequest courseContentRequest : list ) {
            list1.add( courseContentRequestToCourseContent( courseContentRequest ) );
        }

        return list1;
    }

    protected Certificate certificateRequestToCertificate(CertificateRequest certificateRequest) {
        if ( certificateRequest == null ) {
            return null;
        }

        Certificate.CertificateBuilder certificate = Certificate.builder();

        certificate.issued( certificateRequest.getIssued() );
        certificate.details( certificateRequest.getDetails() );

        return certificate.build();
    }
}
