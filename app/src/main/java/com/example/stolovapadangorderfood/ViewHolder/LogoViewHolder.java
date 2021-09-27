package com.example.stolovapadangorderfood.ViewHolder;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.stolovapadangorderfood.Interface.ItemClickListener;
import com.example.stolovapadangorderfood.R;

import androidx.recyclerview.widget.RecyclerView;

public class LogoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    public Button RestoLihatbtn;
    public ImageView RestoImage;
    public ItemClickListener listener;
    private String parentDbName = "Sellers";


    public LogoViewHolder(View itemView) {
        super(itemView);

        RestoImage = (ImageView) itemView.findViewById(R.id.select_resto_image);
        RestoLihatbtn = (Button) itemView.findViewById(R.id.restolihat_btn);
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