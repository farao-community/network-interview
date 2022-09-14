package com.rte.interview.network;

/**
 * @author Joris Mancini {@literal <joris.mancini at rte-france.com>}
 *
 * A generator is a specific injection that produces electricity on the network and has a
 * minimum and a maximum power generation. They both are positive.
 */
public class Generator extends Injection {

    private final double maxP;
    private final double minP;

    public Generator(double maxP, double minP) {
        this(minP, maxP, minP);
    }

    public Generator(double currentP, double maxP, double minP) {
        super(currentP);
        if (minP < 0 || maxP < 0 || minP > maxP || currentP < 0) {
            throw new IllegalArgumentException(String.format("Generator configuration is not valid %f %f %f.", minP, maxP, currentP));
        }
        this.maxP = maxP;
        this.minP = minP;
    }

    public double getMaxP() {
        return maxP;
    }

    public double getMinP() {
        return minP;
    }
}
