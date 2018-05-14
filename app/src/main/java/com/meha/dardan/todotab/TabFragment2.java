package com.meha.dardan.todotab;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;

public class TabFragment2 extends Fragment {

    private List personalList = new List(0,"personal");

    private RecyclerView tRecyclerView;
    private RecyclerView.Adapter tAdapter;
    private RecyclerView.Adapter tAdapter2;
    private RecyclerView.LayoutManager mLayoutManager;

    private TaskListOpenHelper db;
    private RecyclerView mRecyclerView;
    private TaskAdapter mAdapter;
    private int mLastPosition;

    public TabFragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment1, container, false);

        db = new TaskListOpenHelper(getActivity());//initialize so we can use
        // Create recycler view.
        mRecyclerView = view.findViewById(R.id.recyclerview1);
        // Create an mAdapter and supply the data to be displayed.
        mAdapter = new TaskAdapter(getActivity(), db);//update to include reference to db
        // Connect the mAdapter with the recycler view.
        mRecyclerView.setAdapter(mAdapter);
        // Give the recycler view a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

}
