package com.polstatstis.volunteerpdt.mapper;

/*
 * @author blessy
 */

import com.polstatstis.volunteerpdt.dto.VolunteerDto;
import com.polstatstis.volunteerpdt.entity.Volunteer;

public class VolunteerMapper {
    public static Volunteer mapToVolunteer(VolunteerDto volunteerDto){
        return Volunteer.builder()
                .id(volunteerDto.getId())
                .nim(volunteerDto.getNim())
                .nama(volunteerDto.getNama())
                .status(volunteerDto.getStatus())
                .build();
    }
    public static VolunteerDto mapToVolunteerDto(Volunteer volunteer){
        return VolunteerDto.builder()
                .id(volunteer.getId())
                .nim(volunteer.getNim())
                .nama(volunteer.getNama())
                .status(volunteer.getStatus())
                .build();
    }
}
