package com.kursovaya.acc_type.employee;

import com.kursovaya.database.Database;
import com.kursovaya.login.Login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GETQueryEmployee {

    static Database db = new Database();

    public void showMySalary(){
        String myWord = Login.wordID;
        String query = "SELECT salary from users WHERE word = '"+myWord+"'";
        try{
            Statement statement = db.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(query);
            if(rs.next()){
                int salary = rs.getInt("salary");
                System.out.println("Ваша зарплата --- "+salary);
            }
        } catch (SQLException e) {
            EmployeeMainMenu.employeeMainMenu();
        }
    }
}
