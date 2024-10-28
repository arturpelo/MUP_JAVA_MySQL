package org.example;
import java.sql.*;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        // URL połączenia do bazy danych MySQL
        String url = "jdbc:mysql://localhost:3306/javaDB"; // Zmień nazwę_bazy na swoją
        String user = "javauser"; // Zmień na swoją nazwę użytkownika
        String password = "javapass"; // Zmień na swoje hasło

        try {
            // Inicjalizacja połączenia
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Połączenie z bazą danych MySQL nawiązane!");

            // Tworzenie obiektu Statement
            Statement statement = connection.createStatement();

            // Wykonanie operacji INSERT na bazie danych
            String sql = "INSERT INTO students (id, name, surname, phone) VALUES (NULL, 'Jan', 'Kowalski', '111-222-333')";
            int rowsAffected = statement.executeUpdate(sql);
            System.out.println("Wstawiono " + rowsAffected + " rekord(ów) do tabeli users.");
            // Wypisanie wyników zapytania SELECT
            String selectSql = "SELECT * FROM students";
            ResultSet resultSet = statement.executeQuery(selectSql);
            System.out.println("Zawartość tabeli users:");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String phone = resultSet.getString("phone");
                System.out.println("ID: " + id + ", Name: " + name + ", Surname: " + surname +"Phone:"+phone);

            }

            // Zamknięcie połączenia
            connection.close();
            System.out.println("Połączenie z bazą danych zamknięte.");
        } catch (SQLException e) {
            System.out.println("Błąd podczas łączenia się z bazą danych.");
            e.printStackTrace();
        }
    }
}