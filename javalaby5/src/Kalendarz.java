import java.time.LocalTime;
import java.util.ArrayList;
import java.util.function.Predicate;
public class Kalendarz {
    private ArrayList<ArrayList<Wpisywanie>> dni = new ArrayList<ArrayList<Wpisywanie>>();
    public Kalendarz() {
        this(7);
    }

    public Kalendarz(Integer liczbaDni) {
        while (this.dni.size() < liczbaDni) {
            this.dni.add(new ArrayList<Wpisywanie>());
        }
    }

    public void add(Integer nrDnia, String opis, LocalTime poczatek, LocalTime koniec, Spotkanie.Priorytet priorytet) throws Exception {
        Spotkanie spotkanie = new Spotkanie(opis, poczatek, koniec, priorytet);
        dni.get(nrDnia).add(spotkanie);
    }

    public void add(Integer nrDnia, String opis, LocalTime poczatek, LocalTime koniec, Zadanie.Status status) throws Exception {
        Zadanie zadanie = new Zadanie(opis, poczatek, koniec, status);
        dni.get(nrDnia).add(zadanie);
    }

    public void remove(Integer nrDnia, Wpisywanie wpisDoUsuniecia){
        dni.get(nrDnia).remove(wpisDoUsuniecia);
    }

    public ArrayList<Wpisywanie> getWpisy(Integer dzien, Predicate<Wpisywanie> warunek){
        ArrayList<Wpisywanie> wpisDnia=dni.get(dzien);
        ArrayList<Wpisywanie> wpisFiltrowane = new ArrayList<Wpisywanie>();
        for (Wpisywanie wpis : wpisDnia) {
            if(warunek.test(wpis)){
                wpisFiltrowane.add(wpis);
            }
        }
        return wpisFiltrowane;
    }
}