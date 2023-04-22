package com.goit.module13;

public class TypicodeUserAddress {
    private String street;
    private String suite;
    private String city;
    private String zipcode;

    private TypicodeUserAddressGeo geo;

    public TypicodeUserAddressGeo getGeo() {
        return geo;
    }

    public void setGeo(TypicodeUserAddressGeo geo) {
        this.geo = geo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    @Override
    public String toString() {
        return "TypicodeUserAddress{" +
                "street='" + street + '\'' +
                ", suite='" + suite + '\'' +
                ", city='" + city + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", geo=" + geo +
                '}';
    }
}
