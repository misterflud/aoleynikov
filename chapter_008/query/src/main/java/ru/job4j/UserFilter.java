 package ru.job4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Anton on 20.06.2017.
 */
public class UserFilter extends BaseFilter {

    private String request;
    private String requestDescription;


    public UserFilter(int number, Constructor first, Constructor second) {
        super(number);
        request = String.format("%s %s", first.getRequest(), second.getRequest());
        requestDescription = String.format("%s) %s %s", number, first.getRequest(), second.getRequest());
    }


    @Override
    public void execute(PreparedStatement st, ResultSet rs, Connect connect, Connection conn) {
        try{
            st = conn.prepareStatement(request);
            rs = st.executeQuery();
            while(rs.next()) {
                String s = "";
                for (int i = 1; i != rs.getMetaData().getColumnCount() + 1; i++) {
                    s += " " + rs.getString(i);
                }
                connect.sendAnswer(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void execute(PreparedStatement st, Connection conn) {
        try{
            st = conn.prepareStatement(request);
            st.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getRequestDescription() {
        return requestDescription;
    }
}
