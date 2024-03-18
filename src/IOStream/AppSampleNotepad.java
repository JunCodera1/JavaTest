package IOStream;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AppSampleNotepad extends JFrame implements ActionListener {
	private JTextArea textArea;
	
	public AppSampleNotepad() {
		setTitle("Fake Notepad");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem openItem = new JMenuItem("Open");
		JMenuItem saveItem = new JMenuItem("Save");
		JMenuItem exitItem = new JMenuItem("Exit");
		
		openItem.addActionListener(this);
		saveItem.addActionListener(this);
		exitItem.addActionListener(this);
		
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.add(exitItem);
		menuBar.add(fileMenu);
		
		setJMenuBar(menuBar);
		add(scrollPane, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		switch(command) {
		case "Open":
			openFile();
			break;
		case "Save":
			saveFile();
			break;
		case "Exit":
			System.exit(0);
		}
	}
	
	private void openFile() {
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
		fileChooser.setFileFilter(filter);
		
		int returnValue = fileChooser.showOpenDialog(this);
		if(returnValue == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			try(BufferedReader reader = new BufferedReader(new FileReader(file))){
				textArea.setText("");
				String line;
				while((line = reader.readLine()) != null) {
					textArea.append(line + "\n");
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	private void saveFile() {
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files","txt");
		fileChooser.setFileFilter(filter);
		
		int returnValue = fileChooser.showOpenDialog(this);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(textArea.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			AppSampleNotepad notepad = new AppSampleNotepad();
            notepad.setVisible(true);
        });
	}
}