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
import org.igo.letsgo.engine.ann.activation.function.ActivationFunctionDerivative;

/**
 *
 * @author surzhin.konstantin
 */
public abstract class ArtificialNeuralNetworkTeacher {

    private int epochs;
    private double error;
    private double mse;
    private double learningRate ;

    /**
     * @return the epochs
     */
    public int getEpochs() {
        return epochs;
    }

    /**
     * @param epochs the epochs to set
     */
    public void setEpochs(final int epochs) {
        this.epochs = epochs;
    }

    /**
     * @return the error
     */
    public double getError() {
        return error;
    }

    /**
     * @param error the error to set
     */
    public void setError(final double error) {
        this.error = error;
    }

    /**
     * @return the mse
     */
    public double getMse() {
        return mse;
    }

    /**
     * @param mse the mse to set
     */
    public void setMse(final double mse) {
        this.mse = mse;
    }

    private double calculateNewPerseptronWeight(double inputWeightOld, double learningRate, double trainSample, final double error) {
        return inputWeightOld
                + learningRate
                * error
                * trainSample;

    }

    public ArtificialNeuralNetwork train(final ArtificialNeuralNetwork neuralNet) {

        final int rows = neuralNet.getTrainSet().length;
        final int cols = neuralNet.getTrainSet()[0].length;

        while (this.getEpochs() < neuralNet.getMaxEpochs()) {

            double estimatedOutput = 0.0;
            double realOutput = 0.0;

            for (int i = 0; i < rows; i++) {
                double value = 0.0;

                for (int j = 0; j < cols; j++) {

                    final ArrayList<Double> inputWeightIn = neuralNet
                            .getInputLayer()
                            .getListOfNeurons()
                            .get(j)
                            .getListOfIncomingWeights();

                    double inputWeight = inputWeightIn.get(0);

                    value = value + inputWeight * neuralNet.getTrainSet()[i][j];
                }
                estimatedOutput = neuralNet
                        .getActivationFunction()
                        .performFunction(value);

                realOutput = neuralNet.getRealOutputSet()[i];

                this.setError(realOutput - estimatedOutput);

                if (Math.abs(this.getError()) > neuralNet.getTargetError()) {
                    // fix weights
                    final ArtificialNeuronsLayer inputLayer = new ArtificialNeuronsLayer("Incoming Layer");
                    final List<ArtificialNeuron> nerons = this.teachNeuronsOfLayer(cols, i, neuralNet, getLearningRate(), value);

                    inputLayer.setListOfNeurons(nerons);
                    neuralNet.setInputLayer(inputLayer);
                }
            }

            this.setMse(Math.pow(realOutput - estimatedOutput, 2.0));

            neuralNet.getListOfMSE().add(this.getMse());

            this.setEpochs(this.getEpochs() + 1);
        }

        neuralNet.setTrainingError(this.getError());
        return neuralNet;
    }

    private ArrayList<ArtificialNeuron> teachNeuronsOfLayer(
            int numberOfInputNeurons,
            int line,
            ArtificialNeuralNetwork neuralNet,
            final double learningRate,
            double value) {

        final ArrayList<ArtificialNeuron> listOfNeurons = new ArrayList<>();

        for (int j = 0; j < numberOfInputNeurons; j++) {

            final ArrayList<Double> inputWeightsInOld = neuralNet
                    .getInputLayer()
                    .getListOfNeurons()
                    .get(j)
                    .getListOfIncomingWeights();

            final double inputWeightOld = inputWeightsInOld.get(0);
            final ArrayList<Double> inputWeightsInNew = new ArrayList<>();

            inputWeightsInNew.add(calculateNewWeight(
                    neuralNet.getTrainType(),
                    inputWeightOld,
                    neuralNet,
                    this.getError(),
                    learningRate,
                    neuralNet.getTrainSet()[line][j],
                    value));

            final ArtificialNeuron neuron = new ArtificialNeuron("neuron:" + j);

            neuron.setListOfIncomingWeights(inputWeightsInNew);
            listOfNeurons.add(neuron);
        }
        return listOfNeurons;
    }

    private Double calculateNewWeight(
            final TrainingTypesEnum trainType,
            final double inputWeightOld,
            final ArtificialNeuralNetwork neuralNet,
            final double error,
            final double learningRate,
            final double trainSample,
            final double value
    ) {

        switch (trainType) {
            case PERCEPTRON:
                return calculateNewPerseptronWeight(inputWeightOld, learningRate, trainSample, error);

            case ADALINE:
                return calculateNewPerseptronWeight(inputWeightOld, learningRate, trainSample, error)
                        * ((ActivationFunctionDerivative)neuralNet
                                .getActivationFunction())
                                .performDerivativeFunction(value);
            default:
                throw new IllegalArgumentException(trainType
                        + " does not exist in TrainingTypesEnum");
        }
    }

    /**
     * @return the learningRate
     */
    public double getLearningRate() {
        return learningRate;
    }

    /**
     * @param learningRate the learningRate to set
     */
    public void setLearningRate(double learningRate) {
        this.learningRate = learningRate;
    }

    void setTrainSet(double[][] d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setRealOutputSet(double[] d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setMaxEpochs(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setTargetError(double d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
