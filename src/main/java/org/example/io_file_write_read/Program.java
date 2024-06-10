package org.example.io_file_write_read;

import java.io.*;
import java.util.Arrays;

public class Program {

    public static void main(String[] args) {

        String text = "Hello world!"; // строка для записи
        try(FileOutputStream fos=new FileOutputStream("notes.txt"))
        {
            // перевод строки в байты
            byte[] buffer = text.getBytes();
            System.out.println("byte[] buffer : " + Arrays.toString(buffer));

            fos.write(buffer, 0, buffer.length);
            System.out.println("The file has been written");
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}

class Program2 {

    public static void main(String[] args) {

        String text = "Привет мир из Program2!"; // строка для записи
        try(FileOutputStream fos=new FileOutputStream("notes3.txt");
            PrintStream printStream = new PrintStream(fos))
        {
            printStream.println(text);
            System.out.println("Запись в файл произведена");
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}

class Program3 {

    public static void main(String[] args) {

        try(FileInputStream fin=new FileInputStream("notes.txt"))
        {
            byte[] buffer = new byte[2];//специально 2, чтобы размер был меньше, чем значений в файле.
            System.out.println("File data:");

            int count;
            while((count=fin.read(buffer))!=-1){
                System.out.println("count " + count);//для наглядности шагов итераций
                System.out.println("buffer " + Arrays.toString(buffer));//для наглядности шагов итераций
                for(int i=0; i<count;i++){
                    System.out.println((char)buffer[i]);
                }
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}

class Program4 {

    public static void main(String[] args) {

        try(PrintStream printStream = new PrintStream("notes4.txt"))
        {
            printStream.print("Hello World!");
            printStream.println("Welcome to Java!");

            printStream.printf("Name: %s Age: %d \n", "Tom", 34);

            String message = "PrintStream";
            byte[] message_toBytes = message.getBytes();
            printStream.write(message_toBytes);

            System.out.println("The file has been written");
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}

class Program5 {

    public static void main(String[] args) {

        byte[] array1 = new byte[]{1, 3, 5, 7};
        ByteArrayInputStream byteStream1 = new ByteArrayInputStream(array1);
        int b;
        while((b=byteStream1.read())!=-1){

            System.out.println(b);
        }

        String text = "Hello world! ";
        byte[] array2 = text.getBytes();
        System.out.println("array2 : " + Arrays.toString(array2));
        // считываем 5 символов
        ByteArrayInputStream byteStream2 = new ByteArrayInputStream(array2, 0, 5);
        int c;
        while((c=byteStream2.read())!=-1){

            System.out.println((char)c);
        }
    }
}