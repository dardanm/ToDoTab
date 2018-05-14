package com.meha.dardan.todotab;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.Arrays;

public class TaskListOpenHelper extends SQLiteOpenHelper {

    public static final String TAG = "TaskListOpenHelper";
    private static final String DB_NAME ="wordlist";
    private static final int DB_VERSION = 1;
    private static final String TABLE_WORD_LIST = "word_entries";
    public static final String KEY_ID = "_id";
    public static final String KEY_WORD = "word";

    private SQLiteDatabase writeableDB;
    private SQLiteDatabase readableDB;

    private static final String[] COLUMNS = { KEY_ID, KEY_WORD };

    private static final String CREATE_TABLE_WORD_LIST = "CREATE TABLE "+ TABLE_WORD_LIST +
            " ( " +KEY_ID + " INTEGER PRIMARY KEY, " + KEY_WORD + " TEXT );"  ;

    private Context context;



    public TaskListOpenHelper(Context ctx){
        super(ctx, DB_NAME, null, DB_VERSION);
        context = ctx;
        // Log.d(TAG, "DB version="+DB_VERSION);


    }
    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_WORD_LIST);
        //has no data... but the table exists
        fillWithDummData(db);
    }

    /**
     * Called when the database needs to be upgraded. The implementation
     * should use this method to drop tables, add tables, or do anything else it
     * needs to upgrade to the new schema version.
     * <p>
     * <p>
     * The SQLite ALTER TABLE documentation can be found
     * <a href="http://sqlite.org/lang_altertable.html">here</a>. If you add new columns
     * you can use ALTER TABLE to insert them into a live table. If you rename or remove columns
     * you can use ALTER TABLE to rename the old table, then create the new table and then
     * populate the new table with the contents of the old table.
     * </p><p>
     * This method executes within a transaction.  If an exception is thrown, all changes
     * will automatically be rolled back.
     * </p>
     *
     * @param db         The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "upgrading ...");
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_WORD_LIST);
        onCreate(db);
    }


    private void fillWithDummData(SQLiteDatabase db) {
        Log.d(TAG, "inside fillWithDummData ");
        String[] theWords = context.getResources().getStringArray(R.array.dummy_data);
        Log.d(TAG, "words are: " + Arrays.toString(theWords));
        ContentValues contentValues = new ContentValues();
        for (int i = 0; i < theWords.length; i++) {
            contentValues.put(KEY_WORD, theWords[i]);//put into the values
            db.insert(TABLE_WORD_LIST, null, contentValues);
        }
    }
    public long getNumEntries(){
        if(readableDB == null){
            readableDB = getReadableDatabase();
        }
        return DatabaseUtils.queryNumEntries(readableDB, TABLE_WORD_LIST);
    }

    public int delete(int id){
        int deleted = 0;
        try{
            if(writeableDB == null){
                writeableDB = getWritableDatabase();
            }
            deleted = writeableDB.delete(TABLE_WORD_LIST, KEY_ID +
                    " = ? ", new String[]{String.valueOf(id)});
        }
        catch(Exception e){
            Log.d(TAG, "EXCEPTION ON DELETE "+id);
        }
        finally {
            return deleted;
        }
    }
    public int update(int id, String word){
        int numRowsUpdatd = -1;
        try{
            if(writeableDB == null) {
                writeableDB = getWritableDatabase();
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put(KEY_WORD, word);
            numRowsUpdatd = writeableDB.update(TABLE_WORD_LIST, contentValues,
                    KEY_ID +" = ? ",
                    new String[]{String.valueOf(id)});

        } catch(Exception e){
            Log.d(TAG, "EXCEPTION ON UPDATE "+id+" word="+word);
        }
        finally {
            return numRowsUpdatd;
        }

    }


}
