package com.bycrptlogger.model;


import javax.persistence.*;

@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String text;

    @ManyToOne
    SiteUser siteUser;

    public Posts(){}
    public Posts(String text){
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public SiteUser getSiteUser() {
        return siteUser;
    }

    public void setSiteUser(SiteUser siteUser) {
        this.siteUser = siteUser;
    }

    public String getText() {
        return text;
    }

    public void setId(long id) {
        this.id = id;
    }



    public void setText(String text) {
        this.text = text;
    }
}
