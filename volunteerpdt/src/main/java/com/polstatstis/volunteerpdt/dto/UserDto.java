package com.polstatstis.volunteerpdt.dto;

/*
 * @author blessy
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Collections;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements UserDetails{
    @JsonIgnore
    private Long id;

    @Schema(example = "222212537")
    private String nim;

    @Schema(example = "Pengurus PDT")
    private String role;

    @Schema(example = "Blessy Munthia")
    private String nama;

    @Schema(example = "blessymunthia@gmail.com")
    private String email;

    @Schema(example = "072003")
    private String password;

    @Schema(example = "Aktif")
    private String status;

    @Schema(example = "3SI2")
    private String kelas;

    @Schema(example = "64")
    private String angkatan;

    @Schema(example = "21")
    private int usia;

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(role));
    }

    @JsonIgnore
    @Override
    public String getUsername() {
        return this.nim;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return "Aktif".equalsIgnoreCase(this.status);
    }
}
