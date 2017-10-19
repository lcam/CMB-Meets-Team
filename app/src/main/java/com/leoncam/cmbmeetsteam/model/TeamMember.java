package com.leoncam.cmbmeetsteam.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TeamMember {

    @SerializedName("avatar")
    @Expose
    private String avatar;
    @SerializedName("bio")
    @Expose
    private String bio;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("title")
    @Expose
    private String title;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
