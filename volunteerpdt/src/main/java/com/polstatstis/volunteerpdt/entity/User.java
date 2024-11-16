package com.polstatstis.volunteerpdt.entity;

/*
 * @author blessy
 */

import jakarta.persistence.*;

import java.util.List;
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
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nim;
    
    @Column(nullable = false)
    private String role;
    
    @Column(nullable = false)
    private String nama;
    
    @Column(nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String status;
    
    @Column(nullable = false)
    private String kelas;
    
    @Column(nullable = false)
    private String angkatan;
    
    @Column(nullable = false)
    private int usia;

}
