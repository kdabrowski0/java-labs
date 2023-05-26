import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    static Scanner scanner= new Scanner(System.in);
    static ListaOfert listaOfert= new ListaOfert();
    public static void menu(){
        System.out.println("Wybierz opcję od 1-7:");
        System.out.println("1. Dodaj oferte domu");
        System.out.println("2. Dodaj oferte mieszkania");
        System.out.println("3. Wyszukanie wszystkich aktualnych ofert domów");
        System.out.println("4. Wyszukanie wszystkich aktualnych ofert mieszkań");
        System.out.println("5. Wyświetl wszystkie oferty sprzedaż domów, w podanej miejscowosci o powierzchni nie mniejszej niz podana wartosc");
        System.out.println("6. Wyświetl wszystkie oferty sprzedaż mieszkań, w podanej miejscowosci, nie drozszych niz podana wartosc i od podanego piętra wzwyż");
        System.out.println("7. Zakończ program");
    }
    public static void main(String[] args) throws Exception {
        int choice = 0;
        System.out.println("Program służący do obsługi kalendarza tygodniowego spotkań");
        while (choice != 7) {
            menu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1 -> dodajOferteDomu();
                case 2 -> dodajOferteMieszkania();
                case 3 -> wyszukajOfertyDomow();
                case 4 -> wyszukajOfertyMieszkan();
                case 5 -> wyszukajOfertyDomowFiltr();
                case 6 -> wyszukajOfertyMieszkanFiltr();
                case 7 -> System.out.println("Zakończyłeś program");
                default -> System.out.println("Nie ma takiej opcji w menu");
            }
        }
    }

    private static void dodajOferteDomu() {
        System.out.println("Podaj ulice: ");
        String ulica= scanner.nextLine();
        System.out.println("Podaj numer domu: ");
        int nrDomu= scanner.nextInt();
        System.out.println("Podaj miejscowosc: ");
        scanner.nextLine();
        String miejscowosc= scanner.nextLine();
        System.out.println("Podaj kod pocztowy: ");
        String kodPocztowy= scanner.nextLine();
        System.out.println("Podaj powierzchnie domu: ");
        float powierzchnia= scanner.nextFloat();
        System.out.println("Podaj cene: ");
        float cena= scanner.nextFloat();
        System.out.println("Podaj powierzchnie dzialki: ");
        float powierzchniaDzialki= scanner.nextFloat();
        System.out.println("Podaj date obowiazywania w formacie YYYY-MM-DD: ");
        scanner.nextLine();
        String dataObowiazywaniaString= scanner.nextLine();
        LocalDate dataObowiazywania= LocalDate.parse(dataObowiazywaniaString);
        listaOfert.dodajOferte(ulica, nrDomu, miejscowosc, kodPocztowy, powierzchnia, cena, dataObowiazywania, powierzchniaDzialki);
    }

    private static void dodajOferteMieszkania() {
        System.out.println("Podaj ulice: ");
        String ulica= scanner.nextLine();
        System.out.println("Podaj numer domu: ");
        int nrDomu= scanner.nextInt();
        System.out.println("Podaj miejscowosc: ");
        scanner.nextLine();
        String miejscowosc= scanner.nextLine();
        System.out.println("Podaj kod pocztowy: ");
        String kodPocztowy= scanner.nextLine();
        System.out.println("Podaj powierzchnie domu: ");
        float powierzchnia= scanner.nextFloat();
        System.out.println("Podaj cene: ");
        float cena= scanner.nextFloat();
        System.out.println("Podaj date obowiazywania w formacie YYYY-MM-DD: ");
        scanner.nextLine();
        String dataObowiazywaniaString= scanner.nextLine();
        LocalDate dataObowiazywania= LocalDate.parse(dataObowiazywaniaString);
        System.out.println("Podaj pietro: ");
        int pietro= scanner.nextInt();
        System.out.println("Podaj numer Mieszkania: ");
        int nrMieszkania= scanner.nextInt();
        listaOfert.dodajOferte(ulica, nrDomu, miejscowosc, kodPocztowy, powierzchnia, cena, dataObowiazywania, nrMieszkania, pietro);
    }

    private static void wyszukajOfertyDomow() {
        Predicate<Wpisywanie> filtr= lokal -> lokal instanceof Dom && ((lokal.getDataOferty().isBefore(LocalDate.now())) || (lokal.getDataOferty().isEqual(LocalDate.now())));
        ArrayList<Wpisywanie> listaOfertfiltr= listaOfert.getListaOftert(filtr);
        wypiszListeOfert(listaOfertfiltr);
    }

    private static void wyszukajOfertyMieszkan() {
        Predicate<Wpisywanie> filtr= lokal -> lokal instanceof Mieszkanie && ((lokal.getDataOferty().isBefore(LocalDate.now())) || (lokal.getDataOferty().isEqual(LocalDate.now())));
        ArrayList<Wpisywanie> listaOfertfiltr= listaOfert.getListaOftert(filtr);
        wypiszListeOfert(listaOfertfiltr);
    }

    private static void wyszukajOfertyDomowFiltr() {
        System.out.println("Podaj miejscowosc");
        String miejscowosc= scanner.nextLine();
        System.out.println("Powierzchnia nie miejsza niz: ");
        float powierzchniaMin= scanner.nextFloat();
        Predicate<Wpisywanie> filtr= lokal -> lokal instanceof Dom && (lokal.getDataOferty().isBefore(LocalDate.now()) || lokal.getDataOferty().isEqual(LocalDate.now())) && lokal.getMiejscowosc().equals(miejscowosc) && lokal.getPowierzchnia()>=powierzchniaMin;
        ArrayList<Wpisywanie> listaOfertfiltr= listaOfert.getListaOftert(filtr);
        wypiszListeOfert(listaOfertfiltr);
    }

    private static void wyszukajOfertyMieszkanFiltr() {
        System.out.println("Podaj miejscowosc: ");
        String miejscowosc= scanner.nextLine();
        System.out.println("Nie drozsze niz: ");
        float cenaMax= scanner.nextFloat();
        System.out.println("Od ktorego pietra: ");
        int pietroMin= scanner.nextInt();
        Predicate<Wpisywanie> filtr= lokal -> lokal instanceof Mieszkanie && (lokal.getDataOferty().isBefore(LocalDate.now()) || lokal.getDataOferty().isEqual(LocalDate.now())) && lokal.getMiejscowosc().equals(miejscowosc) && lokal.getCena()<=cenaMax && ((Mieszkanie)lokal).getNumerPietra()>=pietroMin;
        ArrayList<Wpisywanie> listaOfertfiltr= listaOfert.getListaOftert(filtr);
        wypiszListeOfert(listaOfertfiltr);
    }

    private static void wypiszListeOfert(ArrayList<Wpisywanie> listaOfert) {
        for(Wpisywanie wpis: listaOfert){
            System.out.println(wpis.toString());
        }
    }

}