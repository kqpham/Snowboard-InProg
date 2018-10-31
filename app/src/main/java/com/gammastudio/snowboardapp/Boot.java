package com.gammastudio.snowboardapp;

class Boot {
    private Integer id;
    private String name;
    private String brand;
    private Float price;
    private Integer rating;
    private String imageURL;

    public Boot(){

    }

    public Boot(Integer idVal, String nameVal, String brandVal, Float priceVal, Integer ratingVal, String imageURLVal){
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
    public Integer getRating()
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

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
