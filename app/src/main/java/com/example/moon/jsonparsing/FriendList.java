package com.example.moon.jsonparsing;

public class FriendList {
    String firstFriend,secondFriend,thirdFriend;

    public FriendList(String firstFriend, String secondFriend, String thirdFriend) {
        this.firstFriend = firstFriend;
        this.secondFriend = secondFriend;
        this.thirdFriend = thirdFriend;
    }

    public String getFirstFriend() {
        return firstFriend;
    }

    public void setFirstFriend(String firstFriend) {
        this.firstFriend = firstFriend;
    }

    public String getSecondFriend() {
        return secondFriend;
    }

    public void setSecondFriend(String secondFriend) {
        this.secondFriend = secondFriend;
    }

    public String getThirdFriend() {
        return thirdFriend;
    }

    public void setThirdFriend(String thirdFriend) {
        this.thirdFriend = thirdFriend;
    }
}
