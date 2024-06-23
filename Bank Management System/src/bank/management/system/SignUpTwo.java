
package bank.management.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener
{
    
    JTextField adhar , pan;
    JButton next;
    JRadioButton eyes , eno , sno , syes;
    JComboBox occupation, education,income,category,religionOp;
    String formno ;
    
    public SignUpTwo(String formno)
    {
        //Primary key Import from Page 1 formno
        this.formno = formno;
        
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);
        
        JLabel religionlebal = new JLabel("Religion:");
        religionlebal.setFont(new Font("Raleway",Font.BOLD, 20));
        religionlebal.setBounds(100, 140, 100, 30);
        add(religionlebal);
        
        //To add DropDown Menu
        String valreligion[] = {"Hindu" , "Muslim", "Sikh", "christen" ,"Other"};
        religionOp = new JComboBox(valreligion);
        religionOp.setBounds(300, 140, 400, 30);
        religionOp.setBackground(Color.WHITE);
        add(religionOp);
        
        
        
        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway",Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
        
        String valCategory[] = {"OPEN","GENERAL" , "OBC", "SC/ST" ,"NT/VJNT" ,"OTHER"}; 
        category = new JComboBox(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);
        
        
        
        
        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway",Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        
        String valIncome[] = {"Null","< 1,50,000" , "< 2,50,000", "< 5,00,000 " ,"< 10,00,000" ,"10,00,000+"}; 
        income = new JComboBox(valIncome);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);
        
        
        JLabel gender = new JLabel("Educational: ");
        gender.setFont(new Font("Raleway",Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);
        
        JLabel email = new JLabel("Qualification: ");
        email.setFont(new Font("Raleway",Font.BOLD, 20));
        email.setBounds(100, 315, 200, 30);
        add(email);
        
        String educationValues[] = {"Non-Graduate","Graduate" , "Post-Graduate", "Doctrate"  ,"OTHER"}; 
        education = new JComboBox(educationValues);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);
        
        
        JLabel marital = new JLabel("Occupation:");
        marital.setFont(new Font("Raleway",Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);
        
        String occupationValues[] = {"Salaried","Self-Employed" , "Business", "Student", "Retired" ,"OTHER"}; 
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        JLabel address = new JLabel("PAN No:");
        address.setFont(new Font("Raleway",Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);
        
        pan = new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);
        
        JLabel city = new JLabel("Adhar No:");
        city.setFont(new Font("Raleway",Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);
        adhar = new JTextField();
        adhar.setFont(new Font("Raleway",Font.BOLD,14));
        adhar.setBounds(300, 490, 400, 30);
        add(adhar);
        
        JLabel state = new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway",Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 75, 30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(390, 540, 75, 30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup seniorCitizengroup = new ButtonGroup();
        seniorCitizengroup.add(syes);
        seniorCitizengroup.add(sno);
      
        
        JLabel pincode = new JLabel("Existing Account:");
        pincode.setFont(new Font("Raleway",Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 75, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(390, 590, 75, 30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup existingAccountgroup = new ButtonGroup();
        existingAccountgroup.add(eyes);
        existingAccountgroup.add(sno);
        
      
       next = new JButton("Next");   
       next.setBackground(Color.BLACK);
       next.setForeground(Color.WHITE);
       next.setFont(new Font("Raleway",Font.BOLD,14));
       next.setBounds(620, 660, 80, 30);
       next.addActionListener(this);
       add(next);
        
       getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    
    
  
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        
        String Sreligion = (String) religionOp.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();
        
        String seniorCitizen = null;
        if(syes.isSelected())
        {
          seniorCitizen = "Yes";  
        }
        else if(sno.isSelected())
        {
            seniorCitizen = "No";
        }
        
        String exitingAccount = null;
        if(eyes.isSelected())
        {
          exitingAccount = "Yes";  
        }
        else if(eno.isSelected())
        {
            exitingAccount = "No";
        }
        
        String span = pan.getText();
        String sadhar = adhar.getText();
        
        
        
        try
        {
           
               Conn c = new Conn();
               
               String query ="insert into signuptwo values ('"+formno+"' , '"+Sreligion+"' ,'"+scategory+"' ,'"+sincome+"' ,'"+seducation+"' ,'"+soccupation+"' ,'"+span+"' ,'"+sadhar+"' ,'"+seniorCitizen+"' , '"+exitingAccount+"'  )";     
           
               c.s.executeUpdate(query);
               
               //to open signup 3 page
               setVisible(false);
               new SignUpThree(formno).setVisible(true);
           
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }  
        
    }
        
    public static void main(String[] args) 
    {
          new SignUpTwo(null);

    }
  
}
 
    

