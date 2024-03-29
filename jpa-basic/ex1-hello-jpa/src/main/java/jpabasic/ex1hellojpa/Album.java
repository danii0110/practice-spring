package jpabasic.ex1hellojpa;

import jakarta.persistence.Entity;

@Entity
public class Album extends Item {
    private String artist;
}
