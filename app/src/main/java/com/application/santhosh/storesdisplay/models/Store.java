package com.application.santhosh.storesdisplay.models;

import java.io.Serializable;

public class Store implements Serializable{
  private String address;

  public String getAddress() { return this.address; }

  public void setAddress(String address) { this.address = address; }

  private String city;

  public String getCity() { return this.city; }

  public void setCity(String city) { this.city = city; }

  private String name;

  public String getName() { return this.name; }

  public void setName(String name) { this.name = name; }

  private String latitude;

  public String getLatitude() { return this.latitude; }

  public void setLatitude(String latitude) { this.latitude = latitude; }

  private String zipcode;

  public String getZipcode() { return this.zipcode; }

  public void setZipcode(String zipcode) { this.zipcode = zipcode; }

  private String storeLogoURL;

  public String getStoreLogoURL() { return this.storeLogoURL; }

  public void setStoreLogoURL(String storeLogoURL) { this.storeLogoURL = storeLogoURL; }

  private String phone;

  public String getPhone() { return this.phone; }

  public void setPhone(String phone) { this.phone = phone; }

  private String longitude;

  public String getLongitude() { return this.longitude; }

  public void setLongitude(String longitude) { this.longitude = longitude; }

  private String storeID;

  public String getStoreID() { return this.storeID; }

  public void setStoreID(String storeID) { this.storeID = storeID; }

  private String state;

  public String getState() { return this.state; }

  public void setState(String state) { this.state = state; }

  @Override
  public String toString() {
    return "Store{" +
            "address='" + address + '\'' +
            ", city='" + city + '\'' +
            ", name='" + name + '\'' +
            ", latitude='" + latitude + '\'' +
            ", zipcode='" + zipcode + '\'' +
            ", storeLogoURL='" + storeLogoURL + '\'' +
            ", phone='" + phone + '\'' +
            ", longitude='" + longitude + '\'' +
            ", storeID='" + storeID + '\'' +
            ", state='" + state + '\'' +
            '}';
  }
}