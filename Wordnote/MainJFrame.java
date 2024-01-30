import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.*;

public class MainJFrame {
		public final int width = 840;
		public final int height = 600;
		private final String title = "Wordnote";
		private static String username;
		private static String folderpath;
		File textfile;
		
		public String getTitle() {
			return title;
		}
		
		public void loadData() {
			String userhome = System.getProperty("user.home");
			String folderpath = userhome;
			File folder = new File(folderpath, "DataFolder");
			textfile = new File(folderpath+"\\DataFolder", "Datafile.txt");
			
			  if(!folder.exists()) {
				  
				  if(folder.mkdir()) {
					  System.out.println("Made");
				  }else {
					  System.out.println("NOT");
				  }  
			  }
			  
			  
			  if(!textfile.exists()) {
			        try (FileWriter fileWriter = new FileWriter(textfile, true);	//Makes a filewriter
			                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {	//Writes the file
			               bufferedWriter.write("USERNAME" + "\t" + "PASSWORD");

			           } catch (IOException e4) {
			        	   
			           }
			  }else if(textfile.exists()) {
				  
			  }

			  
		}
		
		public int getWidth() {
			return width;
		}
		
		public int getHeight() {
			return height;
		}
		
		public void ClosePopup(Component j) {
			
			
			Timer timer = new Timer(2000, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					j.setVisible(false);
				}
				
			});
			timer.setRepeats(false);
			timer.start();
		}
		
		public JFrame returnframe(JFrame frame) {
			
			return frame;
		}
		
		public void setUsername(String s) {
			username = s;
		}
		
		public String getUsername() {
			return username;
		}
		
		public void setPath(String p) {
			folderpath = p;
		}
	
		public String getPath() {
			return folderpath;
		}
		
		public File getFile() {
			return textfile;
		}
		
		public void sort() {
			try {
				String userhome = System.getProperty("user.home");
				String folderpath = userhome;
				BufferedReader reader = new BufferedReader(new FileReader(folderpath+"\\DataFolder\\Datafile.txt"));
				BufferedReader reader2 = new BufferedReader(new FileReader(folderpath+"\\DataFolder\\Datafile.txt"));
				int size = 0;
				String line;
				
				while((line = reader.readLine()) != null) {
					size++;
				}
				reader.close();
				
				String[] array = new String[size];
				int i = 0;
				while((line = reader2.readLine()) != null) {
					array[i] = line;
					i++;
				}
				
				
				for(int x = 1; x < size; x++) {
					for(int y = 1; y < size-1; y++) {
						String temp = array[y];
						
							
						if(line == null) {
							y++;
						}else if((int)array[y].charAt(0) > (int)array[y+1].charAt(0)) {
							array[y] = array[y+1];
							array[y + 1] = temp;
						}else if((int)array[y].charAt(0) == (int)array[y+1].charAt(0)) {
							if(array[y].compareTo(array[y+1]) > 0) {
								array[y] = array[y+1];
								array[y + 1] = temp;
							}
						}
					}
				}
				
				BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(folderpath+"\\DataFolder\\Datafile.txt"));
				
				for(String s: array) {
					bufferedWriter.write(s);
					bufferedWriter.write("\n");
				}
				bufferedWriter.close();
				
				
			} catch (IOException e) {
				
			}
		}
	
}
