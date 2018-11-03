package com.adamk.test;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

public class Item implements Parcelable {

    private String title;
    private String description;
    private int image;
    private String distance;
    private int rating;

    public Item(String title, String description, int image, String distance, int rating) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.distance = distance;
        this.rating = rating;
    }

    protected Item(Parcel in) {
        title = in.readString();
        description = in.readString();
        image = in.readInt();
        distance = in.readString();
        rating = in.readInt();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(description);
        dest.writeInt(image);
        dest.writeString(distance);
        dest.writeInt(rating);
    }

    public int getRating() {
        return rating;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }

    public String getDistance() {
        return distance;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
