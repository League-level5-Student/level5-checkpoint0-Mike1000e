import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CheckpointMod0 implements ActionListener {
	
	

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton save = new JButton();
	JButton load = new JButton();
	JTextArea text = new JTextArea();
	
	CheckpointMod0(){
		panel.setPreferredSize(new Dimension(1500,1000));
		frame.setSize(1500,1000);
		text.setPreferredSize(new Dimension(750,1000));
		save.setLabel("save");
		load.setLabel("load");
		save.addActionListener(this);
		load.addActionListener(this);
		
		
		
		panel.add(save);
		panel.add(load);
		panel.add(text);
		frame.add(panel);
		
		save.setLocation(1250, 500);
		
		frame.pack();
	}
	
	void start() {
		frame.setVisible(true);
		
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(save)) {
			try {
				FileWriter fw = new FileWriter("C:\\Users\\mikel\\level5-checkpoint0-Mike1000e\\src\\saved", true);
				
				/*
				NOTE: To append to a file that already exists, add true as a second parameter when calling the
				      FileWriter constructor.
				      (e.g. FileWriter fw = new FileWriter("src/_00_Intro_To_File_Input_and_Output/test2.txt", true);)
				*/
				
				fw.write(text.getText());
					
				fw.close();
			} catch (IOException f) {
				f.printStackTrace();
			}
		}else if(e.getSource().equals(load)) {
			String loaded = "";
			try {
				FileReader fr = new FileReader("C:\\Users\\mikel\\level5-checkpoint0-Mike1000e\\src\\saved");
				int c = fr.read();
				while(c != -1){
					loaded = loaded + (char)c;
					System.out.print((char)c);
					
					c = fr.read();
				}
				fr.close();
			} catch (FileNotFoundException g) {
				g.printStackTrace();
			} catch (IOException g) {
				g.printStackTrace();
			}
		}
		
	}
		
}
