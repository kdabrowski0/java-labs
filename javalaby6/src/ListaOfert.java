import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Predicate;

public class ListaOfert {
    private ArrayList<Wpisywanie> listaOfert= new ArrayList<Wpisywanie>();

    public ListaOfert(){
    }

    public void dodajOferte(String ulica, int numerDomu, String miejscowosc, String kodPocztowy, float powierzchnia, float cena, LocalDate dataOferty, int numerMieszkania, int numerPietra){
        Mieszkanie mieszkanie= new Mieszkanie(ulica, numerDomu, miejscowosc, kodPocztowy, powierzchnia, cena, dataOferty, numerMieszkania, numerPietra);
        listaOfert.add(mieszkanie);
    }

    public void dodajOferte(String ulica, int numerDomu, String miejscowosc, String kodPocztowy, float powierzchnia, float cena, LocalDate dataOferty, float powierzchniaDzialki){
        Dom dom= new Dom(ulica, numerDomu, miejscowosc, kodPocztowy, powierzchnia, cena, dataOferty, powierzchniaDzialki);
        listaOfert.add(dom);
    }

    public ArrayList<Wpisywanie> getListaOftert(Predicate<Wpisywanie> test){
        ArrayList<Wpisywanie> lista= new ArrayList<Wpisywanie>();
        for(Wpisywanie wpis: listaOfert){
            if(test.test(wpis)){
                lista.add(wpis);
            }
        }
        return lista;
    }
}