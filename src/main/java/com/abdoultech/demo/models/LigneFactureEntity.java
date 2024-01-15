package com.abdoultech.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "ligne_facture")
@Data
@ToString
public class LigneFactureEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -6723925737270675146L;

    /*
     *
     */
  

    @EmbeddedId
    @Id
    private LigneFactureKey id;

    @ManyToOne()
    @MapsId("factureId")
    private FactureEntity facture;

    @ManyToOne()
    @MapsId("produitId")
    private ProduitEntity produit;

    private double quantite;





}
