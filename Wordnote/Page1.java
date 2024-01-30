import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class Page1 extends MainJFrame{
	public boolean finished = false;
	MainJFrame mainjframe = new MainJFrame();
	public JFrame getbuild() {
		//WordNote
		
		JLabel wordnotelabel1 = new JLabel();
		wordnotelabel1.setText(super.getTitle());
		wordnotelabel1.setFont(new Font("Impact", Font.PLAIN, 40));
		wordnotelabel1.setBounds((super.getWidth() - 200) / 2, -20, 170, 110);
		
		//Powered by eclipse
        ImageIcon imagepath = new ImageIcon("C:\\Users\\khale\\OneDrive\\Desktop\\imageedit_2_4816871736.png"); 
		JLabel wordnotelabel2 = new JLabel();
		
		wordnotelabel2.setForeground(Color.gray);
		wordnotelabel2.setText("powered by eclipse");
		wordnotelabel2.setHorizontalAlignment(SwingConstants.RIGHT);
		wordnotelabel2.setFont(new Font("Impact", Font.PLAIN, 20));
		wordnotelabel2.setBounds((super.getWidth() - 200) / 2, (40), 220, 50);
		wordnotelabel2.setIcon(imagepath);
		wordnotelabel2.setIconTextGap(-215);
		
		//Username

		JTextField username = new JTextField();
		JLabel usernamelabel = new JLabel();
		username.setBounds(350, 170, 200, 30);
		usernamelabel.setBounds(250, 70, 200, 230);
		usernamelabel.setFont(new Font("Impact", Font.PLAIN, 20));
		usernamelabel.setText("Username: ");
		username.setText("Enter Username");
		
		username.addFocusListener(new FocusListener(){
			boolean existingtext = false;
			@Override
			public void focusGained(FocusEvent e) {
				
			 if(!existingtext){
					username.setText("");
			}
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(!username.getText().equals("")) {
					existingtext = true;
				}else {
					username.setText("Enter username:");
					existingtext = false;
				}
				
			}
			
		});
	
		
		//Password
		JPasswordField password = new JPasswordField();
		JLabel passwordlabel = new JLabel();
		password.setBounds(350, 240, 200, 30);
		passwordlabel.setBounds(250, 140, 200, 230);
		passwordlabel.setFont(new Font("Impact", Font.PLAIN, 20));
		passwordlabel.setText("Password: ");
		password.setEchoChar((char) '*');
		
		//Password Toggle
		JCheckBox Hidepassword = new JCheckBox();
		Hidepassword.setBounds((super.getWidth()-100) / 2, 450, 170, 30);
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
		
		//Login Button
		JButton login = new JButton();
		JLabel loginerror = new JLabel();
		loginerror.setForeground(Color.gray);
		loginerror.setFont(new Font("Impact", Font.PLAIN, 40));
		loginerror.setText("INVALID ACCOUNT");
		loginerror.setVisible(false);
		loginerror.setBounds((super.getWidth() - 550),350,300,300);
		login.setBounds(350, 290, 150, 40);
		loginerror.setForeground(Color.red);
		login.setText("Login");
		
		
		
		
		//Create Button
		JButton create = new JButton();
		create.setBounds(350, 350, 150, 40);
		create.setText("Create new account");

		
		
		
		JFrame frame = new JFrame();
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle(super.getTitle());
		frame.setVisible(true);
		frame.setSize(super.getWidth(),super.getHeight());
		frame.setLocationRelativeTo(null);
		frame.add(wordnotelabel1);
		frame.add(wordnotelabel2);
		frame.add(username);
		frame.add(password);
		frame.add(usernamelabel);
		frame.add(passwordlabel);
		frame.add(login);
		frame.add(create);
		frame.add(Hidepassword);
		frame.add(loginerror);
		frame.setResizable(false);	
		
		
		
		
		create.addActionListener(new ActionListener() {
			NewAccountPage newaccountpage = new NewAccountPage();
			
			@Override
			public void actionPerformed(ActionEvent e) {

					frame.dispose();
					JFrame newpage = newaccountpage.getbuild();		

			}
	
		});
		
		login.addActionListener(new ActionListener() {
			WritingPage writing = new WritingPage();
			
			
			@Override
			//Reads file
			public void actionPerformed(ActionEvent e) {

				try {
					String userhome = System.getProperty("user.home");
					String folderpath = userhome;
					BufferedReader reader = new BufferedReader(new FileReader(folderpath+"\\DataFolder\\Datafile.txt"));
					String line;
					String details = username.getText() + "\t" + password.getText();
					
					try {
						while((line = reader.readLine()) != null) {	//Checks all lines in file til line == null
							if(details.equals(line)) {
								frame.dispose();
								mainjframe.setUsername(username.getText());
								JFrame newpage = writing.getbuild();
							}else {
								loginerror.setVisible(true);
								mainjframe.ClosePopup(loginerror);
							}
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
				}catch(FileNotFoundException e2) {
					
				}
				

			}
	
		});
		
		return frame;

	}
}
