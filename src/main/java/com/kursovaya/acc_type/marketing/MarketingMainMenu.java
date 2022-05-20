package com.kursovaya.acc_type.marketing;

import java.util.Scanner;

public class MarketingMainMenu {
    static Scanner sc = new Scanner(System.in);
    static GETQueryMarketing getQuery = new GETQueryMarketing();
    public static void marketingMenuText(){
        System.out.println("Greetings, dear Marketer! \n" +
                "Please dial the menu number to work with the program, if you have finished, then dial 6\n" +

                "1 - Show list of all coverage areas \n" +
                "2 - Show list of categories for marketing  \n" +
                "3 - Show the allocated budget for a specific category of locations for marketing  \n" +
                "4 - Show total budget for marketing \n" +
                "5 - Spend promotion budget \n" +
                "6 - Output \n");
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
        System.out.println("Write the name of the category:");
        String catName = sc.nextLine();
        System.out.println("Write down the amount you want to spend:");
        int money = sc.nextInt();
        int num = GETQueryMarketing.checkMoney(money);
        getQuery.spentMoneyForPromotion(num,catName);
    }

    public static void backToMenu(){
        System.out.println("To exit to the main menu, press ENTER.");
        String button = sc.nextLine();
        marketingMenuText();
    }
}