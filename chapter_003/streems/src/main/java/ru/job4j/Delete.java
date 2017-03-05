package ru.job4j;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * Created by Anton on 17.02.2017.
 */
public class Delete {
    /**
     *
     * @param in in
     * @param out out
     * @param abuse abuse
     * @throws Exception Exception
     */
    public void dropAbuses(InputStream in, OutputStream out, String[] abuse) throws Exception {
        BufferedReader buf = new BufferedReader(new InputStreamReader(in));
        //BufferedWriter write = new BufferedWriter(new OutputStreamWriter(out));//ПОЧЕМУ ничего не пишется в out?
        String line;
        String ww = "";
        for (String ss : abuse) {
            ww += ss;
        }
        while ((line = buf.readLine()) != null) {
            String[] word = line.split(" ");
            String line2 = "";
            for (int i = 0; i < word.length; i++) {
                if (ww.contains(word[i])) {
                    word[i] = "censor";
                }
            }
            if (word.length == 1) {
                line2 = word[0];
            } else {
                for (int i = 0; i < word.length - 1; i++) {
                    line2 += word[i] + " ";
                }
                line2 += word[word.length - 1];
            }
            out.write((line2 + "\n").getBytes());
            //write.write(line2 + "\n");
        }
    }
}
