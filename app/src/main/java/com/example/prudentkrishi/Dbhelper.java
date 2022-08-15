package com.example.prudentkrishi;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Dbhelper extends SQLiteOpenHelper {

    private static final String TABLE_NAME="REPORT";
    private static final int DB_VERSION = 1;
    private static final String COL1="Date";
    private static final String COL2="Time";
    private static final String COL3="Millis";
    private static final String COL4="Wind_Dir";
    private static final String COL5="Wind_speed";
    private static final String COL6="Rain";
    private static final String COL7="BMP_temp";
    private static final String COL8="BMP_humid";
    private static final String COL9="BMP_pressure";
    private static final String COL10="BMP_altitude";
    private static final String COL11="BMP_dew";
    private static final String COL12="LUX";
    private static final String COL13="S_PH";
    private static final String COL14="S_Moist";
    private static final String COL15="S_temp";
    private static final String COL16="S_con";
    private static final String COL17="Nitrogen";
    private static final String COL18="Phosporous";
    private static final String COL19="Potassium";
    private static final String COL20="Soil_hum";
    private static final String COL21="Soil_temp";
    private static final String COL22="Leaf";
    private static final String COL23="UV";

    public Dbhelper(Context context){
        super(context,TABLE_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,Date TEXT,Time TEXT, Millis TEXt,Wind_Dir TEXT,Wind_speed TEXT,Rain TEXT,BMP_temp TEXT,BMP_humid TEXT,BMP_pressure TEXT,BMP_altitude TEXT,BMP_dew TEXT,LUX TEXT,S_PH TEXT,S_Moist TEXT,S_temp TEXT,S_con TEXT,Nitrogen TEXT,Phosporous TEXT,Potassium TEXT,Soil_hum TEXT,Soil_temp TEXT,Leaf TEXT,UV TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

}
