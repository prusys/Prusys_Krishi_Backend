package com.example.prudentkrishi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.prudentkrishi.data.Detail;

public class MainActivity extends AppCompatActivity implements MyFragment.callbacks{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  FragmentManager fm= getSupportFragmentManager();
      //  Fragment fragment=fm.findFragmentById(R.id.mycontainer);
      //  if(fragment==null) fragment= new MyFragment();
       // fm.beginTransaction().add(R.id.mycontainer,fragment).commit();




    }

    @Override
    public void onItem(Detail detail,int position) {
Intent intent= new Intent(MainActivity.this,AllDetails.class);
        intent.putExtra("detail_id",position);
startActivity(intent);


    }
}