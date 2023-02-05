package com.study.task3;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "country")
public class Country {
    private String city;
    private String street;
    private String building;

    public Country(){}

    public Country(String city, String street, String building) {
        this.city = city;
        this.street = street;
        this.building = building;
    }

    @Override
    public String toString() {
        return "Country{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", building='" + building + '\'' +
                '}';
    }

    public String getCity() {
        return city;
    }
    @XmlElement
    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }
    @XmlElement
    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }
    @XmlElement
    public void setBuilding(String building) {
        this.building = building;
    }
}
