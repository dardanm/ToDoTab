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

public class TabFragment2 extends Fragment {

    private List personalList = new List(0,"personal");

    private RecyclerView tRecyclerView;
    private RecyclerView.Adapter tAdapter;
    private RecyclerView.Adapter tAdapter2;
    private RecyclerView.LayoutManager mLayoutManager;

    final LinkedList<String> personalListTitles = new LinkedList<>();
    final LinkedList<String> personalListDescription = new LinkedList<>();

    final String[] personalListTaskTitles = new String[100];

//    private TaskListOpenHelper mDB;
//    private RecyclerView mRecyclerView;
//    private TaskAdapter mAdapter;
//    private int mLastPosition;

    public TabFragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment1, container, false);

//        Task task1 = new Task((int)personalList.getId(),"Note title ","notes description","0","0");
//        Task task2 = new Task((int)personalList.getId(),"Test title 2","Some notes go here","0","0");
//
//
//        personalListTaskTitles[0] = task1.getName();
//        personalListTaskTitles[1] = task2.getName();
//
//        mDB = new TaskListOpenHelper(getActivity());
//
//        // Create recycler view.
//        tRecyclerView = view.findViewById(R.id.recyclerview);
//        // Create an mAdapter and supply the data to be displayed.
//        tAdapter = new TaskAdapter(getActivity(), mDB);
//        // Connect the mAdapter with the recycler view.
//        tRecyclerView.setAdapter(tAdapter);
//        // Give the recycler view a default layout manager.
//        tRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

}
