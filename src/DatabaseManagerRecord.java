import java.sql.*;

public class DatabaseManagerRecord {

        private Connection conn;

        public void createNewDatabase(String filename) {
            String sql = "CREATE TABLE IF NOT EXISTS record (\n"
                    + " id integer PRIMARY KEY,\n"
                    + " timestamp date NOT NULL UNIQUE,\n"
                    + " email text NOT NULL UNIQUE,\n"
                    + " bloodPressure1 text NOT NULL UNIQUE,\n"
                    + " bloodPressure2 text NOT NULL UNIQUE,\n"
                    + " description text NOT NULL UNIQUE\n"
                    + ");";
            try {
                conn = DriverManager.getConnection("jdbc:sqlite:"+ filename);
                Statement statement = conn.createStatement();
                statement.executeUpdate(sql);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }


        public void addRecord(BloodPressureRecord r) {
            String sql = "INSERT INTO record(timestamp, email, bloodPressure1, bloodPressure2, description ) VALUES(?,?,?,?,?)";
            try {
                Connection conn = this.conn;
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, String.valueOf(r.getTimestamp()));
                statement.setString(2, r.getEmail());
                statement.setString(3, r.getBloodPressure1());
                statement.setString(4, r.getBloodPressure2());
                statement.setString(4, r.getDescription());
                statement.executeUpdate();

                System.out.println(r);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
}
