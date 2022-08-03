package com.example.prudentkrishi.data;

import java.util.ArrayList;
import java.util.List;

public class Detaildata {
    String[] details={ "Soil Temperature","Temperature","Humidity","Rainfall","WindSpeed","LightPAR"};


    public List<Detail> detlist() {
        ArrayList<Detail> list= new  ArrayList<Detail>();
        for(int i=0;i<details.length;i++){
            Detail det=new Detail(details[i]);list.add(det);
        }
        return list;
    }
}
