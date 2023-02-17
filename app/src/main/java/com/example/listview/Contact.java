package com.example.listview;

public class Contact {
    private int id;
    private String images;
    private String name;
    private String phone;

    public Contact(int id, String images, String name, String phone) {
        this.id = id;
        this.images = images;
        this.name = name;
        this.phone = phone;
    }

    public Contact() {
    }

    public int getId() {
        return id;
    }

    public String getImages() {
        return images;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
