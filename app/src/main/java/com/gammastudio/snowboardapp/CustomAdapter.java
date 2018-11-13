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

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {


    //vars
    private ArrayList<String> boards = new ArrayList<>();
    private ArrayList<String> boardPrices = new ArrayList<>();
    private ArrayList<String> boardImages = new ArrayList<>();
    private Context mContext;

    public CustomAdapter(Context mContext, ArrayList<String> boards, ArrayList<String> boardPrices , ArrayList<String> boardImages ) {
        this.boards = boards;
        this.boardPrices = boardPrices;
        this.boardImages = boardImages;
        this.mContext = mContext;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view   = LayoutInflater.from(parent.getContext()).inflate(R.layout.gearselectlayer, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(mContext).asBitmap().load(boardImages.get(position)).into(holder.boardhImage);

        holder.boardhName.setText(boards.get(position));
        holder.boardhPrice.setText(boardPrices.get(position));
        holder.boardhImage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Toast.makeText(mContext, boards.get(position) + " - " + boardPrices.get(position),Toast.LENGTH_SHORT);
            }
        });
    }

    @Override
    public int getItemCount() {
        return boardImages.size();
    }

   /* CustomAdapter(Context context, Snowboards[] boards){
        super(context,R.layout.gearselectlayer,boards);

    }*/

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView boardhName ;
        TextView boardhPrice ;
        ImageView boardhImage ;

        public ViewHolder(View itemView) {
            super(itemView);
             boardhName = (TextView) itemView.findViewById(R.id.gearName);
             boardhPrice = (TextView) itemView.findViewById(R.id.gearPrice);
             boardhImage = (ImageView) itemView.findViewById(R.id.gearImage);
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
