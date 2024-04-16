package org.task17.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "games")
@Getter
@Setter
public class Game
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name", nullable=false, length=25)
    private String name;
    @Column(name="creation_date", nullable=false, length=25)
    private String creationDate;
}