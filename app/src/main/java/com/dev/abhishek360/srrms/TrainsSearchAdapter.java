package com.dev.abhishek360.srrms;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class TrainsSearchAdapter extends RecyclerView.Adapter<TrainsSearchAdapter.TrainsListViewHolder>
{
    private ArrayList<String> trainNames;
    private ArrayList<String> timing;
    private ArrayList<String> source_destination;
    private ArrayList<String> runningDays;

    private ArrayList<Integer> trainNos;


    public void setTrainNames(ArrayList<String> trainNames) {
        this.trainNames = trainNames;
    }

    public void setTiming(ArrayList<String> timing) {
        this.timing = timing;
    }

    public void setSource_destination(ArrayList<String> source_destination) {
        this.source_destination = source_destination;
    }

    public void setRunningDays(ArrayList<String> runningDays) {
        this.runningDays = runningDays;
    }

    public void setTrainNos(ArrayList<Integer> trainNos) {
        this.trainNos = trainNos;
    }

    @NonNull
    @Override
    public TrainsListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inf = LayoutInflater.from(parent.getContext());

        View view = inf.inflate(R.layout.train_search_view_holder,parent,false);
        return new TrainsListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrainsListViewHolder holder, final int position)
    {
        holder.name_train.setText(trainNames.get(position)+"("+trainNos.get(position)+")");
        holder.timing_train.setText(timing.get(position));
        holder.source_train.setText(source_destination.get(position));
        holder.running_days.setText("Days: "+runningDays.get(position));



    }

    @Override
    public int getItemCount()
    {
        return trainNames.size();
    }


    public static class  TrainsListViewHolder extends RecyclerView.ViewHolder
    {
        TextView name_train,timing_train,source_train,running_days;

        public TrainsListViewHolder(View itemView)
        {
            super(itemView);
            name_train=(TextView) itemView.findViewById(R.id.train_search_name_no);
            timing_train=(TextView) itemView.findViewById(R.id.train_search_timing);
            source_train=(TextView) itemView.findViewById(R.id.train_search_source_destination);
            running_days=(TextView) itemView.findViewById(R.id.train_search_days_of_run);


        }
    }



}