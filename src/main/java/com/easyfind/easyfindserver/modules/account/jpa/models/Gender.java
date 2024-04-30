package com.easyfind.easyfindserver.modules.account.jpa.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="tb_genders")
public class Gender implements Serializable {
    protected Gender() {}

    public Gender(String genderName) {
        this.genderName = genderName;
        this.genderCreatedAt =  LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer genderId;

    private String genderName;

    private LocalDateTime genderCreatedAt;

    public Integer getGenderId() {
        return genderId;
    }

    public void setGenderId(Integer genderId) {
        this.genderId = genderId;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }

    public LocalDateTime getGenderCreatedAt() {
        return genderCreatedAt;
    }

    public void setGenderCreatedAt(LocalDateTime genderCreatedAt) {
        this.genderCreatedAt = genderCreatedAt;
    }
}
