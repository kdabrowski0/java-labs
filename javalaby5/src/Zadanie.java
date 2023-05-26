import java.time.LocalTime;

non-sealed public class Zadanie extends Wpisywanie{
    private Status status;
    public Zadanie(String opis, LocalTime czasPoczatku, LocalTime czasZakonczenia, Status status){
        super(opis, czasPoczatku, czasZakonczenia);
        this.status = status;
    }
    public Status getStatus(){ return status; }
    public enum Status{
        PLANOWANE,
        POTWIERDZONE,
        REALIZOWANE,
        WYKONANE
    }

    @Override
    public String toString() {
        return "status: %s".formatted(status);
    }
}
