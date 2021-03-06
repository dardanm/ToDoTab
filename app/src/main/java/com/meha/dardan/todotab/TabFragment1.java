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

public class TabFragment1 extends Fragment {

    private List personalList = new List(0,"personal");

    private RecyclerView tRecyclerView;
    private RecyclerView.Adapter tAdapter;
    private RecyclerView.Adapter tAdapter2;
    private RecyclerView.LayoutManager mLayoutManager;

    final LinkedList<String> personalListTitles = new LinkedList<>();
    final LinkedList<String> personalListDescription = new LinkedList<>();

    final LinkedList<Task> personalListTaskTitles = new LinkedList<>();

    public TabFragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment1, container, false);

        Task task1 = new Task((int)personalList.getId(),"Note title ","notes description","0","0");
        Task task2 = new Task((int)personalList.getId(),"Test title 2","Some notes go here","0","0");


        personalListTaskTitles.add(task1);

        personalListTitles.addLast(task1.getName());
        personalListTitles.addLast(task2.getName());


        // Replace 'android.R.id.list' with the 'id' of your RecyclerView
        tRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview1);
        mLayoutManager = new LinearLayoutManager(this.getActivity());
        Log.d("debugMode", "The application stopped after this");
        tRecyclerView.setLayoutManager(mLayoutManager);

        tAdapter = new TaskAdapter(getActivity(),personalListTitles);
        tRecyclerView.setAdapter(tAdapter);
        return view;
    }

}
