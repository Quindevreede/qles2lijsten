package nl.novi.quin;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Hieronder volgt de lijst :

public class ListOefeningQ {
    public static void main(String[] args) {
        List<String> muppetsNames = new ArrayList<>();
        muppetsNames.add("Kermit the Frog");
        muppetsNames.add("Miss Piggy");
        muppetsNames.add("Gonzo");
        muppetsNames.add("Fozzy Bear");
        muppetsNames.add("Rowlf the Dog");
        muppetsNames.add("Scooter");
        muppetsNames.add("Swedish Chef");

        // Hieronder volgt de methode om de lijst per regel weer te geven :

        printList(muppetsNames);

        // Hieronder volgt de methode om bovenstaande methode weer te geven met INDEX :

        printListWithIndex(muppetsNames);

        /* Hieronder volgt de methode die checkt of een naam er al IN DE LIJST ZIT
         en als dit niet het geval is deze TOEVOEGD : (ALs je hieronder bijvoorbeeld
         KERMIT the FROG invult komt deze niet in de lijst te staan, ook omdat in de
         methode ignoreUpperCase gebruikt wordt.)
        */

        addMuppet(muppetsNames, "Sam the Eagle");

        // Hieronder volgt een methode die de POSITIE van de Muppet weergeeft :

        int position = positionInList(muppetsNames, "Sam the Eagle");

        // Hieronder volgt een methode die de lijst ALFABETISCH SORTEERT
        // Wanneer 'Gonzo" niet op POSITIE 1 staat moeten eerdere
        // muppetsNames verwijderd worden zodat dit wel het geval is.

        muppetsNames.add("Animal");
        muppetsNames.add("Beaker");
        muppetsNames.add("Dr. Teeth");

    //  printListWithIndex(muppetsNames);
        /*als ik deze code
         zou activeren zouden Animal Beaker en Dr. Teeth ook
         in de lijst komen maar nog niet op alfabetische volgorde
        */

        sortListAndGonzoFirst(muppetsNames);
        System.out.println("List after sorting and Gonzo first : ");
        printListWithIndex(muppetsNames);

        // Hieronder volgt een methode die de lijst ALFABETISCH SORTEERT
        // Wanneer 'Swedish Chef" niet op LAATSTE POSITIE staat moeten latere
        // muppetsNames verwijderd worden zodat dit wel het geval is.

        muppetsNames.add("Sweetums");
        muppetsNames.add("Rizzo");
        muppetsNames.add("Waldorf and Statler");

        System.out.println("Swedish Chef last : ");
        muppetsNames = sortListAndSwedishChefLast(muppetsNames);
        System.out.println("List after sorting and Swedish Chef last : ");
        printListWithIndex(muppetsNames);

    }

    // Hieronder volgen de daadwerkelijke Methods waarvan we eerder
    // hadden opgezet. Dit is de eerste (printList)

    public static void printList(List<String> theMuppets) {
        System.out.println("The MUPPETS in the list : ");
        for (String muppet : theMuppets) {
            System.out.println(muppet);
        }
    }
    // Dit is de tweede (printListWithIndex)
    // Hieronder heb ik in plaats van i 'mIndex' gebruikt

    public static void printListWithIndex(List<String> theMuppets) {
        System.out.println("MUPPETS in list with position : ");
        for (int mIndex = 0; mIndex < theMuppets.size(); mIndex++) {
            System.out.println(mIndex + " : " + theMuppets.get(mIndex));
        }
    }

    // Dit is de methode om een Muppet toe te voegen

    public static void addMuppet(List<String> theMuppets, String name) {
        if (isUnique(theMuppets, name)) {
            theMuppets.add(name);
        }
    }

    /* Dit is de Methode om de lijst te doorlopen en
     te kijken of de toegevoegde Muppet al
     in de lijst stond deze wordt dan als 'false'
     teruggegeven,zo niet als 'true'(let op de Scope)
     In dit geval is de BOOLEAN dus TRUE want er staan geen dubbele namen
    */

    public static boolean isUnique(List<String> theMuppets, String name) {
        for (String muppet : theMuppets) {
            if (muppet.equalsIgnoreCase(name)) {
                return false;
            }
        }
        return true;
    }

    /* De isUnique in de methode hieronder is eigenlijk een extra check.
       Als uit de methode hierboven (boolean isUnique) dus uitkomt
       dat de naam in de lijst uniek (niet dubbel) is, wordt deze als
       FALSE gezien, omdat ! (LOGICAL NOT operator), ervoor zorgt dat
       de uitkomst omgedraaid wordt. Dus deze eerste IF doet iets met
       dubbele namen...
       // Logical Not kan ook zo:
       // if (isUnique(theMuppets, name) == false)
     */
    public static int positionInList(List<String> theMuppets, String name) {
        if (!isUnique(theMuppets, name)) {
            for (int mIndex = 0; mIndex < theMuppets.size(); mIndex++) {
                if (name.equalsIgnoreCase(theMuppets.get(mIndex))) {
                    return mIndex;
                }
            }
        }
        return -1;
    }

    public static void sortListAndGonzoFirst(List<String> theMuppets) {
        Collections.sort(theMuppets);

        while (positionInList(theMuppets, "Gonzo") != 0) {
            theMuppets.remove(0);
        }
    }

    public static List<String> sortListAndSwedishChefLast(List<String> theMuppets) {
        Collections.sort(theMuppets);
        //System.out.println("Pos Swedish Chef : " + positionInList(theMuppets, "Swedish Chef"));

        int indexSwedishChef = positionInList(theMuppets, "Swedish Chef");
        System.out.println("index Swedish Chef : " + indexSwedishChef);

        List<String> tempList = new ArrayList<>();

        for (int mIndex = 0; mIndex < theMuppets.size(); mIndex++) {
            if (mIndex <= indexSwedishChef) {
                tempList.add(theMuppets.get(mIndex));
            }
        }
        return tempList;
    }
}


