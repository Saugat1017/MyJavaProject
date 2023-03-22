package com.gradle.tutorial.Project.Project1;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Player extends Character {
    public static Timer timer;
    public static AtomicInteger timeLeft;

    private RoomBST<String, Room> bst;

    //make a boolean flag called threwItem.
    private boolean threwItem;
    //at the start of every run of the game loop, reset threwItem to false
    //if the player uses an item, simply set it to true
    //otherwise, it will be false
    public boolean getThrewItem(){
        return threwItem;
    }



    public Player(String Name, String Description) {
        super(Name, Description);
    }

    public void setBST(RoomBST<String, Room> bst){
        this.bst = bst;
    }
    public RoomBST<String, Room> getBST(){
       return bst;
    }


    public void startTimer() {
        initTimer(60);
    }



    public void initTimer(int secs) {
        timeLeft = new AtomicInteger(secs);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                int tl = timeLeft.decrementAndGet();
                if (tl == 0) {
                    System.out.println("YOU LOST :( THE GAME");
                    exit();
                }
            }
        };
        timer = new Timer();
        timer.schedule(task, 0, 1000);
    }

    public void Play(String s){
        Scanner scanner = new Scanner(System.in);
        if(s.equalsIgnoreCase("cheatmode")){
            System.out.println("Cheat Mode Activated!");
            playWithCheatMode(scanner);

        }else if(s.equalsIgnoreCase("nocheatmode")){
            playWithoutCheatMode(scanner);
        }
    }


    public void playWithCheatMode(Scanner s) {
        String command = s.nextLine();

        if(command.equalsIgnoreCase("nocheatmode")){
            System.out.println("You wanna play fair! that's great");
            playWithoutCheatMode(s);

        } else if (command.equalsIgnoreCase("help")) {
            help();
            System.out.println("Time left: " + timeLeft);
            System.out.println("Enter the Command: ");
            playWithCheatMode(s);

        } else if (command.equalsIgnoreCase("look")) {
            look();
            System.out.println("Time left: " + timeLeft);
            System.out.println("Enter the Command: ");
            playWithCheatMode(s);
        } else if (command.equalsIgnoreCase("north")) {
            if (currentRoom.getNorth() != null) {
                enterNorth();
            } else {
                System.out.println(" Current room doesn't have north");
            }
            System.out.println("Time left: " + timeLeft);
            System.out.println("Enter the Command: ");
            playWithCheatMode(s);
        } else if (command.equalsIgnoreCase("south")) {
            if (currentRoom.getSouth() != null) {
                enterSouth();
            } else {
                System.out.println(" Current room doesn't have south");
            }
            System.out.println("Time left: " + timeLeft);
            System.out.println("Enter the Command: ");
            playWithCheatMode(s);
        } else if (command.equalsIgnoreCase("east")) {
            if (currentRoom.getEast() != null) {
                enterEast();
            } else {
                System.out.println(" Current room doesn't have east");
            }
            System.out.println("Time left: " + timeLeft);
            System.out.println("Enter the Command: ");
            playWithCheatMode(s);
        } else if (command.equalsIgnoreCase("west")) {
            if (currentRoom.getWest() != null) {
                enterWest();
            } else {
                System.out.println(" Current room doesn't have west");
            }
            System.out.println("Time left: " + timeLeft);
            System.out.println("Enter the Command: ");
            playWithCheatMode(s);
        } else if (command.split(":")[0].equalsIgnoreCase("shake")) {
            shakeItem(command.split(":")[1]);
            System.out.println("Time left: " + timeLeft);
            System.out.println("Enter the Command: ");
            playWithCheatMode(s);
        } else if (command.split(":")[0].equalsIgnoreCase("possess")) {
            possessItem(command.split(":")[1]);
            System.out.println("Time left: " + timeLeft);
            System.out.println("Enter the Command: ");
            playWithCheatMode(s);
        } else if (command.split(":")[0].equalsIgnoreCase("throw")) {
            throwItem(command.split(":")[1]);
            System.out.println("Time left: " + timeLeft);
            System.out.println("Enter the Command: ");
            playWithCheatMode(s);
        } else if (command.equalsIgnoreCase("exit")) {
            exit();
        } else if (command.split(":")[0].equalsIgnoreCase("look")) {
            lookRoom(command.split(":")[1]);
            System.out.println("Time left: " + timeLeft);
            System.out.println("Enter the Command: ");
            playWithCheatMode(s);
        } else {
            System.out.println("Time left: " + timeLeft);
            System.out.println("Could not Understand, Please repeat");
            System.out.println("Enter the Command: ");
            playWithCheatMode(s);
        }
    }

    private void lookRoom(String roomName) {
        Room catchRoom = bst.find(roomName);
        if (roomName.equalsIgnoreCase("all")) {
            bst.traverse();
        } else if (catchRoom == null) {
            System.out.println("Such room doesn't exist");

        } else {
            System.out.println(catchRoom);
        }
    }



    public void playWithoutCheatMode(Scanner s) {
        String command = s.nextLine();
        if(command.equalsIgnoreCase("cheatmode")){
            System.out.println(" Cheatmode activated!!");
            playWithCheatMode(s);
        } else if (command.equalsIgnoreCase("help")) {
            help();
            System.out.println("Time left: " + timeLeft);
            System.out.println("Enter the Command: ");
            playWithoutCheatMode(s);

        } else if (command.equalsIgnoreCase("look")) {
            look();
            System.out.println("Time left: " + timeLeft);
            System.out.println("Enter the Command: ");
            playWithoutCheatMode(s);
        } else if (command.equalsIgnoreCase("north")) {
            if (currentRoom.getNorth() != null) {
                enterNorth();
            } else {
                System.out.println(" Current room doesn't have north");
            }
            System.out.println("Time left: " + timeLeft);
            System.out.println("Enter the Command: ");
            playWithoutCheatMode(s);
        } else if (command.equalsIgnoreCase("south")) {
            if (currentRoom.getSouth() != null) {
                enterSouth();
            } else {
                System.out.println(" Current room doesn't have south");
            }
            System.out.println("Time left: " + timeLeft);
            System.out.println("Enter the Command: ");
            playWithoutCheatMode(s);
        } else if (command.equalsIgnoreCase("east")) {
            if (currentRoom.getEast() != null) {
                enterEast();
            } else {
                System.out.println(" Current room doesn't have east");
            }
            System.out.println("Time left: " + timeLeft);
            System.out.println("Enter the Command: ");
            playWithoutCheatMode(s);
        } else if (command.equalsIgnoreCase("west")) {
            if (currentRoom.getWest() != null) {
                enterWest();
            } else {
                System.out.println(" Current room doesn't have west");
            }
            System.out.println("Time left: " + timeLeft);
            System.out.println("Enter the Command: ");
            playWithoutCheatMode(s);
        } else if (command.split(":")[0].equalsIgnoreCase("shake")) {
            shakeItem(command.split(":")[1]);
            System.out.println("Time left: " + timeLeft);
            System.out.println("Enter the Command: ");
            playWithoutCheatMode(s);
        } else if (command.split(":")[0].equalsIgnoreCase("possess")) {
            possessItem(command.split(":")[1]);
            System.out.println("Time left: " + timeLeft);
            System.out.println("Enter the Command: ");
            playWithoutCheatMode(s);
        } else if (command.split(":")[0].equalsIgnoreCase("throw")) {
            throwItem(command.split(":")[1]);
            System.out.println("Time left: " + timeLeft);
            System.out.println("Enter the Command: ");
            playWithoutCheatMode(s);
        } else if (command.equalsIgnoreCase("exit")) {
            exit();
        } else {
            System.out.println("Time left: " + timeLeft);
            System.out.println("Could not Understand, Please repeat");
            System.out.println("Enter the Command: ");
            playWithoutCheatMode(s);
        }
    }


    public void help() {
        //from examples
        System.out.println("if you wanna look information about the room you are present in type------> look");
        System.out.println("if you wanna go to specific room 'room in the north , room in the south,room in the east,room in the west' type ------> north/ south/east/west respectively");
        System.out.println("if you wanna manipulate the object in the room like 'shake, possess or throw' type------>shake:itemname/ possess:itemname/ throw:itemname respectively ");
        System.out.println("if you wanna exit type------>exit ");

    }

    public void enterSouth() {
        getactualRoom().removePlayer(this);
        current_room(getactualRoom().getSouth());
        getactualRoom().addCharacter(this);
        currentRoom.cleanItem();

    }

    public void enterNorth() {
        getactualRoom().removePlayer(this);
        current_room(getactualRoom().getNorth());
        getactualRoom().addCharacter(this);
        currentRoom.cleanItem();
    }

    public void enterEast() {
        getactualRoom().removePlayer(this);
        current_room(getactualRoom().getEast());
        getactualRoom().addCharacter(this);
        currentRoom.cleanItem();
    }

    public void enterWest(){
        getactualRoom().removePlayer(this);
        current_room(getactualRoom().getWest());
        getactualRoom().addCharacter(this);
        currentRoom.cleanItem();
    }

    public void look() {
        System.out.println("The room contains:  \n");
        System.out.println(currentRoom);
    }

    public void shakeItem(String itemName) {
        threwItem=false;
        for (Item item : currentRoom.getItem()) {

            if (item != null) {
                if (item.getName().equalsIgnoreCase(itemName) && !item.brokenStatus()) {
                    threwItem=true;
                    for (Adult a : currentRoom.getAdults()) {
                        a.adultShake(itemName);
                    }
                    for (Child c : currentRoom.getChilds()) {
                        c.childShake(itemName);
                    }
                } else if (item.getName().equalsIgnoreCase(itemName) && item.brokenStatus()) {
                    System.out.println(" the item has already been broken ");
                }
            }
        }
    }

    public void possessItem(String itemName) {
        threwItem=false;
        for (Item item : currentRoom.getItem()) {
            if (item != null) {
                if (item.getName().equalsIgnoreCase(itemName) && !item.brokenStatus()) {
                    threwItem=true;
                    for (Adult a : currentRoom.getAdults()) {
                        a.adultPossess(itemName);
                    }
                    for (Child c : currentRoom.getChilds()) {
                        c.childPossess(itemName);
                    }
                } else if (item.getName().equalsIgnoreCase(itemName) && item.brokenStatus()) {
                    System.out.println(" the item has already been broken ");
                }
            }
        }
    }

    public  void throwItem(String itemName) {
        threwItem=false;
        Random random = new Random();
        int i = 0;
        for (Item item : currentRoom.getItem()) {
            boolean broken = false;
            if (item != null) {
                if (item.getName().equalsIgnoreCase(itemName) && item.brokenStatus()) {
                    System.out.println(" the item has already been broken ");

                } else if (item.getName().equalsIgnoreCase(itemName) && !item.brokenStatus()) {
                    //set the threwItem flag to true
                    threwItem=true;


                    while (!broken) {
                        if (!item.brokenStatus() && item.getName().equalsIgnoreCase(itemName)) {
                            currentRoom.getItem()[i].Break();
                            broken = true;
                            for (Adult a : currentRoom.getAdults()) {
                                a.adultThrow(itemName);
                            }
                            for (Child c : currentRoom.getChilds()) {
                                c.childThrow(itemName);
                            }


                        }
                    }
                }
            }
            i++;
        }



    }

    public void exit() {
        System.out.println("GoodBye!");
        System.exit(0);
    }

    public AtomicInteger getTime() {
        return timeLeft;
    }


}


// player wins
//testing j unit
//making static