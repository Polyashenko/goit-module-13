package com.goit.module13;

public class TypicodeUser {
    private Long id;
    private String name;
    private String username;
    private TypicodeUserAddress address;

    private String phone;
    private String website;
    private TypicodeUserCompany company;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public TypicodeUserCompany getCompany() {
        return company;
    }

    public void setCompany(TypicodeUserCompany company) {
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public TypicodeUserAddress getAddress() {
        return address;
    }

    public void setAddress(TypicodeUserAddress address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "TypicodeUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", address=" + address +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", company=" + company +
                '}';
    }
}


