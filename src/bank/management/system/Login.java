
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener  {
    JButton Login,Clear,Signup,exit;
    JTextField cardTextField;
    JPasswordField pinTextField;
     Login(){
          setTitle("ATOMATED TELLER MAACHINE");
          setLayout(null);
         ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
         Image i2= i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel labe1= new JLabel(i3);
         labe1.setBounds(70,10,100,100);
         add(labe1);
         
         JLabel text = new JLabel("Welcome To ATM");
         text.setFont(new Font("Osward",Font.BOLD,38));
         text.setBounds(200, 40, 400, 40);
         add(text);
         
          JLabel cardno = new JLabel("Card No :");
         cardno.setFont(new Font("Ralwey",Font.BOLD,28));
         cardno.setBounds(120, 150, 150, 30);
         add(cardno);
         
            cardTextField = new JTextField();
            cardTextField.setFont(new Font("Arial",Font.BOLD,14));
           cardTextField.setBounds(300,150,230,30);
           add(cardTextField);
         
          JLabel pin = new JLabel("Pin :");
         pin.setFont(new Font("Ralwey",Font.BOLD,28));
         pin.setBounds(120, 220, 250, 30);
         add(pin);
         
          pinTextField = new JPasswordField ();
           pinTextField.setFont(new Font("Arial",Font.BOLD,14));
           pinTextField.setBounds(300,220,230,30);
           add(pinTextField);
           
            Login = new JButton("SIGN IN");
           Login.setBounds(300, 300, 100, 30);
           Login.setBackground(Color.black);
           Login.setForeground(Color.white);
           Login.addActionListener(this);
           add(Login);
           
             Clear = new JButton("CLEAR");
           Clear.setBounds(430, 300, 100, 30);
           Clear.setBackground(Color.black);
           Clear.setForeground(Color.white);
           Clear.addActionListener(this);
           add(Clear);
          
             Signup = new JButton("SIGN UP");
           Signup.setBounds(300, 350, 230, 30);
           Signup.setBackground(Color.black);
           Signup.setForeground(Color.white);
           Signup.addActionListener(this);
           add(Signup);
           
            exit = new JButton("EXIT");
          exit.setBounds(370, 400, 80, 30);
           exit.setBackground(Color.black);
           exit.setForeground(Color.white);
          exit.addActionListener(this);
           add(exit);
         
         getContentPane().setBackground(Color.WHITE);
         
        
         setSize(800,500);
        
         setUndecorated(true);
         setLocation(350,200);
          setVisible(true);
     }
     
     public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== Clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource()==exit){
          setVisible(false);
          System.exit(0);
        
        }
        else if(ae.getSource()== Login){
            conn con = new conn();   //   connection establish from database
           
           String cardnumber =cardTextField.getText();
           String pinnumber = pinTextField.getText(); // text collected  from pin and cardnumber
           String query ="select * from login where cardnumber ='"+cardnumber+"' and pin = '"+pinnumber+"'";//this is query of sql data base and the query was DDL query
           try{
             ResultSet rs= con.s.executeQuery(query);  // data return from data base so store from resultset                       // data base is external entity so exception handling is necessary
               if(rs.next()){    //data succesfull outside
               setVisible(false);  // current frame close 
               new Transation(pinnumber).setVisible(true);//next frame shown and set visible true so visible
             }
               else{
               JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
               }
           }
           catch(Exception e){
           
           System.out.print(e);
           }
        
        
        
        }
        
        else if(ae.getSource()== Signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
     }
    public static void main(String[] args) {
      new Login();
    }
    
}
