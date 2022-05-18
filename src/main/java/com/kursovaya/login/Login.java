package com.kursovaya.login;

import com.kursovaya.database.Database;
import com.kursovaya.acc_type.director.DirectorMainMenu;
import com.kursovaya.acc_type.employee.EmployeeMainMenu;
import com.kursovaya.acc_type.manager.ManagerMainMenu;
import com.kursovaya.acc_type.marketing.MarketingMainMenu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Login {
    public static String wordID;
    static Scanner sc = new Scanner(System.in);
    static Database db = new Database();
    public static void main(String[] args) {
        welcomeText();
    }

    private static void check(String login, String word){
        String query = "SELECT acc_type, word FROM users WHERE acc_type = '" + login + "' and word = '"+ word+"'";
        try{
            Statement statement = db.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                wordID = resultSet.getString("word");
                switch (resultSet.getString("acc_type")){
                    case "marketing":
                        MarketingMainMenu.marketingMenuText();
                    case "manager":
                        ManagerMainMenu.managerMainMenu();
                    case "employee":
                        EmployeeMainMenu.employeeMainMenu();
                    case "director":
                        DirectorMainMenu.directorMainMenu();
                }

            }else{
                System.out.println("Извините, но мы не нашли такой тип аккаунта.");
                System.exit(0);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void welcomeText(){
        System.out.println("Для запуска программы, пожалуйста введите тип аккаунта и свое ключевое слово: >>>");
        System.out.println("Тип аккаунта:");
        String login = sc.nextLine();
        System.out.println("Ключевое слово:");
        String word = sc.nextLine();
        check(login,word);
    }
}
