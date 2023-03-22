package com.gradle.tutorial.Project.Project1;

import java.util.ArrayList;
import java.util.Random;

public abstract class Character {
    public Room currentRoom;
    private final String Name;
    private final String Description;
    private ArrayList<Room> rooms;
    protected static int characterCount = 0;

    public Character(String Name, String Description) {
        this.Name = Name;
        this.Description = Description;
        characterCount++;
    }
    @Override
    public String toString() {

        return "Name:  " + Name + "                           Description: " + Description;
    }

    public Room getactualRoom() {
        return currentRoom;
    }
    public String getName(){
        return Name;
    }

    public void current_room(Room currentRoom){
        this.currentRoom=currentRoom;
    }

}
