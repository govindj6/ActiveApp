package com.example.activeapp;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "User")
public class User extends Model {
    @Column(name = "Name")
    public String name;
    @Column(name = "Mobile")
    public String mobile;
    @Column(name ="Email")
    public String email;
    @Column(name = "Password")
    public String password;

    public User() {
        super();
    }

    public User(String name, String mobile, String email, String password) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
    }

    @Table(name = "Ironman")
    public static class Ironman extends Model{
        @Column(name = "Mobile")
        public String mobile;
        @Column(name = "Email")
        public String email;
        @Column(name = "Password")
        public String password;
        @Column(name = "Height")
        public String height;
        @Column(name = "Moto")
        public String moto;
        @Column(name = "Power")
        public String power;
        @Column(name = "Gender")
        public String gender;
        @Column(name = "Image")
        public String image;

        public Ironman() {
            super();
        }

        public Ironman(String mobile, String email, String password, String height, String moto, String power, String gender, String image) {
            this.mobile = mobile;
            this.email = email;
            this.password = password;
            this.height = height;
            this.moto = moto;
            this.power = power;
            this.gender = gender;
            this.image = image;
        }
    }
}
