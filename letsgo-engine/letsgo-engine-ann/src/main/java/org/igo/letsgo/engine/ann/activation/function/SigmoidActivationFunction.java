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
package org.igo.letsgo.engine.ann.activation.function;

/**
 *
 * @author surzhin.konstantin
 */
public final class SigmoidActivationFunction implements ActivationFunction {

    @Override
    public double performFunction(final double x) {
        return 1.0 / (1.0 + Math.exp(-x));
    }

    @Override
    public double performDerivativeFunction(double x) {
        return x * (1.0 - x);
    }
}
