package com.abdoultech.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class UserEntity implements Serializable {

    @Id
    @GeneratedValue
    private Integer userId;
    @Column(nullable = false)

    private String username;
    @Column(nullable = false)

    private String password;

    @ManyToMany
    /*@JoinColumn(name = "user_roles",joinColomns = @JoinColumn(name = "userId")),
    inverseJoinColumns = @JoinColumn(name = "roleId")
    )*/

    private List<RoleEntity> roles;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private  UserProfile profile;






}
