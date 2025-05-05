package br.edu.lab5.exercicio02;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private int id;
    @Getter
    private String name;
    @Getter
    private int age;
    @Getter
    private List<Email> emails;
}