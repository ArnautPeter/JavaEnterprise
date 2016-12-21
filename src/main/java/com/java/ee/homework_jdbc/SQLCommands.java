package com.java.ee.homework_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLCommands {

    static void dropTable(Connection connection, String tableName) throws SQLException {
        Statement statement = connection.createStatement();
        String query = "drop table " + tableName;
        statement.executeUpdate(query);
    }

    static void printTable(Connection connection, String tableName) throws SQLException {
        Statement statement = connection.createStatement();
        String query = "SELECT * from " + tableName;
        ResultSet resultSet = statement.executeQuery(query);
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (resultSet.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = resultSet.getString(i);
                System.out.print(rsmd.getColumnName(i) + " -> " + columnValue);
            }
            System.out.println("");
        }
    }

    static void insertRecords(Connection connection, String name, int dept_id, int salary, int possition_id)
            throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO " +
                "employees(NAME, DEPT_ID, SALARY, POSSITION_ID) VALUES(?, ?, ?, ?)");

        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, dept_id);
        preparedStatement.setInt(3, salary);
        preparedStatement.setInt(4, possition_id);
        preparedStatement.addBatch();

        preparedStatement.executeBatch();
    }

    static void deleteRecordById(Connection connection, String tableName, int id) throws SQLException {
        Statement statement = connection.createStatement();
        String query = "DELETE FROM " + tableName + " WHERE ID = " + id;
        statement.executeUpdate(query);
    }

    static void selectByName(Connection connection, String tableName, String name) throws SQLException {
        String query = "select * from " + tableName + " where name = ";
        PreparedStatement preparedStatement = connection.prepareStatement(query + "?");
        preparedStatement.setString(1, name);
        preparedStatement.addBatch();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println("--> " + resultSet.getString("id"));
        }
    }

    static void selectByDeptName(Connection connection, String deptName) throws SQLException {
        String query = "SELECT * FROM employees e INNER JOIN departments d ON e.dept_id = d.id where d.name =";
        PreparedStatement preparedStatement = connection.prepareStatement(query + "?");
        preparedStatement.setString(1, deptName);
        preparedStatement.addBatch();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println("--> " + resultSet.getString("name"));
        }
    }
}
