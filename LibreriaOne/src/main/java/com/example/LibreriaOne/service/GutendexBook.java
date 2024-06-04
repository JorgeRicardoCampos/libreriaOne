package com.example.LibreriaOne.service;

public class GutendexBook {
    private String title;
    private GutendexAuthor[] authors;
    private String[] languages;
    private int downloadCount;
    private int releaseYear;

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public GutendexAuthor[] getAuthors() {
        return authors;
    }

    public void setAuthors(GutendexAuthor[] authors) {
        this.authors = authors;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
}
