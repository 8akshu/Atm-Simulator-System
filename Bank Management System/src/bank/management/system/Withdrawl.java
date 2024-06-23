
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;



public class Withdrawl extends JFrame implements ActionListener
{
    String pinNumber;
    JTextField amount;
    JButton withdrawl ,back;
    
    
    public Withdrawl(String pinNumber)
    {
        this.pinNumber = pinNumber;
        
        setLayout(null);
        
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(0,0,900,900);
       add(image);
       
       
       JLabel text = new JLabel("Enter Amount You want To Withdrawl");
       text.setForeground(Color.WHITE);
       text.setFont(new Font("System", Font.BOLD, 16));
       text.setBounds(170, 300, 400, 20);
       image.add(text);
       
       amount = new JTextField();
       amount.setFont(new Font("Raleway",Font.BOLD,22));
       amount.setBounds(170,350,300,25);
       image.add(amount);
       
      withdrawl = new JButton("Withdraw");
      withdrawl.setBounds(355, 485, 150, 30);
      withdrawl.addActionListener(this);
      image.add(withdrawl);
      
      back = new JButton("BACK");
      back.setBounds(355, 520, 150, 30);
      back.addActionListener(this);
      image.add(back);
       
        
        setSize(900,900);
        setLocation(300, 0);
        setVisible(true);
         
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == withdrawl)
        {
            String amountNumber = amount.getText();
            Date date = new Date();
            if(amountNumber.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Enter The Amount You Want To Withdraw");
            }
            else
            {
                try
                {
                    Conn conn  = new Conn();
                    
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

                   if(ae.getSource() != back && Integer.parseInt(amountNumber) > balance)
                   {
                      JOptionPane.showMessageDialog(null, "You Cancelled Transaction");
                       setVisible(false);
                       new Login().setVisible(true);
                    }
        
                   else
                   {
                        String query = "insert into Bank values('"+pinNumber+"','"+date+"','Withdrawl','"+amountNumber+"')";
                        conn.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null,"RS. "+amountNumber+" Debited Successfully"); 
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
        else if(ae.getSource() == back)
        {
            new Transactions(pinNumber).setVisible(true);
        }
    }
    
    
    public static void main(String[] args) 
    {
        new Withdrawl(null);
    }
    
}
