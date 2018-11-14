package com.gammastudio.snowboardapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<String> mImageNames= new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(Context mContext, ArrayList<String> mImageNames, ArrayList<String> mImages) {
        this.mImageNames = mImageNames;
        this.mImages = mImages;
        this.mContext = mContext;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gear_listitem,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
       // holder.setItem(mDataset[position]);
        Log.d(TAG, "onBindViewHolder: called");
        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.imageView);

        holder.imageName.setText(mImageNames.get(position));
        holder.mRelativeLayoutGearSetItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                    Log.d(TAG, "onClick: Clicked on a gear set" + mImageNames.get(position));
                    Toast.makeText(mContext, mImageNames.get(position), Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(mContext, ListView.class);
                    intent.putExtra("image_url", mImages.get(position));
                    intent.putExtra("image_name", mImages.get(position));
                    mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imageView;
        TextView imageName;
        RelativeLayout mRelativeLayoutGearSetItem;


        public ViewHolder(View itemView) {
            super(itemView);
            imageView =itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            mRelativeLayoutGearSetItem = itemView.findViewById(R.id.gear_set_item_ParentLayout);


        }


//        private String mItem;
//        private TextView mTextView;
//
//
//        public void setItem(String item) {
//            mItem = item;
//            mTextView.setText(item);
//        }



    }

//    private String[] mDataset;
//
//    public RecyclerViewAdapter(String[] dataset) {
//        mDataset = dataset;
//    }

//
//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position) {
//        holder.setItem(mDataset[position]);
//    }



}
