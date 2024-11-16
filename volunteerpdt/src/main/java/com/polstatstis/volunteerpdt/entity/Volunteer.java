package com.polstatstis.volunteerpdt.entity;

/*
 * @author blessy
 */

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "volunteers")
public class Volunteer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @Schema(description = "Nim dari Volunteer", example = "222212537")
    private String nim;

    @Column(nullable = false)
    @Schema(description = "Nama dari Volunteer", example = "Blessy Munthia Purba")
    private String nama;

    @Column(nullable = false)
    private String status;

}
