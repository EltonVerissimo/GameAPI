package com.example.demo.game;

import java.time.LocalDate;

public class Game {
    private Long id;
    private String name;
    private LocalDate releaseDate;
    private String platforms;

    public Game() {
    }

    public Game(Long id, String name, LocalDate releaseDate, String platforms) {
        this.id = id;
        this.name = name;
        this.releaseDate = releaseDate;
        this.platforms = platforms;
    }

    public Game(String name, LocalDate releaseDate, String platforms) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.platforms = platforms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", releaseDate=" + releaseDate +
                ", platforms='" + platforms + '\'' +
                '}';
    }
}
