package com.example.android.emax.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.android.emax.Model.ModelClass;
import com.example.android.emax.R;

import java.util.ArrayList;

/**
 * its is the main adapter
 */
public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<ModelClass> modelClassArrayList;
    private int mode = 0;
    private TextView tvdate;
    private TextView tvdistance;
    private TextView tvdetail;
    private TextView tvdestination;
    private TextView tvrideTime;
    private TextView tvtotalAmount;
    private TextView tvnumber;
    private TextView tvname;

    /**
     * @param model model aray lis is created
     * @param mode  mode to select job history or missed job
     */
    public MainAdapter(final ArrayList<ModelClass> model, final int mode) {
        this.mode = mode;
        this.modelClassArrayList = model;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {

        View convertview = LayoutInflater.from(parent.getContext()).inflate(R.layout.rider_details, parent, false);
        ViewHolder viewHolder = new ViewHolder(convertview);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        ModelClass objJobHIstory = modelClassArrayList.get(position);

        if (mode == 0) {
            TextView textViewDate = tvdate;
            textViewDate.setText(objJobHIstory.getMdate());

            TextView textDetail = tvdetail;
            textDetail.setText(objJobHIstory.getMdetils());

            TextView textdistance = tvdistance;
            textdistance.setText(objJobHIstory.getMdistance());

            TextView textdestination = tvdestination;
            textdestination.setText(objJobHIstory.getMdestination());

            TextView textrideTime = tvrideTime;
            textrideTime.setText(objJobHIstory.getMrideTime());

            TextView texttotalAmount = tvtotalAmount;
            texttotalAmount.setText(objJobHIstory.getMtotalAmount());

            TextView textnumber = tvnumber;
            textnumber.setText(objJobHIstory.getMnumber());


        } else {
            TextView textViewDate = tvdate;
            textViewDate.setText(objJobHIstory.getMdate());

            TextView textdistance = tvdistance;
            textdistance.setText(objJobHIstory.getMdistance());

            TextView textname = tvname;
            textname.setText(objJobHIstory.getMname());

            TextView textDetail = tvdetail;
            textDetail.setText(objJobHIstory.getMdetils());
        }
    }

    @Override
    public int getItemCount() {
        return modelClassArrayList.size();
    }

    /**
     * view holder class is created here
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout linearLayout;

        /**
         * @param itemView return items
         */
        public ViewHolder(final View itemView) {
            super(itemView);
            tvdate = (TextView) itemView.findViewById(R.id.tv_date);
            tvdistance = (TextView) itemView.findViewById(R.id.tv_distance);
            tvdetail = (TextView) itemView.findViewById(R.id.tv_details);
            tvdestination = (TextView) itemView.findViewById(R.id.tv_destination_details);
            tvname = (TextView) itemView.findViewById(R.id.tv_name);
            tvrideTime = (TextView) itemView.findViewById(R.id.tv_ride_time);
            tvtotalAmount = (TextView) itemView.findViewById(R.id.tv_totalAmount);
            tvnumber = (TextView) itemView.findViewById(R.id.tv_number);

            linearLayout = (LinearLayout) itemView.findViewById(R.id.ll_display);
            if (mode == 1) {
                linearLayout.setVisibility(View.GONE);
            } else {
                tvname.setVisibility(View.GONE);
            }

        }

    }
}
