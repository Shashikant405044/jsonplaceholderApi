package com.example.apiintegration.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apiintegration.R;
import com.example.apiintegration.model.userresponse.UsersResponse;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.MyViewHolder> {

    Context context;
    List<UsersResponse> usersResponseList ;

    public UsersAdapter(Context context, List<UsersResponse> usersResponseList) {
        this.context = context;
        this.usersResponseList = usersResponseList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.users_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        UsersResponse usersResponse = usersResponseList.get(position);
        holder.idtxt.setText(usersResponse.getIdData());
        holder.name.setText(usersResponse.getName());
        holder.username.setText(usersResponse.getUsername());
        holder.email.setText(usersResponse.getEmail());

        holder.street.setText(usersResponse.getAddressPojoData().getStreet());
        holder.suite.setText(usersResponse.getAddressPojoData().getSuite());
        holder.city.setText(usersResponse.getAddressPojoData().getCity());
        holder.zipcode.setText(usersResponse.getAddressPojoData().getZipcode());
        holder.lat.setText(usersResponse.getAddressPojoData().getGeoPojoData().getLatitude());
        holder.lan.setText(usersResponse.getAddressPojoData().getGeoPojoData().getLongitude());
//

        holder.phone.setText(usersResponse.getPhone());
        holder.website.setText(usersResponse.getWebsite());
        holder.namec.setText(usersResponse.getCompanyPojoData().getName());
        holder.catchPhrase.setText(usersResponse.getCompanyPojoData().getCatchPhrase());
        holder.bs.setText(usersResponse.getCompanyPojoData().getBs());



    }

    @Override
    public int getItemCount() {
        return usersResponseList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView idtxt, name, username,email;
        TextView street, suite,city,zipcode;
        TextView lat,lan;
        TextView phone, website;
        TextView namec,catchPhrase, bs;


        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            idtxt = itemView.findViewById(R.id.id);
            name = itemView.findViewById(R.id.name);
            username = itemView.findViewById(R.id.username);
            email = itemView.findViewById(R.id.email);

            street = itemView.findViewById(R.id.street);
            suite = itemView.findViewById(R.id.suite);
            city = itemView.findViewById(R.id.city);
            zipcode = itemView.findViewById(R.id.zipcode);

            lat = itemView.findViewById(R.id.lat);
            lan = itemView.findViewById(R.id.lan);
            phone = itemView.findViewById(R.id.phone);
            website = itemView.findViewById(R.id.website);
            namec = itemView.findViewById(R.id.C_name);
            catchPhrase = itemView.findViewById(R.id.catchPhrase);
            bs = itemView.findViewById(R.id.bs);




        }
    }
}
