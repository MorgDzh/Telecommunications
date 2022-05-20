package com.kursovaya.acc_type.marketing;

import com.kursovaya.database.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GETQueryMarketing {
    static Database db = new Database();


    public void getAllAreas(){
        String query = "SELECT * from districts";
        try {
            Statement statement = db.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                String name = rs.getString("name");
                int procent = rs.getInt("procent");
                int members = rs.getInt("members");
                System.out.println(name + " ---- "+procent+"%"+" ---- "+members+" per.");
            }
        } catch (SQLException e) {
            MarketingMainMenu.backToMenu();
        }
    }

    public void getMarketingCategory(){
        String query = "SELECT * from marketing_category";
        try {
            Statement statement = db.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                String name = rs.getString("name");
                int members = rs.getInt("members");
                System.out.println(name+" ---- "+members);
            }
        } catch (SQLException e) {
            MarketingMainMenu.backToMenu();
        }
    }

    public void getMarketingCategoryBudget(){
        String query = "SELECT * from marketing_category";
        try {
            Statement statement = db.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                String name = rs.getString("name");
                int budget = rs.getInt("budget");
                System.out.println(name+" ---- "+budget+" som");
            }
        } catch (SQLException e) {
            MarketingMainMenu.backToMenu();
        }
    }

    public void getMarketingAllBudget(){
        String query = "SELECT * from marketing_category";
        try {
            Statement statement = db.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(query);
            int sum = 0;
            while (rs.next()){
                int budget = rs.getInt("budget");
                sum += budget;
            }
            System.out.println("Dedicated budget for marketing ---- "+sum+" som");
        } catch (SQLException e) {
            MarketingMainMenu.backToMenu();
        }
    }

    public void getOnlyMarketingCategoryName(){
        String query = "SELECT * from marketing_category";
        try {
            Statement statement = db.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                String name = rs.getString("name");
                System.out.println(name);
            }
        } catch (SQLException e) {
            MarketingMainMenu.backToMenu();
        }
    }
    public static int checkMoney(int money){
        int budget = 0;
        String query = "SELECT * from marketing_category";
        try {
            Statement statement = db.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                budget = rs.getInt("budget");
                if(budget>=money){
                    budget = budget-money;
                    return budget;
                }else{
                    System.out.println("The amount you have listed is more than the budget for this category.");
                    MarketingMainMenu.backToMenu();
                }
            }
        } catch (SQLException e) {
            MarketingMainMenu.backToMenu();
        }
        return budget;
    }

    public void spentMoneyForPromotion(int money,String social){
        String query = "UPDATE marketing_category SET budget = '"+money+"' WHERE name = '"+social+"'";
        try {
            Statement statement = db.getConnection().createStatement();
            statement.executeUpdate(query);
            System.out.println("Successfully spent!");
            MarketingMainMenu.backToMenu();
        } catch (SQLException e) {
            System.out.println("Oops... Something went wrong.");
            MarketingMainMenu.backToMenu();
        }

    }
}