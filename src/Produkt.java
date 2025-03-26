package model;

// Klasa bazowa dla produktów
public abstract class Produkt {
    private int id;
    private String nazwa;
    private double cenaZakupu;
    private double cenaSprzedazy;
    private int ilosc;

    // Konstruktor
    public Produkt(int id, String nazwa, double cenaZakupu, double cenaSprzedazy, int ilosc) {
        this.id = id;
        this.nazwa = nazwa;
        this.cenaZakupu = cenaZakupu;
        this.cenaSprzedazy = cenaSprzedazy;
        this.ilosc = ilosc;
    }

    // Metoda abstrakcyjna - do implementacji w klasach potomnych
    public abstract String opisProduktu();

    // Obliczanie marży
    public double obliczMarze() {
        return cenaSprzedazy - cenaZakupu;
    }

    // Gettery (pola można tylko odczytywać)
    public int getId() {
        return id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public double getCenaZakupu() {
        return cenaZakupu;
    }

    public double getCenaSprzedazy() {
        return cenaSprzedazy;
    }

    public int getIlosc() {
        return ilosc;
    }
}
