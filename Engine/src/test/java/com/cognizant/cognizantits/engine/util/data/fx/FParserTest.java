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
package com.cognizant.cognizantits.engine.util.data.fx;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.json.simple.JSONValue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

public class FParserTest {

    /**
     * Test of getFuncList method, of class FParser.
     */
    @Test
    public void testGetFuncList() {
        System.out.println("getFuncList");
        String[] vals = {"Concat", "Random", "Round", "Pow", "Min", "Max", "Date"};
        List<String> expResult = Arrays.asList(vals);
        Collections.sort(expResult);
        List<String> result = FParser.getFuncList();
        Collections.sort(result);
        assertEquals(expResult.toString(), result.toString());
    }

    /**
     * Test of eval method, of class FParser.
     */
    @Test(invocationCount = 10)
    public void testEval() {
        System.out.println("Eval");
        String s = "Concat(=Round(=Random(4)),test@gmail.com)";
        Object result = FParser.eval(s);
        assertTrue(result.toString().matches("[0-9]{4}test@gmail.com"), "random email " + result);
    }

    /**
     * Test of eval method, of class FParser.
     */
    @Test
    public void testEval_DateTest() {
        System.out.println("eval date fn");
        String s;
        Object result;
        s = "Date(0,\"MM-dd-yy\")";
        result = FParser.eval(s);
        assertTrue(result.toString().matches("(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])-\\d{2}"),
                "date " + result);

        s = "Date(0,\"MM dd yyyy\")";
        result = FParser.eval(s);
        assertTrue(result.toString().matches("(0[1-9]|1[012]) (0[1-9]|[12][0-9]|3[01]) \\d{4}"),
                "date " + result);

        s = "Date(0,\"MM:dd:yyyy\")";
        result = FParser.eval(s);
        assertTrue(result.toString().matches("(0[1-9]|1[012]):(0[1-9]|[12][0-9]|3[01]):\\d{4}"),
                "date " + result);
        s = "Date(0,\"dd/MM/yyyy\")";
        result = FParser.eval(s);
        assertTrue(result.toString().matches("(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/\\d{4}"),
                "date " + result);
    }

    /**
     * Test of evaljs method, of class FParser.
     */
    @Test(invocationCount = 10)
    public void testEvaljs() {
        System.out.println("Evaljs");
        String script = "floor(100 + random() * 900)";
        String result = FParser.evaljs(script);
        assertTrue(result.matches("[0-9]{3}"),
                "Test random ");
        script = "'test'+ floor(100 + random() * 900)+'vt@gmail.com'";
        result = (String) JSONValue.parse(FParser.evaljs(script));
        assertTrue(result.matches("test[0-9]{3}vt@gmail.com"),
                "Test random email ");

    }

}
