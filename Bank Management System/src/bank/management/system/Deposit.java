
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;



public class Deposit extends JFrame implements ActionListener
{
    String pinNumber;
    JTextField amount;
    JButton deposit ,back;
    
    
    public Deposit(String pinNumber)
    {
        this.pinNumber = pinNumber;
        
        setLayout(null);
        
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(0,0,900,900);
       add(image);
       
       
       JLabel text = new JLabel("Enter Amount You want To Deposit");
       text.setForeground(Color.WHITE);
       text.setFont(new Font("System", Font.BOLD, 16));
       text.setBounds(170, 300, 400, 20);
       image.add(text);
       
       amount = new JTextField();
       amount.setFont(new Font("Raleway",Font.BOLD,22));
       amount.setBounds(170,350,300,25);
       image.add(amount);
       
      deposit = new JButton("Deposit");
      deposit.setBounds(355, 485, 150, 30);
      deposit.addActionListener(this);
      image.add(deposit);
      
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
        if(ae.getSource() == deposit)
        {
            String amountNumber = amount.getText();
            Date date = new Date();
            if(amountNumber.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Enter The Amount You Want To Deposit");
            }
            else
            {
                try
                {
                    Conn conn  = new Conn();
                    String query = "insert into Bank values('"+pinNumber+"','"+date+"','Deposit','"+amountNumber+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"RS. "+amountNumber+" Deposited Successfully"); 
                    setVisible(false);
                    new Login().setVisible(true);
                    
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
        new Deposit(null);
    }
    
}
