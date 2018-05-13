package com.meha.dardan.todotab;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private List pList = new List(0,"personal");

    private RecyclerView tRecyclerView;
    private RecyclerView.Adapter tAdapter;
    private RecyclerView.Adapter tAdapter2;
    private RecyclerView.LayoutManager mLayoutManager;

    final LinkedList<String> personalListTitles = new LinkedList<>();
    final LinkedList<String> personalListDescription = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        // set tabs to fill entire layout
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        // using pageadapter to manage page views in fragments
        // each page is represented by its own gragment
        // this is naother example of the adapter pattern
        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        // setting a listener for clicks
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

//        // Put initial data into the word list.
//        for (int i = 0; i < 5; i++) {
//            personalListTitles.addLast("Word " + i);
//        }
//
//        for (int i = 0; i < 20; i++) {
//            personalListDescription.addLast("Notesses " + i);
//        }
////
////        RecyclerView tRecyclerView;
////        TaskAdapter tAdapter;
////
////        final LinkedList<String> personalList = new LinkedList<>();
////
////        personalList.addLast("hello");
////
////
////        // Get a handle to the RecyclerView.
////        tRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
////        // Create an adapter and supply the data to be displayed.
////        tAdapter = new TaskAdapter(this, personalList);
////        // Connect the adapter with the RecyclerView.
////        tRecyclerView.setAdapter(tAdapter);
////        // Give the RecyclerView a default layout manager.
////        tRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//
//        tRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
//
//        // use this setting to improve performance if you know that changes
//        // in content do not change the layout size of the RecyclerView
//        tRecyclerView.setHasFixedSize(true);
//
//        // use a linear layout manager
//        mLayoutManager = new LinearLayoutManager(this);
//        tRecyclerView.setLayoutManager(mLayoutManager);
//
//        // specify an adapter (see also next example)
//        tAdapter = new TaskAdapter(this,personalListTitles);
//        //tAdapter2 = new TaskAdapter(this,personalListDescription);
//        tRecyclerView.setAdapter(tAdapter);
//        //tRecyclerView.setAdapter(tAdapter2);
//
//        Task task1 = new Task((int)pList.getId(),"task1","notes","0","0");
//        Log.d("hi","THE ID IS" + task1.getName() + " " + task1.getNotes());



//        // Add a floating action click handler for creating new entries.
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int wordListSize = personalListTitles.size();
//                // Add a new word to the end of the wordList.
//                personalListTitles.addLast("+ Word " + wordListSize);
//                // Notify the adapter, that the data has changed so it can
//                // update the RecyclerView to display the data.
//                tRecyclerView.getAdapter().notifyItemInserted(wordListSize);
//                // Scroll to the bottom.
//                tRecyclerView.smoothScrollToPosition(wordListSize);
//            }
//        });





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu); // set your file name
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_delete:
                Intent i = new Intent(this,AddRemoveTasksActivity.class);
                this.startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
