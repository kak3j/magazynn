package dao;

import database.Database;
import model.ProduktOdziezowy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class ProduktDAO {

    public ProduktOdziezowy getProduktById(int id) {
        String sql = "SELECT * FROM produkty WHERE id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new ProduktOdziezowy(
                        rs.getInt("id"),
                        rs.getString("nazwa"),
                        rs.getDouble("cena_zakupu"),
                        rs.getDouble("cena_sprzedazy"),
                        rs.getInt("ilosc"),
                        rs.getString("rozmiar"),
                        rs.getString("material")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // ✅ POPRAWNA METODA DO GENEROWANIA DANYCH
    public void generujDane(int liczbaRekordow) {
        String sql = "INSERT INTO produkty (nazwa, cena_zakupu, cena_sprzedazy, ilosc, rozmiar, material) VALUES (?, ?, ?, ?, ?, ?)";
        String[] nazwy = {"Koszulka", "Spodnie", "Kurtka", "Bluza", "Sweter", "Szalik", "Czapka"};
        String[] rozmiary = {"S", "M", "L", "XL", "XXL"};
        String[] materialy = {"Bawełna", "Poliester", "Len", "Jedwab", "Wełna"};

        Random random = new Random();

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            for (int i = 0; i < liczbaRekordow; i++) {
                stmt.setString(1, nazwy[random.nextInt(nazwy.length)]);
                double cenaZakupu = 50 + (500 - 50) * random.nextDouble();
                double cenaSprzedazy = cenaZakupu + (cenaZakupu * (0.2 + random.nextDouble() * 0.8));
                stmt.setDouble(2, cenaZakupu);
                stmt.setDouble(3, cenaSprzedazy);
                stmt.setInt(4, random.nextInt(100) + 1);
                stmt.setString(5, rozmiary[random.nextInt(rozmiary.length)]);
                stmt.setString(6, materialy[random.nextInt(materialy.length)]);
                stmt.addBatch();

                if (i % 1000 == 0) { // Co 1000 rekordów wykonujemy zapytanie batch
                    stmt.executeBatch();
                }
            }
            stmt.executeBatch(); // Wykonujemy ostatnie zapytania
            System.out.println("Dodano " + liczbaRekordow + " losowych rekordów do bazy danych.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
