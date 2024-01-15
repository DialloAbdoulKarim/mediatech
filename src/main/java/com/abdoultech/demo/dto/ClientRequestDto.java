package com.abdoultech.demo.dto;


import com.abdoultech.demo.annotation.IpAddress;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDto {


    //@NotNull(message = "le nom est obligatoire!!")
    //@Size(min = 5, max = 20, message = "le nombre de charactere doit etre compris entre 5 et 20")
    @NotBlank(message =  "ce champs est obligatoire")
    @Size(min = 5, message = "ce champs doit avoir au moins 5 charactere")
    @Size(max = 20, message = "ce champs doit avoir au moins 20 charactere")
    private String nom;


    //@NotNull(message = "le prenom est obligatoire!!")
   // @Size(min = 5, max = 20, message = "le nombre de charactere doit etre compris entre 5 et 20")
    @NotBlank(message =  "ce champs est obligatoire")
    @Size(min = 5, message = "ce champs doit avoir au moins 5 charactere")
    @Size(max = 20, message = "ce champs doit avoir au moins 20 charactere")
    private String prenom;


    @NotNull
    @Pattern(regexp = "^(\\+212|0)([\\-_/]*)(\\d[ \\-_/]*)d{9}$", message = "format invalid")
    private String telephone;


    @IpAddress()
    private String ip;

}
