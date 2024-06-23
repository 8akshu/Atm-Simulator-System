/**
 *Bank Management System
 * (Frist Project)
 * Start date 02'nd FEB 2024
 * last modification - 7 FEb
 * completed On  7 FEB 2024 
 * @author prash
 */

package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

//jFreame For Frame Manupulation 
//ActionListener for take text input anf perform action on it
public class Login extends JFrame implements ActionListener
{
    
    //create JButtyon variable buttyon to access any where
    JButton loginButton, clearButton , signUpButton;
    JTextField cardTextField ;
    JPasswordField pinTextField;
    
    public Login()
    {       
        //set Frame Title
        setTitle("ATM");
        
        //to set default layaout to custom
        setLayout(null);
        
         //to apply or peast the icon 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        // to scale or set image 
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        //to past icon on Frame
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);
        
        //Label 1 "Wel Come To ATM"
        //to write content on frame
        JLabel text = new JLabel("Welcome to SBI ATM");
        //to set Font size and Font Family
        text.setFont(new Font("Osward", Font.BOLD, 38));
        //to add location
        text.setBounds(200, 40, 400, 40);
        add(text); 
        
        //Label 2 "Card No"
        //to write content on frame
        JLabel cardno = new JLabel("Card No:");
        //to set Font size and Font Family
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        //to add location
        cardno.setBounds(120, 150, 150, 30);
        add(cardno);
        //To Add Text Field
        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 235, 30);
        //To set Font of text in TextField 
        cardTextField.setFont(new Font("Arial", Font.BOLD, 28));
        add(cardTextField);
        
        
        //Label 3 "PIN"
        //to write content on frame
        JLabel pin = new JLabel("PIN:");
        //to set Font size and Font Family
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        //to add location
        pin.setBounds(120, 220, 250, 30);
        add(pin);
        
        //To Add Text Field
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 235, 30);
        //To set Font of text in TextField 
        pinTextField.setFont(new Font("Arial", Font.BOLD, 28));
        add(pinTextField);
        
        
        //TO create and add Buttons
        
        //1
        //SIGN-In Button
        loginButton = new JButton("SIGN IN");
        loginButton.setBounds(300, 300, 100, 30);
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);
        //to catch action performmed on Button
        loginButton.addActionListener(this);
        add(loginButton);
        //2
        //CLEAR Button
         clearButton = new JButton("CLEAR");
        clearButton.setBounds(430, 300, 100, 30);
        clearButton.setBackground(Color.BLACK);
        clearButton.setForeground(Color.WHITE);
        //to catch action performmed on Button
        clearButton.addActionListener(this);
        add(clearButton);
        //3
        //SIGN-up Button
        signUpButton = new JButton("SIGN-UP");
        signUpButton.setBounds(300, 350, 230, 30);
        signUpButton.setBackground(Color.BLACK);
        signUpButton.setForeground(Color.WHITE);
        //to catch action performmed on Button
        signUpButton.addActionListener(this);
        add(signUpButton);
        
        
        //to change the Frame-background color
        getContentPane().setBackground(Color.WHITE);
        
        
        //to create and set size of Frame
        setSize(800,480);
        //to set the Location
        setLocation(350,200);
        //To undecorate the Frame
        //setUndecorated(true);
        //to see the Frame
        setVisible(true);
        
        
    }
    
    //Overriden method from ActionListener Interface
    @Override 
    public void actionPerformed(ActionEvent ae)
    {
        //To PerformAction on text Field Based on Acton Button Click                         
        if(ae.getSource() == clearButton)
        {
            //to set value in text field
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource() == loginButton)
        {
            Conn conn = new Conn();
            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();
            
            String query = "Select * from Login where cardNumber = '"+cardNumber+"' AND pinNumber = '"+pinNumber+"' ";
            try
            {
                ResultSet rs = conn.s.executeQuery(query);
                
                if(rs.next())
                {
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid Card Number PIN Combination");
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == signUpButton)
        {
            setVisible(false);
            new SignUpOne().setVisible(true);
        }
        
    }
    public static void main(String[] args)
    {
        new Login();
           
    }
           
    
}










































