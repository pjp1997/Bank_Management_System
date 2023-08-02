
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;



public class SignupTwo extends JFrame implements ActionListener {
    
    JTextField pantextfield,adhartextfield ;
    JButton next,previous;
    JRadioButton sny,sno,eay,ean;
    JComboBox  religionbox,categorybox,incomebox,educationbox , occupationbox ;
    String formno;
    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);
       setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
       JLabel additionalDetails = new JLabel("Page 2: Additional Details");
       additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
       additionalDetails.setBounds(290, 80, 400, 30); 
        add(additionalDetails);
        
       
        
         JLabel religion= new JLabel("Religion :");
       religion.setFont(new Font("Raleway",Font.BOLD,20));
       religion.setBounds(100, 140, 100, 30); 
        add(religion);
        
        String []valreligion ={"Hindu","Muslim","Sikh","Christian","Other"};
         religionbox = new JComboBox(valreligion);
        religionbox.setBounds(300, 140, 400, 30);
        religionbox.setBackground(Color.white);
         add(religionbox);
        
        
           
         JLabel category= new JLabel("Category :");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(100, 190, 200, 30); 
        add( category);
        
        String [] valcategory = {"General","OBC","SC","ST","Other"};
         categorybox = new JComboBox(valcategory);
        categorybox .setBounds(300, 190, 400, 30);
        categorybox.setBackground(Color.white);
        add(categorybox);
        
       
        
           JLabel income= new JLabel("Income :");
       income.setFont(new Font("Raleway",Font.BOLD,20));
       income.setBounds(100, 240, 200, 30); 
       add(income);
       
       String [] valincome = {"None","Below 1.5 Lakhs","1.5 Lakhs - 3.0 Lakhs","3.0 Lakhs - 5.0 Lakhs","Above 5.0 Lakhs"};
        incomebox = new JComboBox(valincome);
        incomebox .setBounds(300, 240, 400, 30);
        incomebox.setBackground(Color.white);
        add(incomebox);
        
        
          JLabel educational= new JLabel("Educational");
       educational.setFont(new Font("Raleway",Font.BOLD,20));
       educational.setBounds(100, 290, 200, 30); 
        add(educational);
        
         JLabel qualification= new JLabel("Qualification :");
        qualification.setFont(new Font("Raleway",Font.BOLD,20));
       qualification.setBounds(100, 315, 200, 30); 
        add(qualification);
        
         String [] valeducation = {"Under Graduation","Graduation","Post Gratuation","PHD","Other"};
      educationbox = new JComboBox(valeducation);
       educationbox .setBounds(300, 315, 400, 30);
       educationbox.setBackground(Color.white);
        add(educationbox);
        
        
         JLabel occupation= new JLabel("Occupation :");
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        occupation.setBounds(100, 390, 200, 30); 
        add(occupation);
        
        
         String [] valoccupation = {"Student","Salaried","Self-Employed","Bussiness","Retired","Other"};
         occupationbox = new JComboBox(valoccupation);
       occupationbox .setBounds(300, 390, 400, 30);
       occupationbox.setBackground(Color.white);
        add(occupationbox);
        
         
      
         
         JLabel pan= new JLabel("PAN Number :");
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(100, 440, 200, 30); 
        add(pan);
        
         pantextfield = new JTextField();
        pantextfield.setFont(new Font("Raleway",Font.BOLD,14));
        pantextfield.setBounds(300, 440, 400, 30);
        add(pantextfield);
        
        
           
         JLabel adhar= new JLabel("Adhar Number :");
        adhar.setFont(new Font("Raleway",Font.BOLD,20));
        adhar.setBounds(100, 490, 200, 30); 
        add(adhar);
        
         adhartextfield = new JTextField();
        adhartextfield.setFont(new Font("Raleway",Font.BOLD,14));
       adhartextfield.setBounds(300, 490, 400, 30);
        add(adhartextfield);
        
        
            
         JLabel senior =new JLabel("Senior Citizen :");
       senior.setFont(new Font("Raleway",Font.BOLD,20));
        senior.setBounds(100, 540, 200, 30); 
        add(senior);
        
           sny = new JRadioButton("Yes");
        sny.setBounds(300, 540, 100, 30);
        sny.setBackground(Color.WHITE);
        add(sny);
        
          sno = new JRadioButton("NO");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup sngroup = new ButtonGroup();
        sngroup.add(sny);
        sngroup.add(sno);
  
        
        
         JLabel existingaccount= new JLabel("Existing Account :");
        existingaccount.setFont(new Font("Raleway",Font.BOLD,20));
       existingaccount.setBounds(100, 590, 200, 30); 
        add(existingaccount);
        
        
           eay = new JRadioButton("Yes");
       eay.setBounds(300, 590, 100, 30);
        eay.setBackground(Color.WHITE);
        add(eay);
        
          ean = new JRadioButton("NO");
       ean.setBounds(450, 590, 100, 30);
        ean.setBackground(Color.WHITE);
        add(ean);
        
        ButtonGroup eagroup = new ButtonGroup();
        eagroup.add(eay);
      eagroup.add(ean);
  
        
         next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);
        
         previous = new JButton("Previous");
         previous.setBackground(Color.black);
         previous.setForeground(Color.WHITE);
         previous.setFont(new Font("Raleway",Font.BOLD,14));
        previous.setBounds(100, 660, 100, 30);
       previous.addActionListener(this);
        add( previous);
        
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setUndecorated(true);
        setVisible(true);
    }
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==previous){
         setVisible(false);
         new SignupOne().setVisible(true);
         }
         else{
         String sreligion = (String)religionbox.getSelectedItem();
         String scategory =(String)categorybox.getSelectedItem();
         String sincome =(String)incomebox.getSelectedItem();
         String seducation =(String)educationbox.getSelectedItem();
         String soccupation =(String)occupationbox.getSelectedItem();
         
         String ssenior= null;
         if(sny.isSelected()){
          ssenior = "Yes";
         }
         else if(sno.isSelected()){
            ssenior= "No";
         }
      
         String sea =null;
         if(eay.isSelected())
         {  sea ="Yes";
         }
         else if (ean.isSelected())
         {sea= "No";
         }
         String span  = pantextfield.getText();
         String sadhar = adhartextfield.getText();
        
         try{
             
             conn c = new conn();
             String query = "insert into signupTwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+sadhar+"','"+ssenior+"','"+sea+"')";
             c.s.executeUpdate(query);
             
             //Signup3 Object
             setVisible(false);
             new signupThree(formno).setVisible(true);
             
             
         }
         catch(Exception e)
         {System.out.println(e);
         }
         }
     }
     public static void main(String[] args) {
     new SignupTwo("");
    }
    
}

