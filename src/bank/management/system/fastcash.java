
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class fastcash extends JFrame implements ActionListener{
    JButton hundred,fivehundred,thousand,twothousand,fivethousand,back,tenthousand;
    String pinnumber;
    fastcash(String pinnumber){    
        this.pinnumber=pinnumber;   // try to local variable store in global varible
        setLayout(null);  //for not set default coordinate
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));   //icone build ande scaled
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);   // i2 image put in image icone 
        JLabel image = new JLabel(i3);  // image icon coverted in jlabel
         image.setBounds(0,0,900,900); //set the image coordinate manually
        add(image);
        
        
        JLabel text = new JLabel("Select Withrawl Amount");
        text.setBounds(250,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);  // add the text on image 
        
         hundred = new JButton("Rs 100");
        hundred.setBounds(170, 415, 150, 30);
       hundred.addActionListener(this);
        image. add(hundred);
        
         fivehundred= new JButton("Rs 500");
       fivehundred.setBounds(355, 415, 150, 30);
       fivehundred.addActionListener(this);
       image. add(fivehundred);
       
       
         thousand= new JButton("Rs 1000");
         thousand.setBounds(170, 450, 150, 30);
         thousand.addActionListener(this);
         image. add(thousand);  
         
          twothousand = new JButton("Rs 2000");
        twothousand.setBounds(355, 450, 150, 30);
         twothousand.addActionListener(this);
        image. add(twothousand);       
       
          fivethousand = new JButton("Rs 5000");
         fivethousand.setBounds(170, 485, 150, 30);
          fivethousand.addActionListener(this);
         image. add(fivethousand);       
       
         
          tenthousand= new JButton("Rs 10000");
     tenthousand.setBounds(355, 485, 150, 30);
        tenthousand.addActionListener(this);
        image. add(tenthousand);       
       
         
          back = new JButton("Back");
         back .setBounds(355, 520, 150, 30);
           back.addActionListener(this);        // all button get acess for action 
         image. add(back );       
       
         
         
       
        setSize(900,900);  // frame build
        setLocation(300,0);
       setUndecorated(true);  // perfect image saw and frame border part not visible
        setVisible(true);          // this method last beacuse of after this not shawn any action in frame
    
    }
    public void actionPerformed(ActionEvent ae){   // actionperformed method in sideActionListener interface for action any button
     if(ae.getSource()== back){
         setVisible(false);
         new Transation(pinnumber).setVisible(true);
     }
     else {
         String amount =((JButton)ae.getSource()).getText().substring(3) ;  // Rs 500   //ae.getsource return object so typecastingtojbutton
         conn c = new conn();   // this for connection to database
          try{
              ResultSet rs = c.s.executeQuery("select * from bank where pin ='"+pinnumber+"'"); // all the pin match details retrive it is DDl query
              int balance =0;
              while(rs.next()){
              if(rs.getString("type_of_transation").equals("Deposit")) //all details catch from bank table and compare the data from balace existance or not and balace value find
              {
              balance +=Integer.parseInt( rs.getString("amount"));     //this deposit balace
              }
              else{
                  balance-=Integer.parseInt(rs.getString("amount")); 
              }
                    // this is withdraw balance
              }
              
              if(ae.getSource()!= back && balance <Integer.parseInt(amount))
              {              //this is try to check if the amount you withraw is more than your balance 
               JOptionPane.showMessageDialog(null,"Insufficient Balance");
               return;
              }
              else{
              Date date = new Date();//date class is two package so expllicite import java.util.Date
              String query ="insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+amount+"')";// this is withrawl data stored in database because of withraw succes to data stored
              c.s.executeUpdate(query);
              JOptionPane.showMessageDialog(null,"Rs "+amount+ " Debited Sucessfully");
          
             setVisible(false);
             new Transation(pinnumber).setVisible(true);
              }
          }
          
          
          catch(Exception e){
          System.out.println(e);
          }
     }
    }
    public static void main (String [] args)
   {
       new fastcash("");  // main method call same class constructor
    }
    
}
