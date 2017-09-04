package ru.job4j;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

/**
 * Created by Anton on 09.03.2017.
 */
public class Chat {
    /**
     * Size of lines in txt file.
     */
    private ArrayList<Integer> sizeLine;

    /**
     *
     * @param args args
     *  @throws Exception Exception
     */
    public static void main(String[] args) throws Exception {
        Chat chat = new Chat();
        chat.chatting();
    }

    /**
     *
     * @return path
     * @throws Exception Exception
     */
    public String getFile() throws Exception {
        final Properties prs = new Properties();
        ClassLoader load = Chat.class.getClassLoader(); // иснтересное решение получение пути вначале к классу, а потом через него к properties
        try (InputStream inputStream = load.getResourceAsStream("config.properties")) {
           prs.load(inputStream);
        }
        return prs.getProperty("file1");
    }
    /**
     *
     * @throws Exception Exception
     */
    public void chatting() throws Exception {
        String s;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (!"закончить".equals(s = reader.readLine())) {
                if ("стоп".equals(s)) {
                    while (!"продолжить".equals(reader.readLine())) {

                    }
                } else {
                    System.out.println(answer());
                }
            }
        }
    }

    /**
     * Print random answers from file.
     * @throws Exception Exception
     * @return String Answer
     */
    public String answer() throws Exception { //система рандомного ответа
        sizeLine = paramsOfFile(); //хранятся кол-во слов в строках
        String s = "";
        final Random random = new Random();
        int randomLine = random.nextInt(sizeLine.size()); //какая строка
        int randomStartWord; //откуда начало фразы
        int randomCountWords;
        final int ten = 10;

        randomCountWords = random.nextInt(ten) + 1;
        randomStartWord = random.nextInt(sizeLine.get(randomLine));
        while (randomCountWords + randomStartWord > sizeLine.get(randomLine) - 1) { //Мы рандомно выбираем начало фразы и ее длину, НО проблема может быть в том что длина (рандомной строки + начало строки) превышает длину существующей строки в файле. Этот блок кода предотвращает это.
            randomCountWords = random.nextInt(ten) + 1;
            randomStartWord = random.nextInt(sizeLine.get(randomLine));
        }

        try (BufferedReader readerFromFile = new BufferedReader(new FileReader(getFile()))) {
            int count = 0;
            while (count < randomLine + 1) {
                count++;
                s = readerFromFile.readLine();
            }
            String[] words = s.split(" ");
            StringBuilder fraze = new StringBuilder();
            for (int i = randomStartWord; i < randomStartWord + randomCountWords; i++) {
                fraze.append(words[i]);
                fraze.append(" ");
            }
            return fraze.toString();
        }
    }

    /**
     *
     * @return ArrayList
     * @throws Exception Exception
     */
    public ArrayList<Integer> paramsOfFile() throws Exception { //чтобы 100 раз не загружать одно и тоже
        try (BufferedReader readerFromFile = new BufferedReader(new FileReader(getFile()))) {
            String s;
            ArrayList<Integer> sizeLine2 = new ArrayList<>(); //храняться кол-во слов в строках
            while ((s = readerFromFile.readLine()) != null) {
                sizeLine2.add(s.split(" ").length);
            }
            return sizeLine2;
        }
    }
}
