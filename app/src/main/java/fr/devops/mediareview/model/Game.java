package fr.devops.mediareview.model;

public class Game {
    private int id;
    private String name;

    // Constructeurs, getters et setters

    public Game(int id, String name, String releaseDate) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

