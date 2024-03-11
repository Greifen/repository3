package model;


import org.junit.jupiter.api.Test;



import org.junit.Before;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.*;


public class SchachtelTest {

    private Schachtel schachtel;

    @Before
    public void setUp() {
        schachtel = new Schachtel();
    }

    @Test
    @DisplayName("Teste befuelle Methode für korrekte Anzahl von Holzstücken")
    public void testBefuelleKorrekteAnzahl() {
        assertThat(schachtel.befuelle(20)).isEqualTo(0);
        assertThat(schachtel.getAnzahlHoelzer()).isEqualTo(20);
    }

    @Test
    @DisplayName("Teste befuelle Methode für zu viele Holzstücke")
    public void testBefuelleZuVieleHolzstuecke() {
        assertThat(schachtel.befuelle(50)).isEqualTo(1); // Erwartet eine Fehlermeldung
        assertThat(schachtel.getAnzahlHoelzer()).isEqualTo(0); // Die Anzahl der Holzstücke sollte unverändert bleiben
    }

    @Test
    @DisplayName("Teste befuelle Methode für zu wenige Holzstücke")
    public void testBefuelleZuWenigeHolzstuecke() {
        assertThat(schachtel.befuelle(5)).isEqualTo(1); // Erwartet eine Fehlermeldung
        assertThat(schachtel.getAnzahlHoelzer()).isEqualTo(0); // Die Anzahl der Holzstücke sollte unverändert bleiben
    }

    @Test
    @DisplayName("Teste setAnzahlHoelzer und getAnzahlHoelzer Methoden")
    public void testSetGetAnzahlHoelzer() {
        schachtel.setAnzahlHoelzer(10);
        assertThat(schachtel.getAnzahlHoelzer()).isEqualTo(10);
    }

    @Test
    @DisplayName("Teste befuelle Methode für korrekte Rückgabewerte")
    public void testBefuelleRueckgabewerte() {
        assertThat(schachtel.befuelle(20)).isEqualTo(0); // Erfolgreich befüllt
        assertThat(schachtel.befuelle(50)).isEqualTo(1); // Zu viele Holzstücke
        assertThat(schachtel.befuelle(5)).isEqualTo(1); // Zu wenige Holzstücke
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