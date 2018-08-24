package com.example.user.loginusingapi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegistrationParam {

    private String firstName;
    private String lastName;
    @SerializedName("getUserName")
    @Expose
    private String getUserName;
    @SerializedName("getEmailId")
    @Expose
    private String getEmailId;
    @SerializedName("getContactNo")
    @Expose
    private String getContactNo;
    @SerializedName("getRegistrationDate")
    @Expose
    private String getRegistrationDate;
    @SerializedName("getPassword")
    @Expose
    private String getPassword;

    public String getGetUserName() {
        return getUserName;
    }

    public void setGetUserName(String getUserName) {
        this.getUserName = getUserName;
    }

    public String getGetEmailId() {
        return getEmailId;
    }

    public void setGetEmailId(String getEmailId) {
        this.getEmailId = getEmailId;
    }

    public String getGetContactNo() {
        return getContactNo;
    }

    public void setGetContactNo(String getContactNo) {
        this.getContactNo = getContactNo;
    }

    public String getGetRegistrationDate() {
        return getRegistrationDate;
    }

    public void setGetRegistrationDate(String getRegistrationDate) {
        this.getRegistrationDate = getRegistrationDate;
    }

    public String getGetPassword() {
        return getPassword;
    }

    public void setGetPassword(String getPassword) {
        this.getPassword = getPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
