package Uebung_7;

import Uebung_5.Folge;
import Uebung_5.FolgeMitDynArray;

import java.util.Comparator;

public class Suchbaum <T> {
    private Knoten wurzel;
    private Comparator<T> comparator;

    /**
     * Interne Klasse für die Knoten eines Baumes
     */
    class Knoten {
        //Wert der im Knoten gespeichert ist
        T value;
        //linker & rechter Folgeknoten
        Knoten l, r = null;

        /**
         * Konstruktor für den Knoten
         * @param value Wert der gespeichert wird
         */
        Knoten(T value) {
            this.value = value;
        }
    }

    /**
     * Quasi Nutzloser Konstruktor
     */
    public Suchbaum() {
        wurzel = null;
    }
    public Suchbaum(Comparator<T> c) {
        wurzel = null;
        comparator = c;
    }

    /**
     * Gibt an, ob der Baum leer ist
     * @return true falls Wurzel null, false sonst
     */
    public boolean isEmpty() {
        return wurzel == null;
    }

    /**
     * Fügt einen Wert an richtiger Stelle in den Baum hinzu
     * @param i Wert der eingefügt wird
     */
    public void insert(T i) {
        //Falls die Wurzel noch nicht existiert
        //wird ein neuer Knoten als Wurzel angelegt
        if (wurzel == null)
            wurzel = new Knoten(i);
        else
            //Aufruf der rekursiven Hilfsfunktion
            insert(i, wurzel);
    }

    /**
     * Private rekursive Hilfsfunktion zum Einfügen
     * @param i Eingefügter Wert
     * @param k Aktueller Knoten
     */
    private void insert(T i, Knoten k) {
        int compareValue;
        //Falls ein Komparator vorhanden ist
        if (comparator != null) {
            compareValue = comparator.compare(i, k.value);
        } else {
            compareValue = comp(i, k.value);
        }
        //falls der Wert schon vorhanden ist, wird er nicht eingefügt
        if (compareValue == 0)
            return;
            //sollte der Wert kleiner als der aktuelle sein
            //wird er links eingefügt
        else if (compareValue < 0) {
            //falls links noch kein Knoten ist,
            //wird ein neuer mit dem Wert erzeugt
            if (k.l == null)
                k.l = new Knoten(i);
            else
                //sollte schon einer da sein,
                //dann wird rekursiv vom linken
                //folgeknoten aus fortgeführt
                insert(i, k.l);
            //sollte der Wert größer als der aktuelle sein
            //wird er rechts eingefügt
        } else if (compareValue > 0) {
            //falls rechts noch kein Knoten ist,
            //wird ein neuer erzeugt
            if (k.r == null)
                k.r = new Knoten(i);
                //sollte noch schon einer da sein,
                //dann wird rekursiv vom rechten
                //folgeknoten aus fortgeführt
            else
                insert(i, k.r);
        }
    }

    /**
     * Vergleicht zwei Objekte ohne Comparator
     * @param a Erstes Element
     * @param b Zweites Element (a - b bestimmt den Rückgabewert)
     * @return 0,falls a=b, <0, falls b<a, >0,falls b>a
     */
    @SuppressWarnings("unchecked")
    private int comp(T a, T b) {
        Comparable<T> cb = (Comparable<T>) b;
        return cb.compareTo(a);
    }

    /**
     * Gibt an, ob der Wert im Baum vorhanden ist
     * @param i Zu überprüfender Wert
     * @return true falls vorhanden, false sonst
     */
    public boolean contains(T i) {
        //Bezug von i zur Wurzel
        int compareValue = 0;
        //Sollte kein Comparator vorhanden sein
        if (comparator == null)
            compareValue = comp(i, wurzel.value);
        //Sollte ein Comparator vorhanden sein
        else
            compareValue = comparator.compare(i, wurzel.value);
        //Falls der Baum leer ist, kann das Element nicht vorhanden sein
        if (isEmpty())
            return false;
        //sollte der gesuchte Wert direkt in der Wurzel sein
        else if (compareValue == 0)
            return true;
            //Aufruf der rekursiven Hilfsfunktion
        else
            return contains(i, wurzel);
    }

