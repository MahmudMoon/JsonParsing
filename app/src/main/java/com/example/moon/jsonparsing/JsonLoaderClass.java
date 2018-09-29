package com.example.moon.jsonparsing;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class JsonLoaderClass extends AsyncTask<String, Void, ArrayList<ObjectOfEmployees>> {


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected ArrayList<ObjectOfEmployees> doInBackground(String... strings) {
        String params = strings[0];
        String result = "";
        JSONObject jsonObject = null;
        FriendList friendList = null;
        ObjectOfEmployees objectOfEmployees;
        JSONArray jsonArray;
        String UserName;
        int age;
        boolean isMarried;
        double salary;
        JSONArray jsonArray1 = null;
        ArrayList<ObjectOfEmployees> employees = new ArrayList<>();
        Log.i("OurURl", params);


        try {
            URL url = new URL(params);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }
            result = stringBuffer.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        employees.clear();
        try {
            jsonObject = new JSONObject(result);
            jsonArray = jsonObject.getJSONArray("employee");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                UserName = jsonObject1.getString("name");
                age = jsonObject1.getInt("age");
                isMarried = jsonObject1.getBoolean("married");
                salary = jsonObject1.getDouble("salary");
                jsonArray1 = jsonObject1.getJSONArray("friends");
                for (int j = 0; j < jsonArray1.length(); j++) {
                    JSONObject jsonObject2 = null;
                    String firstFriend = "";
                    String secondFriend = "";
                    String thirdFriend = "";
                    try {
                        jsonObject2 = jsonArray1.getJSONObject(j);
                        firstFriend = jsonObject2.getString("fristFriend");
                        secondFriend = jsonObject2.getString("secondFriend");
                        thirdFriend = jsonObject2.getString("thirdFriend");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    friendList = new FriendList(firstFriend, secondFriend, thirdFriend);
                }

                objectOfEmployees = new ObjectOfEmployees(UserName, age, isMarried, salary, friendList);
                employees.add(objectOfEmployees);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.i("ListEmployee",String.valueOf(employees.size()));
        return employees;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(ArrayList<ObjectOfEmployees> objectOfEmployees) {
        StaticValues.setObjectForEmplyees(objectOfEmployees);
    }
}
