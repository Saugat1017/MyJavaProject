package com.gradle.tutorial.Project.Project1;

import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    private Character[] character = new Character[5];
    private int itemNumber = 0;
    private ItemActions acts;
    private Player player;
    private Item[] items = new Item[8];
    private Room[] room = new Room[20];
    private ArrayList<ItemActions> actions = new ArrayList<>();
    private Room north, south, east, west;
// private ArrayList<Room> rooms;


    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }
//    public void  addRoomsToList(Room r){
//        rooms.add(r);
//    }

    public String getName() {
        return this.name;
    }

    public void addNorth(Room north) {
        this.north = north;
    }

    public void addSouth(Room south) {
        this.south = south;
    }

    public void addEast(Room east) {
        this.east = east;
    }

    public void addWest(Room west) {
        this.west = west;
    }


    public void addCharacter(Character guest) {
        for (int i = 0; i < character.length; i++) {
            if (character[i] == null) {
                character[i] = guest;
                break;
            }
        }
    }

    public void addCharacter(Player player) {
        for (int i = 0; i < character.length; i++) {
            if (character[i] == null) {
                character[i] = player;
                break;
            }
        }
    }

    public void removePlayer(Player player) {
        for (int i = 0; i < character.length; i++) {
            if (character[i] != null) {
                if (character[i].getName().equalsIgnoreCase(player.getName())){
                    character[i] = null;
                }
            }
        }
    }



    public Player getPlayer() {
        return player;
    }

    public void addItem(Item item) {
        int check = 0;
        int i = 0;
        while (i < items.length && items[i] != null) {
            if (items[i].getName().equals(item.getName())) {
                check = 1;
                break;
            }
            i++;
        }
        if (check == 0) {
            items[itemNumber] = item;
            itemNumber++;
        }
        if (check == 1) {
            System.out.println("Item is already present");
        }

    }
//    public Object getActions(String s){
//
//        return null;
//    }

    public void addActions(String action) {

        //actions.add(action);
    }

    public void remove(String name) {
        for (int i = 0; i < character.length; i++) {
            if (character[i] != null) {
                if (character[i].getName().equalsIgnoreCase(name)) {
                    character[i] = null;
                }
            }
        }
    }

    public void cleanItem() {
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                if (items[i].brokenStatus()) {
                    items[i] = null;
                }
            }
        }
    }

    public Room getNorth() {
        return north;
    }

    public Room getSouth() {
        return south;
    }

    public Room getEast() {
        return east;
    }

    public Room getWest() {
        return west;
    }

    public Item[] getItem() {
        return items;
    }

    public ArrayList<Adult> getAdults() {
        ArrayList<Adult> adults = new ArrayList<>();
        for (Character c : character) {
            if (c instanceof Adult) {
                adults.add((Adult) c);
            }
        }
        return adults;
    }

    public ArrayList<Child> getChilds() {
        ArrayList<Child> childs = new ArrayList<>();
        for (Character c : character) {
            if (c instanceof Child) {
                childs.add((Child) c);
            }
        }
        return childs;
    }

//    public void remove() {
//        for (int i = 0; i < character.length; i++) {
//            if (character[i] != null) {
//                character[i] = null;
//                character[i] = character[i + 1];
//                character[i + 1] = null;
//                break;
//            }
//        }
//    }

//    public void scare(int incr){
//        int index = 0;
//        for (Character c : character) {
//            if (c instanceof Adult ||c instanceof Child ) {
//                 c.scare(incr);
//            }
//        }
//    }

    public boolean checkPlayer() {
        for (int i = 0; i < character.length; i++) {
            if (character[i] != null) {
                if (character[i].getName().equalsIgnoreCase("Rex")) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String returned = null;
        returned = "Room Name: " + name + "         Description: " + description;
        if (north != null) {
            returned = returned + "  \nNorth: " + north.getName();

        }
        if (west != null) {
            returned = returned + " \n West: " + west.getName();

        }
        if (east != null) {
            returned = returned + "\n East: " + east.getName();

        }
        if (south != null) {
            returned = returned + " \n South: " + south.getName();

        }
        for (Character value : character) {
            if (value != null) {
                returned = returned + "\n " + value;
            }
        }
        for (Item item : items) {
            if (item != null) {
                returned = returned + "\n " + item;
            }
        }


        return returned;
    }

    public Character[] getCharacter() {
        return character;
    }


}
//public void Cleaning(){
//after all the NPC are out. It should be cleaned the room.



