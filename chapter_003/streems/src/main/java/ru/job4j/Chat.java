package ru.job4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
     * @throws Exception Exception
     */
    public void chatting() throws Exception {
        String s;
        sizeLine = paramsOfFile(); //хранятся кол-во слов в строках
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (!(s = reader.readLine()).equals("закончить")) {
            if (s.equals("стоп")) {
                while (!(reader.readLine()).equals("продолжить")) {

                }
            } else {
                answer();
            }
        }
    }

    /**
     * Print random answers from file.
     * @throws Exception Exception
     */
    public void answer() throws Exception { //система рандомного ответа
        String s = "";
        final Random random = new Random();
        int randomLine = random.nextInt(sizeLine.size()); //какая строка
        int randomStartWord; //откуда начало фразы
        int randomCountWords;
        final int ten = 10;
        while ((randomCountWords = random.nextInt(ten) + 1) + (randomStartWord = random.nextInt(sizeLine.get(randomLine))) > sizeLine.get(randomLine) - 1) { //чтобы не вышли за пределы длины строки

        }
        BufferedReader readerFromFile = new BufferedReader(new FileReader("C:/java/for_tests/Answer.txt"));
        int count = 0;
        while (count < randomLine + 1) {
            count++;
            s = readerFromFile.readLine();
        }
        readerFromFile.close();
        String[] words = s.split(" ");
        String fraze = "";
        for (int i = randomStartWord; i < randomStartWord + randomCountWords; i++) {
            fraze += words[i] + " ";
        }
        System.out.println(fraze);
    }

    /**
     *
     * @return ArrayList
     * @throws Exception Exception
     */
    public ArrayList<Integer> paramsOfFile() throws Exception { //чтобы 100 раз не загружать одно и тоже
        BufferedReader readerFromFile = new BufferedReader(new FileReader("C:/java/for_tests/Answer.txt"));
        String s;
        ArrayList<Integer> sizeLine2 = new ArrayList<>(); //храняться кол-во слов в строках
        while ((s = readerFromFile.readLine()) != null) {
            sizeLine2.add(s.split(" ").length);
        }
        readerFromFile.close();
        return sizeLine2;
    }
}
