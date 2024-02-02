package ru.spring.cloud.micro.demo.autheurekaclient.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Data
@Entity
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false, length = 20, name = "name")
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }

    public Role(String name) {
        this.name = name;
    }
}
