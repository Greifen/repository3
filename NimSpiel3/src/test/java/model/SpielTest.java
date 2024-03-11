package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import model.Schachtel;
import model.Spieler;
import model.Spiel;

public class SpielTest {

    private Spiel spiel;

    @Before
    public void setUp() {
        spiel = new Spiel();
    }

    @Test
    @DisplayName("Teste waechselAktuellenSpieler Methode")
    public void testWaechselAktuellenSpieler() {
        Spieler aktuellerSpieler = spiel.getAktuellerSpieler();
        Spieler andererSpieler;
        if (aktuellerSpieler.equals(spiel.getSpieler())) {
            andererSpieler = spiel.getSpieler2();
        } else {
            andererSpieler = spiel.getSpieler();
        }

        spiel.waechselAktuellenSpieler(aktuellerSpieler);
        assertEquals(andererSpieler, spiel.getAktuellerSpieler());
    }

    @Test
    @DisplayName("Teste befuelle Methode in Schachtel Klasse")
    public void testBefuelle() {
        Schachtel schachtel = new Schachtel();
        int erwartet1 = 0;
        int erwartet2 = 1;
        assertEquals(erwartet1, schachtel.befuelle(20));
        assertEquals(erwartet2, schachtel.befuelle(50));
    }

    @Test
    @DisplayName("Teste nehmen Methode in Spieler Klasse")
    public void testSpielerNehmen() {
        Spieler spieler = new Spieler(new Schachtel());
        int erwartet1 = 0;
        int erwartet2 = 1;
        int erwartet3 = 2;
        spieler.getSchachtel().setAnzahlHoelzer(5);
        assertEquals(erwartet1, spieler.nehmen(3));
        assertEquals(erwartet2, spieler.nehmen(5));
        assertEquals(erwartet3, spieler.nehmen(2));
    }

    @Test
    @DisplayName("Teste Computerd Klasse")
    public void testComputerspieler() {
        Schachtel schachtel = new Schachtel();
        schachtel.setAnzahlHoelzer(5);
        Spieler computerspieler = new Computerd(schachtel);
        ((Computerd) computerspieler).nehmen();
        int restHoelzer = schachtel.getAnzahlHoelzer();
        assertEquals(true, restHoelzer >= 1 && restHoelzer <= 3);
    }

    @Test
    @DisplayName("Teste istBeendet Methode")
    public void testIstBeendet() {
        Schachtel schachtel = new Schachtel();
        schachtel.setAnzahlHoelzer(0);
        assertTrue(spiel.istBeendet());
    }

    @Test
    @DisplayName("Teste starteKonsole Methode")
    public void testStarteKonsole() {
        // Da starteKonsole eine interaktive Methode ist, ist es schwierig automatisiert zu testen.
        // Hier können Sie entweder manuelle Tests durchführen oder eine Mocking-Bibliothek verwenden,
        // um die Eingaben und Ausgaben zu simulieren und dann zu überprüfen, ob der erwartete Zustand
        // erreicht wurde.
        // Für diesen Test könnten Sie Mockito verwenden, um den Scanner zu mocken und die Eingaben zu steuern.
    }
    
    @Test
    @DisplayName("Teste nehmen Methode in Computerd Klasse")
    public void testComputerdNehmen() {
        Schachtel schachtel = new Schachtel();
        schachtel.setAnzahlHoelzer(5);
        Spieler computerspieler = new Computerd(schachtel);
        ((Computerd) computerspieler).nehmen();
        int restHoelzer = schachtel.getAnzahlHoelzer();
        assertEquals(true, restHoelzer >= 1 && restHoelzer <= 3);
    }
    
  

}