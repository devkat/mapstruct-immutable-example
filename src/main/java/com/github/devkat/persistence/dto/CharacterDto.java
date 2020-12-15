package com.github.devkat.persistence.dto;

import javax.persistence.*;

@Entity
public class CharacterDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

}
