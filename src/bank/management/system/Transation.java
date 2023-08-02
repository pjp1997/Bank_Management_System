
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Transation extends JFrame implements ActionListener{
    JButton deposit,withdrawl,ministatement,pinchange,fastcash,exit,balanceenquiry;
    String pinnumber;
    Transation(String pinnumber){    
        this.pinnumber=pinnumber;   // try to local variable store in global varible
        setLayout(null);  //for not set default coordinate
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));   //icone build ande scaled
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);   // i2 image put in image icone 
        JLabel image = new JLabel(i3);  // image icon coverted in jlabel
         image.setBounds(0,0,900,900); //set the image coordinate manually
        add(image);
        
        
        JLabel text = new JLabel("Please Select Your Transection");
        text.setBounds(215,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);  // add the text on image 
        
         deposit = new JButton("Deposit");
        deposit.setBounds(170, 415, 150, 30);
       deposit.addActionListener(this);
        image. add(deposit);
        
         withdrawl = new JButton("Cash Withdrawl");
       withdrawl.setBounds(355, 415, 150, 30);
       withdrawl.addActionListener(this);
       image. add(withdrawl);
       
       
         fastcash = new JButton("Fast Cash");
         fastcash.setBounds(170, 450, 150, 30);
         fastcash.addActionListener(this);
         image. add(fastcash);  
         
          ministatement = new JButton("Mini Statement");
        ministatement.setBounds(355, 450, 150, 30);
          ministatement.addActionListener(this);
        image. add(ministatement);       
       
          pinchange = new JButton("Pin Change");
         pinchange.setBounds(170, 485, 150, 30);
          pinchange.addActionListener(this);
         image. add(pinchange);       
       
         
           balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(355, 485, 150, 30);
        balanceenquiry.addActionListener(this);
        image. add(balanceenquiry);       
       
         
          exit = new JButton("Exit");
         exit .setBounds(355, 520, 150, 30);
            exit.addActionListener(this);        // all button get acess for action 
         image. add(exit );       
       
         
         
       
        setSize(900,900);  // frame build
        setLocation(300,0);
      setUndecorated(true);  // perfect image saw and frame border part not visible
        setVisible(true);          // this method last beacuse of after this not shawn any action in frame
    
    }
    public void actionPerformed(ActionEvent ae){   // actionperformed method in sideActionListener interface for action any button
     if(ae.getSource()== exit){
         System.exit(0);           
     }
     else if (ae.getSource()== deposit){ 
// all transation performed in transation class and differnt button to executed action
     setVisible(false);
new Deposit(pinnumber).setVisible(true);          // this all are button in transation class but performed as class becus all in inside data
        
    }
     else if (ae.getSource()== withdrawl)          // this for withrawl class
     {
         setVisible(false);
       new Withdrawl(pinnumber).setVisible(true);
     }
     else if(ae.getSource()== fastcash){               // this action goes for fastcash class(page)
       setVisible(false);
       new fastcash(pinnumber).setVisible(true);
     }
    else if(ae.getSource()== pinchange){               // this action goes for pinchange class(page)
       setVisible(false);
       new PinChange(pinnumber).setVisible(true);
     }
    else if(ae.getSource()==balanceenquiry){            // this action goes for balanceenquiry class(page)
      setVisible(false);
      new BalanceEnquiry(pinnumber).setVisible(true);
    }
    else if(ae.getSource()== ministatement){             // this action goes for ministatement class(page)
//       setVisible(false);                               setvisible not false because current page visible and ministatment open
       new MiniStatement(pinnumber).setVisible(true);
    }
    }
    
    public static void main (String [] args)
   {
       new Transation("");  // main method call same class constructor
    }
    
}
