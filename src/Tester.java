public class Tester extends Pracownik {
    private boolean czyAutomatyzujacy;
    private int liczbaScenariuszy;

    private static final double DODATEK_ZA_AUTOMATYZACJE = 1200.0;
    private static final double STAWKA_ZA_SCENARIUSZ = 20.0;

    public Tester(String idPracownika, String imie, String nazwisko, double stawkaBazowa,
                  boolean czyAutomatyzujacy, int liczbaScenariuszy) {
        super(idPracownika, imie, nazwisko, stawkaBazowa);
        this.czyAutomatyzujacy = czyAutomatyzujacy;
        this.liczbaScenariuszy = liczbaScenariuszy;
    }

    public boolean isCzyAutomatyzujacy() {
        return czyAutomatyzujacy;
    }

    public int getLiczbaScenariuszy() {
        return liczbaScenariuszy;
    }

    @Override
    public double obliczKosztMiesieczny() {
        double koszt = super.obliczKosztMiesieczny() + liczbaScenariuszy * STAWKA_ZA_SCENARIUSZ;
        if (czyAutomatyzujacy) {
            koszt += DODATEK_ZA_AUTOMATYZACJE;
        }
        return koszt;
    }

    @Override
    public String przedstawSie() {
        String rola = czyAutomatyzujacy ? "testerem automatyzującym" : "testerem manualnym";
        return super.przedstawSie()
                + " Jestem " + rola
                + " i mam przygotowane " + liczbaScenariuszy + " scenariuszy testowych.";
    }

    public void uruchomRaportTestow() {
        System.out.println("Raport testera " + getImie() + " " + getNazwisko() + ":");
        System.out.println(" - liczba scenariuszy: " + liczbaScenariuszy);
        System.out.println(" - automatyzacja: " + (czyAutomatyzujacy ? "TAK" : "NIE"));
    }

    @Override
    public String toString() {
        return "Tester{" +
                "id='" + pobierzIdPracownika() + '\'' +
                ", imie='" + getImie() + '\'' +
                ", nazwisko='" + getNazwisko() + '\'' +
                ", stawkaBazowa=" + getStawkaBazowa() +
                ", czyAutomatyzujacy=" + czyAutomatyzujacy +
                ", liczbaScenariuszy=" + liczbaScenariuszy +
                '}';
    }
}
