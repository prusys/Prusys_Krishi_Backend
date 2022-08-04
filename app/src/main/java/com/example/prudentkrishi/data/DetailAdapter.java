package com.example.prudentkrishi.data;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.prudentkrishi.R;

import java.util.List;

public class DetailAdapter extends ArrayAdapter<Detail> {
    private List<Detail> details;
    private Context context;
    public DetailAdapter(@NonNull Context context, int resource, @NonNull List<Detail> details) {
        super(context, resource, details);
        this.context=context;
        this.details=details;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Detail detail=details.get(position);
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view= inflater.inflate(R.layout.details,null);
        TextView tx1=view.findViewById(R.id.textView);
        tx1.setText(detail.getDet1());

        return view;
    }

}
