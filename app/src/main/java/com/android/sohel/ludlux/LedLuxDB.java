package com.android.sohel.ludlux;

/**
 * Created by user on 13/03/2018.
 */

import java.util.LinkedList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class LedLuxDB extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "LedLuxDB";

    // marker
    public LedLuxDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create user table
        String CREATE_Workers_TABLE = "CREATE TABLE worker ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "days_on INTEGER, " +
                "days_off INTEGER, " +
                "name TEXT, " +
                "username TEXT, " +
                "password TEXT )";

        String CREATE_MANAGER_TABLE = "CREATE TABLE manager ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "username TEXT, " +
                "password TEXT )";

        // create workers table
        db.execSQL(CREATE_Workers_TABLE);
        db.execSQL(CREATE_MANAGER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older users table if existed
        db.execSQL("DROP TABLE IF EXISTS worker");


        // create fresh users table
        this.onCreate(db);
    }
    //---------------------------------------------------------------------

    /**
     * CRUD operations (create "add", read "get", update, delete) user + get all users + delete all users
     */

    // users table name
    private static final String TABLE_WORKER = "worker";

    // users Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_days_on = "days_on";
    private static final String KEY_days_off = "days_off";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";


    private static final String[] WORKER_COLUMNS = {KEY_ID, KEY_NAME, KEY_days_on, KEY_days_off, KEY_USERNAME, KEY_PASSWORD};

    public void addWorker(Worker worker) {
        Log.d("addWorker", worker.toString());
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_ID, worker.getId());
        values.put(KEY_NAME, worker.getName()); // get title
        values.put(KEY_days_on, worker.getDaysOn());
        values.put(KEY_days_off, worker.getDaysOff());
        values.put(KEY_USERNAME, worker.getUsername()); // get title
        values.put(KEY_PASSWORD, worker.getPassword()); // get title


        // 3. insert
        db.insert(TABLE_WORKER, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values

        // 4. close
        db.close();
    }

    public Worker getWorker(int id) {

        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query
        Cursor cursor =
                db.query(TABLE_WORKER, // a. table
                        WORKER_COLUMNS, // b. column names
                        " id = ?", // c. selections
                        new String[]{String.valueOf(id)}, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();

        // 4. build user object
        Worker worker = new Worker();
        worker.setId(Integer.parseInt(cursor.getString(0)));
        worker.setName(cursor.getString(1));
        worker.setDaysOn(cursor.getInt(2));
        worker.setDaysOff(cursor.getInt(3));
        worker.setUsername(cursor.getString(4));
        worker.setPassword(cursor.getString(5));

        Log.d("getWorker" +
                "(" + id + ")", worker.toString());

        // 5. return user
        return worker;
    }

    public Worker getWorker(String username) {

        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query
        Cursor cursor =
                db.query(TABLE_WORKER, // a. table
                        WORKER_COLUMNS, // b. column names
                        " username = ?", // c. selections
                        new String[]{String.valueOf(username)}, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();

        // 4. build user object

        if (cursor.getCount() > 0) {
            Worker worker = new Worker();
            worker.setId(Integer.parseInt(cursor.getString(0)));
            worker.setName(cursor.getString(1));
            worker.setDaysOn(cursor.getInt(2));
            worker.setDaysOff(cursor.getInt(3));
            worker.setUsername(cursor.getString(4));
            worker.setPassword(cursor.getString(5));
            Log.d("getWorker(" + username + ")", worker.toString());
            return worker;
        } else {
            Log.d("getWorker(" + username + ")", "null");
            return null;
        }
        // 5. return user
    }

    // Get All users
    public List<Worker> getAllWorkers() {
        List<Worker> workers = new LinkedList<Worker>();

        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_WORKER;

        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // 3. go over each row, build user and add it to list
        Worker user = null;
        if (cursor.moveToFirst()) {
            do {
                Worker worker = new Worker();
                user.setId(Integer.parseInt(cursor.getString(0)));
                user.setName(cursor.getString(1));
                user.setDaysOn(cursor.getInt(2));
                user.setDaysOff(cursor.getInt(3));
                user.setUsername(cursor.getString(4));
                user.setPassword(cursor.getString(5));

                // Add user to users
                workers.add(user);
            } while (cursor.moveToNext());
        }

        Log.d("getAllUsers()", workers.toString());

        // return users
        return workers;
    }

    // Updating single user
    public int updateUser(Worker worker) {

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put("Id", worker.getId()); // get title
        values.put("Name", worker.getName()); // get author
        values.put("Days on", worker.getDaysOn());
        values.put("Days off", worker.getDaysOff());
        values.put("Username", worker.getUsername());
        values.put("Password", worker.getPassword());

        // 3. updating row
        int i = db.update(TABLE_WORKER, //table
                values, // column/value
                KEY_ID + " = ?", // selections
                new String[]{String.valueOf(worker.getId())}); //selection args

        // 4. close
        db.close();

        return i;

    }

    // Deleting single user
    public void deleteUser(Worker worker) {

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. delete
        db.delete(TABLE_WORKER,
                KEY_ID + " = ?",
                new String[]{String.valueOf(worker.getId())});

        // 3. close
        db.close();

        Log.d("deleteWorker", worker.toString());
    }

    // Manager
    private static final String TABLE_MANAGER = "manager";
    private static final String KEY_ID_MANAGER = "id";
    private static final String KEY_NAME_MANAGER = "name";
    private static final String KEY_USERNAME_MANAGER = "username";
    private static final String KEY_MANAGER = "password";


    private static final String[] MANAGER_COLUMNS = {KEY_ID, KEY_NAME, KEY_USERNAME, KEY_PASSWORD};

    public void addManager(Manager manager) {
        Log.d("addManager", manager.toString());
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_ID, manager.getId());
        values.put(KEY_NAME, manager.getName()); // get title

        values.put(KEY_USERNAME, manager.getUsername()); // get title
        values.put(KEY_PASSWORD, manager.getPassword()); // get title


        db.insert(TABLE_MANAGER, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values

        // 4. close
        db.close();
    }

    public Manager getManager(int id) {

        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query
        Cursor cursor =
                db.query(TABLE_MANAGER, // a. table
                        MANAGER_COLUMNS, // b. column names
                        " id = ?", // c. selections
                        new String[]{String.valueOf(id)}, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        if (cursor != null)
            cursor.moveToFirst();

        // 4. build user object
        Manager manager = new Manager();
        manager.setId(Integer.parseInt(cursor.getString(0)));
        manager.setName(cursor.getString(1));
        manager.setUsername(cursor.getString(2));
        manager.setPassword(cursor.getString(3));

        Log.d("getManager" +
                "(" + id + ")", manager.toString());

        // 5. return user
        return manager;
    }

    public Manager getManager(String username) {

        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query
        Cursor cursor =
                db.query(TABLE_MANAGER, // a. table
                        MANAGER_COLUMNS, // b. column names
                        " username = ?", // c. selections
                        new String[]{String.valueOf(username)}, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        if (cursor != null)
            cursor.moveToFirst();

        if (cursor.getCount() > 0) {
            Manager manager = new Manager();
            manager.setId(Integer.parseInt(cursor.getString(0)));
            manager.setName(cursor.getString(1));
            manager.setUsername(cursor.getString(2));
            manager.setPassword(cursor.getString(3));
            Log.d("getManager(" + username + ")", manager.toString());
            return manager;
        } else {
            Log.d("getManager(" + username + ")", "null");
            return null;
        }
        // 5. return user
    }
}
    /*
    public List<Manager> getAllmanagers() {
        List<Manager> managers = new LinkedList<Worker>();

        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_WORKER;

        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // 3. go over each row, build user and add it to list
        Worker user = null;
        if (cursor.moveToFirst()) {
            do {
                Worker worker = new Worker();
                user.setId(Integer.parseInt(cursor.getString(0)));
                user.setName(cursor.getString(1));
                user.setDaysOn(cursor.getInt(2));
                user.setDaysOff(cursor.getInt(3));
                user.setUsername(cursor.getString(4));
                user.setPassword(cursor.getString(5));

                // Add user to users
                workers.add(user);
            } while (cursor.moveToNext());
        }


    }*/