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
import org.igo.letsgo.engine.ann.activation.function.ActivationFunction;

/**
 *
 * @author surzhin.konstantin
 */
public class ArtificialNeuralNetwork implements NeuralNetworkProcessor {

    private final AartificialNeuronsLayer inputLayer = new AartificialNeuronsLayer("Input layer");
    private final ArrayList<AartificialNeuronsLayer> listOfLayer = new ArrayList<>();
    private final AartificialNeuronsLayer outputLayer = new AartificialNeuronsLayer("Output layer");

    private final ActivationFunction activationFunction;

    private TrainingTypesEnum trainType;

    private final List<Double> listMSE = new ArrayList<>();
    private double[] inputData;
    private double[] outputData;

    ArtificialNeuralNetwork(final ActivationFunction sigmoid) {
        activationFunction = sigmoid;
    }

    public void init(final int numberOfNeuronsInTheInputLayer,
            final int[] numberOfNeuronsInEachHiddenLayer,
            final int numberOfNeuronsInTheOutputLayer) {

        makeLayers(numberOfNeuronsInTheInputLayer,
                numberOfNeuronsInEachHiddenLayer,
                numberOfNeuronsInTheOutputLayer);
        bindLayers();

        listOfLayer.stream().forEach(AartificialNeuronsLayer::init);
    }

    private void makeLayers(final int numberOfNeuronsInTheInputLayer,
            final int[] numberOfNeuronsInEachHiddenLayer,
            final int numberOfNeuronsInTheOutputLayer) {

        inputLayer.setNumberOfNeuronsInLayer(numberOfNeuronsInTheInputLayer);
        listOfLayer.add(inputLayer);

        int i = 1;
        for (final int n : numberOfNeuronsInEachHiddenLayer) {
            final AartificialNeuronsLayer hiddenLayer = new AartificialNeuronsLayer("Hidden layer №" + (i++));
            hiddenLayer.setNumberOfNeuronsInLayer(n);
            listOfLayer.add(hiddenLayer);
        }

        outputLayer.setNumberOfNeuronsInLayer(numberOfNeuronsInTheOutputLayer);
        listOfLayer.add(outputLayer);
    }

    private void bindLayers() {
        AartificialNeuronsLayer previousLayer = null;
        for (AartificialNeuronsLayer currentLayer : listOfLayer) {
            if (previousLayer != null) {
                previousLayer.setOutputLayer(currentLayer);
                currentLayer.setInputLayer(previousLayer);
            }

            previousLayer = currentLayer;
        }
    }

    public void printNet() {
        listOfLayer.stream().forEach(AartificialNeuronsLayer::printLayer);
    }

    /**
     * @return the numberOfHiddenLayers
     */
    public int getNumberOfHiddenLayers() {
        return listOfLayer.size();
    }

    public double[][] getTrainSet() {
        return new double[3][3];
    }

    public AartificialNeuronsLayer getInputLayer() {
        return listOfLayer.get(0);
    }

    public int getMaxEpochs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public double[] getRealOutputSet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    double getTargetError() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setInputLayer(final AartificialNeuronsLayer inputLayer) {
        inputLayer
                .setListOfNeurons(inputLayer.getListOfNeurons());
    }

    public List<Double> getListOfMSE() {
        return this.listMSE;
    }

    void setTrainingError(double error) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the activationFunction
     */
    public ActivationFunction getActivationFunction() {
        return activationFunction;
    }

    /**
     * @return the trainType
     */
    public TrainingTypesEnum getTrainType() {
        return trainType;
    }

    /**
     * @param trainType the trainType to set
     */
    public void setTrainType(TrainingTypesEnum trainType) {
        this.trainType = trainType;
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
        this.inputLayer.setInputData(this.inputData);
        this.inputLayer.recalculate();
        this.outputData = this.outputLayer.getOutputData();
    }
}
