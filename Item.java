package com.gradle.tutorial.Project.Project1;


public class Item {
    private final String name;
    private final String Description;
    private ItemActions[] action = new ItemActions[3];
    private Item item;
    private Boolean broken = false;
    public  Room currentRoom;

    public Item(String name, String Description){
        this.name = name;
        this.Description = Description;
    }

    public void addAction(ItemActions act){
        for(int i = 0;i < action.length;i++) {
        if (action[i] == act) {
            break;
        }else if(action[i] == null){
            action[i]= act;
            break;
        }
    }

    }

    public Boolean supportsAction(ItemActions task){ //Support action
        for (ItemActions a: action
             ) {
            if(task == a ) {
                return true;
            }
        }
        return false;


    }

    public Object getActions(){
        for(ItemActions a : action){
            System.out.println(a);
        }
        return null;
    }
    public Item getItem(){
        return item;
    }


    public String getName() {
        return name;
    }
    public void Break(){
        broken = true;
    }
    public Boolean brokenStatus(){
        return  broken;
    }


    @Override
    public String toString(){
        return "ItemName: " + name + "                          ItemDescription: " + Description;
    }

}
