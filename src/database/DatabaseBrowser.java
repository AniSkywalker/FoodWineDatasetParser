package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseBrowser {

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public Connection getConnect() {
        return connect;
    }

    public void disconnect() {
        try {
            connect.close();
        } catch (Exception e) {
        }

    }

    public void connect(String username, String password) {
        // pass your mysql username and password to connect
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/?" + "user=" + username + "&password=" + password + "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createDatabase(String name) {
        //creating a database
        try {
            String sql = "create database if not exists " + name + ";";
            if (this.connect != null) {
                Statement s = this.connect.createStatement();
                s.executeUpdate(sql);
            } else {
                System.out.println("No connection");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void useDatabase(String name) {
        //setting the active database
        try {
            String sql = "use " + name + ";";
            Statement s = this.connect.createStatement();
            s.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void executingDDL(String sql) {
        // executing DDL sql (create, alter)
        try {
            if (this.connect != null) {
                Statement s = this.connect.createStatement();
                s.executeUpdate(sql);
            } else {
                System.out.println("No connection");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void executingDML(String sql) {
        // executing DML sql
        try {
            Statement st = this.connect.createStatement();
            st.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
