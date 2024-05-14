package Register;

import javax.swing.*;

import Register.RegistrationFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class RegistrationFrame extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RegistrationFrame() {
        setTitle("Registration");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        add(panel);

        placeComponents(panel);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);
        
     // User name
        JLabel userLabel = new JLabel("Name");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        final JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);
        
     // Date of birth
        JLabel dobLabel = new JLabel("Date of Birth");
        dobLabel.setBounds(10, 80, 80, 25);
        panel.add(dobLabel);

        final JTextField dobText = new JTextField(20);
        dobText.setBounds(100, 80, 165, 25);
        panel.add(dobText);
        
     // Email
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(10, 110, 80, 25);
        panel.add(emailLabel);

        final JTextField emailText = new JTextField(20);
        emailText.setBounds(100, 110, 165, 25);
        panel.add(emailText);
        
     // Gender
        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setBounds(10, 50, 80, 25);
        panel.add(genderLabel);

        final JRadioButton maleButton = new JRadioButton("Male");
        maleButton.setBounds(100, 50, 80, 25);
        panel.add(maleButton);

        JRadioButton femaleButton = new JRadioButton("Female");
        femaleButton.setBounds(180, 50, 80, 25);
        panel.add(femaleButton);

        final ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        
     // Province
        JLabel provinceLabel = new JLabel("Province");
        provinceLabel.setBounds(10, 140, 80, 25);
        panel.add(provinceLabel);

//        JTextField provinceText = new JTextField(20);
//        provinceText.setBounds(100, 140, 165, 25);
//        panel.add(provinceText);
       
        JComboBox<String> provinceCombo = new JComboBox<String>(new String[]{"Ha Noi", "Ho Chi Minh"});
        provinceCombo.setBounds(100, 140, 165, 25);
        panel.add(provinceCombo);
        
     // Register button
        JButton registerButton = new JButton("register");
        registerButton.setBounds(100, 200, 80, 25);
        panel.add(registerButton);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Write to file
                try (FileWriter writer = new FileWriter("dulieu.txt")) {
                    writer.write("User: " + userText.getText() + "\n");
                    writer.write("Date of Birth: " + dobText.getText() + "\n");
                    writer.write("Email: " + emailText.getText() + "\n");
                    JLabel provinceText = null;
                    writer.write("Gender: " + (maleButton.isSelected() ? "Male" : "Female") + "\n");
					writer.write("Province: " + provinceText.getText() + "\n");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
       
        // Reset button
        JButton resetButton = new JButton("reset");
        resetButton.setBounds(10, 200, 80, 25);
        panel.add(resetButton);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear all fields
                userText.setText("");
                genderGroup.clearSelection();
                dobText.setText("");
                emailText.setText("");
                JLabel provinceText = null;
				provinceText.setText("");
            }
        });
    }

    public static void main(String[] args) {
        RegistrationFrame registrationFrame = new RegistrationFrame();
    }
}

        
     