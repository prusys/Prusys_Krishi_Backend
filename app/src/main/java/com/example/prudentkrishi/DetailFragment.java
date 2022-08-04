package com.example.prudentkrishi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleObserver;

import com.example.prudentkrishi.data.Detail;
import com.example.prudentkrishi.data.Detaildata;

public class DetailFragment extends Fragment {
    Detail detail;


    public DetailFragment() {

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle=getArguments();
if(bundle!=null&&bundle.containsKey("detail_id")){
    int position=bundle.getInt("detail_id");
    detail=new Detaildata().detlist().get(position);
}
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.detail_fragment,container ,false);
        if(detail!=null){
            TextView tex2=view.findViewById(R.id.textView2);
            tex2.setText(detail.getDet1());

        }
        return view;

    }

}
