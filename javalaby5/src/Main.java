import java.time.LocalTime;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.function.Predicate;
public class Main {
    public static void dodanieSpotkania(Kalendarz kalendarz, Scanner scanner) throws Exception {
        System.out.println("Podaj dzien spotkania które chcesz dodać (liczbe od 1): ");
        int dzien = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj opis spotkania: ");
        String opis = scanner.nextLine();
        System.out.println("Podaj godzinę rozpoczęcia spotkania : ");
        int gb = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj minutę rozpoczęcia spotkania : ");
        int mb = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj godzinę zakonczenia spotkania : ");
        int ge = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj minutę zakonczenia spotkania : ");
        int me = scanner.nextInt();
        scanner.nextLine();
        if(ge < gb) {
            throw new IllegalArgumentException("Czas zakończenia spotkania jest przed godziną rozpoczęcia spotkania!");
        }
        LocalTime czasRozpoczecia = LocalTime.of(gb,mb);
        LocalTime czasZakonczenia = LocalTime.of(ge,me);
        if(czasRozpoczecia.isBefore(Spotkanie.POCZATEK_SPOTKANIA)){
            throw new IllegalArgumentException("Czas początku spotkania jest przed godziną rozpoczęcia spotkań!");
        }
        System.out.println("Podaj priorytet spotkania(1(NISKI),2(SREDNI),3(WYSOKI)): ");
        int prior = scanner.nextInt();
        Spotkanie.Priorytet myPrior = Spotkanie.Priorytet.NISKI;
        if(prior == 1){
            myPrior = Spotkanie.Priorytet.NISKI;
        }else if (prior == 2){
            myPrior = Spotkanie.Priorytet.SREDNI;
        } else if (prior == 3){
            myPrior = Spotkanie.Priorytet.WYSOKI;
        } else {
            System.out.println("Podałeś złą wartosc");
        }
        scanner.nextLine();
        kalendarz.add(dzien-1, opis, czasRozpoczecia, czasZakonczenia, myPrior);
    }
    public static void dodanieZadanie(Kalendarz kalendarz, Scanner scanner) throws Exception {
        System.out.println("Podaj dzien zadania które chcesz dodać (liczbe od 1): ");
        int dzien = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj opis zadania: ");
        String opis = scanner.nextLine();
        System.out.println("Podaj godzinę rozpoczęcia zadania : ");
        int gb = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj minutę rozpoczęcia zadania : ");
        int mb = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj godzinę zakonczenia zadania : ");
        int ge = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj minutę zakonczenia zadania : ");
        int me = scanner.nextInt();
        scanner.nextLine();
        if(ge < gb) {
            throw new IllegalArgumentException("Czas zakończenia zadania jest przed godziną rozpoczęcia zadania!");
        }
        LocalTime czasRozpoczecia = LocalTime.of(gb,mb);
        LocalTime czasZakonczenia = LocalTime.of(ge,me);
        if(czasRozpoczecia.isBefore(Spotkanie.POCZATEK_SPOTKANIA)){
            throw new IllegalArgumentException("Czas początku spotkania jest przed godziną rozpoczęcia zadań!");
        }
        System.out.println("Podaj status zadania(1(PLANOWANE),2(POTWIERDZONE),3(REALIZOWANE),4(WYKONANE)): ");
        int prior = scanner.nextInt();
        Zadanie.Status myStatus = Zadanie.Status.PLANOWANE;
        if(prior == 1){
            myStatus = Zadanie.Status.PLANOWANE;
        }else if (prior == 2){
            myStatus = Zadanie.Status.POTWIERDZONE;
        } else if (prior == 3){
            myStatus = Zadanie.Status.REALIZOWANE;
        }else if (prior == 4){
            myStatus = Zadanie.Status.WYKONANE;
        } else {
            System.out.println("Podałeś złą wartosc");
        }
        scanner.nextLine();
        kalendarz.add(dzien-1, opis, czasRozpoczecia, czasZakonczenia, myStatus);
    }
    public static void usunSpotkanie(Kalendarz kalendarz, Scanner scanner) throws Exception {
        System.out.println("z ktorego dnia (od 1)");
        Integer dzien = scanner.nextInt();
        Predicate<Wpisywanie> warunek = s -> s instanceof Spotkanie;
        ArrayList<Wpisywanie> spotkania = kalendarz.getWpisy(dzien-1, warunek);
        wypiszSpotkania(spotkania);
        System.out.println("podaj index (od 0):");
        int index = scanner.nextInt();
        kalendarz.remove(dzien-1, spotkania.get(index));
    }
    public static void usunZadanie(Kalendarz kalendarz, Scanner scanner) throws Exception {
        System.out.println("z ktorego dnia (od 1)");
        Integer dzien = scanner.nextInt();
        Predicate<Wpisywanie> warunek = s -> s instanceof Spotkanie;
        ArrayList<Wpisywanie> zadania = kalendarz.getWpisy(dzien-1, warunek);
        wypiszSpotkania(zadania);
        System.out.println("podaj index (od 0):");
        int index = scanner.nextInt();
        kalendarz.remove(dzien-1, zadania.get(index));
    }

