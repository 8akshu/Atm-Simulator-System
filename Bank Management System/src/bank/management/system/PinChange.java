
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener
{
    JButton back , changePin;
    JPasswordField newPin , cNewPin;
    String pinNumber ;
    
    public PinChange(String pinNumber)
    {
        this.pinNumber = pinNumber ;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(250, 280, 500, 35);
        image.add(text);
        
        JLabel pinText = new JLabel("NEW PIN");
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("System",Font.BOLD,16));
        pinText.setBounds(165, 320, 180, 25);
        image.add(pinText);
        
        newPin = new JPasswordField();
        newPin.setFont(new Font("Raleway", Font.BOLD,25));
        newPin.setBounds(330, 320, 180, 25);
        image.add(newPin);

        
        JLabel conPinText = new JLabel("Re-Enter NEW PIN");
        conPinText.setForeground(Color.WHITE);
        conPinText.setFont(new Font("System",Font.BOLD,16));
        conPinText.setBounds(165, 360, 180, 25);
        image.add(conPinText);
        
        cNewPin = new JPasswordField();
        cNewPin.setFont(new Font("Raleway", Font.BOLD,25));
        cNewPin.setBounds(330, 360, 180, 25);
        image.add(cNewPin);
        
        changePin = new JButton("CHANGE PIN");
        //changePin.setBackground(Color.BLACK);
       // changePin.setForeground(Color.WHITE);
        changePin.setBounds(355, 485, 150, 30);
        changePin.addActionListener(this);
        image.add(changePin);
        
        back = new JButton("BACK");
        //changePin.setBackground(Color.BLACK);
       // changePin.setForeground(Color.WHITE);
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
       
        
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
             
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource() == changePin) 
       {
           try
           {
                String sNewPin = newPin.getText();
                String rNewPin = cNewPin.getText();

                if(!sNewPin.equals(rNewPin))
                {
                    JOptionPane.showMessageDialog(null, "Entered PIN Does Not Match");
                    return ;
                }
                
                if(sNewPin.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please Enter New PIN");
                    return ;
                }
                if(rNewPin.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please Re-Enter New PIN");
                    return ;
                }
                
                Conn conn = new Conn(); 
                String query1 = "update bank set pinNumber = '"+rNewPin+"' where pinNumber = '"+pinNumber+"'";
                String query2 = "update login set pinNumber = '"+rNewPin+"' where pinNumber = '"+pinNumber+"'";
                String query3 = "update signupThree set pinNumber = '"+rNewPin+"' where pinNumber = '"+pinNumber+"'";
                
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "PIN CHANGED SUCESSFULLY");
                
                setVisible(false);
                new Login().setVisible(true);        
           }
           catch(Exception e)
           {
               e.printStackTrace();
           }
        }
       else
       {
           setVisible(false);
           new Transactions(pinNumber).setVisible(true);
       }       
         
    }
    
    
    public static void main(String[] args) 
    {
        new PinChange(null);
    }
    
}
