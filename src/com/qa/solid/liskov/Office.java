package com.qa.solid.liskov;

public class Office extends BuildingStructure{
    @Override
    public String toString() {
        return("Office");
    }

    @Override
    public int getNumberOfRooms(){
        return 50;
    }
}
