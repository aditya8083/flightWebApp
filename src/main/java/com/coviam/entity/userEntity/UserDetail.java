package com.coviam.entity.userEntity;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
public class UserDetail {
    private int userId;
    private String firstName;
    private String lastName;
    private String age;
    private String dob;
    private String emailId;
    private String contactNumber;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }


    @Override
    public String toString() {
        return "UserDetail{" + "userId=" + userId + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", age='" + age + '\'' + ", dob='" + dob + '\'' + ", emailId='" + emailId + '\'' + ", contactNumber='" + contactNumber + '\'' + '}';
    }
}
