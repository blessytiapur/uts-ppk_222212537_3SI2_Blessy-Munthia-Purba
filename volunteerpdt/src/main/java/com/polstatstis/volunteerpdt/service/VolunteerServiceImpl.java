package com.polstatstis.volunteerpdt.service;

/*
 * @author blessy
 */

import com.polstatstis.volunteerpdt.dto.VolunteerDto;
import com.polstatstis.volunteerpdt.entity.Volunteer;
import com.polstatstis.volunteerpdt.mapper.VolunteerMapper;
import com.polstatstis.volunteerpdt.repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VolunteerServiceImpl implements  VolunteerService {
    @Autowired
    private VolunteerRepository volunteerRepository;

    @Override
    public void createVolunteer(VolunteerDto volunteerDto) {
        volunteerRepository.save(VolunteerMapper.mapToVolunteer(volunteerDto));
    }

    @Override
    public VolunteerDto updateVolunteer(VolunteerDto volunteerDto) {
        Volunteer volunteer = volunteerRepository.save(VolunteerMapper.mapToVolunteer(volunteerDto));
        return VolunteerMapper.mapToVolunteerDto(volunteer);
    }

    @Override
    public void deleteVolunteer(String nim) {
        // Mencari volunteer berdasarkan NIM
        List<Volunteer> volunteerList = volunteerRepository.findByNim(nim);

        // Jika tidak ditemukan, lemparkan exception
        if (volunteerList == null || volunteerList.isEmpty()) {
            throw new IllegalArgumentException("Volunteer not found with NIM: " + nim);
        }

        // Hapus berdasarkan NIM
        volunteerRepository.deleteByNim(nim);  // Menggunakan deleteByNim yang sudah didefinisikan
    }


    @Override
    public VolunteerDto getVolunteer(Long id) {
        // Ambil volunteer berdasarkan ID dan konversi ke VolunteerDto
        Volunteer volunteer = volunteerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Volunteer not found with ID: " + id));
        return VolunteerMapper.mapToVolunteerDto(volunteer);
    }

    @Override
    public List<VolunteerDto> getVolunteers() {
        List<Volunteer> volunteer = (List<Volunteer>) volunteerRepository.findAll();
        return volunteer.stream()
                .map(VolunteerMapper::mapToVolunteerDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<VolunteerDto> searchVolunteers(String searchTerm) {
        List<Volunteer> volunteers = volunteerRepository.searchVolunteers(searchTerm);
        return volunteers.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private VolunteerDto convertToDto(Volunteer volunteer) {
        // Convert Volunteer entity to VolunteerDto
        return null;
    }
}
