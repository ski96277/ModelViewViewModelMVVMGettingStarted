package com.example.modelviewview_modelmvvmgettingstarted.adapter_class;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.modelviewview_modelmvvmgettingstarted.R;
import com.example.modelviewview_modelmvvmgettingstarted.pojoClass.Users;
import com.squareup.picasso.Picasso;

public class UserAdapterClass extends RecyclerView.Adapter<UserAdapterClass.UserViewViewHolder> {
    Users[] users;
    Context context;

    public UserAdapterClass(Users[] users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //DataBinding
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_view, viewGroup, false);
        return new UserViewViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull UserViewViewHolder userViewViewHolder, int i) {

        Picasso.get().load(users[i].getAvatarUrl()).into(userViewViewHolder.imageView);
        userViewViewHolder.name.setText(users[i].getLogin());
        userViewViewHolder.description.setText(users[i].getType());

    }

    @Override
    public int getItemCount() {
        return users.length;
    }

    //create Class View
    public class UserViewViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name;
        TextView description;

        public UserViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView_profile);
            name = itemView.findViewById(R.id.name_TV);
            description = itemView.findViewById(R.id.descricptio_TV);
        }
    }
}
