package com.kaanju;

import jakarta.xml.bind.annotation.XmlAttribute;

public class Item {
    private String id;
    private String author;

    //setters
    @XmlAttribute
    public void setId(String givenId) {
        this.id = givenId;
    }

    @XmlAttribute
    public void setAuthor(String givenAuthor) {
        this.author = givenAuthor;
    }

    //getters
    public String getId() {
        return this.id;
    }

    public String getAuthor() {
        return this.author;
    }



}
