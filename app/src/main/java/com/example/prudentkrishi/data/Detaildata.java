package com.example.prudentkrishi.data;

import java.util.ArrayList;
import java.util.List;

public class Detaildata {
    Detail[] details={new Detail ("SoilTemperature","det2soiltemp","det3soiltemp","det4soiltemp","det5soiltemp","det6soiltemp") ,
            new Detail ("Temperature","det2temp","det3temp","det4temp","det5temp","det6temp"),
            new Detail ("Humidity","det2humidity","det3humidity","det4humidity","det5humidity","det6humidity"),
            new Detail ("Rainfall","det2rainfall","det3rainfall","det4rainfall","det5rainfall","det6rainfall"),
    new Detail("WindSpeed","det2windspeed","det3windspeed","det4windspeed","det5windspeed","det6windspeed"),
    new Detail("Light_PAR","det2lightPar","det3lightPar","det4lightPar","det5lightPar","det6lightPar")};


    public List<Detail> detlist() {
        ArrayList<Detail> list= new  ArrayList<Detail>();
        for(int i=0;i<details.length;i++){
            Detail det=new Detail(details[i].getDet1(),details[i].getDet2(),details[i].getDet3(),details[i].getDet4(),details[i].getDet5(),details[i].getDet6());list.add(det);
        }
        return list;
    }
}
