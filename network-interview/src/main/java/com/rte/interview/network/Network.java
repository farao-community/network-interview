package com.rte.interview.network;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @author Joris Mancini {@literal <joris.mancini at rte-france.com>}
 */
public class Network {

    private final Set<Load> loads;
    private final List<Generator> generators;

    public Network(Set<Load> loads, List<Generator> generators) {
        this.loads = loads;
        this.generators = generators;
    }

    public Stream<Load> getLoads() {
        return loads.stream();
    }

    public Stream<Generator> getGenerators() {
        return generators.stream();
    }

    /**
     * Shift method increases power generation on the network. Two steps:
     *  - First it shifts up generators proportionally to the remaining generation capacity i.e maxP - currentP
     *  - Then, if target value is not reached, it shifts down all the loads evenly
     * @param targetValue: Total injection variation that is targeted.
     */
    void shift(double targetValue) {

    }

    /**
     * Shift method increases power generation on the network. Two steps:
     *  - First it shifts up generators with merit order until Pmax for each
     *  - Then, if target value is not reached, it shifts down all the loads proportionally to their current P
     * @param targetValue: Total injection variation that is targeted.
     */
//    void shift(double targetValue) {
//
//    }
}
