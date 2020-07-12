package com.akter.retrofitdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.akter.retrofitdemo.R;
import com.akter.retrofitdemo.modelClass.FlowerData;
import java.util.List;

public class FlowerListAdapter extends RecyclerView.Adapter<FlowerListAdapter.MyViewHolder>{

    Context context;
    List<FlowerData> dataList;


    public FlowerListAdapter(Context context, List<FlowerData> dataList) {
        this.context = context;
        this.dataList = dataList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.row_design,viewGroup,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.flowerName.setText(dataList.get(position).getName());
        holder.flowerCategory.setText(dataList.get(position).getCategory());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView flowerName,flowerCategory;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            flowerCategory  = itemView.findViewById(R.id.categoryName);
            flowerName      = itemView.findViewById(R.id.flowerName);

        }
    }
}
