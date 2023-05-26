import java.time.LocalDate;

non-sealed public class Mieszkanie extends Wpisywanie {
    private int numerMieszkania;
    private int numerPietra;
    public Mieszkanie(){
    }
    public Mieszkanie(String ulica, int numerDomu, String miejscowosc, String kodPocztowy, float powierzchnia, float cena, LocalDate dataOferty, int numerMieszkania, int numerPietra){
        super(ulica,numerDomu,miejscowosc,kodPocztowy,powierzchnia,cena,dataOferty);
        this.numerMieszkania = numerMieszkania;
        this.numerPietra = numerPietra;
    }


    public int getNumerMieszkania() {
        return numerMieszkania;
    }

    public int getNumerPietra() {
        return numerPietra;
    }
    @Override
    public String toString() {
        return String.format("%s, Numer piętra: %s, Numer mieszkania: %s",
                super.toString(), numerPietra, numerMieszkania);
    }
}
