package com.meha.dardan.todotab;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Implements a simple Adapter for a RecyclerView.
 * Demonstrates how to add a click handler for each item in the ViewHolder.
 */
public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.WordViewHolder> {

    /**
     *  Custom view holder with a text view and two buttons.
     */
    class WordViewHolder extends RecyclerView.ViewHolder {
        public final TextView wordItemView;
        //Button delete_button;
        //Button edit_button;

        public WordViewHolder(View itemView) {
            super(itemView);
            wordItemView = (TextView) itemView.findViewById(R.id.nameTextView);
//            delete_button = (Button)itemView.findViewById(R.id.delete_button);
//            edit_button = (Button)itemView.findViewById(R.id.edit_button);
        }
    }

    private static final String TAG = TaskAdapter.class.getSimpleName();
    private TaskListOpenHelper db;

    public static final String EXTRA_ID = "ID";
    public static final String EXTRA_WORD = "WORD";

    private final LayoutInflater mInflater;
    Context mContext;

    public TaskAdapter(Context context, TaskListOpenHelper db) {
        mInflater = LayoutInflater.from(context);
        mContext = context;
        this.db = db;
    }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.listview_task, parent, false);
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        holder.wordItemView.setText("placeholder");

//        WordItem currentItem =   db.query(position);
//        holder.wordItemView.setText(currentItem.getWord());
    }

    @Override
    public int getItemCount() {
        // Placeholder so we can see some mock data.
        //return 10;
        return (int) db.getNumEntries();
    }
}


