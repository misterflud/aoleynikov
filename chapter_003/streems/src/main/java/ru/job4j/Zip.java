package ru.job4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


/**
 * Created by Anton on 04.03.2017.
 * C:/java/for tests
 * 1. Задана директория проекта. например c:\project\job4j\
 2. В качестве ключей передаются расширения файлов, которые должны попасть в архив.
 3. Архив должен сохранять структуру проекта.
 4. Запуск проекта java -r pack.jar -d c:\project\job4j\ -e java,xml -o project.zip
 5. Для архивации использовать классы https://docs.oracle.com/javase/7/docs/api/java/util/zip/ZipOutputStream.html
 */
public class Zip {
    /**
     * all files.
     */
    private static ArrayList<File> collectFiles = new ArrayList<>();

    /**
     *
     * @param args args
     * @throws Exception Exception
     */
    public static void main(String[] args) throws Exception { //static
        String path = "";
        String extensionFiles = "";
        String nameZip = "";
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-d")) {
                path = args[i + 1];
            } else if (args[i].equals("-e")) {
                extensionFiles = args[i + 1];
            } else if (args[i].equals("-o")) {
                nameZip = args[i + 1];
            }
        }
        String[] extensionFiles2 = extensionFiles.split(",");
        path.replace("\\", "/");

        File[] files = new File(path).listFiles();
        getFiles(files);
        selectNecessaryFiles(extensionFiles2);
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(path + nameZip));
        for (File file : collectFiles) { //пробегаем по всем файлам из списка и записываем в архив, НО путь получается от C, как удалить лишние папки -- неясно
            FileInputStream fileInputStream = new FileInputStream(file.getAbsolutePath());
            ZipEntry entry = new ZipEntry(file.getAbsolutePath());
            zipOutputStream.putNextEntry(entry);
            zipOutputStream.write(fileInputStream.read(new byte[fileInputStream.available()]));
            zipOutputStream.closeEntry();
            fileInputStream.close();
        }
        zipOutputStream.close();

    }

    /**
     *
     * @param files files
     * @throws Exception Exception
     */
    public static void getFiles(File[] files) throws Exception { // получение всех файлов из дериктории
        for (File file : files) {
            if (file.isDirectory()) {
                //System.out.println("Directory: " + file.getCanonicalPath() + " "  + file.getName());
                getFiles(file.listFiles()); // Calls same method again.
            } else {
                //System.out.println(file.getName());
                collectFiles.add(file);
            }
        }
    }

    /**
     *
     * @param extensionFiles2 extensionFiles2
     */
    public static void selectNecessaryFiles(String[] extensionFiles2) { //удаление из списка дериктории -- файлов с ненужным расширением
        boolean flag;
        for (int i = 0; i < collectFiles.size(); i++) {
            String[] afterPoint1 = collectFiles.get(i).getName().split("\\."); //получение расширения
            String afterPoint2 = afterPoint1[1];
            flag = false;
            for (int j = 0; j < extensionFiles2.length; j++) {
                if (afterPoint2.equals(extensionFiles2[j])) {
                    flag = true;
                    break;
                }
            }
            if (!flag) { // flag == false
                collectFiles.remove(i);
                i = -1;
            }
        }
    }
}
