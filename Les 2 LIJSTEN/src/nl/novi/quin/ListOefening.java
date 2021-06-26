package nl.novi.quin;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListOefening {

    public static void main(String[] uitlegList) {

        //We hebben een list die de namen van voetbalclubs bevat
        List<String> clubNames = new ArrayList<>();
        //Die vullen we alvast voor de opdracht
        clubNames.add("Ajax");
        clubNames.add("PSV");
        clubNames.add("Feyenoord");
        clubNames.add("Fc Utrecht");
        clubNames.add("Fc Groningen");
        clubNames.add("FC Twente");

        // Vraag -1: Maak een methode die als taak heeft om de list per regel uit te printen.
        printList(clubNames);

        // Vraag 0: Maak een methode die als taak heeft om de list uit te printen: positie + inhoud.
        // Bovenstaande list zou dan dit zijn:
        // 0 - Ajax
        // 1 - PSv
        // etc...
        printListWithIndex(clubNames);

        // Vraag 1: Maak een methode die checkt of een club al in de lijst zit en voeg deze anders toe.
        addClub(clubNames, "DOSC");

        // Vraag 2: Maak een methode die de positie van de club in de lijst teruggeeft.
        int position = positionInList(clubNames, "DOSC");

        // Vraag 3: Maak een methode die de lijst alfabetisch sorteert. Wanneer Ajax niet op positie 1 staat, moeten de
        // clubs die voor Ajax staan verwijderd worden.
        // We voegen nog wat clubs toe om de code te kunnen testen.
        clubNames.add("AA Aachen");
        clubNames.add("AFC Amsterdam");
        clubNames.add("AFC");

        sortListAndAjaxFirst(clubNames);
        System.out.println("List after sorting and Ajax first:");
        printListWithIndex(clubNames);


        // Vraag 4: Kun je hetzelfde doen als hierboven, maar PSV moet dan laatste zijn.
        clubNames.add("Zlotty FC");
        clubNames.add("SC Eindhoven");

        System.out.println("PSV last: ");
        clubNames = sortListAndPsvLast(clubNames);
        System.out.println("List after sorting and PSV Last:");
        printListWithIndex(clubNames);

    }

    public static void printList(List<String> clubs) {
        System.out.println("The clubs in the list: ");
        for (String club : clubs) {
            System.out.println(club);
        }
    }

    public static void printListWithIndex(List<String> clubs) {
        System.out.println("Clubs in list with position: ");
        for (int i = 0; i < clubs.size(); i++) {
            System.out.println(i + " : " + clubs.get(i));
        }
    }

    public static void addClub(List<String> clubs, String name) {
        if (isUnique(clubs, name)) {
            clubs.add(name);
        }
    }

    public static boolean isUnique(List<String> clubs, String name) {
        for (String club : clubs) {
            if (club.equalsIgnoreCase(name)) {
                return false;
            }
        }
        return true;
    }

    public static int positionInList(List<String> clubs, String name) {
        if (!isUnique(clubs, name)) {
            for (int i = 0; i < clubs.size(); i++) {
                if (name.equalsIgnoreCase(clubs.get(i))) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void sortListAndAjaxFirst(List<String> clubs) {
        Collections.sort(clubs);

        while (positionInList(clubs, "Ajax") != 0) {
            clubs.remove(0);
        }
    }

    public static List<String> sortListAndPsvLast(List<String> clubs) {
        Collections.sort(clubs);

        //System.out.println("Pos psv: " + positionInList(clubs, "psv"));

        int indexPsv = positionInList(clubs, "psv");
        System.out.println("index PSV: " + indexPsv);

        List<String> tempList = new ArrayList<>();

        for (int i = 0; i < clubs.size(); i++) {
            if (i <= indexPsv) {
                tempList.add(clubs.get(i));
            }
        }
        return tempList;
    }
}
