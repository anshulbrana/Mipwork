package com.example.game.mipwork_copy;

/**
 * Created by game on 23/02/18.
 */


public class Item {
    String number,cnumber;
    int image;
    int maudioresourceID;

    public Item(String number,String cnumber,int image,int maudioresourceID){
        this.number=number;
        this.cnumber=cnumber;
        this.image=image;
        this.maudioresourceID=maudioresourceID;
    }
    public String getNumber(){
        return number;
    }
    public void setNumber(String number){
        this.number=number;
    }
    public String getCNumber(){
        return cnumber;
    }
    public void setCNumber(String cnumber){
        this.cnumber=cnumber;
    }
    public int getImage(){
        return image;
    }
    public void setImage(int image){
        this.image=image;
    }

    public int getMaudioresourceID(){
        return maudioresourceID;
    }
    public void setMaudioresourceID(int maudioresourceID){
        this.maudioresourceID=maudioresourceID;
    }

}
