package com.github.giovane.entity;

public class CompanyEntity implements Entity {

    private int id;

    private String name;

    private String address;

    public int getId() {
        return id;
    }

    public CompanyEntity setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CompanyEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public CompanyEntity setAddress(String address) {
        this.address = address;
        return this;
    }

}
