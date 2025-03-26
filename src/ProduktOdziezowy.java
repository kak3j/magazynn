package model;

public class ProduktOdziezowy extends Produkt { // Poprawiono nazwę klasy
    private String rozmiar;
    private String material;

    public ProduktOdziezowy(int id, String nazwa, double cenaZakupu, double cenaSprzedazy, int ilosc, String rozmiar, String material) {
        super(id, nazwa, cenaZakupu, cenaSprzedazy, ilosc);
        this.rozmiar = rozmiar;
        this.material = material;
    }

    public String getRozmiar() {
        return rozmiar;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String opisProduktu() {
        return "Produkt odzieżowy: " + getNazwa() + ", rozmiar: " + rozmiar + ", materiał: " + material + ".";
    }
}