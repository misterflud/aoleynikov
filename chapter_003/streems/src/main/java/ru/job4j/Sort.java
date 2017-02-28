package ru.job4j;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 * Created by Anton on 25.02.2017.
 */
public class Sort {
    /**
     * count .
     */
    private int count = 1; //в какой файл пишем: 1й или 2й
    /**
     * file2.
     */
    private File file2; //исходный пустой файл
    /**
     * file1.
     */
    private File file1;
    /**
     * sizeOfArray.
     */
    private final int sizeOfArray = 10; //размер массива можно менять
    /**
     * pathFile1.
     */
    private String pathFile1;
    /**
     * pathFile2.
     */
    private String pathFile2;

    /**
     *
     * @param source main file
     * @param pathFile1 temp file
     * @param pathFile2 temp file
     * @throws Exception exception
     */
    public void sort(File source, String pathFile1, String pathFile2) throws Exception {
        this.pathFile1 = pathFile1;
        this.pathFile2 = pathFile2;
        file2 = new File(pathFile2); //исходный пустой файл
        file2.createNewFile();
        RandomAccessFile randomAccessFile = new RandomAccessFile(source, "r");
        ArrayList<String> lines = new ArrayList<>();
        String line;
        while (true) {
            line = randomAccessFile.readLine();
            if (line == null) { //если дошли до конца исходного файла -- выходим из массива и заканчиваем запись в результирующий файл
                if (lines.size() > 0) {
                    sortArray(lines);
                }
                break;
            }
            if (lines.size() == sizeOfArray) { //размер выделим в 10 строк
                sortArray(lines);
                lines.clear();
            } else {
                lines.add(line);
            }
        }
        randomAccessFile.close();
    }

    /**
     *
     * @param lines sorting Array
     * @throws Exception exception
     */
    public void sortArray(ArrayList<String> lines) throws Exception { //внутринняя сортировка массива
        for (int i = 0; i < lines.size() - 1; i++) { //применим глупую сортировку
            String change;
            if (lines.get(i).length() > lines.get(i + 1).length()) {
                change = lines.get(i);
                lines.set(i, lines.get(i + 1));
                lines.set(i + 1, change);
                i = -1;
            }
        }

        if (count == 1) { //выбор откуда читать куда писать(конечно этот кусок кода немного не вписывается в метод, но все же)
            file1 = new File(pathFile1); //файл куда записывается слияние(Source1), создается заново, так как до этого он был удален
            file1.createNewFile();
            merger(lines, file2, file1);
            count = 2;
            file2.delete(); //удаляется файл(Source2), который читался до этого
        } else {
            file2 = new File(pathFile2);
            file2.createNewFile();
            merger(lines, file1, file2);
            count = 1;
            file1.delete();
        }
    }

    /**
     *
     * @param lines sorted array from past method
     * @param fileReader fileReader
     * @param fileWriter fileWriter
     * @throws Exception exception
     */
    public void merger(ArrayList<String> lines, File fileReader, File fileWriter) throws Exception { // слияние в файл Source1.txt или Source2.txt с Array
        RandomAccessFile read = new RandomAccessFile(fileReader, "r");
        RandomAccessFile write = new RandomAccessFile(fileWriter, "rw");
        String s;
        int i = 0; //счетчик прочитанных строк из массива
        s = read.readLine();
        while (true) {
            if (i == sizeOfArray && s == null) { //дошли до конца массива и в файле чтения больше нет строк
                break;
            } else if (i == sizeOfArray) { //дошли до конца массива поэтому добавляем оставшиеся строки из файла чтения
                write.writeBytes(s + "\r\n");
                s = read.readLine();
            } else if (s == null) { //дошли до конца файла чтения поэтому добавляем оставшиеся строки из массива
                write.writeBytes(lines.get(i) + "\r\n");
                i++;
            } else { //здесь сравниваем длины из массива и из файла считывания
                if (lines.get(i).length() < s.length()) {
                    write.writeBytes(lines.get(i) + "\r\n");
                    i++;
                } else if (lines.get(i).length() > s.length()) {
                    write.writeBytes(s + "\r\n");
                    s = read.readLine();
                } else {
                    write.writeBytes(lines.get(i) + "\r\n");
                    write.writeBytes(s + "\r\n");
                    s = read.readLine();
                    i++;
                }
            }
        }
        read.close();
        write.close();
    }
}
