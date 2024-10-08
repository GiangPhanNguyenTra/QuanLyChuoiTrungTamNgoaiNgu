package com.prj.projectweb.mapper;

import com.prj.projectweb.dto.request.GiangVienDTO;
import com.prj.projectweb.dto.request.GiangVienRequest;
import com.prj.projectweb.dto.response.GiangVienResponse;
import com.prj.projectweb.entities.GiangVien;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-29T09:50:47+0700",
    comments = "version: 1.6.2, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.1.jar, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class GiangVienMapperImpl implements GiangVienMapper {

    @Override
    public GiangVien toGiangVien(GiangVienRequest giangVienRequest) {
        if ( giangVienRequest == null ) {
            return null;
        }

        GiangVien.GiangVienBuilder giangVien = GiangVien.builder();

        giangVien.id( giangVienRequest.getId() );
        giangVien.name( giangVienRequest.getName() );

        return giangVien.build();
    }

    @Override
    public GiangVienResponse toGiangVienResponse(GiangVien giangVien) {
        if ( giangVien == null ) {
            return null;
        }

        GiangVienResponse.GiangVienResponseBuilder giangVienResponse = GiangVienResponse.builder();

        if ( giangVien.getDob() != null ) {
            giangVienResponse.dob( LocalDate.parse( localDateToString( giangVien.getDob() ) ) );
        }
        giangVienResponse.id( giangVien.getId() );
        giangVienResponse.name( giangVien.getName() );

        return giangVienResponse.build();
    }

    @Override
    public GiangVien dtoToGiangVien(GiangVienDTO giangVienDTO) {
        if ( giangVienDTO == null ) {
            return null;
        }

        GiangVien.GiangVienBuilder giangVien = GiangVien.builder();

        giangVien.name( giangVienDTO.getName() );
        giangVien.dob( giangVienDTO.getDob() );

        return giangVien.build();
    }
}
