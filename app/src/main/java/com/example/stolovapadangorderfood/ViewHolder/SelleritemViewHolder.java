package com.example.stolovapadangorderfood.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.stolovapadangorderfood.Interface.ItemClickListener;
import com.example.stolovapadangorderfood.R;

import androidx.recyclerview.widget.RecyclerView;


public class SelleritemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    public TextView txtProductName, txtProductPrice, txtProductState, txtRestoName;
    public ImageView imageView;
    public ItemClickListener listener;


    public SelleritemViewHolder(View itemView) {
        super(itemView);

        imageView = (ImageView) itemView.findViewById(R.id.seller_select_product_image);
        txtRestoName = (TextView) itemView.findViewById(R.id.seller_resto_name);
        txtProductName = (TextView) itemView.findViewById(R.id.seller_product_name);
        txtProductPrice = (TextView) itemView.findViewById(R.id.seller_product_price);
        txtProductState = (TextView) itemView.findViewById(R.id.seller_product_state);
    }

    public void setItemClickListener(ItemClickListener listener)
    {
        this.listener = listener;
    }

    @Override
    public void onClick(View view)
    {
        listener.onClick(view, getAdapterPosition(), false);
    }
}