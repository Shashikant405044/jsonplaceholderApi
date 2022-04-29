package com.example.apiintegration.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.apiintegration.R;
import com.example.apiintegration.model.PhotosResponse;
import com.squareup.picasso.Picasso;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.MyViewHolder> {

      Context context;
      List<PhotosResponse> photosResponseList;

    public PhotosAdapter(Context context, List<PhotosResponse> photosResponseList) {
        this.context = context;
        this.photosResponseList = photosResponseList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.photos_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        PhotosResponse photosResponse = photosResponseList.get(position);

        holder.idtext.setText(photosResponse.getId());
        holder.album_id.setText(photosResponse.getAlbumId());
      //   holder.title.setText(photosResponse.getTitle());
        Picasso.with(context).load(photosResponse.getThumbnailUrl()).into(holder.url);

      //  Glide.with(context).load(photosResponse.getThumbnailUrl()).apply(RequestOptions.centerCropTransform()).into(holder.url);

    }

    @Override
    public int getItemCount() {
        return photosResponseList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView idtext, album_id, title;
        ImageView url, thumurl;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            idtext = itemView.findViewById(R.id.id_data);
            album_id = itemView.findViewById(R.id.album_id);
            title = itemView.findViewById(R.id.title);

            url = itemView.findViewById(R.id.url);
            thumurl = itemView.findViewById(R.id.thumbnailUrl);




        }
    }
}
