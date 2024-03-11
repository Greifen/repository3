package model;


import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class ComputerdTest {

    private Schachtel schachtel;
    private Computerd computerd;

    @Before
    public void setUp() {
        schachtel = new Schachtel();
        computerd = new Computerd(schachtel);
    }

    @Test
    @DisplayName("Teste nehmen Methode für korrekte Anzahl von Holzstücken")
    public void testComputerdNehmen() {
        schachtel.setAnzahlHoelzer(5);
        computerd.nehmen();
        int restHoelzer = schachtel.getAnzahlHoelzer();
        assertThat(restHoelzer).isBetween(1, 3);
    }
    
    @Test
    @DisplayName("Teste nehmen Methode für leere Schachtel")
    public void testComputerdNehmenLeereSchachtel() {
        schachtel.setAnzahlHoelzer(0);
        computerd.nehmen();
        assertThat(schachtel.getAnzahlHoelzer()).isEqualTo(0);
    }

}