package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.DisplayName;


public class SchachtelTest {

    private Schachtel schachtel;

    @Before
    public void setUp() {
        schachtel = new Schachtel();
    }

    @Test
    @DisplayName("Teste befuelle Methode für korrekte Anzahl von Holzstücken")
    public void testBefuelleKorrekteAnzahl() {
        assertEquals(0, schachtel.befuelle(20));
        assertEquals(20, schachtel.getAnzahlHoelzer());
    }

    @Test
    @DisplayName("Teste befuelle Methode für zu viele Holzstücke")
    public void testBefuelleZuVieleHolzstuecke() {
        assertEquals(1, schachtel.befuelle(50));
        assertEquals(0, schachtel.getAnzahlHoelzer()); // Die Anzahl der Holzstücke sollte unverändert bleiben
    }

    @Test
    @DisplayName("Teste befuelle Methode für zu wenige Holzstücke")
    public void testBefuelleZuWenigeHolzstuecke() {
        assertEquals(1, schachtel.befuelle(5));
        assertEquals(0, schachtel.getAnzahlHoelzer()); // Die Anzahl der Holzstücke sollte unverändert bleiben
    }

    @Test
    @DisplayName("Teste setAnzahlHoelzer und getAnzahlHoelzer Methoden")
    public void testSetGetAnzahlHoelzer() {
        schachtel.setAnzahlHoelzer(10);
        assertEquals(10, schachtel.getAnzahlHoelzer());
    }

    @Test
    @DisplayName("Teste befuelle Methode für korrekte Rückgabewerte")
    public void testBefuelleRueckgabewerte() {
        assertEquals(0, schachtel.befuelle(20)); // Erfolgreich befüllt
        assertEquals(1, schachtel.befuelle(50)); // Zu viele Holzstücke
        assertEquals(1, schachtel.befuelle(5)); // Zu wenige Holzstücke
    }

    @Test
    @DisplayName("Teste print Methode")
    public void testPrint() {
        schachtel.setAnzahlHoelzer(15);
        // Da print nur die Anzahl der Holzstücke ausgibt, können wir die Konsolenausgabe nicht direkt testen.
        // Wir können jedoch die print-Methode aufrufen und sicherstellen, dass sie ohne Fehler ausgeführt wird.
        schachtel.print();
    }

}