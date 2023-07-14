/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package loginwithguý;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
public class LoginWithGUI extends JFrame implements ActionListener {
    public static final int WIDTH=200;
    public static final int HEIGHT=100;
    private JTextField userName;
    private JTextField password;
    private HashMap<String,String> loginInformationTable=new HashMap<String,String>(3);
    public static void main(String[] args) {
        LoginWithGUI gui=new LoginWithGUI();
        gui.setVisible(true);
        
    }
    public LoginWithGUI(){
        super("Account Login");
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c=getContentPane();
        c.setLayout(new GridLayout(3,2));
        JLabel label1=new JLabel("User Name:");
        JLabel label2=new JLabel("Password:");
        JButton login=new JButton("Login");
        userName=new JTextField(20);
        password=new JTextField(20);
        c.add(label1);
        c.add(userName);
        c.add(label2);
        c.add(password);
        c.add(login);
        loginInformationTable.put("Joe","12345");
        loginInformationTable.put("Andy","99999");
        loginInformationTable.put("Michael","16345");
        login.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String nameInput=userName.getText();
        String pwdInput=password.getText();
        if(find(nameInput,pwdInput)){
            JOptionPane.showMessageDialog(null,"LOGIN SUCCESFULL!");
        }
        else{
            JOptionPane.showMessageDialog(null,"LOGIN NOT SUCCESFULL!");
        }

    }
    public boolean find(String userName,String password){
        
        if(!loginInformationTable.containsKey(userName)){
            return false;
        }
        String pwd=loginInformationTable.get(userName);
        if(pwd.equals(password)){
            return false;
        }
        return true;
        
    }
    
}
