import java.time.LocalTime;
sealed public abstract class Wpisywanie permits Spotkanie, Zadanie {
    private String opis;
    private LocalTime czasPoczatku;
    private LocalTime czasZakonczenia;
    public static final LocalTime POCZATEK_SPOTKANIA = LocalTime.of(8,0);

    public Wpisywanie(){

    }
    public Wpisywanie(String opis, LocalTime czasPoczatku, LocalTime czasZakonczenia){
        this.opis = opis;
        this.czasPoczatku = czasPoczatku;
        this.czasZakonczenia = czasZakonczenia;
    }
    public abstract String toString();

    @Override
    public String toString(){
        return "opis: %s, poczatek: %s, koniec: %s, %s".formatted(this.getOpis(), this.getPoczatek(), this.getKoniec(), toString());
    };

    public String getOpis(){
        return this.opis;
    }

    public LocalTime getPoczatek(){
        return this.czasPoczatku;
    }

    public LocalTime getKoniec(){
        return this.czasZakonczenia;
    }

}
