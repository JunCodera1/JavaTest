package Lambda;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MyFrame extends JFrame{
	
	JButton myButton = new JButton("MY BUTTON");
	JButton myButton2 = new JButton("MY BUTTON 2");
	
	MyFrame(){
		
		myButton.setBounds(100,100,200,100);
		myButton.addActionListener((e)->System.out.println("Tin dep trai"));
		myButton2.setBounds(100,200,200,100);
		myButton2.addActionListener((e)->System.out.println("Tin dep trai 2"));
		
		this.add(myButton2);
		this.add(myButton);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(420, 420);
		this.setLayout(null);
		this.setVisible(true);
	}
}