    public static void wyswietlSpotkaniaWDniu(Kalendarz kalendarz, Scanner scanner) {
        System.out.println("z ktorego dnia (od 1):");
        Integer dzien = scanner.nextInt();
        Predicate<Wpisywanie> warunek = s -> s instanceof Spotkanie;
        ArrayList<Wpisywanie> spotkania = kalendarz.getWpisy(dzien-1, warunek);
        wypiszSpotkania(spotkania);
    }
    public static void wyswietlZadaniaWDniu(Kalendarz kalendarz, Scanner scanner) {
        System.out.println("z ktorego dnia (od 1):");
        Integer dzien = scanner.nextInt();
        Predicate<Wpisywanie> warunek = s -> s instanceof Zadanie;
        ArrayList<Wpisywanie> zadania = kalendarz.getWpisy(dzien-1, warunek);
        wypiszSpotkania(zadania);
    }
    public static void wyswietlSpotkaniaPriorytet(Kalendarz kalendarz, Scanner scanner){
        System.out.println("z ktorego dnia (od 1):");
        Integer dzien = scanner.nextInt();
        System.out.println("Podaj priorytet: ");
        Spotkanie.Priorytet priorytetSpotkania = Spotkanie.Priorytet.valueOf(scanner.next().toUpperCase());
        Predicate<Wpisywanie> warunek = s -> s instanceof Spotkanie && ((Spotkanie) s).getPriorytet() == priorytetSpotkania;
        ArrayList<Wpisywanie> spotkania = kalendarz.getWpisy(dzien-1, warunek);
        wypiszSpotkania(spotkania);
    }
    public static void wyswietlZadaniaStatus(Kalendarz kalendarz, Scanner scanner){
        System.out.println("z ktorego dnia (od 1):");
        Integer dzien = scanner.nextInt();
        System.out.println("Podaj status: ");
        Zadanie.Status statusZadania = Zadanie.Status.valueOf(scanner.next().toUpperCase());
        Predicate<Wpisywanie> warunek = s -> s instanceof Zadanie && ((Zadanie) s).getStatus() == statusZadania;
        ArrayList<Wpisywanie> zadania = kalendarz.getWpisy(dzien-1, warunek);
        wypiszSpotkania(zadania);
    }
    public static void wyswietlSpotkaniaDniaCzas(Kalendarz kalendarz, Scanner scanner) throws Exception {
        System.out.println("z ktorego dnia (od 1):");
        Integer dzien = scanner.nextInt();
        System.out.println("Od ktorej godziny: ");
        String poczatek = scanner.next();
        LocalTime czas = LocalTime.parse(poczatek);
        Predicate<Wpisywanie> warunek = s -> s instanceof Spotkanie && s.getPoczatek().isAfter(czas) || s.getPoczatek().equals(czas);
        ArrayList<Wpisywanie> spotkania = kalendarz.getWpisy(dzien-1, warunek);
        wypiszSpotkania(spotkania);
    }

    public static void wyswietlSpotkaniaDniaPoczatekKoniec(Kalendarz kalendarz, Scanner scanner) throws Exception {
        System.out.println("z ktorego dnia (od 1):");
        Integer dzien = scanner.nextInt();
        System.out.println("Od ktorej godziny: ");
        String poczatek = scanner.next();
        LocalTime czasPoczatek = LocalTime.parse(poczatek);
        System.out.println("Do ktorej godziny: ");
        String koniec = scanner.next();
        LocalTime czasKoniec = LocalTime.parse(koniec);
        Predicate<Wpisywanie> warunek = s -> s instanceof Spotkanie && ((s.getPoczatek().isAfter(czasPoczatek) || s.getPoczatek().equals(czasPoczatek)) && (s.getPoczatek().isBefore(czasKoniec) || s.getPoczatek().equals(czasKoniec)));
        ArrayList<Wpisywanie> spotkania = kalendarz.getWpisy(dzien-1, warunek);
        wypiszSpotkania(spotkania);
    }

