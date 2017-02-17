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
            if (ww.contains(line)) {
                //write.write(line + "\n");
                out.write("censor".getBytes());
                out.write("\n".getBytes());
            } else {
                //write.write("censor" + "\n");
                out.write(line.getBytes());
                out.write("\n".getBytes());
            }
        }
    }
}
