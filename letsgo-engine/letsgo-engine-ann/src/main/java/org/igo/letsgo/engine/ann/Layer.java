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
    private int numberOfNeuronsInLayer;

    /**
     * @return the listOfNeurons
     */
    public ArrayList<Neuron> getListOfNeurons() {
        return listOfNeurons;
    }

    /**
     * @param listOfNeurons the listOfNeurons to set
     */
    public void setListOfNeurons(ArrayList<Neuron> listOfNeurons) {
        this.listOfNeurons.clear();
        this.listOfNeurons.addAll(listOfNeurons);
    }

    /**
     * @return the numberOfNeuronsInLayer
     */
    public int getNumberOfNeuronsInLayer() {
        return numberOfNeuronsInLayer;
    }

    /**
     * @param numberOfNeuronsInLayer the numberOfNeuronsInLayer to set
     */
    public void setNumberOfNeuronsInLayer(int numberOfNeuronsInLayer) {
        this.numberOfNeuronsInLayer = numberOfNeuronsInLayer;
    }
  
}
