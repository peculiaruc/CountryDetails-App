package com.pecpacker.countrydetailsapp.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.pecpacker.countrydetailsapp.Model.CountryModel;
import com.pecpacker.countrydetailsapp.R;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.ViewHolder> {

    private static final String TAG = "CountriesAdapter";

    private CountryModel mCountryName, mCapitalcitie;
    private Context mContext;

    public CountriesAdapter(CountryModel mCountryName, CountryModel mCapitalcitie, Context mContext) {
        this.mCountryName = mCountryName;
        this.mCapitalcitie = mCapitalcitie;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_item_row, parent, false);
        RecyclerView.ViewHolder holder = new ViewHolder(view);
        return (ViewHolder) holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Log.d(TAG, "onBindViewHolder Called");

        Glide.with(mContext)
                .asBitmap()
                .load(mCountryName.getName())
                .load(mCapitalcitie.getCapital())
                .into(holder.imageflag);

        holder.countryname.setText(mCountryName.getName().charAt(position));
        holder.countrycapital.setText(mCapitalcitie.getCapital().charAt(position));

        holder.parentlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//              Log.d(TAG, "onClick: clicked on: " + mCharName.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageflag;
        TextView countryname, countrycapital;
        ConstraintLayout parentlayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageflag = itemView.findViewById(R.id.img_flag);
            countryname = itemView.findViewById(R.id.country_name);
            countrycapital = itemView.findViewById(R.id.country_capital);
            parentlayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
