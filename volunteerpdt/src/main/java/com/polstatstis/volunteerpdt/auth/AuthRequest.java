package com.polstatstis.volunteerpdt.auth;

/*
 * @author blessy
 */

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor
public class AuthRequest {
    @NotNull @Max(20)
    private String nim;

    @NotNull @Max(16)
    private String password;
}
