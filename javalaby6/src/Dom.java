import java.time.LocalDate;

non-sealed public class Dom extends Wpisywanie {
    private float powierzchniaDzialki;
    public Dom(){

    }
    public Dom(String ulica, int numerDomu, String miejscowosc, String kodPocztowy, float powierzchnia, float cena, LocalDate dataOferty, float powierzchniaDzialki){
        super(ulica,numerDomu,miejscowosc,kodPocztowy,powierzchnia,cena,dataOferty);
        this.powierzchniaDzialki = powierzchniaDzialki;
    }
    public float getPowierzchniaDzialki() {
        return powierzchniaDzialki;
    }
    @Override
    public String toString() {
        return String.format("%s, Powierzchnia dzialki: %s",
                super.toString(), powierzchniaDzialki);
    }
}