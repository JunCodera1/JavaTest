package IOStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class IOStream{
	public static void main(String[] args) {
		// Tạo mới file
        String fileName = "input.txt";
        createFile(fileName);

        // Ghi dữ liệu vào file
        String data = "Đây là nội dung của file.";
        writeFile(fileName, data);

        // Đọc file
        String fileContent = readFile(fileName);
        System.out.println("Nội dung của file:");
        System.out.println(fileContent);

        // Lấy đường dẫn file
        String filePath = getFilePath(fileName);
        System.out.println("Đường dẫn của file:");
        System.out.println(filePath);

        // Xóa file
       // deleteFile(fileName);

        // Tạo thư mục
        String directoryName = "java";
        createDirectory(directoryName);
	}
	// Tạo File
	public static void createFile(String fileName){
		try {
			File file = new File(fileName);
			 
            if (file.createNewFile()) {
                System.out.println("File is created!");
            } else {
                System.out.println("File already exists.");
            }
		}catch(IOException e) {
			System.out.println("Create Failed!");
		}
	}
	
	//Viết File
	public static void writeFile(String fileName, String data) {
		
		try {
			FileWriter writer = new FileWriter(fileName);
			writer.write(data);
			writer.close();
			System.out.println("The data has been written to the file!");
		}catch(IOException e) {
			System.out.println("Write failed!");
		}
		
	}
	
	//Đọc File
	public static String readFile(String fileName) {
		
		StringBuilder content = new StringBuilder();
		try {
			FileReader reader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line;
			while((line = bufferedReader.readLine()) != null) {
				content.append(line).append("\n");
			}
		}catch(IOException e) {
			System.out.println("Read Failed!");
		}
		return content.toString();
	}
	
	//Lấy đường dẫn file
	public static String getFilePath(String fileName) {
		File file = new File(fileName);
		return file.getAbsolutePath();
	}
	
	//Xóa file
	public static void deleteFile(String fileName) {
		File file = new File(fileName);
		if(file.delete()) {
			System.out.println("File has been deleted !");
		}
		else {
			System.out.println("Cannot delete file!");
		}
	}
	
	//Tạo thư mục
	public static void createDirectory(String directoryName) {
		File directory = new File(directoryName);
		if(directory.mkdir()) {
			System.out.println("Folder has been created!");
		}
		else {
			System.out.println("Cannot created Directory!");
		}
	}
}