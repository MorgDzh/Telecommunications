package com.kursovaya.acc_type.manager;

import com.kursovaya.acc_type.marketing.GETQueryMarketing;

import java.util.Scanner;

public class ManagerMainMenu{

    private static final Scanner sc = new Scanner(System.in);
    static GETQueryMarketing getQueryMarketing = new GETQueryMarketing();

    static GETQueryManager getQueryManager = new GETQueryManager();


    public static void managerMainMenu(){
        System.out.println("Greetings, dear Manager! Please dial the menu number for the \n" +
                "program, if you have finished, please dial 5:\n");
        System.out.println("1 - Show employee list\n"+
                           "2 - Show to-do list \n"+
                           "3 - Show list of instructions to employees  \n"+
                           "4 - Show a list of all coverage areas  \n"+
                           "5 - Exit \n");
        String menuNumber = sc.nextLine();
        switch (menuNumber){
            case "1":
                getQueryManager.getListOfEmployee();
                backToMenu();
            case "2":
                showToDo();
                backToMenu();
            case "3":
                getQueryManager.showAllToDoList();
                backToMenu();
            case "4":
                getQueryMarketing.getAllAreas();
                backToMenu();
            case "5":
                System.exit(0);
        }
    }

    public static void backToMenu(){
        System.out.println("To exit to the main menu, press ENTER");
        String button = sc.nextLine();
        managerMainMenu();
    }


    public static void showToDo(){
        System.out.println("Select: \n"+
                "1 - All to do list \n"+
                "2 - List of active tasks \n"+
                "3 - List of done tasks \n"+
                "4 - Add the task \n"+
                "5 - Complete the task \n"+
                "6 - Exit to the main menu \n");
        String todoNumber = sc.nextLine();
        switch (todoNumber){
            case "1":
                getQueryManager.showAllMyToDoList();
                backToMenu();
            case "2":
                getQueryManager.showActiveOrDoneToDo("ACTIVE");
                backToMenu();
            case "3":
                getQueryManager.showActiveOrDoneToDo("DONE");
                backToMenu();
            case "4":
                System.out.println("Write the name of task you want to add:");
                String task = sc.nextLine();
                getQueryManager.addTaskForToDoList(task);
                backToMenu();
            case "5":
                getQueryManager.updateTaskToDone();
                backToMenu();
            case "6":
                managerMainMenu();
        }
    }
}