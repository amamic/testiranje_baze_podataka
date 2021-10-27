import java.sql.*;

public class DatabaseManagerPatient {
    private Connection conn;

    public void createNewDatabase(String filename) {
        String sql = "CREATE TABLE IF NOT EXISTS patient (\n"
                + " id integer PRIMARY KEY,\n"
                + " name text NOT NULL UNIQUE,\n"
                + " surname text NOT NULL UNIQUE,\n"
                + " email text NOT NULL UNIQUE,\n"
                + " date text NOT NULL UNIQUE\n"
                + ");";
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:"+ filename);
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void addPatient(Patient p) {
        String sql = "INSERT INTO patient (name, surname, email, date) VALUES(?,?,?,?)";
        try {
            Connection conn = this.conn;
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, p.getName());
            statement.setString(2, p.getSurname());
            statement.setString(3, p.getEmail());
            statement.setString(4, p.getDate());
            statement.executeUpdate();

            System.out.println(p);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /*public int returnBalance(String number) {
        String sql = "SELECT number, balance FROM card";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                if (number.equals(resultSet.getString("number"))) {
                    return resultSet.getInt("balance");
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public void updateBalance(String number, int InputtedIncome) {
        String sql = "UPDATE card SET " +
                "balance = ?" +
                "WHERE number = ?";
        int balance = returnBalance(number);
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, balance + InputtedIncome);
            statement.setString(2, number);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }

    public boolean isCardInDatabase(String number, String pin) {
        String sql = "SELECT number, pin FROM card";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                if (number.equals(resultSet.getString("number")) &&
                        pin.equals(resultSet.getString("pin"))) {
                    return true;
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return false;
    }

    public boolean isCardInDatabase(String number) {

        String sql = "SELECT number, pin FROM card";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                if (number.equals(resultSet.getString("number"))) {
                    return true;
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public void deleteCreditCardAccount(String number) {
        String sql = "DELETE FROM card where number = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, number);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadCreditCardAccounts() {
        String sql = "SELECT * FROM card";
        try (Statement statement = conn.createStatement();
             ResultSet result = statement.executeQuery(sql)) {

            while (result.next()) {
                CreditCard creditCard = new CreditCard();
                creditCard.setCardNumber(result.getString("number"));
                creditCard.setPin(result.getString("pin"));
                creditCard.setBalance(result.getInt("balance"));
                System.out.println("Account loaded: " + creditCard);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }*/
}


