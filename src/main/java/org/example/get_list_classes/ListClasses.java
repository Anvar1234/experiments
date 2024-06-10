package org.example.get_list_classes;

import org.example.get_list_classes.util.PropertiesUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Нужно получать список классов, классы должны иметь полный путь к ним, но без расширения ".java" или ".class"
 */
public class ListClasses {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IOException {
//        String workingDir = System.getProperty("user.dir");
//        System.out.println("Текущий рабочий каталог: " + workingDir);
        Map<String, String> operationMap = Map.of("+", "x + y");
        int x = 5;
        int y = 2;

        //Получаем список<String> ссылок на классы:
        Path pathToImpl = Path.of(PropertiesUtil.get("app.impl.relative.path"));
        Stream<Path> streamClassPaths = Files.list(pathToImpl);
        List<String> stringClassDirs = streamClassPaths.map(Path::toString).toList();
        streamClassPaths.close(); //не забываем закрыть поток, эксепшены пробрасываем выше

        //Работаем со списком ссылок на классы в папке impl, приводим в удобоваримый вид для класса Class
        //(удаляем .java, заменяем / на точки) и загоняем все это дело в список:
        List<Class<?>> classes = new ArrayList<>();
        String regex = PropertiesUtil.get("app.string.to.replace");
        System.out.println("regex : " + regex);
        String suffix = PropertiesUtil.get("app.class.suffix.to.replace");
        System.out.println("suffix : " + suffix);
        for (String s : stringClassDirs){
            String sCopy;
            sCopy = s.replace('\\', '.')
                    .replace(regex, "")
                    .replace(suffix,"")
                    .trim();
            System.out.println("s : " + sCopy);
            classes.add(Class.forName(sCopy));
        }
        System.out.println("classesList : " + classes);

        //возможно сделать 2 мапы, 1: где ключ - символ токена, а значение приоритет,
        // а 2: где ключ оператор, а значение его метод operation? И дальше работать с этими мапами




//        String strPath = "src/main/java/org/example/get_list_classes/math/impl";
//        Path path = Path.of(strPath);
//        Stream<Path> files = Files.list(path);
//        List<Path> listClassNames = files.map(a -> a.getFileName()).toList();
//        files.close();
//        System.out.println("listClassNames : " + listClassNames);
//
//        List<String> strClasses = new ArrayList<>();
//        for (Path p : listClassNames) {
//            strClasses.add(p.toString());
//        }
//        for (String s : strClasses) {
//            System.out.println("s : " + s);
//        }
//        //чистим имена от суффиксов:
//        String suffix = ".java";
//        String prefix = "src/main/java/";
//        List<String> myListClasses = new ArrayList<>();
//        for (String elem : strClasses) {
//            if (elem.endsWith(suffix)) {
//                String subString = elem.substring(0, (elem.length() - suffix.length()));
//                myListClasses.add(subString);
//            }
//        }
//        System.out.println("myListClasses : " + myListClasses);
//
//        //создаем путь, который пригоден для использования классом Class, то есть с точками вместо / и без расширения java:
//
//        List<String> strPaths = new ArrayList<>();
//        for (String s : myListClasses) {
//            String strPathForClass = strPath.replaceFirst(prefix, "").replace('/', '.').concat(".").concat(s);
//            System.out.println("strPathForClass : " + strPathForClass);
//            strPaths.add(strPathForClass);
//        }
//        System.out.println("strPaths : " + strPaths);
//
//        //собираем список значений Class<?>:
//        try {
//            List<Class<?>> listClasses = new ArrayList<>();
//            for (String s : strPaths) {
//                System.out.println("s = " + s);
//                listClasses.add(Class.forName(s));
//            }
//            System.out.println("listClasses : " + listClasses);
//        } catch (ClassNotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }


        String className = "Plus";//это получаем из списка List<Class<?>> classes, когда потрошим директорию impl
        String mult = "+";//нужно получить рефлексией


//        Class<?> clazz = Class.forName(className);
//        Constructor<?> constructor = clazz.getConstructor(clazz);


    }
}
