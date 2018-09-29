package com.example.moon.jsonparsing;

public class ObjectOfEmployees {
    String name;
    int age;
    boolean isMarried;
    double salary;
    FriendList friendList;

    public ObjectOfEmployees(String name, int age, boolean isMarried, double salary, FriendList friendList) {
        this.name = name;
        this.age = age;
        this.isMarried = isMarried;
        this.salary = salary;
        this.friendList = friendList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        isMarried = married;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public FriendList getFriendList() {
        return friendList;
    }

    public void setFriendList(FriendList friendList) {
        this.friendList = friendList;
    }
}
