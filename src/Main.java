public class Main {
    public static void main(String[] args) {
        ZespolProjektowy zespol = new ZespolProjektowy("Campus App");

        Pracownik p1 = new Programista("E-101", "Anna", "Maj", 12000.0, "Java", 4);
        Pracownik p2 = new Tester("E-201", "Piotr", "Lis", 9800.0, true, 25);
        Pracownik p3 = new Programista("E-102", "Karol", "Wojcik", 11500.0, "Kotlin", 3);
        Pracownik p4 = new Tester("E-202", "Magdalena", "Nowak", 8500.0, false, 18);

        zespol.dodajPracownika(p1);
        zespol.dodajPracownika(p2);
        zespol.dodajPracownika(p3);
        zespol.dodajPracownika(p4);

        zespol.wypiszSkladZespolu();
        System.out.println("Łączny koszt zespołu: " + zespol.policzLacznyKoszt() + " PLN");
        System.out.println();

        System.out.println(">>> Polimorficzne wywołanie przedstawSie() <<<");
        System.out.println(p1.przedstawSie());
        System.out.println(p2.przedstawSie());
        System.out.println(p3.przedstawSie());
        System.out.println(p4.przedstawSie());
        System.out.println();

        System.out.println(">>> Bezpieczne rzutowanie z instanceof <<<");
        if (p1 instanceof Programista) {
            Programista programista = (Programista) p1;
            programista.wypiszTechnologie();
        }
        if (p2 instanceof Tester) {
            Tester tester = (Tester) p2;
            tester.uruchomRaportTestow();
        }
        System.out.println();

        zespol.wypiszProgramistow();
        zespol.wypiszTesterowAutomatyzujacych();
        System.out.println();

        System.out.println(">>> Wyszukiwanie po ID <<<");
        Pracownik znaleziony = zespol.znajdzPoId("E-102");
        if (znaleziony != null) {
            System.out.println("Znaleziono: " + znaleziony.przedstawSie());
        }
        System.out.println();

        System.out.println(">>> Porównanie przez equals() <<<");
        Pracownik duplikatPiotra = new Tester("E-201", "Inne", "Dane", 9000.0, false, 10);
        System.out.println("p2.equals(duplikatPiotra) -> " + p2.equals(duplikatPiotra));
        System.out.println("p1.equals(p3)             -> " + p1.equals(p3));
        System.out.println();

        System.out.println(">>> toString() obiektów <<<");
        System.out.println(p1);
        System.out.println(p2);
    }
}
