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
public class NeuralNet {

    private InputLayer inputLayer;
    private HiddenLayer hiddenLayer;
    private final ArrayList<HiddenLayer> listOfHiddenLayer = new ArrayList<>();
    private OutputLayer outputLayer;
    private int numberOfHiddenLayers;

    public void initNet() {
    }

    public void printNet() {
    }

    /**
     * @return the inputLayer
     */
    public InputLayer getInputLayer() {
        return inputLayer;
    }

    /**
     * @param inputLayer the inputLayer to set
     */
    public void setInputLayer(InputLayer inputLayer) {
        this.inputLayer = inputLayer;
    }

    /**
     * @return the hiddenLayer
     */
    public HiddenLayer getHiddenLayer() {
        return hiddenLayer;
    }

    /**
     * @param hiddenLayer the hiddenLayer to set
     */
    public void setHiddenLayer(HiddenLayer hiddenLayer) {
        this.hiddenLayer = hiddenLayer;
    }

    /**
     * @return the listOfHiddenLayer
     */
    public ArrayList<HiddenLayer> getListOfHiddenLayer() {
        return listOfHiddenLayer;
    }

    /**
     * @param listOfHiddenLayer the listOfHiddenLayer to set
     */
    public void setListOfHiddenLayer(ArrayList<HiddenLayer> listOfHiddenLayer) {
        this.listOfHiddenLayer.clear();
        this.listOfHiddenLayer.addAll(listOfHiddenLayer);
    }

    /**
     * @return the outputLayer
     */
    public OutputLayer getOutputLayer() {
        return outputLayer;
    }

    /**
     * @param outputLayer the outputLayer to set
     */
    public void setOutputLayer(OutputLayer outputLayer) {
        this.outputLayer = outputLayer;
    }

    /**
     * @return the numberOfHiddenLayers
     */
    public int getNumberOfHiddenLayers() {
        return numberOfHiddenLayers;
    }

    /**
     * @param numberOfHiddenLayers the numberOfHiddenLayers to set
     */
    public void setNumberOfHiddenLayers(int numberOfHiddenLayers) {
        this.numberOfHiddenLayers = numberOfHiddenLayers;
    }

}
