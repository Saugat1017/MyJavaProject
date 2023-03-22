package com.gradle.tutorial.Project.Project1;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;


public class XmlHandler extends DefaultHandler {

    public Room[] room = new Room[20];
    private int curIndex = 0;
    public Room current_room;
    private String roomName;
    private String roomDescription;
    private String itemName;
    private String itemDescription;
    private String playerName;
    private String playerDescription;
    private String adultName;
    private String adultDescription;
    private String childName;
    private String childDescription;
    private String actions;
    private Player player;
    private Adult adult;
    private RoomBST <String, Room> bst = new RoomBST();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equals("room")) {
            roomName = attributes.getValue("name");
            roomDescription = attributes.getValue("description");
            current_room = new Room(roomName, roomDescription);

        }
        if (attributes.getValue("north") != null) {
            Room north = new Room(attributes.getValue("north"), null);
            current_room.addNorth(north);
        }

        if (attributes.getValue("east") != null) {
//
            Room east = new Room(attributes.getValue("east"), null);
            current_room.addEast(east);

        }
        if (attributes.getValue("south") != null) {
//
            Room south = new Room(attributes.getValue("south"), null);
            current_room.addSouth(south);
//
        }
        if (attributes.getValue("west") != null) {
//
            Room west = new Room(attributes.getValue("west"), null);
            current_room.addWest(west);
        }
        else if (qName.equals("adult")) {
            adultName = attributes.getValue("name");
            adultDescription = attributes.getValue("description");
            Adult a = new Adult(adultName, adultDescription);
            current_room.addCharacter(a);
            a.currentRoom=current_room;
          //  adult=a;


        } else if (qName.equals("child")) {
            childName = attributes.getValue("name");
            childDescription = attributes.getValue("description");
            Child c = new Child(childName, childDescription);
            current_room.addCharacter(c);
            c.currentRoom=current_room;
           // child=c;

        } else if (qName.equals("player")) {
            playerName = attributes.getValue("name");
            playerDescription = attributes.getValue("description");
            Player p = new Player(playerName, playerDescription);
            current_room.addCharacter(p);
            p.currentRoom = current_room;
            player = p;

        } else if (qName.equals("item")) {
            itemName = attributes.getValue("name");
            itemDescription = attributes.getValue("description");
            Item i = new Item(itemName, itemDescription);
            current_room.addItem(i);
            i.currentRoom=current_room;
            String[] actions = attributes.getValue("actions").split(",");
            for(String s : actions){
                current_room.addActions(s);
            }
        }
}
   @Override
    public void endElement(String uri, String localName,String qName) {
       if (qName.equals("room")) {
       room[curIndex] = current_room;
       curIndex++;
      // bst.add(current_room.getName(),current_room);
       }
       if(qName.equals("xml")){
           Room[] masterList = getroom();
           for(Room r : masterList){
               if(r!= null && r.getNorth()!= null){
                   String northName = r.getNorth().getName();
                   for(Room nr : masterList){
                       if( nr!= null) {
                           if (northName.equalsIgnoreCase(nr.getName())) {
                               r.addNorth(nr);
                           }
                       }
                   }
               }
               if(r!= null && r.getSouth()!= null){
                   String southName = r.getSouth().getName();
                   for(Room nr : masterList){
                       if( nr!= null) {
                           if (southName.equalsIgnoreCase(nr.getName())) {
                               r.addSouth(nr);
                           }
                       }
                   }
               }
               if(r!= null && r.getEast()!= null){
                   String eastName = r.getEast().getName();
                   for(Room nr : masterList){
                       if( nr!= null) {
                           if (eastName.equalsIgnoreCase(nr.getName())) {
                               r.addEast(nr);
                           }
                       }
                   }
               }
               if(r!= null && r.getWest()!= null){
                   String westName = r.getWest().getName();
                   for(Room nr : masterList){
                       if( nr!= null) {
                           if (westName.equalsIgnoreCase(nr.getName())) {
                               r.addWest(nr);
                           }
                       }
                   }
               }
           }
       }
   }
    public void fillBST(){
       Room[] masterList = getroom();
       for(Room r : masterList) {
           if (r != null) {
               bst.add(r.getName(), r);
           }
       }
    }

    public Player getPlayer() {
        player.setBST(bst);
        return player;
    }


    public Adult getAdult() {
        return adult;
    }
    public Room[] getroom(){

        return room;
    }
    public ArrayList<Room> getroomList(){
        ArrayList<Room> rooms = new ArrayList<Room>();
        for(Room r : room){
            rooms.add(r);
        }
        return rooms;
    }
}