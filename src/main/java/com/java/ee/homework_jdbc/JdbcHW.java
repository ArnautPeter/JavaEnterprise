package com.java.ee.homework_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class JdbcHW {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection("jdbc:h2:file:D:\\users_hw_db", "sa", "sa");

        //SQLCommands.dropTable(connection, "test");
        //SQLCommands.printTable(connection, "positions");
        //SQLCommands.selectAvgSalary(connection);
        //SQLCommands.insertRecords(connection, "test", 1, 3000, 1);
        //SQLCommands.deleteRecordById(connection, "employees", 3);
        //SQLCommands.selectByName(connection, "employees", "Peter");
        SQLCommands.printTable(connection, "departments");
        SQLCommands.selectByDeptName(connection, "IT_DEPARTMENT");
    }

}
