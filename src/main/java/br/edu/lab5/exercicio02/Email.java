package br.edu.lab5.exercicio02;

import lombok.Getter;

public class Email {
    private int id;
    @Getter
    private String name;

    public Email(int id, String name) {
        this.id = id;
        this.name = name;
    }

}