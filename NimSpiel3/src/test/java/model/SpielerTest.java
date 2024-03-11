package model;


import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.*;

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
        assertThat(spieler.nehmen(3)).isEqualTo(0);
        assertThat(schachtel.getAnzahlHoelzer()).isEqualTo(2);
    }

    @Test
    @DisplayName("Teste nehmen Methode für zu viele Holzstücke")
    public void testSpielerNehmenZuVieleHolzstuecke() {
        schachtel.setAnzahlHoelzer(2);
        assertThat(spieler.nehmen(3)).isEqualTo(2);
        assertThat(schachtel.getAnzahlHoelzer()).isEqualTo(2);
    }

    @Test
    @DisplayName("Teste nehmen Methode für ungültige Anzahl von Holzstücken")
    public void testSpielerNehmenUngueltigeAnzahl() {
        assertThat(spieler.nehmen(0)).isEqualTo(1);
        assertThat(spieler.nehmen(4)).isEqualTo(1);
    }

    @Test
    @DisplayName("Teste setName und getName Methoden")
    public void testSetNameGetName() {
        String expectedName = "TestSpieler";
        spieler.setName(expectedName);
        assertThat(spieler.getName()).isEqualTo(expectedName);
    }

    @Test
    @DisplayName("Teste Spielerkonstruktor mit Schachtel und Name")
    public void testSpielerKonstruktorMitSchachtelUndName() {
        String expectedName = "TestSpieler";
        Spieler spielerMitName = new Spieler(schachtel, expectedName);
        assertThat(spielerMitName.getSchachtel()).isEqualTo(schachtel);
        assertThat(spielerMitName.getName()).isEqualTo(expectedName);
    }

    @Test
    @DisplayName("Teste Spielerkonstruktor mit Schachtel ohne Name")
    public void testSpielerKonstruktorMitSchachtelOhneName() {
        Spieler spielerOhneName = new Spieler(schachtel);
        assertThat(spielerOhneName.getSchachtel()).isEqualTo(schachtel);
        assertThat(spielerOhneName.getName()).isEmpty();
    }

    @Test
    @DisplayName("Teste Spielerkonstruktor ohne Schachtel")
    public void testSpielerKonstruktorOhneSchachtel() {
        Spieler spielerOhneSchachtel = new Spieler(null);
        assertThat(spielerOhneSchachtel.getSchachtel()).isNull();
    }

    @Test
    @DisplayName("Teste Spielerkonstruktor ohne Namen")
    public void testSpielerKonstruktorOhneName() {
        Spieler spielerOhneName = new Spieler(schachtel);
        assertThat(spielerOhneName.getName()).isEmpty();
    }

    @Test
    @DisplayName("Teste Spielerkonstruktor mit leeren Namen")
    public void testSpielerKonstruktorMitLeeremName() {
        Spieler spielerMitLeeremName = new Spieler(schachtel, "");
        assertThat(spielerMitLeeremName.getName()).isEmpty();
    }
}