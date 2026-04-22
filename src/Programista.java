public class Programista extends Pracownik {
    private String glownyJezyk;
    private int liczbaRepozytoriow;

    private static final double BONUS_ZA_REPOZYTORIUM = 150.0;

    public Programista(String idPracownika, String imie, String nazwisko, double stawkaBazowa,
                       String glownyJezyk, int liczbaRepozytoriow) {
        super(idPracownika, imie, nazwisko, stawkaBazowa);
        this.glownyJezyk = glownyJezyk;
        this.liczbaRepozytoriow = liczbaRepozytoriow;
    }

    public String getGlownyJezyk() {
        return glownyJezyk;
    }

    public int getLiczbaRepozytoriow() {
        return liczbaRepozytoriow;
    }

    @Override
    public double obliczKosztMiesieczny() {
        return super.obliczKosztMiesieczny() + liczbaRepozytoriow * BONUS_ZA_REPOZYTORIUM;
    }

    @Override
    public String przedstawSie() {
        return super.przedstawSie()
                + " Jestem programistą piszącym głównie w języku " + glownyJezyk
                + " i opiekuję się " + liczbaRepozytoriow + " repozytoriami.";
    }

    public void wypiszTechnologie() {
        System.out.println("Programista " + getImie() + " " + getNazwisko()
                + " pracuje w technologii: " + glownyJezyk
                + " (repozytoria: " + liczbaRepozytoriow + ").");
    }

    @Override
    public String toString() {
        return "Programista{" +
                "id='" + pobierzIdPracownika() + '\'' +
                ", imie='" + getImie() + '\'' +
                ", nazwisko='" + getNazwisko() + '\'' +
                ", stawkaBazowa=" + getStawkaBazowa() +
                ", glownyJezyk='" + glownyJezyk + '\'' +
                ", liczbaRepozytoriow=" + liczbaRepozytoriow +
                '}';
    }
}
