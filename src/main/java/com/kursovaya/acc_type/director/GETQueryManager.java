package com.kursovaya.acc_type.manager;

import com.kursovaya.database.Database;
import com.kursovaya.login.Login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class GETQueryManager {
    static Database db = new Database();

    public void getListOfEmployee(){
        String query = "SELECT * from users where acc_type = 'employee'";
        try {
            Statement statement = db.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(query);
            System.out.println("Список сотрудников:");
            while (rs.next()){
                String firstName = rs.getString("firstName");
                String secondName = rs.getString("secondName");
                String acc_type = rs.getString("acc_type");
                System.out.println(" | "+firstName+" "+secondName+" | Должность: "+acc_type);
                System.out.println("--------------------------------------------------");

            }
        } catch (SQLException e) {
            System.out.println("Ошибка! Повторите позже.");
            Login.welcomeText();
        }
    }

    public void showAllMyToDoList(){
        String wordID = Login.wordID;
        String query = "SELECT * from todo_list where who = '"+wordID+"'";
        try {
            Statement statement = db.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(query);
            System.out.println("Список дел:");
            int number = 1;
            while (rs.next()){
                String description = rs.getString("description");
                System.out.println(number + ". "+description);
                number++;
            }
        } catch (SQLException e) {
            System.out.println("Ошибка! Повторите позже.");
            Login.welcomeText();
        }
    }

    public void showActiveOrDoneToDo(String status){
        String wordID = Login.wordID;
        String query = "SELECT * from todo_list where who = '"+wordID+"' and status = '"+status+"'";
        try {
            Statement statement = db.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(query);
            if(status.contains("ACTIVE")){
                System.out.println("Список активных дел:");
            }else {
                System.out.println("Список завершенных дел:");
            }
            while (rs.next()){
                int id = rs.getInt("id");
                String description = rs.getString("description");
                System.out.println(id + ". "+description);
            }
        } catch (SQLException e) {
            System.out.println("Ошибка! Повторите позже.");
            Login.welcomeText();
        }
    }

    public void addTaskForToDoList(String task){
        String wordID = Login.wordID;
        String query = "INSERT into todo_list(who,description,status) values('"+wordID+"','"+task+"','ACTIVE')";
        try {
            Statement statement = db.getConnection().createStatement();
            statement.execute(query);
            System.out.println("Успешно добавленно!");
        } catch (SQLException e) {
            System.out.println("Ошибка! Повторите позже.");
            Login.welcomeText();        }
    }

    public void updateTaskToDone(){
        Scanner sc = new Scanner(System.in);
        showActiveOrDoneToDo("ACTIVE");
        System.out.println("Введите номер дела, которое хотите завершить:");
        String taskNumber = sc.nextLine();
        String wordID = Login.wordID;
        String query = "update todo_list set status = 'DONE' where id = "+taskNumber+" and who = '"+wordID+"'";
        try {
            Statement statement = db.getConnection().createStatement();
            statement.executeUpdate(query);
            System.out.println("Успешно сделанно!");
        } catch (SQLException e) {
            System.out.println("Ошибка! Повторите позже.");
            Login.welcomeText();
        }
    }

    public void showAllToDoList(){
        String query = "SELECT * from todo_list";
        try {
            Statement statement = db.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(query);
            System.out.println("Список дел всех сотрудников:");
            while (rs.next()){
                int id = rs.getInt("id");
                String description = rs.getString("description");
                String word = rs.getString("who");
                System.out.println(id + ". "+description + "---" + getFullNameByWord(word));
            }
        } catch (SQLException e) {
            System.out.println("Ошибка! Повторите позже.");
            Login.welcomeText();
        }
    }


    private String getFullNameByWord(String word){
        String query = "SELECT * from users where word = '"+word+"'";
        String fullName = "";
        try {
            Statement statement = db.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                String firstName = rs.getString("firstName");
                String secondName = rs.getString("secondName");
                fullName = firstName+" "+secondName;
                return fullName;
            }
        } catch (SQLException e) {
            System.out.println("Ошибка! Повторите позже.");
            Login.welcomeText();
        }
        return fullName;
    }
}
