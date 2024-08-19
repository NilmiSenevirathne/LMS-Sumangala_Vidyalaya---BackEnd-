package org.example.sumangalalms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class User {

    @Id
    @Column(name = "User_id")
    private String userId;

    @Column(name = "FName")
    private String FName;

    @Column(name = "LName")
    private String LName;

    @Enumerated(EnumType.STRING)
    private Gender Gender;

    @Column(name = "Address_L1")
    private String Address_L1;

    @Column(name = "Address_L2")
    private String Address_L2;

    @Column(name = "DOB")
    private Date DOB;

    @Column(name = "email")
    private String email;

    @Column(name = "Password")
    private String password;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Enumerated(EnumType.STRING)
    private Role Role;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] Pro_pic;


    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public org.example.sumangalalms.model.Gender getGender() {
        return Gender;
    }

    public void setGender(org.example.sumangalalms.model.Gender gender) {
        Gender = gender;
    }

    public String getAddress_L1() {
        return Address_L1;
    }

    public void setAddress_L1(String address_L1) {
        Address_L1 = address_L1;
    }

    public String getAddress_L2() {
        return Address_L2;
    }

    public void setAddress_L2(String address_L2) {
        Address_L2 = address_L2;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public org.example.sumangalalms.model.Role getRole() {
        return Role;
    }

    public void setRole(org.example.sumangalalms.model.Role role) {
        Role = role;
    }

    public byte[] getPro_pic() {
        return Pro_pic;
    }

    public void setPro_pic(byte[] pro_pic) {
        Pro_pic = pro_pic;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
