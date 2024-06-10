package org.example.io_file_write_read;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile_2
{
    public static void main(String[] args) {
        copyFile("text.txt", "text_copy.txt");
    }

    private static void copyFile(String source, String target) {

        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(target)) {

            int data;
            while ((data = fis.read()) != -1) {
                System.out.println("data : " + data);
                fos.write(data);
            }

        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}