package com.dev.abhishek360.srrms;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class PNRstatusFragment extends Fragment
{
    private Button showStatus;
    private CardView ticketCard;
    private EditText pnrNo;
    private TextView pnrDisplay;


    private OnFragmentInteractionListener mListener;

    public PNRstatusFragment()
    {
        // Required empty public constructor
    }


    public static PNRstatusFragment newInstance(String param1, String param2)
    {
        PNRstatusFragment fragment = new PNRstatusFragment();
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
        View v= inflater.inflate(R.layout.fragment_pnrstatus, container, false);
        ticketCard= v.findViewById(R.id.pnrstatus_ticket_card);
        showStatus= v.findViewById(R.id.pnrstatus_show_status);
        pnrNo=v.findViewById(R.id.pnrstatus_pnr_edittext);
        pnrDisplay=v.findViewById(R.id.ticket_pnr);



        showStatus.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(pnrNo.getText().length()==10)
                {
                    pnrDisplay.setText("PNR: "+pnrNo.getText());
                    ticketCard.setVisibility(ticketCard.getVisibility()==ticketCard.VISIBLE?ticketCard.GONE:ticketCard.VISIBLE);
                    showStatus.setText(showStatus.getText().equals("SHOW PNR STATUS")?"Check Another PNR":"SHOW PNR STATUS");
                    pnrNo.setEnabled(!pnrNo.isEnabled());

                }
                else pnrNo.setError("Enter valid 10 digit PNR!");



            }
        });


        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
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
        } else {
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


    public interface OnFragmentInteractionListener
    {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
