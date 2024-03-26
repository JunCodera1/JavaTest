package JTree;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class NotepadWithJTree extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JTree tree;
    private DefaultTreeModel treeModel;

    public NotepadWithJTree() {
        setTitle("Notepad with JTree");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Text area
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // Menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openMenuItem = new JMenuItem("Open");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        openMenuItem.addActionListener(this);
        saveMenuItem.addActionListener(this);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        // Tree panel
        treeModel = new DefaultTreeModel(new DefaultMutableTreeNode("Root"));
        tree = new JTree(treeModel);
        JScrollPane treeScrollPane = new JScrollPane(tree);
        tree.setPreferredSize(new Dimension(200, getHeight()));
        add(treeScrollPane, BorderLayout.WEST);

        // Add tree selection listener
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                if (node != null && node.isLeaf()) {
                    File file = new File(getPathFromNode(node));
                    if (file.exists() && !file.isDirectory()) {
                        readFile(file);
                    }
                }
            }
        });
    }

    private String getPathFromNode(DefaultMutableTreeNode node) {
        StringBuilder path = new StringBuilder(node.getUserObject().toString());
        DefaultMutableTreeNode parent = (DefaultMutableTreeNode) node.getParent();
        while (parent != null) {
            path.insert(0, parent.getUserObject().toString() + File.separator);
            parent = (DefaultMutableTreeNode) parent.getParent();
        }
        return path.toString();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Open")) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
            fileChooser.setFileFilter(filter);

            int returnVal = fileChooser.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                if (file.isDirectory()) {
                    readFilesInDirectory(file);
                } else {
                    readFile(file);
                }
            }
        } else if (e.getActionCommand().equals("Save")) {
            JFileChooser fileChooser = new JFileChooser();
            int returnVal = fileChooser.showSaveDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                saveFile(file);
            }
        }
    }

    private void readFilesInDirectory(File directory) {
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(directory.getName());
        treeModel.setRoot(rootNode);
        readFilesRecursive(directory, rootNode);
    }

    private void readFilesRecursive(File directory, DefaultMutableTreeNode parentNode) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    DefaultMutableTreeNode node = new DefaultMutableTreeNode(file.getName());
                    parentNode.add(node);
                    readFilesRecursive(file, node);
                }
            }
        }
    }

    private void readFile(File file) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            textArea.setText(content.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveFile(File file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(textArea.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            NotepadWithJTree notepad = new NotepadWithJTree();
            notepad.setVisible(true);
        });
    }
}
