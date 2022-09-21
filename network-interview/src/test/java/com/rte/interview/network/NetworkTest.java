package com.rte.interview.network;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Joris Mancini {@literal <joris.mancini at rte-france.com>}
 */
class NetworkTest {
    private static final double TOLERANCE = 1;

    Load load1;
    Load load2;
    Load load3;
    Generator generator1;
    Generator generator2;
    Generator generator3;
    Generator generator4;
    Network network;

    @BeforeEach
    void setUp() {
        load1 = new Load(-1200);
        load2 = new Load(-50);
        load3 = new Load();

        generator1 = new Generator(2000, 150); // remains 1850
        generator2 = new Generator(150, 150); // remains 0
        generator3 = new Generator(1500, 2000, 150); // remains 500
        generator4 = new Generator(2000, 2000, 150); // remains 0
        // remains 2350

        network = new Network(Set.of(load1, load2, load3), List.of(generator1, generator2, generator3, generator4));
    }

    @Test
    void testShiftNullValue() {
        network.shift(0);

        assertEquals(-1200, load1.getP(), TOLERANCE);
        assertEquals(-50, load2.getP(), TOLERANCE);
        assertEquals(0, load3.getP(), TOLERANCE);

        assertEquals(150, generator1.getP(), TOLERANCE);
        assertEquals(150, generator2.getP(), TOLERANCE);
        assertEquals(1500, generator3.getP(), TOLERANCE);
        assertEquals(2000, generator4.getP(), TOLERANCE);
    }

    @Test
    void testShiftBelowGeneratorsCapacity() {
        network.shift(200);

        assertEquals(-1200, load1.getP(), TOLERANCE);
        assertEquals(-50, load2.getP(), TOLERANCE);
        assertEquals(0, load3.getP(), TOLERANCE);

        assertEquals(307, generator1.getP(), TOLERANCE);
        assertEquals(150, generator2.getP(), TOLERANCE);
        assertEquals(1543, generator3.getP(), TOLERANCE);
        assertEquals(2000, generator4.getP(), TOLERANCE);
    }

    @Test
    void testShiftAboveGeneratorsCapacity() {
        network.shift(200);

        assertEquals(-1200, load1.getP(), TOLERANCE);
        assertEquals(-50, load2.getP(), TOLERANCE);
        assertEquals(0, load3.getP(), TOLERANCE);

        assertEquals(307, generator1.getP(), TOLERANCE);
        assertEquals(150, generator2.getP(), TOLERANCE);
        assertEquals(1543, generator3.getP(), TOLERANCE);
        assertEquals(2000, generator4.getP(), TOLERANCE);
    }
}
