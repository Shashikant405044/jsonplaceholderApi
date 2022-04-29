package com.example.apiintegration.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apiintegration.R;
import com.example.apiintegration.model.PostResponse;

import java.util.List;
import java.util.Random;

public class GetDataAdapter extends RecyclerView.Adapter<GetDataAdapter.MyViewHolder> {


    List<PostResponse> list;
    Context context;

    public GetDataAdapter(List<PostResponse> list, Context context) {

        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.get_api_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        PostResponse postResponse = list.get(position);
        holder.userid.setText(postResponse.getId());
        holder.id.setText(postResponse.getUserId());
        holder.title.setText(postResponse.getTitle());
        holder.body.setText(postResponse.getBody());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView userid, id, title,body;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            userid = itemView.findViewById(R.id.userId);
            id = itemView.findViewById(R.id.id);
            title = itemView.findViewById(R.id.title);
            body = itemView.findViewById(R.id.body);
        }
    }
}
