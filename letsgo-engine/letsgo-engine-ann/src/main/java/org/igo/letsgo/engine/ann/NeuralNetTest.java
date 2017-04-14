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

import java.util.Arrays;
import org.igo.letsgo.engine.ann.activation.function.SigmoidActivationFunction;

/**
 *
 * @author surzhin.konstantin
 */
public class NeuralNetTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        final ArtificialNeuralNetwork neuralNet = new ArtificialNeuralNetwork(new SigmoidActivationFunction());
//
//        neuralNet.init(2, new int[]{7, 5, 3}, 1);
//        neuralNet.printNet();

        final NeuralNetTest test = new NeuralNetTest();

        test.testPerceptron();
        test.testAdaline();
    }

    private void testPerceptron() {
        final ArtificialNeuralNetwork neuralNet = new ArtificialNeuralNetwork(new SigmoidActivationFunction());
        neuralNet.init(2, new int[]{0}, 1);
        neuralNet.printNet();

        neuralNet.setInputData(new double[]{0.0, 0.0});
        neuralNet.recalculate();
        final double[] result = neuralNet.getOutputData();
        System.err.println(Arrays.toString(result));

        // neuralNet.setTrainType(TrainingTypesENUM.PERCEPTRON);
        //final ArtificialNeuralNetworkTeacher teacher = new PerceptronArtificialNeuralNetworkTeacher();
//        teacher.setLearningRate(1.0);
//        teacher.setTrainSet(new double[][]{{1.0, 0.0, 0.0}, {1.0, 0.0, 1.0}, {1.0, 1.0, 0.0}, {1.0, 1.0, 1.0}});
//        teacher.setRealOutputSet(new double[]{0.0, 0.0, 0.0, 1.0});
//        teacher.setMaxEpochs(10);
//        teacher.setTargetError(0.002);
//        teacher.train(neuralNet);
    }

    private void testAdaline() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
