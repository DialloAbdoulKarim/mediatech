package com.abdoultech.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

public class LigneFactureKey implements Serializable {
    /*

     */
    private static final long serialVersionUID = 4722352116317893282L;

    @Column(name = "facture_id")
    private Integer factureId;

    @Column(name =  "facture_id")
    private Integer produitId;

}
