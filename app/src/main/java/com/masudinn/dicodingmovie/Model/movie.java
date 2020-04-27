package com.masudinn.dicodingmovie.Model;

public class movie {
    String id,tittle,img,overview,date,rate,type;

    public movie(String id, String tittle, String img, String overview, String date, String rate, String type) {
        this.id = id;
        this.tittle = tittle;
        this.img = img;
        this.overview = overview;
        this.date = date;
        this.rate = rate;
        this.type = type;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
