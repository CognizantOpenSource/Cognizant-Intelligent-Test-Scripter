/*
 * Copyright 2014 - 2017 Cognizant Technology Solutions
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cognizant.cognizantits.engine.execution.exceptions.data;

import com.cognizant.cognizantits.engine.execution.exception.data.TestDataNotFoundException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author 389747
 */
public class TestDataNotFoundExceptionTest {
    
    public TestDataNotFoundExceptionTest() {
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
     * Test of getTemplate method, of class TestDataNotFoundException.
     */
    @Test
    public void testGetTemplate() {
        System.out.println("getTemplate- TestData");
        String expResult = "{0} \n[Env : {1} | Sheet : {2} | Field : {3} | TestCase : {4}/{5} | Reusabe : {6}/{7} ]";
        String result = TestDataNotFoundException.getTemplate(true);
        assertEquals("TestData template reusable ",expResult, result);
        expResult = "{0} \n[Env : {1} | Sheet : {2} | Field : {3} | TestCase : {4}/{5} ]";
        result = TestDataNotFoundException.getTemplate(false);
        assertEquals("TestData template ",expResult, result);
    }
    
}
