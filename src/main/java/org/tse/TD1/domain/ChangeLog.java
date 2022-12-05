package org.tse.TD1.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
public class ChangeLog {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    LocalDate occured;
    @ManyToOne
    Task task;
    @ManyToOne
    TaskStatus sourceStatus;
    @ManyToOne
    TaskStatus targetStatus;
    


}
