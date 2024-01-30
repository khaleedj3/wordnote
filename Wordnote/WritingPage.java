
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
public class WritingPage extends MainJFrame{
	MainJFrame mainjframe = new MainJFrame();
	public JFrame getbuild() {
		String font = "Arial";
		String color = "black";
		int size = 20;
		String selectedfont = "";
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(500,500));
		panel.setForeground(Color.red);
		panel.setVisible(true);
		
		String[] colors = {"Black", "Red", "Green", "Blue", "Pink"}; 
		JComboBox colorsbox = new JComboBox(colors);
		colorsbox.setPreferredSize(new Dimension(100,30));
		colorsbox.setVisible(true);
		
		String[] AvaliableFonts = {"Arial", "Impact", "Calibri", "Verdana", "Times New Roman", "Tahoma"}; 
		JComboBox fontbox = new JComboBox(AvaliableFonts);
		fontbox.setPreferredSize(new Dimension(100,30));
		fontbox.setVisible(true);
		
		String[] projects = {"Project 1", "Project 2", "Project 3", "Project 4", "Project 5"};
		JComboBox projectbox = new JComboBox(projects);
		projectbox.setPreferredSize(new Dimension(100,30));
		
		
		
		JCheckBox bold = new JCheckBox();
		bold.setPreferredSize(new Dimension(70,50));
		bold.setText("Bold");
		
		JButton savebutton = new JButton();
		savebutton.setPreferredSize(new Dimension(100,25));
		savebutton.setText("SAVE");
		
		JButton loadbutton = new JButton();
		loadbutton.setPreferredSize(new Dimension(100,25));
		loadbutton.setText("LOAD");
		
		JButton exitbutton = new JButton();
		exitbutton.setPreferredSize(new Dimension(100,25));
		exitbutton.setText("EXIT");
		
		
		JCheckBox italic = new JCheckBox();
		italic.setPreferredSize(new Dimension(70,50));
		italic.setText("Italic");
		
		JTextArea textfield = new JTextArea();
		textfield.setFont(new Font("Arial", Font.PLAIN, size));
		textfield.setLineWrap(true);
		textfield.setWrapStyleWord(true);
		JScrollPane scrollPane = new JScrollPane(textfield);
		scrollPane.setPreferredSize(new Dimension(810,400));
		
		JLabel error = new JLabel();
		error.setFont(new Font("Impact", Font.PLAIN, 40));
		error.setForeground(Color.red);
		error.setText("NO PROJECT SAVE");
		error.setVisible(false);
		error.getBaseline(width, height);
		
