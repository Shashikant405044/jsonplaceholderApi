package com.example.apiintegration.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.apiintegration.R;
import com.example.apiintegration.model.CommentsResponse;
import java.util.List;
public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.MyViewHolder> {
    Context context;
    List<CommentsResponse> commentsResponseList;
    public CommentAdapter(Context context, List<CommentsResponse> commentsResponseList) {
        this.context = context;
        this.commentsResponseList = commentsResponseList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.comment_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        CommentsResponse comment = commentsResponseList.get(position);
        holder.postId.setText(comment.getPostId());
        holder.id.setText(comment.getId());
        holder.name.setText(comment.getName());
        holder.email.setText(comment.getEmail());
        holder.body.setText(comment.getBody());

    }

    @Override
    public int getItemCount() {
        return commentsResponseList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView postId, id, name, email, body;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            postId = itemView.findViewById(R.id.postId_t);
            id = itemView.findViewById(R.id.id);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            body = itemView.findViewById(R.id.body);
        }
    }
}
