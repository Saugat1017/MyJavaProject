package com.gradle.tutorial.Project.Project1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicInteger;

public class Adult extends NPC {
        private double adult_scaredlevel = 0;
        private final String Name;

        public Adult(String Name, String Description) {
                super(Name, Description);
                this.Name = Name;
        }

        public void adultShake(String itemname) {
                for (Item a : currentRoom.getItem()) {
                        if (a != null) {
                                if (a.getName().equalsIgnoreCase(itemname)) {
                                        Random random = new Random();
                                        int incr = random.nextInt((15 - 5)) + 5;
                                        if (adult_scaredlevel < 50) {
                                                adult_scaredlevel = adult_scaredlevel + incr;
                                                if (adult_scaredlevel >=50) {
                                                        currentRoom.remove(getName());
                                                        System.out.println("ahhhh he kicked me from the room!!!");
                                                        changeRoom();

                                                }
                                        }else if (adult_scaredlevel >= 50 && adult_scaredlevel < 100) {
                                                adult_scaredlevel = adult_scaredlevel + incr;
                                                if (adult_scaredlevel >= 100) {
                                                        currentRoom.remove(getName());
                                                        System.out.println("ahhhh  ahh ahh sett he kicked me from the house!!!");
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
                System.out.println("The scared level for " + Name + " is: " + adult_scaredlevel);

        }

        public void adultPossess(String itemname){
                for( Item a: currentRoom.getItem()){
                        if(a != null) {
                                if (a.getName().equalsIgnoreCase(itemname)) {
                                        Random random= new Random();
                                        int incr = random.nextInt((25 - 10)) + 10;
                                        if(adult_scaredlevel < 50) {
                                                adult_scaredlevel = adult_scaredlevel + incr;
                                                if(adult_scaredlevel>= 50){
                                                        currentRoom.remove(getName());
                                                        System.out.println("ahhhh he kicked me from the room!!!");
                                                        changeRoom();


                                                }
                                        }else  if( adult_scaredlevel >50 && adult_scaredlevel<100){
                                                adult_scaredlevel = adult_scaredlevel + incr;
                                                if(adult_scaredlevel >=100){
                                                        currentRoom.remove(getName());
                                                        System.out.println("ahhhh  ahh ahh sett he kicked me from the house!!!");
                                                        characterCount--;
                                                        if (characterCount == 1) {
                                                                System.out.println("You won the Game! Congratulation");
                                                                System.exit(0);
                                                        }
                                                        Player.timeLeft.addAndGet(30);
                                                        //Add time 30sec

                                                }
                                        }

                                }

                        }
                }
                System.out.println("The scared level for "+ Name+ " is: " + adult_scaredlevel);

        }
        public void adultThrow(String itemname){
                for( Item a: currentRoom.getItem()){
                        if( a!= null) {
                                if (a.getName().equalsIgnoreCase(itemname)) {
                                        Random random= new Random();
                                        int incr = random.nextInt((40 - 20)) + 20;
                                        if(adult_scaredlevel < 50) {
                                                adult_scaredlevel = adult_scaredlevel + incr;
                                                if(adult_scaredlevel>= 50){
                                                        currentRoom.remove(getName());
                                                        System.out.println("ahhhh he kicked me from the room!!!");
                                                        changeRoom();
                                                }
                                        }
                                        else if( adult_scaredlevel >50 && adult_scaredlevel<100){
                                                adult_scaredlevel = adult_scaredlevel + incr;
                                                if(adult_scaredlevel >= 100){
                                                        currentRoom.remove(getName());
                                                        System.out.println("ahhhh ahh ahh sett he kicked me from the house!!!");
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
                System.out.println("The scared level for "+ Name+ " is: " + adult_scaredlevel);

        }
}

