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
package org.igo.junit.city.entities;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author surzhin.konstantin
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({org.igo.junit.city.entities.CityCacheTest.class, org.igo.junit.city.entities.CityCascadeTest.class, org.igo.junit.city.entities.CityLazyExceptionTest.class, org.igo.junit.city.entities.CityTest.class})
public class CityTestSuite {
    
}
