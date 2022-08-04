package com.example.prudentkrishi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.prudentkrishi.data.Detail;
import com.example.prudentkrishi.data.Detaildata;

public class AllDetails extends AppCompatActivity {
Detail detail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_details);

        if(savedInstanceState==null){

            Bundle extras=getIntent().getExtras();
            int position=extras.getInt("detail_id");
            detail=new Detaildata().detlist().get(position);
            DetailFragment fragment= new DetailFragment();
            fragment.setArguments(extras);
            FragmentManager fragmentManager= getSupportFragmentManager();
            fragmentManager.beginTransaction().add(R.id.detail_container,fragment).commit();
        }
    }
}