package com.kursovaya.acc_type.director;

import com.kursovaya.database.Database;
import com.kursovaya.login.Login;
import com.kursovaya.acc_type.marketing.GETQueryMarketing;
import com.kursovaya.acc_type.manager.GETQueryManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class GETQueryDirector {

    static Database db = new Database();

    public static void getAllBudgetCategory(){
        String query = "SELECT salary from users";
        int salaryBudget = 0;
        try{
            Statement statement = db.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()){
                int salary = rs.getInt("salary");
                salaryBudget+=salary;
            }
        } catch (SQLException e) {
            Login.welcomeText();
        }
        GETQueryMarketing getQueryMarketing = new GETQueryMarketing();
        getQueryMarketing.getMarketingAllBudget();
        System.out.println("Dedicated budget for salaries ---- "+salaryBudget + " som");
    }

    public static void salaryChange(String changeString){
        GETQueryManager getQueryManager = new GETQueryManager();
        getListOfEmployeeWithSalary();
        Scanner sc = new Scanner(System.in);
        System.out.println("Type the name of the employee you want to change the salary for:");
        String name = sc.nextLine();
        int salary = salaryCheck(name);
        int userID = getUserId(name);
        if(changeString.contains("UP")){
            System.out.println("Indicate the amount of the allowance:");
            int salaryUp =sc.nextInt();
            try{
                salary += salaryUp;
            }catch (Exception e){
                DirectorMainMenu.directorMainMenu();
            }
        }else{
            System.out.println("Specify the amount of the deduction:");
            int salaryUp =sc.nextInt();
            try{
                salary -= salaryUp;
            }catch (Exception e){
                DirectorMainMenu.directorMainMenu();
            }
        }
     String query = "UPDATE users set salary = "+salary+" where id = "+userID+"";
        try{
            Statement statement = db.getConnection().createStatement();
            statement.executeUpdate(query);
            System.out.println("Successfully done!");
        } catch (SQLException e) {
            DirectorMainMenu.directorMainMenu();
        }
    }

    private static int salaryCheck(String name){
        String query = "SELECT * FROM users";
        try{
            Statement statement = db.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                String firstName = rs.getString("firstName");
                String secondName = rs.getString("secondName");
                String fullName = firstName + " " + secondName;
                if(fullName.contains(name)){
                    return rs.getInt("salary");
                }
            }
        } catch (SQLException e) {
            DirectorMainMenu.directorMainMenu();
        }
        return 0;
    }

    private static int getUserId(String name){
        String query = "SELECT * FROM users";
        try{
            Statement statement = db.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                String firstName = rs.getString("firstName");
                String secondName = rs.getString("secondName");
                String fullName = firstName + " " + secondName;
                if(fullName.contains(name)){
                    return rs.getInt("id");
                }
            }
        } catch (SQLException e) {
            DirectorMainMenu.directorMainMenu();
        }
        return 0;
    }
private static void getListOfEmployeeWithSalary(){
        String query = "SELECT * from users";
        try {
            Statement statement = db.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(query);
            System.out.println("List of employees:");
            while (rs.next()){
                if(!rs.getString("acc_type").contains("director")){
                    String firstName = rs.getString("firstName");
                    String secondName = rs.getString("secondName");
                    String acc_type = rs.getString("acc_type");
                    int salary = rs.getInt("salary");
                    String output = "| "+firstName+" "+secondName+"| Position: "+acc_type+"| Salary: "+salary+" som";
                    int size = output.length();
                    System.out.println(output);
                    System.out.println("--------------------------------------------------");

                }
            }
        } catch (SQLException e) {
            System.out.println("Error! Please try again later.");
            Login.welcomeText();
        }
    }
}