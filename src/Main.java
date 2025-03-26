import dao.ProduktDAO; // Dodaj ten import
import model.ProduktOdziezowy; // Potrzebny dla typu zwracanego przez getProduktById

public class Main {
    public static void main(String[] args) {
        ProduktDAO produktDAO = new ProduktDAO();

        // Wygenerowanie 600 000 rekordów
        produktDAO.generujDane(600000);

        // Pobranie przykładowego produktu
        ProduktOdziezowy produkt = produktDAO.getProduktById(1);

        if (produkt != null) {
            System.out.println("Pobrano produkt:");
            System.out.println(produkt.opisProduktu());
            System.out.println("Marża: " + produkt.obliczMarze());
        } else {
            System.out.println("Nie znaleziono produktu o podanym ID.");
        }
    }
}