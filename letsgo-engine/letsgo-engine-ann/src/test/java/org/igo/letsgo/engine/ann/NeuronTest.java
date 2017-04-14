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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author surzhin.konstantin
 */
public class NeuronTest {
    
    public NeuronTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getListOfWeightIn method, of class ArtificialNeuron.
     */
    @Test
    public void testGetListOfWeightIn() {
        System.out.println("getListOfWeightIn");
        ArtificialNeuron instance = new ArtificialNeuron("test neuron");
        ArrayList<Double> expResult = null;
        ArrayList<Double> result = instance.getListOfIncomingWeights();
        assertEquals(expResult, result);

    }

    /**
     * Test of setListOfWeightIn method, of class ArtificialNeuron.
     */
    @Test
    public void testSetListOfWeightIn() {
        System.out.println("setListOfWeightIn");
        ArrayList<Double> listOfWeightIn = null;
        ArtificialNeuron instance = new ArtificialNeuron("test neuron");
        instance.setListOfIncomingWeights(listOfWeightIn);

    }

    /**
     * Test of getListOfWeightOut method, of class ArtificialNeuron.
     */
    @Test
    public void testGetListOfWeightOut() {
        System.out.println("getListOfWeightOut");
        ArtificialNeuron instance = new ArtificialNeuron("test neuron");
        ArrayList<Double> expResult = null;
        ArrayList<Double> result = instance.getListOfOutgoingWeights();
        assertEquals(expResult, result);

    }

    /**
     * Test of setListOfWeightOut method, of class ArtificialNeuron.
     */
    @Test
    public void testSetListOfWeightOut() {
        System.out.println("setListOfWeightOut");
        ArrayList<Double> listOfWeightOut = null;
        ArtificialNeuron instance = new ArtificialNeuron("test neuron");
        instance.setListOfOutgoingWeights(listOfWeightOut);

    }
    
}
