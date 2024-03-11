package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;


public class SpielerTest {

    private Spieler spieler;
    private Schachtel schachtel;

    @Before
    public void setUp() {
        schachtel = new Schachtel();
        spieler = new Spieler(schachtel);
    }

    @Test
    @DisplayName("Teste nehmen Methode für korrekte Anzahl von Holzstücken")
    public void testSpielerNehmen() {
        schachtel.setAnzahlHoelzer(5);
        assertEquals(0, spieler.nehmen(3));
        assertEquals(2, schachtel.getAnzahlHoelzer());
    }

    @Test
    @DisplayName("Teste nehmen Methode für zu viele Holzstücke")
    public void testSpielerNehmenZuVieleHolzstuecke() {
        schachtel.setAnzahlHoelzer(2);
        assertEquals(2, spieler.nehmen(3));
        assertEquals(2, schachtel.getAnzahlHoelzer());
    }

    @Test
    @DisplayName("Teste nehmen Methode für ungültige Anzahl von Holzstücken")
    public void testSpielerNehmenUngueltigeAnzahl() {
        assertEquals(1, spieler.nehmen(0));
        assertEquals(1, spieler.nehmen(4));
    }

    @Test
    @DisplayName("Teste setName und getName Methoden")
    public void testSetNameGetName() {
        String expectedName = "TestSpieler";
        spieler.setName(expectedName);
        assertEquals(expectedName, spieler.getName());
    }

    @Test
    @DisplayName("Teste Spielerkonstruktor mit Schachtel und Name")
    public void testSpielerKonstruktorMitSchachtelUndName() {
        String expectedName = "TestSpieler";
        Spieler spielerMitName = new Spieler(schachtel, expectedName);
        assertEquals(schachtel, spielerMitName.getSchachtel());
        assertEquals(expectedName, spielerMitName.getName());
    }

    @Test
    @DisplayName("Teste Spielerkonstruktor mit Schachtel ohne Name")
    public void testSpielerKonstruktorMitSchachtelOhneName() {
        Spieler spielerOhneName = new Spieler(schachtel);
        assertEquals(schachtel, spielerOhneName.getSchachtel());
        assertEquals("", spielerOhneName.getName());
    }

    @Test
    @DisplayName("Teste Spielerkonstruktor ohne Schachtel")
    public void testSpielerKonstruktorOhneSchachtel() {
        Spieler spielerOhneSchachtel = new Spieler(null);
        assertEquals(null, spielerOhneSchachtel.getSchachtel());
    }

    @Test
    @DisplayName("Teste Spielerkonstruktor ohne Namen")
    public void testSpielerKonstruktorOhneName() {
        Spieler spielerOhneName = new Spieler(schachtel);
        assertEquals("", spielerOhneName.getName());
    }

    @Test
    @DisplayName("Teste Spielerkonstruktor mit leeren Namen")
    public void testSpielerKonstruktorMitLeeremName() {
        Spieler spielerMitLeeremName = new Spieler(schachtel, "");
        assertEquals("", spielerMitLeeremName.getName());
    }
}