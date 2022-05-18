package com.kursovaya.acc_type.marketing;

import java.util.Scanner;

public class MarketingMainMenu {
    static Scanner sc = new Scanner(System.in);
    static GETQueryMarketing getQuery = new GETQueryMarketing();
    public static void marketingMenuText(){
        System.out.println("Приветствую дорогой, Маркетолог!\n" +
                "Пожалуйста наберите номер меню для работы с программой, если закончили, то наберите 6\n"+
                "1 - Показать список всех зон покрытия \n"+
                "2 - Показать список категорий для маркетинга  \n"+
                "3 - Показать выделенный бюджет для определенной категории мест для маркетинга  \n"+
                "4 - Показать общий бюджет для маркетинга \n"+
                "5 - Потратить бюджет на продвижение \n"+
                "6 - Выход \n");
        String menuNumber = sc.nextLine();
        switch (menuNumber){
            case "1":
                getQuery.getAllAreas();
                backToMenu();
                break;
            case "2":
                getQuery.getMarketingCategory();
                backToMenu();
                break;
            case "3":
                getQuery.getMarketingCategoryBudget();
                backToMenu();
                break;
            case "4":
                getQuery.getMarketingAllBudget();
                backToMenu();
                break;
            case "5":
                spentMoney();
                backToMenu();
            case "6":
                System.exit(0);
        }
    }

    private static void spentMoney() {
        getQuery.getOnlyMarketingCategoryName();
        System.out.println("Напишите название категории:");
        String catName = sc.nextLine();
        System.out.println("Напишите сумму которую хотите потратить:");
        int money = sc.nextInt();
        int num = GETQueryMarketing.checkMoney(money);
        getQuery.spentMoneyForPromotion(num,catName);
    }

    public static void backToMenu(){
        System.out.println("Для выходя в главное меню нажмите ENTER");
        String button = sc.nextLine();
        marketingMenuText();
    }
}
