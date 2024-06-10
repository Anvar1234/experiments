package org.example.working_with_path;

import org.example.working_with_path.mypackage.MyCls;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;

public class MyPath {
    public static void main(String[] args) throws IOException {
////1
//        System.out.println("1--------------------------------------------");
//        Class<?> clazz = MyCls.class;
//        Path path = Paths.get(clazz.getName());
//        String str = path.toString().replace('.', '\\');
//        Path parentPath = Path.of(str);
//        System.out.println("path : " + path);
//        System.out.println("parentPath : " + parentPath);
//        boolean exist = Files.exists (parentPath);
//        System.out.println(exist);
//        Path parPath = parentPath.getParent();
//        System.out.println("parPath : " + parPath);
//
////2
//        System.out.println("2--------------------------------------------");
//        Path path1 = Path.of("D:\\Programming_Local\\projects\\experiments");
//        System.out.println("1parent path1 = " + path1.resolve(".."));
//        System.out.println("2parent path1 = " + path1.getParent());
//
//
////3
//        System.out.println("3--------------------------------------------");
//        Path currentDir = Paths.get(".");
//        System.out.println("currentDir : " + currentDir.toAbsolutePath());
//
//        Path currentDir1 = Paths.get("..");
//        System.out.println("currentDir : " + currentDir1.toAbsolutePath());


//4     https://javarush.com/groups/posts/2275-files-path
        System.out.println("4--------------------------------------------");
        Path testFilePath = Paths.get("C:\\Users\\Username\\Desktop\\testFile.txt");

        Path fileName = testFilePath.getFileName();
        System.out.println(fileName);

        Path parent = testFilePath.getParent();
        System.out.println(parent);

        Path root = testFilePath.getRoot();
        System.out.println(root);

        boolean endWithTxt = testFilePath.endsWith("Desktop\\testFile.txt");
        System.out.println(endWithTxt);

        boolean startsWithLalala = testFilePath.startsWith("lalalala");
        System.out.println(startsWithLalala);
//5
        System.out.println("5--------------------------------------------");
        Path path5 = Paths.get("C:\\Users\\Username\\.\\Desktop\\");

        System.out.println(path5.normalize());

        Path path6 = Paths.get("C:\\Users\\Username\\..\\Desktop\\");
        System.out.println(path6.normalize());

//6
        System.out.println("6--------------------------------------------");
        Path txt = Paths.get("2.txt").toAbsolutePath();
        System.out.println("txt = " + txt);
        try(BufferedReader br = Files.newBufferedReader(txt);) {
            String str;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
        }
       catch (IOException ex){
           System.out.println(ex.getMessage());
       }


//7
        System.out.println("7--------------------------------------------");
        try {
//            Path filePath = Paths.get("src", "main", "java", "org", "example", "working_with_path", "newFile.txt");
            Path filePath = Paths.get("src\\main\\java\\org\\example\\working_with_path\\newFile1.txt");
            System.out.println("parent = " + filePath.getParent());
//            boolean isDirect = filePath.e
            Files.createDirectories(filePath.getParent()); // Создаем папки, если они не существуют
            Files.createFile(filePath); // Создаем файл
            System.out.println("Файл создан: " + filePath);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
