
package bank.management.system;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Image;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.sql.ResultSet;




public class FastCash extends JFrame implements ActionListener
{
    
    JButton back,num500,num100, num1000, num2000, num5000, num10000;
    
    String pinNumber ;
    
    
    public FastCash(String pinNumber)
    {
        this.pinNumber = pinNumber;
        
        setLayout(null);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT );
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Select Withdrawl Amount");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System" , Font.BOLD,16));
        image.add(text);
        
        num100 = new JButton("100");
        num100.setBounds(170, 415, 150, 30);
        num100.addActionListener(this);
        image.add(num100);
        
        num500 = new JButton("500");
        num500.setBounds(355, 415, 150, 30);
        num500.addActionListener(this);
        image.add(num500);
        
        
        num1000 = new JButton("1000");
        num1000.setBounds(170, 450, 150, 30);
        num1000.addActionListener(this);
        image.add(num1000);
        
       num2000 = new JButton("2000");
        num2000.setBounds(355, 450, 150, 30);
        num2000.addActionListener(this);
        image.add(num2000);
        
        
        num5000 = new JButton("5000");
        num5000.setBounds(170, 485, 150, 30);
        num5000.addActionListener(this);
        image.add(num5000);
        
        num10000 = new JButton("10000");
        num10000.setBounds(355, 485, 150, 30);
        num10000.addActionListener(this);
        image.add(num10000);
        
        
        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        
        
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == back)
        {
           setVisible(false);
           new Transactions(pinNumber).setVisible(true);
        }
        else 
        {
            String amountNumber = ((JButton)ae.getSource()).getText();
            
            Conn conn  = new Conn();
            
            try
            {
                ResultSet rs = conn.s.executeQuery("Select * from bank Where pinNumber = '"+pinNumber+"'");
                
                int balance = 0 ;
                
                while(rs.next())
                {
                   if(rs.getString("type").equals("Deposit"))
                   {
                       balance = balance + Integer.parseInt(rs.getString("amount"));
                   }
                   else
                   {
                       balance = balance - Integer.parseInt(rs.getString("amount"));
                  
                   }
                }
                //validation for amount and exit button
                
                if(ae.getSource() != back && Integer.parseInt(amountNumber) > balance )
                {
                    JOptionPane.showMessageDialog(null, "Insuffient Balance");
                    setVisible(false);
                    new Login().setVisible(true);
                }
                else
                {
                    Date date = new Date();
                    
                    String query = "insert into bank values ('"+pinNumber+"', '"+date+"' , 'Withdrawl' , '"+amountNumber+"')";
                    
                    conn.s.executeUpdate(query);
                    
                    JOptionPane.showMessageDialog(null, "Rs. "+amountNumber+" Debited SuccessFully ");
                    
                    setVisible(false);
                    
                    new Login().setVisible(true);
                }
                
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
            
        }
        
        
    }
    
    
    
    public static void main(String[] args) 
    {
        new FastCash(null);
    }
    
}
