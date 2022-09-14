package com.rte.interview.network;

/**
 * @author Joris Mancini {@literal <joris.mancini at rte-france.com>}
 *
 * A load is a specific injection that consumes electricity on the network and has a no limitation of power consumption
 * except that it will always be negative.
 */
public class Load extends Injection {

    public Load() {
        this(0);
    }

    public Load(double currentP) {
        super(currentP);
        if (currentP > 0) {
            throw new IllegalArgumentException("Load power consumption must be negative.");
        }
    }
}
