package com.codingblocks.planet;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MainActivityFragment extends Fragment{
    ArrayList<Imageclass> arrayList=new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        arrayList.add(new Imageclass("Mercury" ,"the closest planet to the sun","https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Mercury_in_color_-_Prockter07-edit1.jpg/225px-Mercury_in_color_-_Prockter07-edit1.jpg"));
        arrayList.add(new Imageclass("Venus" ,"terriably hot","https://upload.wikimedia.org/wikipedia/commons/thumb/e/e5/Venus-real_color.jpg/130px-Venus-real_color.jpg"));
        arrayList.add(new Imageclass("Earth" ,"where life exist","https://upload.wikimedia.org/wikipedia/commons/thumb/0/0d/Africa_and_Europe_from_a_Million_Miles_Away.png/126px-Africa_and_Europe_from_a_Million_Miles_Away.png"));
        arrayList.add(new Imageclass("Mars" ,"a cold, dusty place. ","https://upload.wikimedia.org/wikipedia/commons/thumb/0/02/OSIRIS_Mars_true_color.jpg/130px-OSIRIS_Mars_true_color.jpg"));
        arrayList.add(new Imageclass("Jupiter" ,"Jupiter is huge and is the most massive planet in our solar system","https://upload.wikimedia.org/wikipedia/commons/thumb/c/c1/Jupiter_New_Horizons.jpg/123px-Jupiter_New_Horizons.jpg"));
        arrayList.add(new Imageclass("Saturn" ,"Known for its rings.","https://upload.wikimedia.org/wikipedia/commons/thumb/f/f7/Jewel_of_the_Solar_System.jpg/148px-Jewel_of_the_Solar_System.jpg"));
        arrayList.add(new Imageclass("Uranus" ,"Uranus is an oddbal","https://upload.wikimedia.org/wikipedia/commons/thumb/2/2e/Uranus_true_colour.jpg/138px-Uranus_true_colour.jpg"));
        arrayList.add(new Imageclass("Neptune" ," one of the coldest in the solar system","https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/Neptune_true_colour.jpg/138px-Neptune_true_colour.jpg"));

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        HetrogeneousAdapter hetrogeneousAdapter = new HetrogeneousAdapter(arrayList, (AppCompatActivity) getActivity());

        recyclerView.setAdapter(hetrogeneousAdapter);
    }
}

