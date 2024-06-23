
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class MiniStatement extends JFrame implements ActionListener
{
    String pinNumber ;
    
    
    public MiniStatement(String pinNumber)
    {
        this.pinNumber = pinNumber;
        
        setTitle("Mini Statement");
        
        setLayout(null);
        
       /* ImageIcon i1 = new ImageIcon("icons/.atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
       */
        
        JLabel text = new JLabel();
        add(text);
        
        JLabel bank = new JLabel("State Bank of India");
        bank.setBounds(130, 20, 200, 20);
        add(bank);
        
        JLabel cardNumber = new JLabel();
        cardNumber.setBounds(30, 80, 300, 20);
        add(cardNumber);
        
        try
        {
           Conn conn = new Conn();
           ResultSet rs = conn.s.executeQuery("Select * from Login where pinNumber = '"+this.pinNumber+"'");
           while(rs.next())
           {
              cardNumber.setText("Card Number : " + rs.getString("cardNumber").substring(0, 4)+"XXXXXXXX"+rs.getString("cardNumber").substring(12));
           }    
        }
        catch(Exception e)
        {
            e.printStackTrace();
        } 
      
        JLabel mini = new JLabel();
        mini.setBounds(20, 100, 400, 200);
        add(mini);
       
        try
        {
            Conn conn = new Conn();
             
            ResultSet rs = conn.s.executeQuery("Select * from Bank where pinNumber = '"+this.pinNumber+"'");
            
            while(rs.next())
            {
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        JLabel accBalance = new JLabel();
        accBalance.setBounds(20, 400, 300, 20);
        add(accBalance);
        
        try
        {
            Conn conn = new Conn();
            int balance = 0 ;
            ResultSet rs = conn.s.executeQuery("Select * from bank Where pinNumber = '"+this.pinNumber+"'");
                   
            while(rs.next())
            {
                //mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
          
                if(rs.getString("type").equals("Deposit"))
                {
                    balance = balance + Integer.parseInt(rs.getString("amount"));
                }
                else
                {
                    balance = balance - Integer.parseInt(rs.getString("amount"));
                  
                }
            }
           accBalance.setText("Your Current Account Balance is Rs. "+balance);
           
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        setSize(400,600);
        setLocation(0,100);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        
    }
    
    public static void main(String[] args) 
    {
        new MiniStatement(null);   
    }
    
}
