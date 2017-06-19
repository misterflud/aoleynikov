package ru.job4j.sql;

import java.sql.*;
import java.util.Properties;

/**
 * Created by Anton on 15.06.2017.
 */
public class SqlManager {
    //private static final log = LoggerFactory
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/tracker";
        String username = "postgres";
        String password = "331610";
        Connection conn = null;
        try {
            //коннекш мы получаем с помощью статической фабрики (по методу а не по оператору new),
            //и так как он статический, то на всё приложение он будет один.
            conn = DriverManager.getConnection(url, username, password);
            PreparedStatement st = conn.prepareStatement("delete from users  where id = ?");


            st.setInt(1, 2);
            st.executeUpdate();
            st.close();
            /*
            PreparedStatement st = conn.prepareStatement("SELECT * FROM users WHERE users.id in (?)");
            st.setInt(1, 2);
            ResultSet rs = st.executeQuery();
            while (rs.next())
            {
                System.out.println(String.format("%s, %s", rs.getInt("id"), rs.getString("name")));
            }
            */
            //rs.close();
            //st.close();

        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e.getMessage(), e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    //log.error(e.getMessage(), e);
                }
            }
        }
    }
}
