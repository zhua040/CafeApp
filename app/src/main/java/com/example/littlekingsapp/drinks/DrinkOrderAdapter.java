package com.example.littlekingsapp.drinks;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.littlekingsapp.R;

import java.util.List;

// 1. extend RecyclerView class (the parent class)
public class DrinkOrderAdapter extends RecyclerView.Adapter<DrinkOrderAdapter.ViewHolder> {
    //Vars for the adapter
    List<DrinkModel> modelList;
    Context context;

    // constructor of OrderAdapter class
    public DrinkOrderAdapter(Context context, List<DrinkModel> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.drink_listitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //here we will find the position and start setting the output on our views
        holder.mDrinkName.setText(modelList.get(position).getmDrinkName());
        holder.mDrinkDescription.setText(modelList.get(position).getmDrinkDetail());
        holder.imageView.setImageResource(modelList.get(position).getmDrinkPhoto());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    // 2. create a ViewHolder sub-class and extend it to RecycleView.ViewHolder
    // In order to make our views responsible we can implement onClicklistener on our recycleViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        // here we will find the views on which we will inflate our data
        TextView mDrinkName, mDrinkDescription;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            mDrinkName = itemView.findViewById(R.id.coffeeName);
            mDrinkDescription = itemView.findViewById(R.id.description);
            imageView = itemView.findViewById(R.id.coffeeImage);

            //Invoke onclick method
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            // Let's get the position of the view in the list and then work on it
            int position = getAdapterPosition();
            if (position == 0){
                Intent intent = new Intent(context, Drink_InfoActivity.class);
                context.startActivity(intent);
            }
        }
    }

}
