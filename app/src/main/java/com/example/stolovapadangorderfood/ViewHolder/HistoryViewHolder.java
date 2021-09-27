package com.example.stolovapadangorderfood.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.stolovapadangorderfood.Interface.ItemClickListener;
import com.example.stolovapadangorderfood.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HistoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    public TextView txtDate, txtTime, txtRestoName, txtProductName, txtProductPrice, txtProductQuantity, txtTotalPrice;
    private ItemClickListener itemClickListener;
    public ImageView imageView;


    public HistoryViewHolder(@NonNull View itemView)
    {
        super(itemView);
        txtDate = itemView.findViewById(R.id.histori_date);
        txtTime = itemView.findViewById(R.id.histori_time);
        txtRestoName = itemView.findViewById(R.id.histori_resto_name);
        txtProductName = itemView.findViewById(R.id.histori_product_name);
        txtProductPrice= itemView.findViewById(R.id.histori_product_price);
        txtProductQuantity = itemView.findViewById(R.id.histori_product_quantity);
        txtTotalPrice = itemView.findViewById(R.id.histori_total_harga);
    }

    @Override
    public void onClick(View view)
    {
        itemClickListener.onClick(view, getAdapterPosition(), false);
    }

    public void setItemClickListener(ItemClickListener itemClickListener)
    {
        this.itemClickListener = itemClickListener;
    }
}
