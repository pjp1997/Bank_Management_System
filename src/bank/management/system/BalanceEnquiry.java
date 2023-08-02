
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
    String pinnumber;
    JButton back;
    BalanceEnquiry(String pinchange){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));  // image path decide code and selected as icon
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);  // image icon to coverted in image and rescaled size as frame size 
        ImageIcon i3 = new ImageIcon(i2);   //this ready for image icon for rescaled as frame size
        
        JLabel image = new JLabel(i3);     
        image.setBounds(0, 0, 900, 900); //this all image to put in frame 
       add(image);
      
       
       back = new JButton("BACK");
       back.setBounds(355, 520, 150, 30);
       back.addActionListener(this);    // put the action listener
       add(back);
       
       conn c = new conn();   // this for connection to database
       int balance =0;
          try{
              ResultSet rs = c.s.executeQuery("select * from bank where pin ='"+pinnumber+"'"); // all the pin match details retrive it is DDl query
              
              while(rs.next()){ // this will helping all the row one by one looping 
              if(rs.getString("type_of_transation").equals("Deposit")) //all details catch from bank table and compare the data from balace existance or not and balace value find
              {
              balance +=Integer.parseInt( rs.getString("amount"));     //this deposit balace
              }
              else{
                  balance-=Integer.parseInt(rs.getString("amount"));     //this all thing put in the constructor because of there no action in button click direct show display
              }
                    // this is withdraw balance
              }
          }
          catch(Exception e){
          
          System.out.println(e); 
          }
          JLabel text = new JLabel("Your Current Account Balance Rs : "+balance);
          text.setForeground(Color.white);
          text.setFont(new Font("Raleway",Font.BOLD,16));
          text.setBounds(165,300,400,50);
          image.add(text);
        
    setSize(900,900);
    setLocation(300,0);
    //setUndecorated(true);
    setVisible(true);
   
    
    } 
    public void actionPerformed(ActionEvent ae){
     setVisible(false);    //current page close and not check statement because of only one button  in the constructer
     new Transation (pinnumber).setVisible(true);
    }
    public static void main (String [] args){
        new BalanceEnquiry("");
    
    
    }
}
