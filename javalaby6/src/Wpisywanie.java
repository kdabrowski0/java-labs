import java.time.LocalDate;
sealed public abstract class Wpisywanie permits Dom, Mieszkanie{
    private String ulica;
    private int numerDomu;
    private String miejscowosc;
    private String kodPocztowy;
    private float powierzchnia;
    private float cena;
    private LocalDate dataOferty;

    public Wpisywanie(){

    }
    public Wpisywanie(String ulica, int numerDomu, String miejscowosc, String kodPocztowy, float powierzchnia, float cena, LocalDate dataOferty){
        this.ulica = ulica;
        this.numerDomu = numerDomu;
        this.miejscowosc = miejscowosc;
        this.kodPocztowy = kodPocztowy;
        this.powierzchnia = powierzchnia;
        this.cena = cena;
        this.dataOferty = dataOferty;
    }

    @Override
    public String toString() {
        return String.format("Ulica: %s, Numer domu: %s, Miejscowosc: %s, Powierzchnia: %s, Kod Pocztowy: %s, Cena: %s, Data Oferty: %s",
                ulica, numerDomu, miejscowosc, powierzchnia, kodPocztowy, cena, dataOferty);
    }
    public float getCena() {
        return cena;
    }

    public float getPowierzchnia() {
        return powierzchnia;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public int getNumerDomu() {
        return numerDomu;
    }

    public String getUlica() {
        return ulica;
    }

    public LocalDate getDataOferty() {
        return dataOferty;
    }
}