    public static void wyswietlSpotkaniaDniaCzasPriorytet(Kalendarz kalendarz, Scanner scanner) throws Exception {
        System.out.println("z ktorego dnia (od 1):");
        Integer dzien = scanner.nextInt();
        System.out.println("Podaj priorytet: ");
        Spotkanie.Priorytet priorytetSpotkania = Spotkanie.Priorytet.valueOf(scanner.next().toUpperCase());
        System.out.println("Od ktorej godziny: ");
        int poczatekG = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Od ktorej minuty: ");
        int poczatekM = scanner.nextInt();
        scanner.nextLine();
        LocalTime czasPoczatek = LocalTime.of(poczatekG,poczatekM);
        Predicate<Wpisywanie> warunek = s -> s instanceof Spotkanie && ((s.getPoczatek().isAfter(czasPoczatek) || s.getPoczatek().equals(czasPoczatek)) && (((Spotkanie) s).getPriorytet()==priorytetSpotkania));
        ArrayList<Wpisywanie> spotkania = kalendarz.getWpisy(dzien-1, warunek);
        wypiszSpotkania(spotkania);
    }
    public static void wyswietlZadaniaDniaCzasStatus(Kalendarz kalendarz, Scanner scanner) throws Exception {
        System.out.println("z ktorego dnia (od 1):");
        Integer dzien = scanner.nextInt();
        System.out.println("Podaj status: ");
        Zadanie.Status statusZadania = Zadanie.Status.valueOf(scanner.next().toUpperCase());
        System.out.println("Od ktorej godziny: ");
        int koniecG = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Od ktorej minuty: ");
        int koniecM = scanner.nextInt();
        scanner.nextLine();
        LocalTime czasKoniec = LocalTime.of(koniecG,koniecG);
        Predicate<Wpisywanie> warunek = s -> s instanceof Zadanie && ((s.getKoniec().isBefore(czasKoniec) || s.getKoniec().equals(czasKoniec)) && (((Zadanie) s).getStatus()==statusZadania));
        ArrayList<Wpisywanie> spotkania = kalendarz.getWpisy(dzien-1, warunek);
        wypiszSpotkania(spotkania);
    }
    public static void wypiszSpotkania(ArrayList<Wpisywanie> wpisy){
        for (Wpisywanie wpis : wpisy) {
            System.out.println(wpis);
        }
    }
    public static void menu(){
        System.out.println("Wybierz opcję od 1-11:");
        System.out.println("1. Dodaj nowe spotkanie na wybrany dzien");
        System.out.println("2. Dodaj nowe zadanie na wybrany dzien ");
        System.out.println("3. Usun spotkanie z danego dnia");
        System.out.println("4. Usun zadanie z danego dnia");
        System.out.println("5. Wyświetl wszystkie spotkania w wybranym dniu");
        System.out.println("6. Wyświetl wszystkie zadania w wybranym dniu");
        System.out.println("7. Wyświetl wszystkie spotkania o danym priorytecie");
        System.out.println("8. Wyświetl wszystkie zadania o danym statusie");
        System.out.println("9. Wyświetl wszystkie spotkania o wybranym priorytecie i od podanego czasu");
        System.out.println("10. Wyświetl wszystkie zadania w danym dniu i konczonce sie pozniej do podanego czasu");
        System.out.println("11. Zakoncz program");
    }
    public static void main(String[] args) throws Exception {
        Kalendarz kalendarz = new Kalendarz();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        System.out.println("Program służący do obsługi kalendarza tygodniowego spotkań");
        while (choice != 11) {
            menu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1 -> dodanieSpotkania(kalendarz, scanner);
                case 2 -> dodanieZadanie(kalendarz, scanner);
                case 3 -> usunSpotkanie(kalendarz, scanner);
                case 4 -> usunZadanie(kalendarz, scanner);
                case 5 -> wyswietlSpotkaniaWDniu(kalendarz, scanner);
                case 6 -> wyswietlZadaniaWDniu(kalendarz, scanner);
                case 7 -> wyswietlSpotkaniaPriorytet(kalendarz, scanner);
                case 8 -> wyswietlZadaniaStatus(kalendarz, scanner);
                case 9 -> wyswietlSpotkaniaDniaCzasPriorytet(kalendarz, scanner);
                case 10 -> wyswietlZadaniaDniaCzasStatus(kalendarz, scanner);
                case 11 -> System.out.println("Zakończyłeś program");
                default -> System.out.println("Wybrałeś złą liczbę. Wybierz liczbę od 1-11");
            }
        }
    }
}