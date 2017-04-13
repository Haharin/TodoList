package dataBase;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbTableCreator {

    public static void main(String[] args) {
        Connection c = null;
        Statement stmt = null;
        String sql = "";
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "Haharin", "3333");

            stmt = c.createStatement();

            sql = "CREATE SCHEMA IF NOT EXISTS JAVA_TASK ";
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE IF NOT EXISTS JAVA_TASK.MAINLIST "
                    + "( ID                      SERIAL PRIMARY KEY     NOT NULL, "
                    +" Name           VARCHAR(32)    NOT NULL, " +
                    " DATE_TIME               TIMESTAMP              NOT NULL, " +
                    " Description    VARCHAR(32), " +
                    " Importance     BOOLEAN, " +
                    " Period         INT,  " +
                    " Notification   BOOLEAN)";

            stmt.executeUpdate(sql);

            sql = "CREATE TABLE IF NOT EXISTS JAVA_TASK.ADDLIST "
                    + " ( "
                    + " ID                      SERIAL PRIMARY KEY     NOT NULL, "
                    + " MAIN_ID                 INT                    NOT NULL, "
                    + " ADD_NAME                   VARCHAR(100)           NOT NULL, "
                    + " DESCRIPTION             VARCHAR(500)           NOT NULL  "
                    + " ) ";
            stmt.executeUpdate(sql);

            sql = "ALTER TABLE JAVA_TASK.ADDLIST "
                    + " ADD CONSTRAINT FK_MAINLIST "
                    + " FOREIGN KEY (MAIN_ID) REFERENCES JAVA_TASK.MAINLIST (ID) MATCH FULL "
                    + " ";
            stmt.executeUpdate(sql);

            stmt.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
            System.exit(0);
        }
        System.out.println("Tables are created successfully");
    }

}