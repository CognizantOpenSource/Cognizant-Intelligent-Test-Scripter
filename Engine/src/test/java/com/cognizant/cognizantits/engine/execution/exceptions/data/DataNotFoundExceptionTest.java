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

import com.cognizant.cognizantits.engine.execution.exception.data.DataNotFoundException;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class DataNotFoundExceptionTest {

    /**
     * Test of getTemplate method, of class DataNotFoundException.
     */
    @Test
    public void testGetTemplate() {
        System.out.println("getTemplate");
        Boolean isReusable = true;
        String expResult = "{0} \n"
                + "[Env : {1} | Field : {2} | TestCase : {4}/{5} | Reusabe : {6}/{7} ]";
        String result = DataNotFoundException.getTemplate(isReusable);
        assertEquals(expResult, result);
        isReusable = false;
        expResult = "{0} \n"
                + "[Env : {1} | Field : {2} | TestCase : {4}/{5} ]";
        result = DataNotFoundException.getTemplate(isReusable);
        assertEquals(expResult, result);
    }

    /**
     * Test of getFormatted method, of class DataNotFoundException.
     */
    @Test
    public void testGetFormatted() {
        System.out.println("getFormatted");
        String template = DataNotFoundException.getTemplate(true);
        Object[] args = {"msg",
            "env", "f", "if",
            "sc", "tc",
            "rsc", "rtc"};
        String expResult = "msg \n"
                + "[Env : env | Field : f | TestCase : sc/tc | Reusabe : rsc/rtc ]";
        String result = DataNotFoundException.getFormatted(template, args);
        assertEquals(expResult, result);
        template = DataNotFoundException.getTemplate(false);
        expResult = "msg \n"
                + "[Env : env | Field : f | TestCase : sc/tc ]";
        result = DataNotFoundException.getFormatted(template, args);
        assertEquals(expResult, result);

    }

}
