package com.qa.functional_interfaces;
// Class with 2 constructors: one empty, one with a name
// no interfaces are implemented (EmployeeEmpty or EmployeeWithName)

public class Employee {
    private String name;

    Employee(){
        System.out.println("Empty constructor is invoked");
    }

    Employee(String name){
        System.out.println("Name constructor is invoked");
        this.name = name;
    }

    @Override
    public String toString() {
        return "name=: " + name;
    }
}
