package com.epam.jwd.database;

import java.sql.*;

public class JdbcExample {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/jd2ex1?useSSL=false", "root", "root");

      /*  String sql = "INSERT INTO users(name, surname) VALUES(?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, "Aliaksei");
        ps.setString(2, "Kulikouski");

        ps.executeUpdate();*/

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * from users");

        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " "
                    + rs.getString(3));
        }

        //close

    }
}
