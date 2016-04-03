/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examplej2eeapp.gmap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Mack
 */
public class DataBase {
    
   public Connection con;
   public Statement stmt;
  public  ResultSet rs ;
  public  String Quary="SELECT LatPosLongPos,Nazwa,Miasto,Ulica FROM ATMBZWBKFINALL";

  
  public void start() throws ClassNotFoundException, SQLException{
  Class.forName("oracle.jdbc.driver.OracleDriver");
           con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jeeappdb", "password");
    	   stmt = con.createStatement();
    	   rs = stmt.executeQuery(Quary);
  
  
  
  
  
  }
    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public Statement getStmt() {
        return stmt;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public String getQuary() {
        return Quary;
    }

    public void setQuary(String Quary) {
        this.Quary = Quary;
    }
    
}
