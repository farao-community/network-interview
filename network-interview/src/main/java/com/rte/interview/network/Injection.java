package com.rte.interview.network;

/**
 * @author Joris Mancini {@literal <joris.mancini at rte-france.com>}
 *
 * An injection is an endpoint of the electrical network. It gives an injected power in producer convention.
 */
public abstract class Injection {

    private double currentP;

    public Injection(double currentP) {
        this.currentP = currentP;
    }

    public double getP() {
        return currentP;
    }

    public void setP(double p) {
        currentP = p;
    }
}
