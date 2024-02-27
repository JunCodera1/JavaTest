package Lambda;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MyFrame extends JFrame{
	
	JButton myButton = new JButton("MY BUTTON");
	
	MyFrame(){
		
		myButton.setBounds(100,100,200,100);
		myButton.addActionListener((e)->System.out.println("Tin dep trai"));
		
		this.add(myButton);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(420, 420);
		this.setLayout(null);
		this.setVisible(true);
	}
}
