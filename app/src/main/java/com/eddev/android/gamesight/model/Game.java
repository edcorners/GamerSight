package com.eddev.android.gamesight.model;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.StringDef;

import com.eddev.android.gamesight.data.ClassificationByGameColumns;
import com.eddev.android.gamesight.data.GameColumns;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Game implements Parcelable {

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({OWNED, TRACKING})
    public @interface CollectionName {}
    private static final String OWNED = "OWNED";
    private static final String TRACKING = "TRACKING";

    private int id;
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
    private double completion = 0;
    private @CollectionName String collection;
    // Transient attributes
    private boolean favorite;

    public Game(int id, String thumbUrl, String name, String description, Date expectedReleaseDate, Date originalReleaseDate) {
        this.id = id;
        this.thumbnailUrl = thumbUrl;
        this.name = name;
        this.description = description;
    }

    public Game(int id, String description, Date expectedReleaseDate, String imageUrl, String thumbnailUrl,
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

    public void copyBasicFields(Game game) {
        //this.id = game.id;
        //this.description = game.description;
        this.expectedReleaseDate = game.expectedReleaseDate;
        //this.imageUrl = game.imageUrl;
        //this.thumbnailUrl = game.thumbnailUrl;
        //this.name = this.name == null ? game.name : this.name;
        this.classificationAttributes = game.classificationAttributes;
        this.numberOfUserReviews = game.numberOfUserReviews;
        this.originalReleaseDate = game.originalReleaseDate;
        this.videos = game.videos;
    }

    public List<String> getClassificationAttributeValues(@ClassificationAttribute.GameAttribType String classificationAttribute) {
        List<String> results = new ArrayList<>();
        for(ClassificationAttribute current: classificationAttributes){
            if(current.typeEquals(classificationAttribute)) {
                results.add(current.getValue());
            }
        }
        return results;
    }

    public List<Integer> getClassificationAttributeIds(@ClassificationAttribute.GameAttribType String classificationAttribute) {
        List<Integer> results = new ArrayList<>();
        for(ClassificationAttribute current: classificationAttributes){
            if(current.typeEquals(classificationAttribute)) {
                results.add(current.getId());
            }
        }
        return results;
    }

    public Date getReleaseDate() {
        return originalReleaseDate == null ? expectedReleaseDate : originalReleaseDate;
    }

    public ContentValues toContentValues(){
        ContentValues cv = new ContentValues();
        cv.put(GameColumns.GAME_ID, id);
        cv.put(GameColumns.DESCRIPTION, description);
        if(expectedReleaseDate != null) {
            cv.put(GameColumns.EXPECTED_RELEASE_DATE, expectedReleaseDate.getTime());
        }
        cv.put(GameColumns.IMAGE_URL, imageUrl);
        cv.put(GameColumns.THUMBNAIL_URL, thumbnailUrl);
        cv.put(GameColumns.NAME, name);
        cv.put(GameColumns.NUMBER_OF_USER_REVIEWS, numberOfUserReviews);
        if(originalReleaseDate != null) {
            cv.put(GameColumns.ORIGINAL_RELEASE_DATE, originalReleaseDate.getTime());
        }
        cv.put(GameColumns.COMPLETION, completion);
        cv.put(GameColumns.COLLECTION, collection);
        return cv;
    }

    public ContentValues[] getClassificationByGameContentValues() {
        ContentValues[] cv = new ContentValues[this.classificationAttributes.size()];
        int cAttrIndex = 0;
        for (ClassificationAttribute current: classificationAttributes) {
            cv[cAttrIndex] = new ContentValues();
            cv[cAttrIndex].put(ClassificationByGameColumns.CLASSIFICATION_ID, current.getId());
            cv[cAttrIndex].put(ClassificationByGameColumns.GAME_ID, id);
            cAttrIndex++;
        }
        return cv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    protected Game(Parcel in) {
        id = in.readInt();
        description = in.readString();
        long tmpExpectedReleaseDate = in.readLong();
        expectedReleaseDate = tmpExpectedReleaseDate != -1 ? new Date(tmpExpectedReleaseDate) : null;
        imageUrl = in.readString();
        thumbnailUrl = in.readString();
        name = in.readString();
        if (in.readByte() == 0x01) {
            classificationAttributes = new ArrayList<ClassificationAttribute>();
            in.readList(classificationAttributes, ClassificationAttribute.class.getClassLoader());
        } else {
            classificationAttributes = null;
        }
        numberOfUserReviews = in.readInt();
        long tmpOriginalReleaseDate = in.readLong();
        originalReleaseDate = tmpOriginalReleaseDate != -1 ? new Date(tmpOriginalReleaseDate) : null;
        if (in.readByte() == 0x01) {
            reviews = new ArrayList<Review>();
            in.readList(reviews, Review.class.getClassLoader());
        } else {
            reviews = null;
        }
        if (in.readByte() == 0x01) {
            videos = new ArrayList<Video>();
            in.readList(videos, Video.class.getClassLoader());
        } else {
            videos = null;
        }
        completion = in.readDouble();
        String collectionString = in.readString();
        if(collectionString != null) {
            switch (collectionString) {
                case TRACKING:
                    collection = TRACKING;
                    break;
                case OWNED:
                    collection = OWNED;
                    break;
            }
        }
        favorite = Boolean.parseBoolean(in.readString());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(description);
        dest.writeLong(expectedReleaseDate != null ? expectedReleaseDate.getTime() : -1L);
        dest.writeString(imageUrl);
        dest.writeString(thumbnailUrl);
        dest.writeString(name);
        if (classificationAttributes == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(classificationAttributes);
        }
        dest.writeInt(numberOfUserReviews);
        dest.writeLong(originalReleaseDate != null ? originalReleaseDate.getTime() : -1L);
        if (reviews == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(reviews);
        }
        if (videos == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(videos);
        }
        dest.writeDouble(completion);
        dest.writeString(collection);
        dest.writeString(String.valueOf(favorite));
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Game> CREATOR = new Parcelable.Creator<Game>() {
        @Override
        public Game createFromParcel(Parcel in) {
            return new Game(in);
        }

        @Override
        public Game[] newArray(int size) {
            return new Game[size];
        }
    };
}