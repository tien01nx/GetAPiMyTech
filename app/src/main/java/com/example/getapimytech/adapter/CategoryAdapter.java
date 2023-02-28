package com.example.getapimytech.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.getapimytech.R;
import com.example.getapimytech.model.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder>{
    private Context context;
    private List<Category> categoryList;

    public CategoryAdapter(Context context, List<Category> movieList) {
        this.context = context;
        this.categoryList = movieList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        v =layoutInflater.inflate(R.layout.list_item_category,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.id.setText(categoryList.get(position).getId());
        holder.name.setText(categoryList.get(position).getName());


    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public static class MyViewHolder extends  RecyclerView.ViewHolder{
        TextView name;
        TextView id;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name =itemView.findViewById(R.id.txt_name);
            id = itemView.findViewById(R.id.txt_id);

        }
    }
}
