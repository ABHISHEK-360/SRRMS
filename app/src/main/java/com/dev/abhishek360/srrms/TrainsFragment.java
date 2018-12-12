package com.dev.abhishek360.srrms;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class TrainsFragment extends Fragment
{
    private RecyclerView trainsRecycler;
    private ArrayList<String> trainNames,trainSource,trainTiming,daysRunning;
    private ArrayList<Integer> trainNo;


    private OnFragmentInteractionListener mListener;

    public TrainsFragment()
    {
        // Required empty public constructor
    }

    public static TrainsFragment newInstance(String param1, String param2)
    {
        TrainsFragment fragment = new TrainsFragment();
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
        View v = inflater.inflate(R.layout.fragment_trains, container, false);

        trainsRecycler= v.findViewById(R.id.trains_search_recycler_trains);
        trainsRecycler.setLayoutManager(new LinearLayoutManager(this.getActivity()));


        trainNames= new ArrayList<>();
        trainNo= new ArrayList<>();
        daysRunning= new ArrayList<>();
        trainTiming= new ArrayList<>();
        trainSource= new ArrayList<>();

        trainNames.add("Rajdhani 1");
        trainNames.add("Rajdhani 2");
        trainNames.add("Rajdhani 3");

        trainNo.add(1001);
        trainNo.add(1002);
        trainNo.add(1003);

        daysRunning.add("Y Y Y Y Y Y N");
        daysRunning.add("Y N Y N Y Y N");
        daysRunning.add("N N N Y N Y N");

        trainSource.add("Base 1 - Base 2");
        trainSource.add("Base 2 - Base 3");
        trainSource.add("Base 1- Base 4");

        trainTiming.add("10:20 - 23:35");
        trainTiming.add("08:50 - 20:35");
        trainTiming.add("12:30 - 18:45");

        TrainsSearchAdapter  adapter = new TrainsSearchAdapter();
        adapter.setTrainNames(trainNames);
        adapter.setRunningDays(daysRunning);
        adapter.setSource_destination(trainSource);
        adapter.setTiming(trainTiming);
        adapter.setTrainNos(trainNo);

        trainsRecycler.setAdapter(adapter);


        return  v;
    }

    public void onButtonPressed(Uri uri)
    {
        if (mListener != null)
        {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener)
        {
            mListener = (OnFragmentInteractionListener) context;
        } else
            {
                throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
