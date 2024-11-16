package com.polstatstis.volunteerpdt.service;

/*
 * @author blessy
 */

import com.polstatstis.volunteerpdt.dto.VolunteerDto;
import java.util.List;

public interface VolunteerService {

    void createVolunteer(VolunteerDto volunteerDto);

    VolunteerDto updateVolunteer(VolunteerDto volunteerDto);

    void deleteVolunteer(String nim);

    VolunteerDto getVolunteer(Long id);

    List<VolunteerDto> getVolunteers();

    List<VolunteerDto> searchVolunteers(String searchTerm);
}
