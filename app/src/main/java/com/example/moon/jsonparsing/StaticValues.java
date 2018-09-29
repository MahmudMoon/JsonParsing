package com.example.moon.jsonparsing;

import java.util.ArrayList;

public class StaticValues {
   public static String url = "https://api.myjson.com/bins/lfgv4";
   public static ArrayList<ObjectOfEmployees> objectOfEmployees;

  public static void setObjectForEmplyees(ArrayList<ObjectOfEmployees> Employees){
      objectOfEmployees = Employees;
   }

   public static ArrayList<ObjectOfEmployees> getObjectOfEmployees() {
      return objectOfEmployees;
   }
}
