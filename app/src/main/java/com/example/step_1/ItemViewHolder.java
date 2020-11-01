package com.example.step_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class itemViewAdaprer extends RecyclerView.Adapter<itemViewAdaprer.itemViewHolder>{

    private List<Item> moneyList = new ArrayList<>();

    public void SetData(List<Item> tmp_data){
        moneyList.clear();
        moneyList.addAll(tmp_data);

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public itemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new itemViewHolder(layoutInflater.inflate(R.layout.activity_main,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull itemViewHolder holder, int position) {
        holder.bind(moneyList.get(position));
    }

    @Override
    public int getItemCount() {
        return moneyList.size();
    }

    static class itemViewHolder extends RecyclerView.ViewHolder{

        private TextView name_c;
        private TextView price_c;

        public itemViewHolder(@NonNull View itemView) {
            super(itemView);
            name_c = itemView.findViewById(R.id.cell_name);
            price_c = itemView.findViewById(R.id.cell_price);
        }

        public void bind(Item item){
            name_c.setText(item.getName());
            price_c.setText(new String(String.valueOf(item.getPrice())));
        }
    }
}