package com.kwork.orgibiz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "ACCESS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Access implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ID")
    private Long id;
    @Column(name = "ROLE")
    private String role;

    @Override
    public String getAuthority() {
        return role;
    }
}
