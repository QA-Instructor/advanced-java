package com.qa.solid.liskov;

public class House extends BuildingStructure{
    @Override
    public String toString() {
        return("House");
    }

    @Override
    public int getNumberOfRooms(){
        return 7;
    }
}
