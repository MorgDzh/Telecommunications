package com.kursovaya.acc_type.employee;

import java.util.Scanner;
import com.kursovaya.acc_type.manager.GETQueryManager;

public class EmployeeMainMenu {

    static final Scanner sc = new Scanner(System.in);

    static GETQueryManager getQueryManager = new GETQueryManager();

    public static void employeeMainMenu(){
        System.out.println("Greetings, dear Employee!\n" +
                "Please dial the menu number to work with the program, if you have finished, then dial 5:\n");
        System.out.println("1 - Show my to-do list.\n"+
                "2 - Show list of completed tasks. \n"+
                "3 - Show the to-do list I'm working on.  \n"+
                "4 - Show payroll   \n"+
                "5 - Exit \n");
        String menuNumber = sc.nextLine();
        switch (menuNumber){
            case "1":
                getQueryManager.showAllMyToDoList();
                backToMenu();
            case "2":
                getQueryManager.showActiveOrDoneToDo("DONE");
                backToMenu();
            case "3":
                getQueryManager.showActiveOrDoneToDo("ACTIVE");
                backToMenu();
            case "4":
                GETQueryEmployee getQueryEmployee = new GETQueryEmployee();
                getQueryEmployee.showMySalary();
                backToMenu();
            case "5":
                System.exit(0);
        }
    }

    public static void backToMenu(){
        System.out.println("To exit to the main menu, press ENTER");
        String button = sc.nextLine();
        employeeMainMenu();
    }
}