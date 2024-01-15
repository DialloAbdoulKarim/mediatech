package com.abdoultech.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "clients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientEntity  implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(name ="client_telephone")
    private String telephone;

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<FactureEntity> factures;

}
