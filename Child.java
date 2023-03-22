package com.gradle.tutorial.Project.Project1;

import java.util.Random;

public class Child extends NPC {
    private final String Name;
    private double child_scaredlevel = 0;
    public Character temp;


    public Child(String Name, String Description) {
        super(Name, Description);
        this.Name=Name;
    }


    public void childShake(String itemname) {
        for (Item a : currentRoom.getItem()) {
            if ( a!= null){
            if (a.getName().equalsIgnoreCase(itemname)) {
                Random random = new Random();
                int incr = random.nextInt((10)) + 5;
                if(child_scaredlevel < 50) {
                    child_scaredlevel = child_scaredlevel+(int) (1.5 * (incr));
                    if(child_scaredlevel >= 50){
                        currentRoom.remove(getName());
                        System.out.println("ahhhh he kicked me from the room!!!");
                        changeRoom();
                    }
                }
                else if( child_scaredlevel >50 && child_scaredlevel<100){
                    child_scaredlevel = child_scaredlevel+(int) (1.5 * (incr));
                    if (child_scaredlevel >= 100) {
                        currentRoom.remove(getName());
                        System.out.println("ahhhh ahh ahh setttt he kicked me from the house!!!");
                        characterCount--;
                        if (characterCount == 1) {
                            System.out.println("You won the Game! Congratulation");
                            System.exit(0); 
                        }
                        Player.timeLeft.addAndGet(30);
                    }
                }

            }
                }

            
        }
        System.out.println("The scared level for "+ Name+ " is: " + child_scaredlevel);
    }

    public void childPossess(String itemname) {

        for (Item a : currentRoom.getItem()) {
            if( a!= null){
            if (a.getName().equalsIgnoreCase(itemname)) {
                Random random= new Random();
                int incr = random.nextInt((25 - 10)) + 10;
                if(child_scaredlevel < 50) {
                    child_scaredlevel = child_scaredlevel+(int) (1.5 * (incr));
                    if(child_scaredlevel >= 50){
                        currentRoom.remove(getName());
                        System.out.println("ahhhh he kicked me from the room!!!");
                        changeRoom();
                    }
                }
                else if( child_scaredlevel >50 && child_scaredlevel<100){
                    child_scaredlevel = child_scaredlevel+(int) (1.5 * (incr));
                    if (child_scaredlevel >=100) {
                        currentRoom.remove(getName());
                        System.out.println("ahhhh ahhh ahh settttt  he kicked me from the house!!!");
                        characterCount--;
                        if (characterCount == 1) {
                            System.out.println("You won the Game! Congratulation");
                            System.exit(0);
                        }
                        Player.timeLeft.addAndGet(30);
                    }

                }

            }
            }
        }
        System.out.println("The scared level for "+ Name+ " is: " + child_scaredlevel);
    }

    public void childThrow(String itemname) {
        for (Item a : currentRoom.getItem()) {
            if (a != null) {
                if (a.getName().equalsIgnoreCase(itemname)) {
                    Random random= new Random();
                    int incr = random.nextInt((40 - 20)) + 20;
                    if (child_scaredlevel < 50) {
                        child_scaredlevel = child_scaredlevel+(int) (1.5 * (incr));
                        if(child_scaredlevel >=50){
                            currentRoom.remove(getName());
                            System.out.println("ahhhh he kicked me from the room!!!");
                            changeRoom();
                        }
                    } else if (child_scaredlevel > 50 && child_scaredlevel < 100) {
                        child_scaredlevel =child_scaredlevel+ (int) (1.5 * (incr));
                        if (child_scaredlevel >= 100) {
                            currentRoom.remove(getName());
                            System.out.println("ahhhh ahh ahh setttt  he kicked me from the house!!!");
                            characterCount--;
                            if (characterCount == 1) {
                                System.out.println("You won the Game! Congratulation");
                                System.exit(0);
                            }
                            Player.timeLeft.addAndGet(30);
                        }
                    }

                }
            }

            System.out.println("The scared level for " + Name + " is: " + child_scaredlevel);
        }
    }
}


