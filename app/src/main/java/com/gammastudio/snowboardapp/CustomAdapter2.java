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

public class CustomAdapter2 extends RecyclerView.Adapter<CustomAdapter2.ViewHolder> {


    //vars
    private ArrayList<String> boots = new ArrayList<>();
    private ArrayList<String> bootsPrices = new ArrayList<>();
    private ArrayList<String> bootsImages = new ArrayList<>();
    private Context mContext;

    public CustomAdapter2(Context mContext, ArrayList<String> boots, ArrayList<String> bootsPrices, ArrayList<String> bootsImages) {
        this.boots = boots;
        this.bootsPrices = bootsPrices;
        this.bootsImages = bootsImages;
        this.mContext = mContext;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view   = LayoutInflater.from(parent.getContext()).inflate(R.layout.gearselectlayer, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(mContext).asBitmap().load(bootsImages.get(position)).into(holder.bootshImage);

        holder.bootshName.setText(boots.get(position));
        holder.bootshPrice.setText(bootsPrices.get(position));
        holder.bootshImage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Toast.makeText(mContext, boots.get(position) + " - " + bootsPrices.get(position),Toast.LENGTH_SHORT);

                Intent intent = new Intent(mContext, ListItem.class);
                intent.putExtra("image_url", bootsImages.get(position));
                intent.putExtra("image_name", boots.get(position));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bootsImages.size();
    }

   /* CustomAdapter(Context context, Snowboards[] boards){
        super(context,R.layout.gearselectlayer,boards);

    }*/

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView bootshName;
        TextView bootshPrice;
        ImageView bootshImage;

        public ViewHolder(View itemView) {
            super(itemView);
             bootshName = (TextView) itemView.findViewById(R.id.gearName);
             bootshPrice = (TextView) itemView.findViewById(R.id.gearPrice);
             bootshImage = (ImageView) itemView.findViewById(R.id.gearImage);
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
