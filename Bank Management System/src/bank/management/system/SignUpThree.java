
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class SignUpThree extends JFrame implements ActionListener
{
    String formno;
    JRadioButton savingAccount , currentAccount, fdAccount ,recurringAccount ;
    JCheckBox c1 ,c2 ,c3, c4,c5, c6 , c7;
    JButton submit , cancel ;
    
    public SignUpThree(String formno)
    {
        setLayout(null);
        
         this.formno = formno;
        JLabel l1 = new JLabel("Page 3 : Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280,40,400,40);
        add(l1);
         
        
        JLabel type = new JLabel(" Account Type: ");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100,140,200,30);
        add(type);
        savingAccount = new JRadioButton("Saving Account");
        savingAccount.setFont(new Font("Raleway",Font.BOLD,16)); 
        savingAccount.setBackground(Color.WHITE);
        savingAccount.setBounds(100,180,150,20);
        add(savingAccount);
        fdAccount = new JRadioButton("Fixed Deposit Account");
        fdAccount.setFont(new Font("Raleway",Font.BOLD,16)); 
        fdAccount.setBackground(Color.WHITE);
        fdAccount.setBounds(350,180,250,20);
        add(fdAccount);
        currentAccount = new JRadioButton("Current Account");
        currentAccount.setFont(new Font("Raleway",Font.BOLD,16)); 
        currentAccount.setBackground(Color.WHITE);
        currentAccount.setBounds(100,220,250,20);
        add(currentAccount);
        recurringAccount = new JRadioButton("Recurring Deposit Account");
        recurringAccount.setFont(new Font("Raleway",Font.BOLD,16)); 
        recurringAccount.setBackground(Color.WHITE);
        recurringAccount.setBounds(350,220,250,20);
        add(recurringAccount);
        
        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(recurringAccount);
        accountGroup.add(currentAccount);
        accountGroup.add(fdAccount);
        accountGroup.add(savingAccount);
        
        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100,300,200,30);
        add(card);
        JLabel number = new JLabel("XXXX-XXXX-XXXX-4148 ");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330,300,300,30);
        add(number);
        JLabel cardDetails = new JLabel("Your 16 DIgit Card Number ");
        cardDetails.setFont(new Font("Raleway", Font.BOLD, 12));
        cardDetails.setBounds(100,330,300,15);
        add(cardDetails);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100,370,200,30);
        add(pin);
        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pnumber.setBounds(330,370,300,30);
        add(pnumber);
        JLabel pinDetails = new JLabel("Your 4 DIgit PIN ");
        pinDetails.setFont(new Font("Raleway", Font.BOLD, 12));
        pinDetails.setBounds(100,400,300,15);
        add(pinDetails);
        
        JLabel services = new JLabel("Services Required: ");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100,450,300,30);
        add(services);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 500, 200, 30);
        add(c1);
        c2 = new JCheckBox("INTERNET BANKING");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350, 500, 200, 30);
        add(c2);
        
        c3 = new JCheckBox("MOBILE BANKING");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100, 530, 200, 30);
        add(c3);
        c4 = new JCheckBox("E-Mail & SMS ALTER");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350,530,200,30);
        add(c4);
        
        c5 = new JCheckBox("CHEQUE BOOK");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100, 560, 200, 30);
        add(c5);
        c6 = new JCheckBox("E-STATEMENT:");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350, 560, 200, 30);
        add(c6);
        
        c7 = new JCheckBox("I hereby declaire that all the above entered details are correct to the best of my knowledge.");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100, 680, 600, 30);
        add(c7);
        
        
        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(250, 720, 100, 30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(420, 720, 100, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
    }
    
    @Override 
    public void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource() == submit) 
       {
           String accountType = null;
           if(savingAccount.isSelected())
           {
               accountType = "Saving Account";
           }
           else if(fdAccount.isSelected())
           {
               accountType = "Fixed Deposit Account";
           }
           else if(currentAccount.isSelected())
           {
               accountType = "Current Account";
           }
           else if(recurringAccount.isSelected())
           {
               accountType = "Recurring Deposit Account";
           }
           
           Random random = new Random();
           String cardNumber = "" + Math.abs((random.nextLong() % 90000000L + 5040936000000000L));
           
           String pinNumber = "" + Math.abs((random.nextInt() % 9000) + 1000);
           
           String facility = "" ;
           if(c1.isSelected())
           {
               facility = facility + "ATM CARD";
           }
           if (c2.isSelected())
           {
               facility = facility + "INTERNET BANKING";
           }
           if (c3.isSelected())
           {
               facility = facility + "MOBILE BANKING";
           }
           if (c4.isSelected())
           {
               facility = facility + "E-Mail & SMS ALTER";
           }
           if(c5.isSelected())
           {
              facility = facility + "CHEQUE BOOK" ;
           }
           if(c6.isSelected())
           {
              facility = facility + "E-STATEMENT BOOK" ;
           }
           
           try
           {
               if(accountType.equals(""))
               {
                  JOptionPane.showMessageDialog(null, "Account Type is Required");
               }
               else
               {
                   Conn conn = new Conn();
                   String query1 = "insert into SignupThree values('"+formno+"' , '"+accountType+"' ,'"+cardNumber+"' , '"+pinNumber+"' , '"+facility+"' )";
                   conn.s.executeUpdate(query1);
                   
                   String query2 = "insert into login values ('"+formno+"' , '"+cardNumber+"' , '"+pinNumber+"')";
                   conn.s.executeUpdate(query2);
                   
                   JOptionPane.showMessageDialog(null, "CardNumber : " + cardNumber+ "\n" + "PIN : "+pinNumber+"");
                   
                   setVisible(false);
                   
                   new Deposit(pinNumber).setVisible(true);
                   
               }
               
               
               
           }
           catch(Exception e)
           {
               e.printStackTrace();
           }
           
           
       }
       else if(ae.getSource() == cancel)
       {
           
            setVisible(false);
                   
            new Login().setVisible(true);
           
       }
    }
    
    public static void main(String[] args) 
    {
        new SignUpThree(null);
    }
    
}
