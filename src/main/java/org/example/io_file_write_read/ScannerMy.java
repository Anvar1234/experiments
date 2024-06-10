package org.example.io_file_write_read;

import java.io.*;
import java.util.Scanner;

public class ScannerMy {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
//        System.out.print("name : ");
//        String name = iScanner.nextLine();
//        System.out.printf("Привет, %s!\n", name);
//        System.out.print("family : ");
//        String family = iScanner.nextLine();
//        System.out.printf("Будем знакомы, %s %s!", name, family);
//        iScanner.close();
        int x;
        while (true) {
            System.out.print("int x : ");
            boolean flag = iScanner.hasNextInt();
            if (flag) {
                x = iScanner.nextInt();
                break;
            } else {
                System.out.println("integer expected!");
                iScanner.next();
            }
        }
        double y;
        while (true) {
            System.out.print("double y : ");
            boolean flag = iScanner.hasNextDouble();
            if (flag) {
                y = iScanner.nextDouble();
                break;
            } else {
                System.out.println("double expected!");
                iScanner.nextDouble();
            }
        }

    }
}

//здесь пробую ввод в консоль превратить в символ (char):
class ScanToChar {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);

        int x;
        while (true) {
            System.out.print("int x : ");
            boolean flag = iScanner.hasNextInt();
            if (flag) {
                x = iScanner.nextInt();
                if (x == 128) break;
                try {
                    char ch = (char) x;
                    System.out.printf("\"%s\" int is char \"%s\" \n", x, ch);
                } catch (ClassCastException classCastException) {
                    classCastException.printStackTrace(System.out);
                }
            } else {
                System.out.println("integer expected!");
                iScanner.next();
            }
        }
    }
}

class BufferedReaderScan {
//    public static void main(String[] args) throws IOException {
//        // Creating object of Scanner class to
//        // read input from keyboard
//        Scanner scn = new Scanner(System.in);
//        System.out.println("Enter an integer");
//        // Using nextInt() to parse integer values
//        int a = scn.nextInt();
//        System.out.println("Enter a String");
//        // Using nextLine() to parse string values
//        String b = scn.next();
//        // Display name and age entered above
//        System.out.printf("You have entered: " + a + " "
//                + "and name as " + b);
//    }
//}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter an integer");
        // Taking integer input
        int a = Integer.parseInt(br.readLine());
        System.out.println("Enter a String");
        String b = br.readLine();
        // Printing input entities above
        System.out.printf("You have entered:- " + a
                + " and name as " + b);
    }
}

class ScannerExample {
    private static String fileName = "examclouds.txt";

    public static void scanFile() {
        try (FileReader fileReader = new FileReader(fileName);
             Scanner scanner = new Scanner(fileReader)) {
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    System.out.println(scanner.nextInt() + " :int");
                } else if (scanner.hasNextDouble()) {
                    System.out.println(scanner.nextDouble() + " :double");
                } else if (scanner.hasNextBoolean()) {
                    System.out.println(scanner.nextBoolean() + " :boolean");
                } else {
                    System.out.println(scanner.next() + " :String");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void makeFile() {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write("2 Java 1,5 true 1.6 ");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        ScannerExample.makeFile();
        ScannerExample.scanFile();
    }
}