package org.tse.TD1.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Data
public class Developer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    String firstname;
    String lastname;
    String password;
    String email;
    LocalDate Startcontract;





}
