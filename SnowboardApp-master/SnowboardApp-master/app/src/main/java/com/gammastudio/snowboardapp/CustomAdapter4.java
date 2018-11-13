package com.gammastudio.snowboardapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CustomAdapter4 extends RecyclerView.Adapter<CustomAdapter4.ViewHolder> {


    //vars
    private ArrayList<String> helmets = new ArrayList<>();
    private ArrayList<String> helmetPrices = new ArrayList<>();
    private ArrayList<String> helmetImages = new ArrayList<>();
    private Context mContext;

    public CustomAdapter4(Context mContext, ArrayList<String> helmets, ArrayList<String> helmetPrices, ArrayList<String> helmetImages) {
        this.helmets = helmets;
        this.helmetPrices = helmetPrices;
        this.helmetImages = helmetImages;
        this.mContext = mContext;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view   = LayoutInflater.from(parent.getContext()).inflate(R.layout.gearselectlayer, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(mContext).asBitmap().load(helmetImages.get(position)).into(holder.helmethImage);

        holder.helmethName.setText(helmets.get(position));
        holder.helmethPrice.setText(helmetPrices.get(position));
        holder.helmethImage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Toast.makeText(mContext, helmets.get(position) + " - " + helmetPrices.get(position),Toast.LENGTH_SHORT);
            }
        });
    }

    @Override
    public int getItemCount() {
        return helmetImages.size();
    }

   /* CustomAdapter(Context context, Snowboards[] helmets){
        super(context,R.layout.gearselectlayer,helmets);

    }*/

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView helmethName;
        TextView helmethPrice;
        ImageView helmethImage;

        public ViewHolder(View itemView) {
            super(itemView);
             helmethName = (TextView) itemView.findViewById(R.id.gearName);
             helmethPrice = (TextView) itemView.findViewById(R.id.gearPrice);
             helmethImage = (ImageView) itemView.findViewById(R.id.gearImage);
        }
    }
/*
    @Override
   public View getView(int position,  View convertView,  ViewGroup parent) {
        LayoutInflater boardInflater = LayoutInflater.from(getContext());
        View customView = boardInflater.inflate(R.layout.gearselectlayer, parent, false);

        Snowboards singleboardItem = getItem(position);
        TextView boardName = (TextView) customView.findViewById(R.id.gearName);
        TextView boardPrice = (TextView) customView.findViewById(R.id.gearPrice);
        ImageView boardImage = (ImageView) customView.findViewById(R.id.gearImage);

        boardName.setText(singleboardItem.name);
        boardPrice.setText(singleboardItem.price);

        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeStream((InputStream)new URL(singleboardItem.imageURL).getContent());
        } catch (IOException e) {
            e.printStackTrace();
        }
        boardImage.setImageBitmap(bitmap);
        return customView;
    }*/


}
