
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PinChange extends JFrame implements ActionListener {
    JButton change,back;
    JPasswordField pin,repin;
    String pinnumber;

   
    PinChange(String pinnumber){
        this.pinnumber =pinnumber;// this is for loacal to global variable valur transfer
        
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel image = new JLabel(i3);
      image .setBounds(0, 0, 900, 900);
        add(image );
        
        JLabel text = new JLabel("CHANGE YOUR PIN:");
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(260, 290, 500, 35);
        image.add(text);
        
         
        JLabel pintext = new JLabel("Enter New PIN:");
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setBounds(165, 340, 180, 25);
        image.add(pintext);
        
         pin = new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        pin.setBounds(330, 340, 180, 25);
        image.add(pin);
        
        JLabel repintext = new JLabel("Re-Enter New PIN:");
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("System",Font.BOLD,16));
        repintext.setBounds(165, 380, 180, 25);
        image.add(repintext);
        
         repin = new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,25));
        repin.setBounds(330, 380, 180, 25);
        image.add(repin);
        
        change = new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);   // this function use for catch the action for clicking 
        image.add(change);
        
         back = new JButton("BACK");
        back .setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back );
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
         if (ae.getSource()== change){
        try{
        String npin =pin.getText();
        String rpin=repin.getText(); 
        //text field stored in string variable
        
        if(!npin.equals("")&& !rpin.equals("")&& !npin.equals(rpin)){
        JOptionPane.showMessageDialog(null,"Entered PIN does not match");
        return;
        }
      if (npin.equals("")){
        JOptionPane.showMessageDialog(null,"Please Enter New PIN");
        return;
         }
         if (rpin.equals("")){
        JOptionPane.showMessageDialog(null,"Please Re-Enter New PIN");
        return;
        }
         conn con = new conn();// this object for connection to database
         String query1 ="update bank set pin ='"+rpin+"' where pin='"+pinnumber+"'";//this query is update the pin number in bank,login,signupthree table;
         String query2 ="update login set pin ='"+rpin+"' where pin='"+pinnumber+"'";
         String query3 ="update  signupthree set Pin_number ='"+rpin+"' where Pin_number='"+pinnumber+"'";
        
         con.s.executeUpdate(query1);  // all DML command query execute
         con.s.executeUpdate(query2);
         con.s.executeUpdate(query3);
         
        JOptionPane.showMessageDialog(null,"Pin Change Successfully");
         
        setVisible(false);
        
        new Transation(rpin).setVisible(true);
        
        
        }catch(Exception e){
        System.out.println(e);
        }
        
         }  
     
      
    
      else if (ae.getSource()== back){
          setVisible(false);
          new Transation(pinnumber).setVisible(true);
      }
    
    }
    
    public static void main (String []args){
      new PinChange("").setVisible(true);
    
    }
}
