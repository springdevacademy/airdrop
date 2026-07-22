package com.springdevacademy.airdrop.model;

import jakarta.persistence.*;

@Entity
@Table(name = "resources")
public class ResourceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String category;

    @Column(length = 1000)
    private String description;

    private String downloadUrl; // Direct GitHub Release URL

    public ResourceItem() {}

    public ResourceItem(String title, String category, String description, String downloadUrl) {
        this.title = title;
        this.category = category;
        this.description = description;
        this.downloadUrl = downloadUrl;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getDownloadUrl() { return downloadUrl; }
    public void setDownloadUrl(String downloadUrl) { this.downloadUrl = downloadUrl; }
}