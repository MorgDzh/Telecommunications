package com.kursovaya.acc_type.manager;

import com.kursovaya.acc_type.marketing.GETQueryMarketing;

import java.util.Scanner;

public class ManagerMainMenu{

    private static final Scanner sc = new Scanner(System.in);
    static GETQueryMarketing getQueryMarketing = new GETQueryMarketing();

    static GETQueryManager getQueryManager = new GETQueryManager();


    public static void managerMainMenu(){
        System.out.println("Приветствую дорогой, Менеджер!\n" + "Пожалуйста наберите номер меню для работы с программой, если закончили, то наберите 5:\n");
        System.out.println("1 - Показать список сотрудников\n"+
                           "2 - Показать список дел \n"+
                           "3 - Показать список указаний к сотрудникам  \n"+
                           "4 - Показать список всех зон покрытия  \n"+
                           "5 - Выход \n");
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
        System.out.println("Для выходя в главное меню нажмите ENTER");
        String button = sc.nextLine();
        managerMainMenu();
    }


    public static void showToDo(){
        System.out.println("Выберите: \n"+
                "1 - Весь список дел \n"+
                "2 - Список активных дел \n"+
                "3 - Список завершенных дел \n"+
                "4 - Добавить дело \n"+
                "5 - Завершить дело \n"+
                "6 - Выйти в главное меню \n");
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
                System.out.println("Напишите дело, которое нужно добавить:");
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
