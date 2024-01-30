import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class NewAccountPage extends MainJFrame{
	
	public JFrame getbuild() {
		JLabel create = new JLabel();
		create.setText("Create Account Here");
		create.setBounds((super.getWidth() - 340) / 2, 10, 400, 100);
		create.setFont(new Font("Impact", Font.PLAIN, 40));
		
		//Caps Lock
		JLabel capslock = new JLabel();
		//loginerror.setForeground(grey);
		capslock.setFont(new Font("Impact", Font.PLAIN, 18));
		capslock.setForeground(Color.red);
		capslock.setText("CAPS LOCK ENABLED");
		capslock.setVisible(false);
		capslock.setBounds((super.getWidth() - 490),390,300,300);
		
		
		JTextField EnterUsername = new JTextField();
		JLabel usernamelabel = new JLabel();
		EnterUsername.setBounds(350, 170, 200, 30);
		usernamelabel.setBounds(190, 70, 200, 230);
		usernamelabel.setFont(new Font("Impact", Font.PLAIN, 20));
		usernamelabel.setText("Create Username: ");
		EnterUsername.setText("username");
		
		EnterUsername.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_CAPS_LOCK) {
					CapsLock(capslock);
				}
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		EnterUsername.addFocusListener(new FocusListener(){
			boolean existingtext = false;
			@Override
			public void focusGained(FocusEvent e) {
				CapsLock(capslock);
			 if(!existingtext){
				 EnterUsername.setText("");
				}
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				CapsLock(capslock);

				if(!EnterUsername.getText().equals("")) {
					existingtext = true;
				}else {
					EnterUsername.setText("Enter username:");
					existingtext = false;
				}
				
			}
			
		});
	
		
		//Password
		JPasswordField password = new JPasswordField();
		JLabel passwordlabel = new JLabel();
		password.setBounds(350, 240, 200, 30);
		passwordlabel.setBounds(190, 140, 200, 230);
		passwordlabel.setFont(new Font("Impact", Font.PLAIN, 20));
		passwordlabel.setText("Create Password: ");
		password.setEchoChar((char) '*');
		
		
		password.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_CAPS_LOCK) {
					CapsLock(capslock);
				}
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		//Confirm Password
		JPasswordField confirmpassword = new JPasswordField();
		JLabel confirmpasswordlabel = new JLabel();
		confirmpassword.setBounds(350, 310, 200, 30);
		confirmpasswordlabel.setBounds(190, 210, 200, 230);
		confirmpasswordlabel.setFont(new Font("Impact", Font.PLAIN, 20));
		confirmpasswordlabel.setText("Confirm Password: ");
		
		//Invalid
		JLabel loginerror = new JLabel();
		//loginerror.setForeground(grey);
		loginerror.setFont(new Font("Impact", Font.PLAIN, 40));
		loginerror.setForeground(Color.red);
		loginerror.setText("INVALID ACCOUNT");
		loginerror.setVisible(false);
		loginerror.setBounds((super.getWidth() - 500),350,300,300);
		

		

		
		//Finished
		JButton finishedbutton = new JButton();
		finishedbutton.setBounds((super.getWidth() - 170) / 2, 400, 170, 30);
		finishedbutton.setText("Finished");
		
		//Exit
		JButton exitbutton = new JButton();
		exitbutton.setBounds((super.getWidth() - 170) / 2, 450, 170, 30);
		exitbutton.setText("EXIT");
		
		//Toggle password
		JCheckBox Hidepassword = new JCheckBox();
		Hidepassword.setBounds(630, 140, 200, 230);
		Hidepassword.setText("Show password");
		
		
		Hidepassword.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					password.setEchoChar((char) 0);
				}else {
					password.setEchoChar((char) '*');
				}
				
			}
			
		});
		
		//Frame
		JFrame frame = new JFrame();
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle(super.getTitle());
		frame.setVisible(true);
		frame.setSize(super.getWidth(),super.getHeight());
		frame.setLocationRelativeTo(null);
		frame.add(EnterUsername);
		frame.add(password);
		frame.add(usernamelabel);
		frame.add(passwordlabel);
		frame.add(Hidepassword);
		frame.add(confirmpassword);
		frame.add(finishedbutton);
		frame.add(confirmpasswordlabel);
		frame.add(create);
		frame.add(capslock);
		frame.add(exitbutton);
		frame.add(loginerror);
		
		
		exitbutton.addActionListener(new ActionListener(){
			Page1 page1 = new Page1();
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame newframe = page1.getbuild();
				frame.dispose();
			}
		
			
		});
		
		
		finishedbutton.addActionListener(new ActionListener(){
			MainJFrame mainjframe = new MainJFrame();
			Page1 page1 = new Page1();
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					if(exists(EnterUsername.getText(), password.getText()) || EnterUsername.getText().contains(" ")|| password.getText().contains(" ")) {
						loginerror.setText("INVALID");
						loginerror.setBounds((frame.getWidth() - 500),350,300,300); //
						loginerror.setVisible(true);
						mainjframe.ClosePopup(loginerror);
					}else if(!confirmpassword.getText().equals(password.getText())) {
						loginerror.setBounds((frame.getWidth() - 650),350,500,300);
						loginerror.setText("PASSWORDS DONT MATCH");
						loginerror.setVisible(true);
						mainjframe.ClosePopup(loginerror);
					}else if(EnterUsername.getText().equals("")|| password.getText().equals("")) {
						loginerror.setText("INVALID");
						loginerror.setBounds((frame.getWidth() - 500),350,300,300); 
						loginerror.setVisible(true);
					}else if(!exists(EnterUsername.getText(), password.getText()) && confirmpassword.getText().equals(password.getText())) {
						String details = EnterUsername.getText() + "\t" + password.getText();
						
						String userhome = System.getProperty("user.home");
						String folderpath = userhome;
						
			        try (FileWriter fileWriter = new FileWriter(folderpath+"\\DataFolder\\DataFile.txt", true);	//Makes a filewriter
			                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {	//Writes the file
			               bufferedWriter.write("\n"+details);;
			               bufferedWriter.close();			  
			               frame.dispose();
			               mainjframe.sort();
			               JFrame newpage = page1.getbuild();
			             
			           } catch (IOException e4) {
			        	   
			           }
					}
				}catch(IOException e4) {
					
				}
			}
		});
		
		return frame;
	}
	
	public boolean exists(String username, String password) throws IOException {
			try {
				String userhome = System.getProperty("user.home");
				String folderpath = userhome;
				BufferedReader reader = new BufferedReader(new FileReader(folderpath+"\\DataFolder\\Datafile.txt"));
				String line;
				while((line = reader.readLine()) != null) {
					String details = username + "\t" + password;
					if(details.equals(line)) {
						return true;
					}
				}
				reader.close();
			} catch (FileNotFoundException e) {
				
			}
			String line;
			
		
		return false;
	}
	
	public void CapsLock(Component j) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        if (Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK)) {
            	j.setVisible(true);
        } else {
        	j.setVisible(false);
        }

	}
	
}
