package org.tse.TD1.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "the title should not be blank")
    String title;

    @NotNull(message = "nbrhoursforcas should not be null")
    Integer nbrhoursforcas;
    @NotNull(message = "nbrhourreel should not be null")
    Integer nbrhourreel;
    LocalDate created;
    @ManyToOne
    TaskStatus taskStatus;
    @ManyToOne
    TaskType taskType;
    @ManyToMany
    Set<Developer> developerSet;
    public Task(){
        this.developerSet= new HashSet<>();
    }
    public void addevelopper(Developer developer){
        developerSet.add(developer);
    }



}