    /**
     * Private rekursive Hilfsfunktion zum Suchen
     * @param i zu suchender Wert
     * @param k aktueller Knoten
     * @return true falls vorhanden, false sonst
     */
    private boolean contains(T i, Knoten k) {
        int compareValue;
        if (comparator == null)
            compareValue = comp(i, k.value);
        else
            compareValue = comparator.compare(i, k.value);
        //sollte der Knoten nicht da sein
        //wird false zurückgegeben
        if (k == null)
            return false;
            //Falls im Knoten der gesuchte Wert
            //i gespeichert ist, wird true
            //zurückgegeben
        else if (compareValue == 0)
            return true;
            //sollte der gesuchte Wert kleiner als
            //der im aktuelle Knoten sein
            //wird rekursiv mit dem linken
            //Folgeknoten fortgeführt
        else if (compareValue < 0)
            return contains(i, k.l);
            //sollte der gesuchte Wert größer als
            //der im aktuelle Knoten sein
            //wird rekursiv mit dem rechten
            //Folgeknoten fortgeführt
        else if (compareValue > 0)
            return contains(i, k.r);
        //sollte es niemals gefunden werden
        //wird false zurückgegeben
        return false;
    }

    /**
     * Gibt den Baum als String zurück
     * @return Baum als String
     */
    public String toString() {
        String s;
        s = toString(wurzel);
        return s;
    }

    /**
     * Private rekursive Hilfsmethode zur Stringausgabe
     * @param k Aktueller Knoten
     * @return Baum in String Form
     */
    private String toString(Knoten k) {
        String s = "(";
        if (k == null)
            return "";
        if (k.l != null)
            s += toString(k.l);
        if (k != null) {
            s += k.value;
        }

        if (k.r != null)
            s += toString(k.r);
        s += ")";

        return s;
    }

    /**
     * Gibt die Anzahl der Knoten an
     * @return Anzahl belegter Knoten
     */
    public int size() {
        //falls der Baum leer sein sollte ist die size 0
        if (isEmpty())
            return 0;
            //Aufruf der Hilfsfunktion
            //1 (Wurzel) + rekursiv links + rekursiv rechts
        else
            return 1 + size(wurzel.l) + size(wurzel.r);
    }

    /**
     * Private rekursive Hilfsmethode zum Bestimmen der Größe
     * @param k aktueller Knoten
     * @return Größe des Baumes
     */
    private int size(Knoten k) {
        //sollte der Knoten nicht vorhanden sein wird eine 0 zurückgegeben
        if (k == null)
            return 0;
            //addieren von 1 (aktueller Knoten) und Rekursion mit linkem
            //und rechten Teilbäumen
        else
            return 1 + size(k.l) + size(k.r);
    }

    /**
     * Bestimmt die Höhe des Baumes
     * @return Maximum der vertikal aufeinanderfolgenden Knoten
     */
    public int hoehe() {
        if (isEmpty())
            return 0;
        else
            return hoehe(wurzel) + 1;
    }

    /**
     * Private rekursive Hilfsmethode zum bestimmen der Höhe
     * @param k Aktueller Knoten
     * @return Höhe des Baumes
     */
    private int hoehe(Knoten k) {
        //initialisieren der Höhen mit 0
        int l = 0;
        int r = 0;

        //sollte der linke Knoten vorhanden sein wird mit
        //dem linken Baum fortgeführt
        if (k.l != null)
            //+1 zum Erhöhen des Wertes, (hoehe(k.l) rekursiver Aufruf)
            l = hoehe(k.l) + 1;
        if (k.r != null)
            //sollte der rechte Knoten vorhanden sein wird mit
            //dem rechten Baum fortgeführt
            r = hoehe(k.r) + 1;
        //maximum der beiden Teilbaumhöhen gibt die gesamte Höhe des Baumes an
        return Math.max(l, r);
    }

    /**
     * Gibt den Baum preorder traversiert zurück
     * @return Preorder traversierten Baum
     */
    public String preorder() {
        return "Preorder: " + traverse(wurzel, "preorder").toString();
    }


    /**
     * Gibt den Baum inorder traversiert zurück
     * @return Inorder traversierter Baum
     */
    public String inorder() {
        return "Inorder: " + traverse(wurzel, "inorder").toString();
    }


    /**
     * Gibt den Baum postorder traversiert zurück
     * @return Postorder traversierter Baum
     */
    public String postorder() {
        return "Postorder: " + traverse(wurzel, "postorder").toString();
    }

