package com.example.prudentkrishi;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

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

    List<Detail> dets=new Detaildata().detlist();
    private callbacks activity;


    public MyFragment() {
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DetailAdapter adapter= new DetailAdapter(getActivity(),R.layout.details,dets);
        setListAdapter(adapter);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.myfragment,container,false);
        return view;
    }
    public interface callbacks{

        public void onItem(Detail detail,int position);
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        Detail x=dets.get(position);
        Toast.makeText(getActivity(),"PositionName"+x.getDet1(),Toast.LENGTH_LONG).show();
       this.activity.onItem(x,position);

    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context); this.activity=(callbacks) context;
    }
}
