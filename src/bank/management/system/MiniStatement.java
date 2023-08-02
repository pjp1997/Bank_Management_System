
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {
  
    MiniStatement(String pinnumber){
        
        setTitle("Mini Statement");
      setLayout(null);
        
      JLabel mini = new JLabel();  //dynamic value insert through this label
      mini.setBounds(20,140,400,200);
      add(mini);
      
      JLabel balance = new JLabel ();
      balance.setBounds(20, 400, 300, 20);
      add(balance);
      
      JLabel bank = new JLabel("Indian Bank");
      bank.setBounds(150,20,100,20);
      add(bank);
      
      JLabel card = new JLabel();
      card.setBounds(20,80,300,20);   //fatch the card number from database 
      add(card);
      
      try{
          conn c= new conn();
          ResultSet rs=c.s.executeQuery("select * from login where pin = '"+pinnumber+"'");//all the value from login data base to fatch it and stored in the resultset 
      while(rs.next())   {            //all the row from the login database 
      card.setText("Card Number :  "+rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardnumber").substring(12));//this statement is fatch the cardnumber column data and set in the label in frame part
      
      }
      }catch(Exception e){
      System.out.println(e);
      }
      try {
          int bal=0;
          conn c = new conn();
          ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
          while(rs.next()){
          mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type_of_transation")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
          //settext is override but gettext uppend so all the text fatch it, the &nbsp command use for spaces,br command for breack the row next line
         
          
          
          if(rs.getString("type_of_transation").equals("Deposit")) //all details catch from bank table and compare the data from balace existance or not and balace value find
              {
              bal +=Integer.parseInt( rs.getString("amount"));     //this deposit balace
              }
              else{
                  bal-=Integer.parseInt(rs.getString("amount")); 
              }
           }
          
          balance.setText("Your Current Account Balance is Rs  "+bal);    // this print the current balance in your mini statement
      }
        catch(Exception e)
        {
            System.out.println(e);
        }
      
      
      
      
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
       // setUndecorated(true);
        setVisible(true);
        
    }
    
    
    public static void main (String [] args){
       new MiniStatement("");
    
    } 
    
}
