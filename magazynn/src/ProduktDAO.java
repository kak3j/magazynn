public class ProduktDAO {
    public boolean insertProdukt(Produkt produkt) {
        // Logika dodawania produktu do bazy danych
        System.out.println("Dodano produkt: " + produkt.getNazwa());
        return false;
    }

    public static void main(String[] args) {
        Produkt produkt = new Produkt(
                "Koszulka sportowa",       // nazwa
                "Rozmiar M",               // wariant
                "Odzież",                  // kategoria
                "SKU12345",                // kod_produktu
                50.00,                     // cena_zakupu
                100.00,                    // cena_sprzedazy
                10,                        // ilosc
                3,                         // minimum_w_magazynie
                "Koszulka idealna na treningi." // opis
        );

        ProduktDAO produktDAO = new ProduktDAO();
        boolean isInserted = produktDAO.insertProdukt(produkt);

        if (isInserted) {
            System.out.println("Produkt został pomyślnie dodany do bazy danych.");
        } else {
            System.out.println("Wystąpił problem podczas dodawania produktu.");
        }
    }
}
