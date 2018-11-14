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

public class CustomAdapter3 extends RecyclerView.Adapter<CustomAdapter3.ViewHolder> {


    //vars
    private ArrayList<String> goggles = new ArrayList<>();
    private ArrayList<String> gogglesPrices = new ArrayList<>();
    private ArrayList<String> gogglesImages = new ArrayList<>();
    private Context mContext;

    public CustomAdapter3(Context mContext, ArrayList<String> goggles, ArrayList<String> gogglePrice, ArrayList<String> goggleImages ) {
        this.goggles = goggles;
        this.gogglesPrices = gogglePrice;
        this.gogglesImages = goggleImages;
        this.mContext = mContext;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view   = LayoutInflater.from(parent.getContext()).inflate(R.layout.gearselectlayer, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(mContext).asBitmap().load(gogglesImages.get(position)).into(holder.gogglehImage);

        holder.gogglehName.setText(goggles.get(position));
        holder.gogglehPrice.setText(gogglesPrices.get(position));
        holder.gogglehImage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Toast.makeText(mContext, goggles.get(position) + " - " + gogglesPrices.get(position),Toast.LENGTH_SHORT);

                Intent intent = new Intent(mContext, ListItem.class);
                intent.putExtra("image_url", gogglesImages.get(position));
                intent.putExtra("image_name", goggles.get(position));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return gogglesImages.size();
    }

   /* CustomAdapter(Context context, Snowboards[] boards){
        super(context,R.layout.gearselectlayer,boards);

    }*/

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView gogglehName;
        TextView gogglehPrice;
        ImageView gogglehImage;

        public ViewHolder(View itemView) {
            super(itemView);
             gogglehName = (TextView) itemView.findViewById(R.id.gearName);
             gogglehPrice = (TextView) itemView.findViewById(R.id.gearPrice);
             gogglehImage = (ImageView) itemView.findViewById(R.id.gearImage);
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
