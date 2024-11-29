public class Produkt {
    private String nazwa;
    private String wariant;
    private String kategoria;
    private String kodProduktu;
    private double cenaZakupu;
    private double cenaSprzedazy;
    private int ilosc;
    private int minimumWMagazynie;
    private String opis;

    public Produkt(String nazwa, String wariant, String kategoria, String kodProduktu,
                   double cenaZakupu, double cenaSprzedazy, int ilosc, int minimumWMagazynie, String opis) {
        this.nazwa = nazwa;
        this.wariant = wariant;
        this.kategoria = kategoria;
        this.kodProduktu = kodProduktu;
        this.cenaZakupu = cenaZakupu;
        this.cenaSprzedazy = cenaSprzedazy;
        this.ilosc = ilosc;
        this.minimumWMagazynie = minimumWMagazynie;
        this.opis = opis;
    }

    // Gettery
    public String getNazwa() { return nazwa; }
    public String getWariant() { return wariant; }
    public String getKategoria() { return kategoria; }
    public String getKodProduktu() { return kodProduktu; }
    public double getCenaZakupu() { return cenaZakupu; }
    public double getCenaSprzedazy() { return cenaSprzedazy; }
    public int getIlosc() { return ilosc; }
    public int getMinimumWMagazynie() { return minimumWMagazynie; }
    public String getOpis() { return opis; }
}
