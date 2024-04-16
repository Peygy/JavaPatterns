package org.task16.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "levels")
@Entity
@Getter
@Setter
public class Level
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="complexity", nullable=false, length=25)
    private String complexity;
    @Column(name="level_name", nullable=false, length=25)
    private String levelName;

    @ManyToOne
    public Game game;
}
