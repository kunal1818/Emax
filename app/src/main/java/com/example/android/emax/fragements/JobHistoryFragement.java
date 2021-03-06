package com.example.android.emax.fragements;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.android.emax.R;
import com.example.android.emax.adapter.MainAdapter;
import com.example.android.emax.Model.ModelClass;
import java.util.ArrayList;

/**
 * job history fragement is created with recyler view
 */
public class JobHistoryFragement extends Fragment {
    private static final int MODE = 0;
    private ArrayList<ModelClass> modelClassArrayList = new ArrayList<ModelClass>();
    private RecyclerView recyclerView;
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view_dispaly, container, false);

        ModelClass modelClass = new ModelClass("22/10/2015 04:15 Pm", "4.5 Km", " # 3331 sector-43 chd",
                " # 457 sector-17 chd", " Ride time: 20 min", "Total Payable Amount", "$20"
        );
        modelClassArrayList.add(modelClass);

        MainAdapter jobHistory = new MainAdapter(modelClassArrayList, MODE);
        recyclerView = (RecyclerView) view.findViewById(R.id.rvItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(jobHistory);
        recyclerView.setHasFixedSize(true);
        return view;
    }
}
