package org.hero.persistance;

import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * <property name="driverClass" value="com.mysql.cj.jdbc.Driver"/>
 *         <property name="url" value="jdbc:mysql://localhost/springbook?serverTimezone=Asia/Seoul"/>
 *         <property name="username" value="root"/>
 *         <property name="password" value="920124"/>
 */
@Log4j
public class JDBCTest {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testConnection(){
        String url = "jdbc:mysql://localhost/springPort?serverTimezone=Asia/Seoul";
        try{
            Connection conn = DriverManager.getConnection(url,"root","920124");
            log.info(conn);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
