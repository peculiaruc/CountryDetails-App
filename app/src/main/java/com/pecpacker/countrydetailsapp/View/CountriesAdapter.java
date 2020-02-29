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

import com.ahmadrosid.svgloader.SvgLoader;
import com.pecpacker.countrydetailsapp.Model.CountryModel;
import com.pecpacker.countrydetailsapp.R;

import java.util.ArrayList;
import java.util.List;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.ViewHolder> {

    private static final String TAG = "CountriesAdapter";
    private List<CountryModel> arrayList = new ArrayList<>();
    private Context mContext;

    public CountriesAdapter(List<CountryModel> arrayList, Context mContext) {
        this.arrayList = arrayList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.country_item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Log.d(TAG, "onBindViewHolder Called");

//        Glide.with(mContext)
//                .asBitmap()
//                .load(arrayList.get(position).getFlag())
//                .into(holder.countryflag);

        SvgLoader.pluck()
                .with(((MainActivity) mContext))
                .load(arrayList.get(position).getFlag(), holder.countryflag);

        Log.d(TAG, "Flag String: " + arrayList.get(position).getFlag());

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
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        ImageView countryflag;
        TextView countryname, countrycapital;
        ConstraintLayout parentlayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mView = itemView;

            countryflag = itemView.findViewById(R.id.flag);
            countryname = itemView.findViewById(R.id.country_name);
            countrycapital = itemView.findViewById(R.id.country_capital);
            parentlayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
