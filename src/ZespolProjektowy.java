import java.util.ArrayList;

public class ZespolProjektowy {
    private String nazwaProjektu;
    private ArrayList<Pracownik> pracownicy;

    public ZespolProjektowy(String nazwaProjektu) {
        this.nazwaProjektu = nazwaProjektu;
        this.pracownicy = new ArrayList<>();
    }

    public String getNazwaProjektu() {
        return nazwaProjektu;
    }

    public void dodajPracownika(Pracownik pracownik) {
        pracownicy.add(pracownik);
    }

    public void wypiszSkladZespolu() {
        System.out.println("=== Skład zespołu projektu: " + nazwaProjektu + " ===");
        for (Pracownik p : pracownicy) {
            System.out.println("- " + p.przedstawSie()
                    + " Koszt miesięczny: " + p.obliczKosztMiesieczny() + " PLN");
        }
        System.out.println("=======================================");
    }

    public double policzLacznyKoszt() {
        double suma = 0.0;
        for (Pracownik p : pracownicy) {
            suma += p.obliczKosztMiesieczny();
        }
        return suma;
    }

    public Pracownik znajdzPoId(String idPracownika) {
        for (Pracownik p : pracownicy) {
            if (p.pobierzIdPracownika().equals(idPracownika)) {
                return p;
            }
        }
        return null;
    }

    public void wypiszProgramistow() {
        System.out.println("--- Programiści w zespole ---");
        for (Pracownik p : pracownicy) {
            if (p instanceof Programista) {
                Programista programista = (Programista) p;
                System.out.println(" * " + programista.getImie() + " " + programista.getNazwisko()
                        + " - " + programista.getGlownyJezyk());
            }
        }
    }

    public void wypiszTesterowAutomatyzujacych() {
        System.out.println("--- Testerzy automatyzujący ---");
        for (Pracownik p : pracownicy) {
            if (p instanceof Tester) {
                Tester tester = (Tester) p;
                if (tester.isCzyAutomatyzujacy()) {
                    System.out.println(" * " + tester.getImie() + " " + tester.getNazwisko()
                            + " (scenariuszy: " + tester.getLiczbaScenariuszy() + ")");
                }
            }
        }
    }
}
