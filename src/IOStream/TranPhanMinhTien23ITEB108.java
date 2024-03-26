package IOStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TranPhanMinhTien23ITEB108 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        System.out.print("Nhập số lượng học viên: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
                BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {

            int option = 0;
            while (option != 5) {
                System.out.println("1. Hiển thị thông tin tất cả sinh viên.");
                System.out.println("2. Hiển thị thông tin sinh viên đậu.");
                System.out.println("3. Hiển thị thông tin sinh viên trượt.");
                System.out.println("4. Hiển thị thông tin sinh viên có điểm trên 8.");
                System.out.println("5. Thoát");
                System.out.print("Chọn chức năng muốn thực hiện: ");
                option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        System.out.println("Thông tin tất cả sinh viên:");
                        displayAllStudents(reader, writer, n);
                        break;
                    case 2:
                        System.out.println("Thông tin sinh viên đậu:");
                        displayPassedStudents(reader, writer, n);
                        break;
                    case 3:
                        System.out.println("Thông tin sinh viên trượt:");
                        displayFailedStudents(reader, writer, n);
                        break;
                    case 4:
                        System.out.println("Thông tin sinh viên có điểm trên 8:");
                        displayStudentsAboveEight(reader, writer, n);
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Chức năng không hợp lệ!");
                }
            }

            System.out.println("Ghi thông tin thành công!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void displayAllStudents(BufferedReader reader, BufferedWriter writer, int n) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(", ");
            String maSV = parts[0].split(": ")[1];
            String hoTen = parts[1].split(": ")[1];
            String gioiTinh = parts[2].split(": ")[1];
            double diemJava = Double.parseDouble(parts[3].split(": ")[1]);
            double diemPython = Double.parseDouble(parts[4].split(": ")[1]);
            double diemTrungBinh = (diemPython + diemJava * 2) / 3;
            String ketQua = diemTrungBinh >= 5 ? "Đậu" : "Trượt";

            // Ghi thông tin vào file
            writer.write("Mã SV: " + maSV + ", Họ tên: " + hoTen + ", Giới tính: " + gioiTinh
                    + ", Điểm trung bình: " + diemTrungBinh + ", Kết quả: " + ketQua + "\n");
        }
    }

    public static void displayPassedStudents(BufferedReader reader, BufferedWriter writer, int n) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(", ");
            String maSV = parts[0].split(": ")[1];
            String hoTen = parts[1].split(": ")[1];
            String gioiTinh = parts[2].split(": ")[1];
            double diemJava = Double.parseDouble(parts[3].split(": ")[1]);
            double diemPython = Double.parseDouble(parts[4].split(": ")[1]);
            double diemTrungBinh = (diemPython + diemJava * 2) / 3;

            if (diemTrungBinh >= 5) {
                // Ghi thông tin vào file
                writer.write("Mã SV: " + maSV + ", Họ tên: " + hoTen + ", Giới tính: " + gioiTinh
                        + ", Điểm trung bình: " + diemTrungBinh + ", Kết quả: Đậu\n");
            }
        }
    }

    public static void displayFailedStudents(BufferedReader reader, BufferedWriter writer, int n) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(", ");
            String maSV = parts[0].split(": ")[1];
            String hoTen = parts[1].split(": ")[1];
            String gioiTinh = parts[2].split(": ")[1];
            double diemJava = Double.parseDouble(parts[3].split(": ")[1]);
            double diemPython = Double.parseDouble(parts[4].split(": ")[1]);
            double diemTrungBinh = (diemPython + diemJava * 2) / 3;

            if (diemTrungBinh < 5) {
                // Ghi thông tin vào file
                writer.write("Mã SV: " + maSV + ", Họ tên: " + hoTen + ", Giới tính: " + gioiTinh
                        + ", Điểm trung bình: " + diemTrungBinh + ", Kết quả: Trượt\n");
            }
        }
    }

    public static void displayStudentsAboveEight(BufferedReader reader, BufferedWriter writer, int n)
            throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(", ");
            String maSV = parts[0].split(": ")[1];
            String hoTen = parts[1].split(": ")[1];
            String gioiTinh = parts[2].split(": ")[1];
            double diemJava = Double.parseDouble(parts[3].split(": ")[1]);
            double diemPython = Double.parseDouble(parts[4].split(": ")[1]);
            double diemTrungBinh = (diemPython + diemJava * 2) / 3;

            if (diemTrungBinh > 8) {
                // Ghi thông tin vào file
                writer.write("Mã SV: " + maSV + ", Họ tên: " + hoTen + ", Giới tính: " + gioiTinh
                        + ", Điểm trung bình: " + diemTrungBinh + ", Kết quả: Đậu\n");
            }
        }
    }
}
