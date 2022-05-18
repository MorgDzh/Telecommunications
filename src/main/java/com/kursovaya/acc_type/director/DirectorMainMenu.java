package com.kursovaya.acc_type.director;

import com.kursovaya.acc_type.marketing.GETQueryMarketing;

import java.util.Scanner;

public class DirectorMainMenu {

    static final Scanner sc = new Scanner(System.in);

    public static void directorMainMenu(){
        System.out.println("Приветствую дорогой, Директор!\n" +
                "Пожалуйста наберите номер меню для работы с программой, если закончили, то наберите 6:\n"+
                "1 - Показать список всех зон покрытия. \n"+
                        "2 -Показать список категорий бюджета.    \n"+
                        "3 - Показать выделенный бюджет для определенной категории мест для маркетинга.  \n"+
                        "4 - Повысить зарплату сотруднику   \n"+
                        "5 - Понизить зарплату сотруднику   \n"+
                        "6 - Выход \n");
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
        System.out.println("Для выходя в главное меню нажмите ENTER");
        String button = sc.nextLine();
        directorMainMenu();
    }
}
