package com.example.lab08_idnp;


import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView textData;
    TextView textTitle;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        textData = itemView.findViewById(R.id.textData);
        textTitle = itemView.findViewById(R.id.textTitle);
    }
}

