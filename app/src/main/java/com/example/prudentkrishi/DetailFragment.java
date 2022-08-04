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
            TextView tex3=view.findViewById(R.id.textView3);
            TextView tex4=view.findViewById(R.id.textView4);
            TextView tex5=view.findViewById(R.id.textView5);
            TextView tex6=view.findViewById(R.id.textView6);
            TextView tex7=view.findViewById(R.id.textView7);
            tex2.setText(detail.getDet1());
            tex3.setText(detail.getDet2());
            tex4.setText(detail.getDet3());
            tex5.setText(detail.getDet4());
            tex6.setText(detail.getDet5());
            tex7.setText(detail.getDet6());


        }
        return view;

    }

}
