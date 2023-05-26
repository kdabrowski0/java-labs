import java.time.LocalTime;
non-sealed public class Spotkanie extends Wpisywanie {
    private Priorytet priorytet;
    public Spotkanie(){

    }
    public Spotkanie(String opis, LocalTime czasPoczatku, LocalTime czasZakonczenia, Priorytet priorytet) throws Exception{
        super(opis, czasPoczatku, czasZakonczenia);
        this.priorytet = priorytet;
    }
    public Priorytet getPriorytet(){
        return priorytet;
    }
    public enum Priorytet{
        NISKI,
        SREDNI,
        WYSOKI
    }
    @Override
    public String toString() {
        return "priorytet: %s".formatted(priorytet);
    }

}
