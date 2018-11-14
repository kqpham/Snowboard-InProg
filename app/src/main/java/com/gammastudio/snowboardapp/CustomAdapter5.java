package com.gammastudio.snowboardapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CustomAdapter5 extends RecyclerView.Adapter<CustomAdapter5.ViewHolder> {


    //vars
    private ArrayList<String> bindings = new ArrayList<>();
    private ArrayList<String> bindingPrices = new ArrayList<>();
    private ArrayList<String> bindingImages = new ArrayList<>();
    private Context mContext;

    public CustomAdapter5(Context mContext, ArrayList<String> binds, ArrayList<String> bindingPrice , ArrayList<String> bindingImage ) {
        this.bindings = binds;
        this.bindingPrices = bindingPrice;
        this.bindingImages = bindingImage;
        this.mContext = mContext;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view   = LayoutInflater.from(parent.getContext()).inflate(R.layout.gearselectlayer, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(mContext).asBitmap().load(bindingImages.get(position)).into(holder.bindinghImage);

        holder.bindinghName.setText(bindings.get(position));
        holder.bindinghPrice.setText(bindingPrices.get(position));
        holder.bindinghImage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Toast.makeText(mContext, bindings.get(position) + " - " + bindingPrices.get(position),Toast.LENGTH_SHORT);

                Intent intent = new Intent(mContext, ListItem.class);
                intent.putExtra("image_url", bindingImages.get(position));
                intent.putExtra("image_name", bindings.get(position));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bindingImages.size();
    }

   /* CustomAdapter(Context context, Snowboards[] boards){
        super(context,R.layout.gearselectlayer,boards);

    }*/

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView bindinghName ;
        TextView bindinghPrice ;
        ImageView bindinghImage ;

        public ViewHolder(View itemView) {
            super(itemView);
             bindinghName = (TextView) itemView.findViewById(R.id.gearName);
             bindinghPrice = (TextView) itemView.findViewById(R.id.gearPrice);
             bindinghImage = (ImageView) itemView.findViewById(R.id.gearImage);
        }
    }


}
