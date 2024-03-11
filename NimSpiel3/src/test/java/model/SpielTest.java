package model;

import org.junit.jupiter.api.BeforeEach;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.*;

public class SpielTest {

    private Spiel spiel;

    @BeforeEach
    public void setUp() {
        spiel = new Spiel();
    }

    @Test
    @DisplayName("Teste waechselAktuellenSpieler Methode")
    public void testWaechselAktuellenSpieler() {
        Spieler aktuellerSpieler = spiel.getAktuellerSpieler();
        Spieler andererSpieler = (aktuellerSpieler.equals(spiel.getSpieler())) ? spiel.getSpieler2() : spiel.getSpieler();
        spiel.waechselAktuellenSpieler(aktuellerSpieler);
        assertThat(spiel.getAktuellerSpieler()).isEqualTo(andererSpieler);
    }

    @Test
    @DisplayName("Teste befuelle Methode in Schachtel Klasse")
    public void testBefuelle() {
        Schachtel schachtel = new Schachtel();
        assertThat(schachtel.befuelle(20)).isEqualTo(0);
        assertThat(schachtel.befuelle(50)).isEqualTo(1);
    }

    @Test
    @DisplayName("Teste nehmen Methode in Spieler Klasse")
    public void testSpielerNehmen() {
        Spieler spieler = new Spieler(new Schachtel());
        spieler.getSchachtel().setAnzahlHoelzer(5);
        assertThat(spieler.nehmen(3)).isEqualTo(0);
        assertThat(spieler.nehmen(5)).isEqualTo(1);
        assertThat(spieler.nehmen(2)).isEqualTo(2);
    }

    @Test
    @DisplayName("Teste nehmen Methode in Computerd Klasse")
    public void testComputerdNehmen() {
        Schachtel schachtel = new Schachtel();
        schachtel.setAnzahlHoelzer(5);
        Spieler computerspieler = new Computerd(schachtel);
        ((Computerd) computerspieler).nehmen();
        int restHoelzer = schachtel.getAnzahlHoelzer();
        assertThat(restHoelzer).isBetween(1, 3);
    }

    @Test
    @DisplayName("Teste istBeendet Methode")
    public void testIstBeendet() {
        Schachtel schachtel = new Schachtel();
        schachtel.setAnzahlHoelzer(0);
        assertThat(spiel.istBeendet()).isTrue();
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
}