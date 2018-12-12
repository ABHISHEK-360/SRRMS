package com.dev.abhishek360.srrms;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class TrainsListAdapter extends RecyclerView.Adapter<TrainsListAdapter.TrainsListViewHolder>
{
    private ArrayList<String> trainNames;
    private ArrayList<String> fare;
    private ArrayList<String> timing;
    private ArrayList<String> source_destination;
    private ArrayList<String> available_tickets;

    private ArrayList<Integer> trainNos;


    public void setTrainNames(ArrayList<String> trainNames) {
        this.trainNames = trainNames;
    }

    public void setFare(ArrayList<String> fare) {
        this.fare = fare;
    }

    public void setTiming(ArrayList<String> timing) {
        this.timing = timing;
    }

    public void setSource_destination(ArrayList<String> source_destination) {
        this.source_destination = source_destination;
    }

    public void setAvailable_tickets(ArrayList<String> available_tickets) {
        this.available_tickets = available_tickets;
    }

    public void setTrainNos(ArrayList<Integer> trainNos) {
        this.trainNos = trainNos;
    }

    @NonNull
    @Override
    public TrainsListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inf = LayoutInflater.from(parent.getContext());

        View view = inf.inflate(R.layout.trains_list_view_holder,parent,false);
        return new TrainsListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrainsListViewHolder holder, final int position)
    {
        holder.name_train.setText(trainNames.get(position)+"("+trainNos.get(position)+")");
        holder.timing_train.setText(timing.get(position));
        holder.source_train.setText(source_destination.get(position));
        holder.fare_train.setText("Fare: Rs. "+fare.get(position));
        holder.avalaible_tickets_train.setText("Tickets\nAvailable:\n"+available_tickets.get(position));







        holder.book_ticket.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {


            }
        });



    }

    @Override
    public int getItemCount()
    {
        return trainNames.size();
    }


    public static class  TrainsListViewHolder extends RecyclerView.ViewHolder
    {
        TextView name_train,fare_train,timing_train,source_train,avalaible_tickets_train;
        Button book_ticket;

        public TrainsListViewHolder(View itemView)
        {
            super(itemView);
            name_train=(TextView) itemView.findViewById(R.id.train_name_no);
            fare_train=(TextView) itemView.findViewById(R.id.train_fare);
            timing_train=(TextView) itemView.findViewById(R.id.train_timing);
            source_train=(TextView) itemView.findViewById(R.id.train_source_destination);
            avalaible_tickets_train=(TextView) itemView.findViewById(R.id.train_ticket_available);
            book_ticket=(Button) itemView.findViewById(R.id.train_book_ticket);


        }
    }



}
