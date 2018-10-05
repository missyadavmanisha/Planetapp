package com.codingblocks.planet;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import com.squareup.picasso.Picasso;

public class HetrogeneousAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Imageclass> arrayList;
    private AppCompatActivity appCompatActivity;
    private Context ctx;

    public HetrogeneousAdapter(ArrayList<Imageclass> arrayList, AppCompatActivity appCompatActivity) {
        this.arrayList = arrayList;
        this.appCompatActivity = appCompatActivity;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ctx = parent.getContext();
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        View inflatedView = li.inflate(R.layout.layout_row_image, parent, false);
        return new ImageHolder(inflatedView);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


        final Imageclass currentImage = arrayList.get(position);
        ImageHolder imageHolder = (ImageHolder) holder;
        Picasso.get()
                .load(currentImage.getUrl())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(imageHolder.imageView);

        imageHolder.subtitle.setText(currentImage.getSubtitle());
        imageHolder.title.setText(currentImage.getTitle());


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ImageHolder extends RecyclerView.ViewHolder {
        TextView title, subtitle;
        ImageView imageView;

        public ImageHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Imageclass imageclass=arrayList.get(getAdapterPosition());

                    if (appCompatActivity.findViewById(R.id.container)==null) {
                        startIntent(imageclass.getTitle(),imageclass.getSubtitle(),imageclass.getUrl());


                    } else
                        addFragment(imageclass.getTitle(),imageclass.getSubtitle(),imageclass.getUrl());




                }
            });
            title = itemView.findViewById(R.id.title);
            subtitle = itemView.findViewById(R.id.subtitle);
            imageView = itemView.findViewById(R.id.imageview);
        }
    }




   private void startIntent(String title,String subtitle,String url) {
        Intent intent = new Intent(ctx, DetailActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("subtitle", subtitle);
        intent.putExtra("url", url);
        ctx.startActivity(intent);
        }

     private void addFragment(String title,String subtitle,String url) {

        FragmentManager fm = appCompatActivity.getSupportFragmentManager();
        fm.beginTransaction()
                .add(R.id.container,new DetailActivityFragment(title,subtitle,url))
        .commit();
        }
}