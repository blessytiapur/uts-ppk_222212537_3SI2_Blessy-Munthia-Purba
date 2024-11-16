package com.polstatstis.volunteerpdt.repository;

/*
 * @author blessy
 */

import com.polstatstis.volunteerpdt.entity.Volunteer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "volunteer", path = "volunteer")
public interface VolunteerRepository extends PagingAndSortingRepository<Volunteer, Long>,
        CrudRepository<Volunteer, Long> {

    List<Volunteer> findByNama(@Param("nama") String nama);

    List<Volunteer> findByNim(@Param("nim") String nim);

    // Menghapus berdasarkan NIM
    void deleteByNim(String nim);

    // Menambahkan pencarian berdasarkan istilah pencarian
    @Query("SELECT v FROM Volunteer v WHERE v.nama LIKE %:searchTerm% OR v.nim LIKE %:searchTerm%")
    List<Volunteer> searchVolunteers(@Param("searchTerm") String searchTerm);
}