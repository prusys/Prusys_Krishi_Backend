package com.example.prudentkrishi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.lifecycle.LifecycleObserver;

import com.example.prudentkrishi.data.Detail;
import com.example.prudentkrishi.data.DetailAdapter;
import com.example.prudentkrishi.data.Detaildata;

import java.util.List;

public class MyFragment extends ListFragment {
    List<Detail> det=new Detaildata().detlist();
    public MyFragment() {
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DetailAdapter adapter= new DetailAdapter(getActivity(),R.layout.details,det);
        setListAdapter(adapter);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.myfragment,container,false);
        return view;
    }
}
