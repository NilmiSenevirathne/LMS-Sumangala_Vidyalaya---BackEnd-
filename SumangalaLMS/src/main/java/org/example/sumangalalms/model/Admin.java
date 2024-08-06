package org.example.sumangalalms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Admin {

    @Id
    @Column(length = 100)
    private String User_id;
    private String FName;
    private String LName;

    @Enumerated(EnumType.STRING)
    private Gender Gender;
    private String Address_L1;
    private String Address_L2;
    private Date DOB;
    private String email;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] Pro_pic;


    public String getUser_id() {
        return User_id;
    }

    public void setUser_id(String user_id) {
        User_id = user_id;
    }

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

    public byte[] getPro_pic() {
        return Pro_pic;
    }

    public void setPro_pic(byte[] pro_pic) {
        Pro_pic = pro_pic;
    }
}
