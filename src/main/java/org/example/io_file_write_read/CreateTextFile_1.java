package org.example.io_file_write_read;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class CreateTextFile_1 {

    public static void main(String[] args) {

//        String test = "0123ABC"; //0123ABC TEST for file!
//
//        Path path = Path.of("text.txt");
//        try {
//            Path newFile = Files.createFile(path);
//        } catch (IOException ioEx){
//            ioEx.printStackTrace(System.out);
//        }



        String test = "0123"; //TEST for file!
        File myFile111 = new File("text.txt");
        try(FileWriter fw = new FileWriter(myFile111.getName())){

                fw.write(test);

        }catch (IOException ex){
            ex.printStackTrace(System.out);
        }
        try (FileReader fr = new FileReader("text.txt")) {
            // Переменная для хранения строки
            StringBuilder sb = new StringBuilder();
            int code;
            // Читаем посимвольно пока код считанного символа не станет равным -1
            while ((code = fr.read()) != -1) {
                System.out.println("code : " + Arrays.toString(Character.toChars(code)));
                // Вызов Character.toChars() преобразует int в char
                sb.append(Character.toChars(code));
            }
            System.out.println(sb.toString());

        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }



////    Scanner scanner = new Scanner(System.in); //сканнер принимает аргументы типа InputStream.
//    InputStream inputStream = new FileInputStream(file);
//}
}