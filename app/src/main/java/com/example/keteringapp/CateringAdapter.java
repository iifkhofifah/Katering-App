package com.example.keteringapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

class CateringAdapter extends RecyclerView.Adapter<CateringAdapter.ViewHolder>  {

    private ArrayList<Catering> mCateringData;
    private Context mContext;

    CateringAdapter(Context context, ArrayList<Catering> CateringData) {
        this.mCateringData = CateringData;
        this.mContext = context;
    }


    @Override
    public CateringAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext)
                .inflate(R.layout.list_info, parent, false));
    }

    @Override
    public void onBindViewHolder(CateringAdapter.ViewHolder holder,
                                 int position) {
        // Get current sport.
        Catering currentCatering = mCateringData.get(position);

        // Populate the textviews with data.
        holder.bindTo(currentCatering);
    }


    @Override
    public int getItemCount() {
        return mCateringData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{

        // Member Variables for the TextViews
        private TextView mJudulText;
        private TextView mInfoText;
        private ImageView mCateringImage;

        ViewHolder(View itemView) {
            super(itemView);

            // Initialize the views.
            mJudulText = itemView.findViewById(R.id.judul);
            mInfoText = itemView.findViewById(R.id.deskripsi);
            mCateringImage = itemView.findViewById(R.id.cateringImage);

            // Set the OnClickListener to the entire view.
            itemView.setOnClickListener(this);
        }

        void bindTo(Catering currentCatering){
            // Populate the textviews with data.
            mJudulText.setText(currentCatering.getTitle());
            mInfoText.setText(currentCatering.getInfo());

            // Load the images into the ImageView using the Glide library.
            Glide.with(mContext).load(
                    currentCatering.getImageResource()).into(mCateringImage);

        }
        @Override
        public void onClick(View view) {
            Catering currentCatering = mCateringData.get(getAdapterPosition());
            Intent detailIntent = new Intent(mContext, DetailInfoActivity.class);
            detailIntent.putExtra("title", currentCatering.getTitle());
            detailIntent.putExtra("descatering", currentCatering.getInfo());
            detailIntent.putExtra("image_resource",
                    currentCatering.getImageResource());
            mContext.startActivity(detailIntent);
        }
    }
}
