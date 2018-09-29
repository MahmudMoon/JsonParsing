package com.example.moon.jsonparsing;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.ThreadPoolExecutor;

public class MainActivity extends AppCompatActivity {

    AsyncTask<String,Void,ArrayList<ObjectOfEmployees>> jsonLoaderClass;
    ArrayList<ObjectOfEmployees> employees = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jsonLoaderClass = new JsonLoaderClass(){
            @Override
            protected void onPostExecute(ArrayList<ObjectOfEmployees> objectOfEmployees) {
                Toast.makeText(getApplicationContext(),String.valueOf(objectOfEmployees.size()),Toast.LENGTH_SHORT).show();
            }
        }.execute(StaticValues.url);

    }
}
