package com.meha.dardan.todotab;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;

public class TabFragment3 extends Fragment {


    private RecyclerView tRecyclerView;
    private RecyclerView.Adapter tAdapter;
    private RecyclerView.Adapter tAdapter2;
    private RecyclerView.LayoutManager mLayoutManager;

    final LinkedList<String> professionalListTitles = new LinkedList<>();
    final LinkedList<String> personalListDescription = new LinkedList<>();

    public TabFragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment1, container, false);


        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        for (int i = 0; i < 15; i++) {
            professionalListTitles.addLast("Word " + i);
        }

        // Replace 'android.R.id.list' with the 'id' of your RecyclerView
        tRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        mLayoutManager = new LinearLayoutManager(this.getActivity());
        Log.d("debugMode", "The application stopped after this");
        tRecyclerView.setLayoutManager(mLayoutManager);

        tAdapter = new TaskAdapter(getActivity(),professionalListTitles);
        tRecyclerView.setAdapter(tAdapter);
    }

}
