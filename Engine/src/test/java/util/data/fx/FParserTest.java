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
package util.data.fx;

import com.cognizant.cognizantits.engine.util.data.fx.FParser;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lib.ExtendedRunner;
import lib.Repeat;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.json.simple.JSONValue;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author 389747
 */
@RunWith(ExtendedRunner.class)
public class FParserTest {

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
    @Test
    @Repeat(200)
    public void testEval() {
        String s = "Concat(=Round(=Random(4)),test@gmail.com)";
        Object result = FParser.eval(s);
        assertThat("random email ", result.toString(), new RegexMatcher("[0-9]{4}test@gmail.com"));

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
        assertThat("date " + result, result.toString(),
                new RegexMatcher("(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])-\\d{2}"));
        s = "Date(0,\"MM dd yyyy\")";
        result = FParser.eval(s);
        assertThat("date " + result, result.toString(),
                new RegexMatcher("(0[1-9]|1[012]) (0[1-9]|[12][0-9]|3[01]) \\d{4}"));
        s = "Date(0,\"MM:dd:yyyy\")";
        result = FParser.eval(s);
        assertThat("date " + result, result.toString(),
                new RegexMatcher("(0[1-9]|1[012]):(0[1-9]|[12][0-9]|3[01]):\\d{4}"));
        s = "Date(0,\"dd/MM/yyyy\")";
        result = FParser.eval(s);
        assertThat("date " + result, result.toString(),
                new RegexMatcher("(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/\\d{4}"));
    }

    /**
     * Test of evaljs method, of class FParser.
     */
    @Test
    @Repeat(200)
    public void testEvaljs() {
        String script = "floor(100 + random() * 900)";
        String result = FParser.evaljs(script);
        assertThat("Test random ", result, new RegexMatcher("[0-9]{3}"));
        script = "'test'+ floor(100 + random() * 900)+'vt@gmail.com'";
        result = (String) JSONValue.parse(FParser.evaljs(script));
        assertThat("Test random Email ", result, new RegexMatcher("test[0-9]{3}vt@gmail.com"));

    }

}

class RegexMatcher extends TypeSafeMatcher<String> {

    private final String regex;

    public RegexMatcher(final String regex) {
        this.regex = regex;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("matches regex=`" + regex + "`");
    }

    @Override
    public boolean matchesSafely(final String string) {
        return string.matches(regex);
    }

    public static RegexMatcher matchesRegex(final String regex) {
        return new RegexMatcher(regex);
    }

}
