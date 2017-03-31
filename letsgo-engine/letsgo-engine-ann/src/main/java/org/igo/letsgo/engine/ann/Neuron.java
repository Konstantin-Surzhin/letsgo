/*
 * Copyright (C) 2017 surzhin.konstantin
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.igo.letsgo.engine.ann;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author surzhin.konstantin
 */
public class Neuron {

    private final ArrayList<Double> listOfIncomingWeights = new ArrayList<>();
    private final ArrayList<Double> listOfOutgoingWeights = new ArrayList<>();
    private final String name;

    Neuron(String name) {
        this.name = name;
    }

    public void init(final int incomingNeuron, final int outgoingNeuron) {
        try {
            final SecureRandom r = SecureRandom.getInstanceStrong();
            for (int i = 0; i < incomingNeuron; i++) {
                listOfIncomingWeights.add(r.nextDouble());
            }
            for (int i = 0; i < outgoingNeuron; i++) {
                listOfOutgoingWeights.add(r.nextDouble());
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Neuron.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the listOfIncomingWeights
     */
    public ArrayList<Double> getListOfIncomingWeights() {
        return listOfIncomingWeights;
    }

    /**
     * @param listOfIncomingWeights the listOfIncomingWeights to set
     */
    public void setListOfIncomingWeights(ArrayList<Double> listOfIncomingWeights) {
        this.listOfIncomingWeights.clear();
        this.listOfIncomingWeights.addAll(listOfIncomingWeights);
    }

    /**
     * @return the listOfOutgoingWeights
     */
    public ArrayList<Double> getListOfOutgoingWeights() {
        return listOfOutgoingWeights;
    }

    /**
     * @param listOfOutgoingWeights the listOfOutgoingWeights to set
     */
    public void setListOfOutgoingWeights(ArrayList<Double> listOfOutgoingWeights) {
        this.listOfOutgoingWeights.clear();
        this.listOfOutgoingWeights.addAll(listOfOutgoingWeights);
    }

    public void printWeights() {
        System.out.println(name);
        System.out.println("Incoming Weights:");

        final String incomingWeights = listOfIncomingWeights.stream()
                .map(w -> w.toString())
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(incomingWeights);

        System.out.println("Outgoing weights:");
        final String outgoingWeights = listOfOutgoingWeights.stream()
                .map(w -> w.toString())
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(outgoingWeights);
    }
}
