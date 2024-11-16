package com.polstatstis.volunteerpdt.auth;

/*
 * @author blessy
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    private String nim;
    private String accessToken;    
}
