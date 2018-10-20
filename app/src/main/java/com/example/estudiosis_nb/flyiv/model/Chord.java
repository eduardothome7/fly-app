package com.example.estudiosis_nb.flyiv.model;

public class Chord {
    private long id;
    private String name;
    private int frequency;

    public Chord(String name, int frequency) {
        this.name = name;
        this.frequency = frequency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
