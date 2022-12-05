package org.tse.TD1.domain;

import lombok.Data;

import javax.persistence.*;
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

    String title;
    Integer nbrhoursforcas;
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
