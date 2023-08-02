
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class signupThree extends JFrame implements ActionListener {
    
    JRadioButton R1,R2,R3,R4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    signupThree(String formno){
        this.formno=formno;
        setLayout(null);
        
        JLabel l1 = new JLabel("Page 3:Account Details");
       l1.setFont(new Font("Raleway",Font.BOLD,22));
       l1.setBounds(280, 40, 400, 40);
       add(l1);
       
       
       JLabel type = new JLabel("Account Type");
       type.setFont(new Font("Raleway",Font.BOLD,22));
       type.setBounds(100, 140, 200, 30);
       add(type);
       
       R1 = new JRadioButton("Saving Account");
       R1.setFont(new Font("Raleway",Font.BOLD,16));
       R1.setBackground(Color.white);
       R1.setBounds(100, 180, 200, 20);
       add(R1);
       
       R2 = new JRadioButton("Fixed Deposit Account");
       R2.setFont(new Font("Raleway",Font.BOLD,16));
       R2.setBackground(Color.white);
       R2.setBounds(350, 180, 200, 20);
       add(R2);
       
       R3 = new JRadioButton("Current Account");
       R3.setFont(new Font("Raleway",Font.BOLD,16));
       R3.setBackground(Color.white);
       R3.setBounds(100, 220, 200, 20);
       add(R3);
       
       R4 = new JRadioButton("Recurring Deposit Account");
       R4.setFont(new Font("Raleway",Font.BOLD,16));
       R4.setBackground(Color.white);
       R4.setBounds(350, 220, 230, 20);
       add(R4);
       
       ButtonGroup groupaccount = new ButtonGroup();
       groupaccount.add(R1);
       groupaccount.add(R2);
       groupaccount.add(R3);
       groupaccount.add(R4);
       
       
        JLabel card = new JLabel("Card Number");
       card.setFont(new Font("Raleway",Font.BOLD,22));
       card.setBounds(100, 300, 200, 30);
       add(card);
       
        JLabel number  = new JLabel("XXXX-XXXX-XXXX-4184");
       number.setFont(new Font("Raleway",Font.BOLD,22));
       number.setBounds(330, 300, 300, 30);
       add(number);
       
        JLabel carddetail = new JLabel("Your 16 Digit card Number");
       carddetail.setFont(new Font("Raleway",Font.BOLD,12));
       carddetail.setBounds(100, 330, 200, 20);
       add(carddetail);
       
       JLabel pin= new JLabel("PIN:");
       pin.setFont(new Font("Raleway",Font.BOLD,22));
       pin.setBounds(100, 370, 200, 30);
       add(pin);
       
        JLabel pnumber  = new JLabel("XXXX");
       pnumber.setFont(new Font("Raleway",Font.BOLD,22));
       pnumber.setBounds(330, 370, 300, 30);
       add(pnumber);
       
        JLabel pindetail = new JLabel("Your 4 Digit PIN Number");
       pindetail.setFont(new Font("Raleway",Font.BOLD,12));
       pindetail.setBounds(100, 400, 200, 20);
       add(pindetail);
       
        JLabel service= new JLabel("Service Required :");
       service.setFont(new Font("Raleway",Font.BOLD,22));
       service.setBounds(100, 450, 200, 30);
       add(service);
       
       c1=new JCheckBox("ATM CARD");
       c1.setBackground(Color.white);
       c1.setFont(new Font("Raleway",Font.BOLD,16));
       c1.setBounds(100, 500, 200, 30);
       add(c1);
       
        c2=new JCheckBox("Internet Banking");
       c2.setBackground(Color.white);
       c2.setFont(new Font("Raleway",Font.BOLD,16));
       c2.setBounds(350, 500, 200, 30);
       add(c2);
       
        c3=new JCheckBox("Mobile Banking");
       c3.setBackground(Color.white);
       c3.setFont(new Font("Raleway",Font.BOLD,16));
       c3.setBounds(100, 550, 200, 30);
       add(c3);
       
        c4=new JCheckBox("EMAIL & SMS Alerts");
       c4.setBackground(Color.white);
       c4.setFont(new Font("Raleway",Font.BOLD,16));
       c4.setBounds(350, 500, 200, 30);
       add(c4);
       
        c5=new JCheckBox("Cheque Book");
       c5.setBackground(Color.white);
       c5.setFont(new Font("Raleway",Font.BOLD,16));
       c5.setBounds(100, 600, 200, 30);
       add(c5);
       
        c6=new JCheckBox("E Statement");
       c6.setBackground(Color.white);
       c6.setFont(new Font("Raleway",Font.BOLD,16));
       c6.setBounds(350, 600, 200, 30);
       add(c6);
       
        c7=new JCheckBox("I here by declares that the above entered details are correct to the best of my knowledge");
       c7.setBackground(Color.white);
       c7.setFont(new Font("Raleway",Font.BOLD,12));
       c7.setBounds(100, 680, 600, 30);
       add(c7);
       
       submit = new JButton("Submit");
       submit.setBackground(Color.BLACK);
       submit.setForeground(Color.WHITE);
       submit.setFont(new Font("Raleway",Font.BOLD,14));
       submit.setBounds(250, 730, 100, 30);
       submit.addActionListener(this);
       add(submit);
       
       cancel = new JButton("Cancel");
       cancel.setBackground(Color.BLACK);
       cancel.setForeground(Color.WHITE);
       cancel.setFont(new Font("Raleway",Font.BOLD,14));
       cancel.setBounds(420, 730, 100, 30);
       cancel.addActionListener(this);
       add(cancel);
       
       getContentPane().setBackground(Color.white);
       
       setSize(800,820);
       setLocation(350,0);
       setUndecorated(true);
       setVisible(true);
    
    }
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==submit){
        String accountType = null;
        if(R1.isSelected()){
         accountType = "Saving Account";
        }
        else if(R2.isSelected()){
        accountType ="Fixed Deposit Account";
        }
        else if (R3.isSelected()){
          accountType = "Current Account";
        }
        else if (R4.isSelected()){
        accountType = "Reccuring Deposit Account";
        }
        Random random = new Random();
        String cardnumber =""+Math.abs((random.nextLong()%9000000L)+5040936000000000L);
        String pinnumber =""+Math.abs((random.nextLong()%9000L)+1000L);
    
        String facility ="";
        if(c1.isSelected()){
            facility =facility + " ATM Card";
        }
        else if(c2.isSelected()){
           facility = facility + " Ineternet Banking";
        }
        else if(c3.isSelected()){
           facility = facility + " Mobile Banking";
        }
        else if(c4.isSelected()){
           facility = facility + " EMAIL & SMS Alerts ";
        }
        else if(c5.isSelected()){
           facility = facility + " Cheque Book ";
        }
        else if(c6.isSelected()){
           facility = facility + " E-Statement";
        }
        try{
            if(accountType.equals("")){
            JOptionPane.showMessageDialog(null,"Account Type is Requred");
            }
            else{
             conn con = new conn();
             String query1 = "insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
             String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
             con.s.executeUpdate(query1);
             con.s.executeUpdate(query2);
             JOptionPane.showMessageDialog(null,"Card Number:"+cardnumber+ "\n Pin:"+pinnumber);
            }
            setVisible(false);
            new Login ().setVisible(true);
           // new Deposit(pinnumber).setVisible(true);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    
    }
    
   else if(ae.getSource()==cancel){
       setVisible(false);
       new Login().setVisible(true);
    
    }
    }
    public static void main (String [] args){
       new signupThree("");
    }
}
