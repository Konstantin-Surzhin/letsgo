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
public class Neuron {

    private final ArrayList<Double> listOfWeightIn = new ArrayList<>();
    private final ArrayList<Double> listOfWeightOut = new ArrayList<>();

    public double initNeuron() {
        return -1;
    }

    /**
     * @return the listOfWeightIn
     */
    public ArrayList<Double> getListOfWeightIn() {
        return listOfWeightIn;
    }

    /**
     * @param listOfWeightIn the listOfWeightIn to set
     */
    public void setListOfWeightIn(ArrayList<Double> listOfWeightIn) {
        this.listOfWeightIn.clear();
        this.listOfWeightIn.addAll(listOfWeightIn);
    }

    /**
     * @return the listOfWeightOut
     */
    public ArrayList<Double> getListOfWeightOut() {
        return listOfWeightOut;
    }

    /**
     * @param listOfWeightOut the listOfWeightOut to set
     */
    public void setListOfWeightOut(ArrayList<Double> listOfWeightOut) {
        this.listOfWeightOut.clear();
        this.listOfWeightOut.addAll(listOfWeightOut);
    }
}
