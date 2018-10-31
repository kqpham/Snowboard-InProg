package com.gammastudio.snowboardapp;

class Helmit {
    private Integer id;
    private String name;
    private String brand;
    private Float price;
    private Float rating;
    private String imageURL;

    public Helmit(){

    }

    public Helmit(Integer idVal, String nameVal, String brandVal, Float priceVal, Float ratingVal, String imageURLVal){
        this.id = idVal;
        this.name = nameVal;
        this.price = priceVal;
        this.brand = brandVal;
        this.rating = ratingVal;
        this.imageURL = imageURLVal;
    }

    public Integer getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getBrand()
    {
        return brand;
    }
    public Float getPrice()
    {
        return price;
    }
    public Float getRating()
    {
        return rating;
    }

    public String getImageURL()
    {
        return imageURL;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