    /**
     * Traversiert den Baum
     * @param k Aktueller Knoten
     * @param art Art der Traversierung
     * @return Traversierter Baum als Folge
     */
    private Folge<T> traverse(Knoten k, String art) {
        //Anlegen einer Folge
        Folge<T> s = new FolgeMitDynArray<>();
        //Sollte der Knoten leer sein wird mit return zurückgegangen
        if (k == null)
            return s;

        //Je nach Art des Traversierens wird anders angefügt
        switch (art) {
            //Sollte preorder traversiert werden
            case "preorder":
                //Der Wert wird zuerst eingefügt
                s.insert(k.value);
                //Anschließend der linke Knoten
                s.append(traverse(k.l, "preorder"));
                //Und dann der rechte Knoten
                s.append(traverse(k.r, "preorder"));
                break;

            //Sollte Inorder traversiert werden
            case "inorder":
                //Zuerst wird der linke Knoten behandelt
                s.append(traverse(k.l, "inorder"));
                //Dann der Wert eingefügt
                s.insert(k.value);
                //Und dann der rechte Knoten
                s.append(traverse(k.r, "inorder"));
                break;

            //Sollte es postorder sein
            case "postorder":
                //Dann wird zuerst der linke Teilbaum
                s.append(traverse(k.l, "postorder"));
                //Dann der rechte
                s.append(traverse(k.r, "postorder"));
                //Und dann der Wert eingefügt
                s.insert(k.value);
                break;
        }
        //Rückgabe der Folge
        return s;
    }

    /**
     * Führt eine Breitensuche durch
     * @return Queue der Breitensuche
     */
    public String breitensuche() {
        return "Breitensuche: " + breitensuche(wurzel).toString();
    }

    /**
     * Rekursive Methode für die Breitensuche
     * @param k Aktueller Knoten
     * @return Queue der Breitensuche
     */
    private Folge<T> breitensuche(Knoten k) {
        //Anlegen der Queue
        Folge<T> queue = new FolgeMitDynArray<>();
        //Sollte der Knoten nicht vorhanden sein wird zurückgegangen
        if (k == null)
            return queue;
        //Sollte der aktuelle Knoten die Wurzel sein wird der Wert eingefügt
        if (k == wurzel)
            queue.insert(k.value);
        //Sollte ein linker Knoten vorhanden sein wird der, der Queue hinzugefügt
        if (k.l != null)
            queue.insert(k.l.value);
        //Sollte ein rechter Knoten vorhanden sein wird der, der Queue hinzugefügt
        if (k.r != null)
            queue.insert(k.r.value);

        //Mit dem linken Teilbaum anfangen
        queue.append(breitensuche(k.l));
        //Mit dem rechten Teilbaum weitermachen
        queue.append(breitensuche(k.r));

        //Rückgabe der Queue
        return queue;
    }

    /**
     * Entfernt den Knoten im Baum mit gewünschtem Wert
     * @param i Wert der gelöscht wird
     */
    public void remove(T i) {
        remove(wurzel, wurzel, i);
    }


    /**
     * Private Hilfsmethode zum Entfernen des Knotens
     * @param k aktueller Knoten
     * @param i Gesuchter Wert zum Entfernen
     */
    private void remove(Knoten p, Knoten k, T i) {
        if (k == null)
            return;
        else if (comparator.compare(i, k.value) < 0) { //cmp(i, k.value) < 0
            //System.out.println("Nächster: " + k.l.value);
            remove(k, k.l, i);
        }
        else if (comparator.compare(i, k.value) > 0)
            remove(k, k.r, i);
        else if (comparator.compare(i, k.value) == 0){
            //Sollte der Knoten keine Kinder haben wird
            //dieser einfach gelöscht
            if (k.l == null && k.r == null)
                if (p.l == k)
                    p.l = null;
                else
                    p.r = null;
                //Sollte nur der linke Knoten vorhanden sein
                //wird der aktuelle Knoten zum Kindknoten (somit gelöscht)
            else if (k.l != null && k.r == null) {
                if (p.l == k)
                    p.l = k.l;
                else
                    p.r = k.l;
            }

            //Sollte nur der rechte Knoten vorhanden sein
            //wird der aktuelle Knoten zum Kindknoten (somit gelöscht)
            else if (k.r != null && k.l == null) {
                if (p.l == k)
                    p.l = k.r;
                else
                    p.r = k.r;
            }
            //Sollten beide Knoten vorhanden sein wird der kleinste
            //Knoten (der größer ist) genommen, und wird mit dem
            // gefundenen Knoten getauscht
            else if (k.l != null && k.r != null){
                // Der Knoten hat zwei Kinder
                Knoten successorParent = k;
                Knoten successor = k.r;

                while (successor.l != null) {
                    successorParent = successor;
                    successor = successor.l;
                }

                k.value = successor.value;

                if (successorParent.l == successor) {
                    successorParent.l = successor.r;
                } else {
                    successorParent.r = successor.r;
                }
            }
        } else {
            return;
        }
    }

}
