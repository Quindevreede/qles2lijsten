package nl.novi.quin;

import java.util.ArrayList;
import java.util.List;

public class GeheimeCode {

    public static void main(String[] secret) {

        List<String> laResistanceMembers = new ArrayList<>();

        laResistanceMembers = addMembers(laResistanceMembers, "Arie");
        laResistanceMembers = addMembers(laResistanceMembers, "Sjaak");
        laResistanceMembers = addMembers(laResistanceMembers, "Henrie");
        laResistanceMembers = addMembers(laResistanceMembers, "Piet");
        laResistanceMembers = addMembers(laResistanceMembers, "LeDroitCestMoi");
        laResistanceMembers = addMembers(laResistanceMembers, "aaa");

        //System.out.println(laResistanceMembers);
        /* als ik hier de println zou gebruiken print ie
        laResistanceMembers zonder encryptie uit
         */

        System.out.println("Encrypted list:");
        for (String s : encryptList(laResistanceMembers)) {
            System.out.println(s);
        }
    }

    /*
        Hieronder zijn via de methode addMembers, leden aan de lijst toegevoegd.
        De Methode is zo aan dat er alleen unieke namen in voor mogen komen.
        */
    // 01 deze maak je eerst
    private static List<String> addMembers(List<String> members, String name) {
        boolean isUnique = true;
        for (String member : members) {
            if (name.equalsIgnoreCase(member)) {
                isUnique = false;
                break;
            }
        }
        if (isUnique) {
            members.add(name);
        }
        return members;
    }

       /*
        Opdracht 2: La Resistance wil niet dat de lijst met namen zo in handen komt te vallen van de bezetter. Versleutel
        Maak een methode die de lijst op de volgende manier versleuteld:
        // https://stackoverflow.com/questions/2451650/how-do-i-apply-the-for-each-loop-to-every-character-in-a-string
        a) Verander elke letter naar het nummer in het alfabet. Voeg na elke veranderde letter een - toe
        (behalve de laatste). Dus a wordt 1, b wordt 2 et cetera.
        Wanneer een letter een hoofdletter is, moet je beginnen met tellen bij 100. Dus A wordt 101, B wordt 102.
        Voorbeeld: Alex wordt versleuteld naar: 101-12-5-24
        // https://www.tutorialspoint.com/java/lang/character_isuppercase.htm#:~:text=isUpperCase(char%20ch)%20determines%20if,category%20type%2C%20provided%20by%20Character.
        b) Als de positie in de lijst een even getal is, dan moet de cijfercombinatie omgedraaid worden.
        // https://beginnersbook.com/2014/02/java-program-to-check-even-or-odd-number/
         */


    /*
    Hieronder wordt een methode encryptList gemaakt.
    Eerst wordt het LIST object encryptedList gemaakt
    daarna worden de members van la Resistance toegevoegd
    en met de methode encryptName gecodeerd bij het
    encryptedList object toegevoegd. (.add)
     */
    // 02 deze maak je als tweede

    private static List<String> encryptList(List<String> members) {
        List<String> encryptedList = new ArrayList<>();

        for (String member : members) {
            encryptedList.add(encryptName(member));
        }

        /*
        We zijn nog steeds in de encryptList methode hieronder:
        Als de positie in de lijst een even getal is, dan moet de cijfercombinatie omgedraaid worden.
        Hieronder verandert de setter van encryptedList met behulp van methode reverseEncryptedName()
        als de positie van de naam op een even getal staat (0,3,4,6)
         */
        for (int i = 0; i < encryptedList.size(); i++) {
            if (i % 2 == 0) {
                encryptedList.set(i, reverseEncryptedName(encryptedList.get(i)));
            }
        }
       /* Als je de encryptList methode gebruikt krijg je door stukje code
          hieronder dus het object encryptedList terug waarin er dus
          aanpassingen zijn gedaan aan de "members".
        */
        return encryptedList;
    }

    /* In de methode encryptName hieronder wordt het
       object encryptedNameBuilder gemaakt. Het is een
       StringBuilder object waar je tekst mee aan elkaar
       kan plakken (we hebben number naar String omgezet
       in de charToNumber methode. Er wordt door de naam
       heen ge-loopt en een nieuwe String variabele
       aangemaakt die de charToNumber methode gebruikt
       om elke letter in de naam te 'encrypten' dus
       die elke character van de String name omvormt
       in een nummer en die weer omvormt naar een String.
       Het OBJECT encryptedNameBuilder zet vervolgens
       deze String nummers weer naast elkaar.
       Als het einde van een naam (-1) bereikt is
       zet het OBJECT encryptedNameBuilder een - erachter.
       ( encryptedNameBuilder.append("-"); )
       Hij returned de achterelkaar gezette cijferstring
       van de encryptedNameBuilder.
    */
    // 04 deze maak je als vierde
    private static String encryptName(String name) {
        StringBuilder encryptedNameBuilder = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            String number = charToNumber(name.charAt(i));
            encryptedNameBuilder.append(number);
            if (i < name.length() - 1) {
                encryptedNameBuilder.append("-");
            }
        }
        return encryptedNameBuilder.toString();
    }

    /*
     Hieronder staat de methode om String (de namen die
     nu bestaan uit cijfers) achterstevoren te zetten.
     - reverseEncryotedName
     Eerst bepaal het einde van de cijfers met de splitString
     de "-". Vervolgens worden de cijfercombinaties gespiegeld met de
     splitStringReversed object en een loop. Als laatste zit er in
     de RETURN een String.join methode om de cijfercombinaties aan
     elkaar te lijmen met een "-".
     */
    // 05 deze maak je als vijfde
    private static String reverseEncryptedName(String encryptedName) {
        String[] splitString = encryptedName.split("-");

        String[] splitStringReversed = new String[splitString.length];

        for (int i = 0; i < splitString.length; i++) {
            splitStringReversed[splitString.length - 1 - i] = splitString[i];
        }

        return String.join("-", splitStringReversed);
    }

    /* Hieronder wordt een methode aangemaakt die characters
       omvormt naar nummers en van deze nummers weer String maakt.
       -Hij wordt pas bij encryptName gebruikt-
       eerst zal de methode de letters(char) omzetten naar nummers (int)
       eerst naar lowercase letters, deze worden als variable
       tempchar opgeslagen daarna wordt 'a'  er van afgetrokken
       dat betekend - 0 en er wordt een int number bij opgeteld
       dus nu is bijv a(=0)-a(=0) + 1 = 1
                   of e(=4) - a(=0) + 1 = 5
       Als het een hoofdletter was wordt bij het nummer 100 opgeteld
       dus A wordt 101 en E wordt 105
       Als deze methode wordt gebruikt krijg je number terug
       die naar een String is omgezet (geen int meer)
    */
    // 03 deze maak je als derde

    private static String charToNumber(char ch) {

        char tempchar = Character.toLowerCase(ch);
        int number = tempchar - 'a' + 1;

        if (Character.isUpperCase(ch)) {
            number = number + 100;
        }
        return Integer.toString(number);
    }

    /*
            Hieronder komt de methode die de versleutelde
            lijst kan omzetten naar de ontsleutelde lijst.
             */

}
