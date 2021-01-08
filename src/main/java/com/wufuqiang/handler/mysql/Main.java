package com.wufuqiang.handler.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionHandler.getConnection("com.mysql.cj.jdbc.Driver","localhost","3306",
                "root","iamroot","test1");
        String sql = "select id,name,url,alexa,country from websites;";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet resultSet = pstmt.executeQuery();
        List<Website> websites = ResultSetHandler.resultToList(resultSet, Website.class);
        websites.forEach(System.out::println);

        System.out.println(connection);
    }
}
