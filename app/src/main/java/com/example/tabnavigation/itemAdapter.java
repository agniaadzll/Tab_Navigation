package com.example.tabnavigation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class itemAdapter extends RecyclerView.Adapter<itemAdapter.ViewHolder> {
    private Context context;
    private ArrayList<itemData> values;
    private LayoutInflater inflater;
    public itemAdapter(Context context, ArrayList<itemData> values){
        this.context=context;
        this.values=values;
        this.inflater=LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.item_list,parent,false)
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        itemData data=values.get(position);
        holder.titleText.setText(data.itemTitle);
        holder.subText.setText(data.itemSubTitle);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Anda pilih data"+data.itemTitle,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public int getItemCount() {
        return values.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView titleText;
        TextView subText;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            titleText=itemView.findViewById(R.id.text1);
            subText=itemView.findViewById(R.id.text2);
        }
    }
}
