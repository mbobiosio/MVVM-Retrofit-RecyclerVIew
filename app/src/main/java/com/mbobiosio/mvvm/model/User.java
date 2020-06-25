package com.mbobiosio.mvvm.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * MVVM-Retrofit-RecyclerVIew
 * Created by Mbuodile Obiosio on Jun 25, 2020
 * https://twitter.com/cazewonder
 * Nigeria.
 */
public class User implements Serializable {

    @SerializedName("ID")
    private int ID;
    @SerializedName("UserName")
    private String username;
    @SerializedName("FullName")
    private String name;
    @SerializedName("ProfilePhoto")
    private String avatar;

    public User(int ID, String username, String name, String avatar) {
        this.ID = ID;
        this.username = username;
        this.name = name;
        this.avatar = avatar;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @NonNull
    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
