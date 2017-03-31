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
import java.util.Iterator;

/**
 *
 * @author surzhin.konstantin
 */
public class NeuralNet {

    private final Layer incomingLayer = new Layer("Input layer");
    private final ArrayList<Layer> listOfLayer = new ArrayList<>();
    private final Layer outgoingLayer = new Layer("Output layer");

    public void init(final int numberOfNeuronsInTheInputLayer,
            final int[] numberOfNeuronsInEachHiddenLayer,
            final int numberOfNeuronsInTheOutputLayer) {

        makeLayers(numberOfNeuronsInTheInputLayer,
                numberOfNeuronsInEachHiddenLayer,
                numberOfNeuronsInTheOutputLayer);
        bindLayers();
        
        listOfLayer.stream().forEach(Layer::init);
    }

    private void makeLayers(final int numberOfNeuronsInTheInputLayer,
            final int[] numberOfNeuronsInEachHiddenLayer,
            final int numberOfNeuronsInTheOutputLayer) {
        incomingLayer.setNumberOfNeuronsInLayer(numberOfNeuronsInTheInputLayer);
        listOfLayer.add(incomingLayer);

        int i = 1;
        for (final int n : numberOfNeuronsInEachHiddenLayer) {
            final Layer hiddenLayer = new Layer("Hidden layer №" + (i++));
            hiddenLayer.setNumberOfNeuronsInLayer(n);
            listOfLayer.add(hiddenLayer);
        }

        outgoingLayer.setNumberOfNeuronsInLayer(numberOfNeuronsInTheOutputLayer);
        listOfLayer.add(outgoingLayer);
    }

    private void bindLayers() {
        Layer previousLayer = null;
        for (Layer currentLayer : listOfLayer) {
            if (previousLayer != null) {
                previousLayer.setOutgoingLayer(currentLayer);
                currentLayer.setIncomingLayer(previousLayer);
            }
            
            previousLayer = currentLayer;
            
        }
    }

    public void printNet() {
        listOfLayer.stream().forEach(Layer::printLayer);
    }

    /**
     * @return the numberOfHiddenLayers
     */
    public int getNumberOfHiddenLayers() {
        return listOfLayer.size();
    }
}
