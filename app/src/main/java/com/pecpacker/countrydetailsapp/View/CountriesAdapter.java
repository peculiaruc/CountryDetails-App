package com.pecpacker.countrydetailsapp.View;

import android.content.Context;
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
import com.pecpacker.countrydetailsapp.Model.CountryModel;
import com.pecpacker.countrydetailsapp.R;

import java.util.List;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.ViewHolder> {

    private static final String TAG = "CountriesAdapter";

    private List<CountryModel> arrayList;
    private Context mContext;

    public CountriesAdapter(List<CountryModel> arrayList, Context mContext) {
        this.arrayList = arrayList;
        this.mContext = mContext;
    }


    public CountriesAdapter(CountryModel mNamel, MainActivity mainActivity) {

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Log.d(TAG, "onBindViewHolder Called");

        Glide.with(mContext)
                .asBitmap()
                .load(arrayList.get(position).getName())
                .load(arrayList.get(position).getCapital())
                .into(holder.imageflag);

        holder.countryname.setText(arrayList.get(position).getName());
        holder.countrycapital.setText(arrayList.get(position).getCapital());

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

        public final View mView;

        ImageView imageflag;
        TextView countryname, countrycapital;
        ConstraintLayout parentlayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mView = itemView;

            imageflag = itemView.findViewById(R.id.img_flag);
            countryname = itemView.findViewById(R.id.country_name);
            countrycapital = itemView.findViewById(R.id.country_capital);
            parentlayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
