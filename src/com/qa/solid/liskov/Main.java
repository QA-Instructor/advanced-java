package com.qa.solid.liskov;

import java.util.ArrayList;
import java.util.List;
// In object-oriented programming, the third of the SOLID Principles is L: Liskov Substitution.
// The Liskov Substitution Principle states that functions which use pointers to base classes (parent classes)
// must be able to use objects of derived classes (child classes) without knowing it.

public class Main {
    public static void main(String[] args) {
//        substitutionExampleA();
//        substitutionExampleB();
//        substitutionExampleC();
//        substitutionExampleD();
        substitutionExampleE();
    }

    static void substitutionExampleA(){
        // Office and House extend BuildingStructure so they can be built using the 'build'
        // method that accepts a BuildingStructure parameter
        BuildingStructure building = new BuildingStructure();
        Office office = new Office();
        House house = new House();
        build(building);
        build(office);
        build(house);
    }

    static void substitutionExampleB(){
//        Because of Liskov substitution, office and house instances can be added
//        to a list of type BuildingStructure
        List<BuildingStructure> structures = new ArrayList<>();
        structures.add(new BuildingStructure());
        structures.add(new Office());
        structures.add(new House());

        printBuildings(structures);
    }

    static void substitutionExampleC(){
//        Liskov substitution does not allow for the substitution of  a list of a derived type
//        where a list of a base type is expected
        List<Office> structures = new ArrayList<>();
        structures.add(new Office());
        structures.add(new Office());

        System.out.println("A list of offices is not a subtype of a list of building structures");
//        printBuildings(structures);
    }

    static void substitutionExampleD(){
//        A wildcard is used to allow any type of list to be passed to the print function
        List<Office> structures = new ArrayList<>();
        structures.add(new Office());
        structures.add(new Office());

        System.out.println("Any type of list can be passed due to the '?' wildcard type");
        printBuildingsAnyList(structures);
    }

    static void substitutionExampleE(){
//        A wildcard is used to allow any subtype of BuildingStructure as the list type
//        to be passed to the print function
        List<Office> offices = new ArrayList<>();
        offices.add(new Office());
        offices.add(new Office());

        System.out.println("Any type of building list can be passed due to the '? extends BS' wildcard type");
        printBuildingsAnyBuildingStructureList(offices);

        List<House> houses = new ArrayList<>();
        houses.add(new House());
        houses.add(new House());
        printBuildingsAnyBuildingStructureList(houses);
    }

    static void build(BuildingStructure building) {
        System.out.println("Constructing a new " + building.toString());
    }

    static void printBuildings(List<BuildingStructure> buildings) {
        for(int i = 0; i < buildings.size(); i++) {
            System.out.println(i + 1 + "a: " + buildings.get(i).toString());
            System.out.println(i + 1 + "b: " + "Number of rooms is: " + buildings.get(i).getNumberOfRooms());
        }
    }

//    used with substitutionExampleD
//    The ? wildcard allows for any type of List to be passed
    static void printBuildingsAnyList(List<?> buildings) {
        for(int i = 0; i < buildings.size(); i++) {
            System.out.println(i + 1 + ": " + buildings.get(i).toString());
//            System.out.println("Number of rooms is: " + buildings.get(i).getNumberOfRooms());
        }
        System.out.println("Because of the ? wildcard, we are all Objects");
    }

    //    used with substitutionExampleE
//    The ? extends BuildingStructure wildcard allows for any subtype of BuildingStructure
//    as the type of the List to be passed
    static void printBuildingsAnyBuildingStructureList(List<? extends BuildingStructure> buildings) {
        for(int i = 0; i < buildings.size(); i++) {
            System.out.println(i + 1 + "a: " + buildings.get(i).toString());
            System.out.println(i + 1 + "a: " + "Number of rooms is: " + buildings.get(i).getNumberOfRooms());
        }
        System.out.println("Because of the ? extends wildcard, we are all buildings with rooms");
    }
}
