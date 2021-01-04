package com.wufuqiang.mysql.handler;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHandler {

    private static String urlFormat =
            "jdbc:mysql://%s:%s/%s?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    public static Connection getConnection(String driver,String hostname,String port,
                                           String username ,String password,String database){
        Connection conn = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(
                    String.format(urlFormat, hostname, port, database),
                    username, password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
}
