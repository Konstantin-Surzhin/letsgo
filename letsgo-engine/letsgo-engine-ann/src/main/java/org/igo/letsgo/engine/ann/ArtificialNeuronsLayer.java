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
import java.util.List;

/**
 *
 * @author surzhin.konstantin
 */
public class ArtificialNeuronsLayer implements NeuralNetworkProcessor {

    private final ArrayList<ArtificialNeuron> listOfNeurons = new ArrayList<>();
    private int numberOfNeuronsInTheLayer = 0;
    private final String name;
    private ArtificialNeuronsLayer inputLayer;
    private ArtificialNeuronsLayer outputLayer;
    private double[] inputData;
    private double[] outputData;

    ArtificialNeuronsLayer(final String name) {
        this.name = name;
    }

    /**
     * @return the listOfNeurons
     */
    public ArrayList<ArtificialNeuron> getListOfNeurons() {
        return listOfNeurons;
    }

    public void init() {

        for (int i = 1; i <= numberOfNeuronsInTheLayer; i++) {
            final ArtificialNeuron neuron = new ArtificialNeuron("Neuron №" + i);

            int inputNeurons = 0;
            if (inputLayer != null) {
                inputNeurons = inputLayer.getNumberOfNeuronsInLayer();
            }

            int outputNeurons = 0;
            if (outputLayer != null) {
                outputNeurons = outputLayer.getNumberOfNeuronsInLayer();
            }

            neuron.init(inputNeurons, outputNeurons);
            listOfNeurons.add(neuron);
        }
    }

    public void printLayer() {
        System.out.println("*********************************");
        System.out.println("Name: " + this.name);
        System.out.println("Number of neurons in the layer: " + this.numberOfNeuronsInTheLayer);

        listOfNeurons.stream().forEach(ArtificialNeuron::printWeights);

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
     * @return the inputLayer
     */
    public ArtificialNeuronsLayer getInputLayer() {
        return inputLayer;
    }

    /**
     * @param inputLayer the inputLayer to set
     */
    public void setInputLayer(ArtificialNeuronsLayer inputLayer) {
        this.inputLayer = inputLayer;
    }

    /**
     * @return the outputLayer
     */
    public ArtificialNeuronsLayer getOutputLayer() {
        return outputLayer;
    }

    /**
     * @param outputLayer the outputLayer to set
     */
    public void setOutputLayer(final ArtificialNeuronsLayer outputLayer) {
        this.outputLayer = outputLayer;
    }

    void setListOfNeurons(final List<ArtificialNeuron> nerons) {
        listOfNeurons.clear();
        listOfNeurons.addAll(nerons);
    }

    @Override
    public void setInputData(final double[] inputData) {
        this.inputData = inputData;
    }

    @Override
    public double[] getOutputData() {
        return this.outputData;
    }

    @Override
    public void recalculate() {
        if (this.inputData == null) {
            throw new IllegalArgumentException("У сети нет входных данных");
        }
        listOfNeurons.forEach((listOfNeuron) -> {
            listOfNeuron.getListOfIncomingWeights().size();
            for( int i=0; i < listOfNeuron.getListOfIncomingWeights().size(); i++){
                
            }
            // listOfNeurons.get(i).getListOfIncomingWeights();
        });
    }
}
