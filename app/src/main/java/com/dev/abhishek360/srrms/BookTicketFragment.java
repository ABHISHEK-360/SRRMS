package com.dev.abhishek360.srrms;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;


public class BookTicketFragment extends Fragment
{

    private Spinner startStations,endStations;
    private DatePicker dojPicker;
    private RecyclerView trainsRecycler;
    private ArrayList<String> trainNames,trainFare,trainSource,trainTiming,trainAvailTickets;
    private ArrayList<Integer> trainNo;

    private OnFragmentInteractionListener mListener;

    public BookTicketFragment() {
        // Required empty public constructor
    }


    public static BookTicketFragment newInstance(String param1, String param2)
    {
        BookTicketFragment fragment = new BookTicketFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v= inflater.inflate(R.layout.fragment_book_ticket, container, false);
        startStations= v.findViewById(R.id.booking_start_station_spinner);
        endStations= v.findViewById(R.id.booking_end_station_spinner);
        dojPicker= v.findViewById(R.id.booking_date_picker_doj);
        dojPicker.setMinDate(System.currentTimeMillis()-1000);
        trainsRecycler= v.findViewById(R.id.booking_recycler_trains);
        trainsRecycler.setLayoutManager(new LinearLayoutManager(this.getActivity()));


        trainNames= new ArrayList<>();
        trainNo= new ArrayList<>();
        trainFare= new ArrayList<>();
        trainAvailTickets= new ArrayList<>();
        trainTiming= new ArrayList<>();
        trainSource= new ArrayList<>();

        trainNames.add("Rajdhani 1");
        trainNames.add("Rajdhani 2");
        trainNames.add("Rajdhani 3");

        trainNo.add(1001);
        trainNo.add(1002);
        trainNo.add(1003);

        trainFare.add("1111");
        trainFare.add("2222");
        trainFare.add("2223");

        trainSource.add("Base 1 - Base 2");
        trainSource.add("Base 2 - Base 3");
        trainSource.add("Base 1- Base 4");

        trainTiming.add("10:20 - 23:35");
        trainTiming.add("08:50 - 20:35");
        trainTiming.add("12:30 - 18:45");

        trainAvailTickets.add("87");
        trainAvailTickets.add("98");
        trainAvailTickets.add("19");


        TrainsListAdapter  adapter = new TrainsListAdapter();
        adapter.setTrainNames(trainNames);
        adapter.setAvailable_tickets(trainAvailTickets);
        adapter.setFare(trainFare);
        adapter.setSource_destination(trainSource);
        adapter.setTiming(trainTiming);
        adapter.setTrainNos(trainNo);

        trainsRecycler.setAdapter(adapter);






        return v;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}


