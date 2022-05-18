package com.kursovaya.acc_type.employee;

import com.kursovaya.acc_type.manager.GETQueryManager;

import java.util.Scanner;

public class EmployeeMainMenu {

    static final Scanner sc = new Scanner(System.in);

    static GETQueryManager getQueryManager = new GETQueryManager();

    public static void employeeMainMenu(){
        System.out.println("Приветствую дорогой, Сотрудник Егор!\n" +
                "Пожалуйста наберите номер меню для работы с программой, если закончили, то наберите 5:\n");
        System.out.println("1 - Показать список порученных мне дел.\n"+
                "2 - Показать список завершенных указаний. \n"+
                "3 - Показать список дел над, которым я работаю.  \n"+
                "4 - Показать зарплату  \n"+
                "5 - Выход \n");
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
        System.out.println("Для выходя в главное меню нажмите ENTER");
        String button = sc.nextLine();
        employeeMainMenu();
    }
}
