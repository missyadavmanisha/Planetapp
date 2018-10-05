package com.codingblocks.planet;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivityFragment extends Fragment {

    String title,subtitle,url;
     @SuppressLint("validFragment")
    public DetailActivityFragment(String title,String subtitle,String url){
        this.title=title;
        this.subtitle=subtitle;
        this.url=url;

    }


    public DetailActivityFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView title1 = view.findViewById(R.id.text);
        TextView subtitle1 = view.findViewById(R.id.text1);
        ImageView url1=view.findViewById(R.id.imagef);
        Intent i = getActivity().getIntent();

        if (i.hasExtra("title")) {
            String receivedName = i.getStringExtra("title");
            title1.setText(receivedName);
        } else
            title1.setText(title);
        if (i.hasExtra("subtitle")) {
            String receivedName = i.getStringExtra("subtitle");
            subtitle1.setText(receivedName);
        } else
            subtitle1.setText(subtitle);
        if (i.hasExtra("url")) {
            String receivedName = i.getStringExtra("url");
            Picasso.get()
                    .load(receivedName)
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(url1);
        } else
            Picasso.get()
                    .load(url)
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(url1);

    }
}