		fontbox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					String selectedfont = (String) fontbox.getSelectedItem();
					Font newfont = new Font(selectedfont, Font.PLAIN, size);
					textfield.setFont(newfont);
				}
				
			}
			
		});
		
		colorsbox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					String selectedcolor = (String) colorsbox.getSelectedItem();
					if(selectedcolor.equalsIgnoreCase("red")) {
						textfield.setForeground(Color.red);
					}else if(selectedcolor.equalsIgnoreCase("black")) {
						textfield.setForeground(Color.black);
					}else if(selectedcolor.equalsIgnoreCase("green")) {
						textfield.setForeground(Color.green);
					}else if(selectedcolor.equalsIgnoreCase("blue")) {
						textfield.setForeground(Color.blue);
					}else if(selectedcolor.equalsIgnoreCase("pink")) {
						textfield.setForeground(Color.pink);
					}
				}
				
			}
		});
		
		bold.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(bold.isSelected()) {
					String selectedfont = (String) fontbox.getSelectedItem();
					Font newfont = new Font(selectedfont, Font.BOLD, size);
					textfield.setFont(newfont);
					italic.setEnabled(false);
				}else {
					Font newfont = new Font(selectedfont, Font.PLAIN, size);
					textfield.setFont(newfont);
					italic.setEnabled(true);
				}
				
			}
			
			
		});
		
		italic.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(italic.isSelected()) {
					String selectedfont = (String) fontbox.getSelectedItem();
					Font newfont = new Font(selectedfont, Font.ITALIC, size);
					textfield.setFont(newfont);
					bold.setEnabled(false);
				}else {
					Font newfont = new Font(selectedfont, Font.PLAIN, size);
					textfield.setFont(newfont);
					bold.setEnabled(true);
				}
				
			}
			
			
		});
		

		
		savebutton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String projectselected = mainjframe.getUsername()+(String) projectbox.getSelectedItem()+".txt";
				String projectselectedattri = mainjframe.getUsername()+(String) projectbox.getSelectedItem()+"attributes.txt";
				String foldername = mainjframe.getUsername()+(String) projectbox.getSelectedItem()+"datafolder";
				
				String userhome = System.getProperty("user.home");	//Gets a path guareented on every PC
				String folderpath = userhome;
				
				File folder = new File(folderpath+"\\DataFolder", foldername);	//Makes folder in that path
				  
				  if(!folder.exists()) {
					  if(folder.mkdir()) {
						  System.out.println("SAVED");
					  }else {
						  System.out.println("NOT SAVED");
					  }
					  
				  }
				
				
			       File textfile = new File(folderpath+"\\DataFolder"+"\\"+foldername, projectselected);	//Creates a file and takes the folderpath
			       File attributefile = new File(folderpath+"\\DataFolder"+"\\"+foldername, projectselectedattri); 

			        try (FileWriter fileWriter = new FileWriter(textfile);	//Makes a filewriter
			                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {	//Writes the file
			               
					       
					       if(!textfield.getText().equalsIgnoreCase("")){
					    	   bufferedWriter.write(textfield.getText());
					       }else {
					    	   error.setText("PROJCET IS EMPTY");
					    	   error.setVisible(true);
					    	   mainjframe.ClosePopup(error);
					       }
			           } catch (IOException e4) {
			        	   
			           }
			  
			
	        try (FileWriter fileWriter = new FileWriter(attributefile);
	                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
	               bufferedWriter.write(font);
	               bufferedWriter.write("\n"+(String) colorsbox.getSelectedItem());
	               
	           } catch (IOException e4) {

	           }
	       }
				
			
			
		});
		
		loadbutton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String userhome = System.getProperty("user.home");
					String folderpath = userhome;
					String projectselected = mainjframe.getUsername()+(String) projectbox.getSelectedItem()+".txt";
					String projectselectedattri = mainjframe.getUsername()+(String) projectbox.getSelectedItem()+"attributes.txt";
					String foldername = mainjframe.getUsername()+(String) projectbox.getSelectedItem()+"datafolder";
					
				    File textfile = new File(folderpath+"\\DataFolder"+"\\"+foldername, projectselected);	//Creates a file and takes the folderpath
				    File attributefile = new File(folderpath+"\\DataFolder"+"\\"+foldername, projectselectedattri); 
					BufferedReader reader = new BufferedReader(new FileReader(folderpath+"\\DataFolder\\"+foldername+"\\"+projectselected));
					BufferedReader reader2 = new BufferedReader(new FileReader(folderpath+"\\DataFolder\\"+foldername+"\\"+projectselectedattri));

					String line;
					String atributecolor = "";
					String atributefont = "";
					
					while((line = reader.readLine()) != null) {
						System.out.println("LOAD");
						textfield.setText(line);
					}
					
					for(int i = 0; i < 2; i++) {
						line = reader2.readLine();
						if(i == 0) {
							 atributefont = line;
						}else if(i == 1) {
							 atributecolor = line;
						}
						
					}
					
					
					if(atributecolor.equalsIgnoreCase("red")) {
						textfield.setForeground(Color.red);
					}else if(atributecolor.equalsIgnoreCase("black")) {
						textfield.setForeground(Color.black);
					}else if(atributecolor.equalsIgnoreCase("green")) {
						textfield.setForeground(Color.green);
					}else if(atributecolor.equalsIgnoreCase("blue")) {
						textfield.setForeground(Color.blue);
					}else if(atributecolor.equalsIgnoreCase("pink")) {
						textfield.setForeground(Color.pink);
					}
					
					Font newfont = new Font(atributefont, Font.PLAIN, size);
					textfield.setFont(newfont);
					
					
					reader.close();
				} catch (IOException e4) {
					error.setText("PROJECT DOESNT EXIST");
					error.setVisible(true);
					mainjframe.ClosePopup(error);
					System.out.println("File doesnt exist");
				}
			}
		});
		
		
		JFrame frame = new JFrame();
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle(super.getUsername() + " "+"notes");
		frame.setVisible(true);
		frame.setSize(super.getWidth(),super.getHeight());
		frame.setLocationRelativeTo(null);
		frame.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		exitbutton.addActionListener(new ActionListener() {
			Page1 page1 = new Page1();
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame newframe = page1.getbuild();
				frame.dispose();
			}
		});
		
		frame.add(colorsbox);
		frame.add(fontbox);
		frame.add(projectbox);
		frame.add(bold);
		frame.add(italic);
		frame.add(savebutton);
		frame.add(loadbutton);
		frame.add(exitbutton);
		frame.add(scrollPane);
		frame.add(error);
		return frame;
	}
	
}
