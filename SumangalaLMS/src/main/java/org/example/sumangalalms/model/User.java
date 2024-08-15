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
    private String User_id;
    private String FName;
    private String LName;

    @Enumerated(EnumType.STRING)
    private Gender Gender;
    private String Address_L1;
    private String Address_L2;
    private Date DOB;
    private String email;

    @Enumerated(EnumType.STRING)
    private Role Role;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] Pro_pic;


}
