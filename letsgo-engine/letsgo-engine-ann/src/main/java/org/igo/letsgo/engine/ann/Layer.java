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

import java.util.ArrayList;

/**
 *
 * @author surzhin.konstantin
 */
public class Layer {

    private final ArrayList<Neuron> listOfNeurons = new ArrayList<>();
    private int numberOfNeuronsInTheLayer = 0;
    private final String name;
    private Layer incomingLayer;
    private Layer outgoingLayer;

    Layer(final String name) {
        this.name = name;
    }

    /**
     * @return the listOfNeurons
     */
    public ArrayList<Neuron> getListOfNeurons() {
        return listOfNeurons;
    }

    public void init() {

        for (int i = 1; i <= numberOfNeuronsInTheLayer; i++) {
            final Neuron neuron = new Neuron("Neuron №" + i);

            int incomingNeurons = 0;
            if (incomingLayer != null) {
                incomingNeurons = incomingLayer.getNumberOfNeuronsInLayer();
            }
            
            int outgoingNeurons = 0;
            if (outgoingLayer != null) {
                outgoingNeurons = outgoingLayer.getNumberOfNeuronsInLayer();
            }

            neuron.init(incomingNeurons, outgoingNeurons);
            listOfNeurons.add(neuron);
        }
    }

    public void printLayer() {
        System.out.println("*********************************");
        System.out.println("Name: " + this.name);
        System.out.println("Number of neurons in the layer: " + this.numberOfNeuronsInTheLayer);

        listOfNeurons.stream().forEach(Neuron::printWeights);

    }

    /**
     * @return the numberOfNeuronsInLayer
     */
    public int getNumberOfNeuronsInLayer() {
        return this.numberOfNeuronsInTheLayer;
    }

    void setNumberOfNeuronsInLayer(int numberOfNeuronsInTheLayer) {
        this.numberOfNeuronsInTheLayer = numberOfNeuronsInTheLayer;
    }

    /**
     * @return the incomingLayer
     */
    public Layer getIncomingLayer() {
        return incomingLayer;
    }

    /**
     * @param incomingLayer the incomingLayer to set
     */
    public void setIncomingLayer(Layer incomingLayer) {
        this.incomingLayer = incomingLayer;
    }

    /**
     * @return the outgoingLayer
     */
    public Layer getOutgoingLayer() {
        return outgoingLayer;
    }

    /**
     * @param outgoingLayer the outgoingLayer to set
     */
    public void setOutgoingLayer(Layer outgoingLayer) {
        this.outgoingLayer = outgoingLayer;
    }
}
