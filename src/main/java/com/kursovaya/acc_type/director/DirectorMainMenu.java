package com.kursovaya.acc_type.director;

import com.kursovaya.acc_type.marketing.GETQueryMarketing;

import java.util.Scanner;

public class DirectorMainMenu {

    static final Scanner sc = new Scanner(System.in);

    public static void directorMainMenu(){
        System.out.println("Greetings, dear Director!\n" +
                "Please dial the menu number to work with the program, if you have finished, then dial 6:\n"+
                "1 - Show a list of all coverage areas. \n"+
                        "2 - Show list of budget categories.    \n"+
                        "3 - Show the allocated budget for a particular category of marketing locations.  \n"+
                        "4 - Increase the salary of an employee   \n"+
                        "5 - Reduce the salary of an employee   \n"+
                        "6 - Exit \n");
        String menuNumber = sc.nextLine();
        GETQueryMarketing getQueryMarketing = new GETQueryMarketing();
        switch (menuNumber){
            case "1":
                getQueryMarketing.getAllAreas();
                backToMenu();
            case "2":
                GETQueryDirector.getAllBudgetCategory();
                backToMenu();
            case "3":
                getQueryMarketing.getMarketingCategoryBudget();
                backToMenu();
            case "4":
                GETQueryDirector.salaryChange("UP");
                backToMenu();
            case "5":
                GETQueryDirector.salaryChange("DOWN");
                backToMenu();
            case "6":
                System.exit(    0);
        }
    }

    public static void backToMenu(){
        System.out.println("To exit to the main menu, press ENTER");
        String button = sc.nextLine();
        directorMainMenu();
    }
}