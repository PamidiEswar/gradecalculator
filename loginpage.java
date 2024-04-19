package studentmanagementsystem;

import javax.swing.*;



import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class loginpage extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField usernameField;
    private JPasswordField passwordField;

    public loginpage() {
        super("Login Page");
        setSize(639, 433);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set layout to absolute layout
        getContentPane().setLayout(null);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        usernameLabel.setBounds(50, 131, 139, 25);
        getContentPane().add(usernameLabel);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        passwordLabel.setBounds(50, 189, 139, 25);
        getContentPane().add(passwordLabel);

        usernameField = new JTextField(20);
        usernameField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        usernameField.setBounds(232, 131, 200, 25);
        getContentPane().add(usernameField);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(232, 189, 200, 25);
        getContentPane().add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        loginButton.setBounds(70, 269, 100, 25);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/login_demo",
                        "root", "Eswar@0607");

                    PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("Select name, password from student2 where name=? and password=?");

                    st.setString(1, username);
                    st.setString(2, password);
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        dispose();
                        
                        
                        JOptionPane.showMessageDialog(loginButton, "You have successfully logged in");
                        JFrame jFrame = new JFrame();
        				jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        				adminpage adminpage=new adminpage();
        				adminpage.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(loginButton, "Wrong Username & Password");
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });
        getContentPane().add(loginButton);

        JButton signupButton = new JButton("Sign Up");
        signupButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        signupButton.setBounds(240, 269, 100, 25);
        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open signup page or perform other actions
            }
        });
        getContentPane().add(signupButton);

        JButton adminButton = new JButton("Admin");
        adminButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        adminButton.setBounds(419, 269, 100, 25);
        adminButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open admin page or perform other actions
            }
        });
        getContentPane().add(adminButton);

        setVisible(true);
    }

    @SuppressWarnings("unused")
	private boolean authenticate(String username, String password) {
        // Implement authentication logic using JDBC to query the database
        // Return true if authentication is successful, false otherwise
        return false;
    }

    public static void main(String[] args) {
        new loginpage();
    }
}
