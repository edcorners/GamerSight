
package com.eddev.android.gamesight.model;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Game {

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({OWNED, TRACKING})
    public @interface CollectionName {}
    private static final String OWNED = "OWNED";
    private static final String TRACKING = "TRACKING";

    private long id;
    private String description;
    private Date expectedReleaseDate;
    private String imageUrl;
    private String thumbnailUrl;
    private String name;
    private List<ClassificationAttribute> classificationAttributes = new ArrayList<ClassificationAttribute>();
    private int numberOfUserReviews;
    private Date originalReleaseDate;
    private List<Review> reviews = new ArrayList<Review>();
    private List<Video> videos = new ArrayList<Video>();
    private double completion;
    private @CollectionName String collection;

    public Game(int id, String thumbUrl, String name) {
        this.id = id;
        this.thumbnailUrl = thumbUrl;
        this.name = name;
    }

    public Game(long id, String description, Date expectedReleaseDate, String imageUrl, String thumbnailUrl,
                String name, List<ClassificationAttribute> classificationAttributes, int numberOfUserReviews,
                Date originalReleaseDate, List<Review> reviews, List<Video> videos, double completion, String collection) {
        this.id = id;
        this.description = description;
        this.expectedReleaseDate = expectedReleaseDate;
        this.imageUrl = imageUrl;
        this.thumbnailUrl = thumbnailUrl;
        this.name = name;
        this.classificationAttributes = classificationAttributes;
        this.numberOfUserReviews = numberOfUserReviews;
        this.originalReleaseDate = originalReleaseDate;
        this.reviews = reviews;
        this.videos = videos;
        this.completion = completion;
        this.collection = collection;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getExpectedReleaseDate() {
        return expectedReleaseDate;
    }

    public void setExpectedReleaseDate(Date expectedReleaseDate) {
        this.expectedReleaseDate = expectedReleaseDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ClassificationAttribute> getClassificationAttributes() {
        return classificationAttributes;
    }

    public void setClassificationAttributes(List<ClassificationAttribute> classificationAttributes) {
        this.classificationAttributes = classificationAttributes;
    }

    public int getNumberOfUserReviews() {
        return numberOfUserReviews;
    }

    public void setNumberOfUserReviews(int numberOfUserReviews) {
        this.numberOfUserReviews = numberOfUserReviews;
    }

    public Date getOriginalReleaseDate() {
        return originalReleaseDate;
    }

    public void setOriginalReleaseDate(Date originalReleaseDate) {
        this.originalReleaseDate = originalReleaseDate;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public double getCompletion() {
        return completion;
    }

    public void setCompletion(double completion) {
        this.completion = completion;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }
}
