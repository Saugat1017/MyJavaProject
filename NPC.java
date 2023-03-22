package com.gradle.tutorial.Project.Project1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class NPC extends Character{

    private Adult adult;
    private int scaredLevel = 0;
    private int incr=0;
    private int temp;

    public NPC(String Name, String Description) {

        super(Name, Description);
        this.temp=characterCount;
    }


    public void changeRoom() {
        Random random= new Random();
        ArrayList<Room> rooms= new ArrayList<>();
        if( currentRoom.getNorth() != null){
            rooms.add(currentRoom.getNorth());
        }
        if( currentRoom.getSouth() != null){
                rooms.add(currentRoom.getSouth());
        }
        if( currentRoom.getEast() != null){
                rooms.add(currentRoom.getEast());
        }
        if( currentRoom.getWest() != null){
                rooms.add(currentRoom.getWest());
        }
            int rand = random.nextInt((rooms.size()));
           if(rooms.get(rand) != null) {

            //remove the character from the current room array
            // count of the members in the room

            System.out.println("Moved to room " +rooms.get(rand).getName());
            currentRoom = rooms.get(rand);
            currentRoom.addCharacter(this);
            currentRoom.addCharacter(currentRoom.getPlayer());
        }
    }

}
