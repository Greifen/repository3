package model;


import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class ComputerTest {

    private Schachtel schachtel;
    private Computer computer;

    @Before
    public void setUp() {
        schachtel = new Schachtel();
        computer = new Computer(schachtel, "Computer");
    }

    @Test
    @DisplayName("Teste nehmen Methode für korrekte Anzahl von Holzstücken")
    public void testComputerdNehmen() {
        schachtel.setAnzahlHoelzer(5);
        computer.nehmen();
        int restHoelzer = schachtel.getAnzahlHoelzer();
        assertThat(restHoelzer).isBetween(1, 3);
    }
    
    @Test
    @DisplayName("Teste nehmen Methode für leere Schachtel")
    public void testComputerdNehmenLeereSchachtel() {
        schachtel.setAnzahlHoelzer(0);
        computer.nehmen();
        assertThat(schachtel.getAnzahlHoelzer()).isEqualTo(0);
    }

}