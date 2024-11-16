package com.polstatstis.volunteerpdt.dto;

/*
 * @author blessy
 */

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VolunteerDto {
    private Long id;

    @NotNull(message = "Nim volunteer wajib diisi.")
    private String nim;

    @NotEmpty(message = "Nama volunteer wajib diisi.")
    private String nama;

    private String status;
}
