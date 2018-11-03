package com.adamk.test;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

public class Item implements Parcelable {

    private String title;
    private String description;
    private int image;
    private String distance;

    public Item(String title, String description, int image, String distance) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.distance = distance;
    }

    protected Item(Parcel in) {
        title = in.readString();
        description = in.readString();
        distance = in.readString();
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
        dest.writeString(distance);
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
}
