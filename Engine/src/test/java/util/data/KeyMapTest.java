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
package util.data;

import com.cognizant.cognizantits.engine.util.data.KeyMap;
import java.util.HashMap;
import java.util.Map;
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
public class KeyMapTest {

    Map vMap = new HashMap();

    public KeyMapTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        System.setProperty("var.1", "x");
        System.setProperty("var.2", "y");
        System.setProperty("var.3", "z");
        System.setProperty("val.1", "1");
        System.setProperty("val.2", "b");
        System.setProperty("val.3", "c");

        vMap.put("scenario", "myscn");
        vMap.put("testcase", "tc");
        vMap.put("project", "pro");
        vMap.put("testset", "ts");
        vMap.put("release", "rel");
        vMap.put("rel", "L2");
    }

    @After
    public void tearDown() {
    }

    public static void main(String[] args) {
        new KeyMapTest().testResolveContextVars();
    }

    /**
     * Test of resolveContextVars method, of class KeyMap.
     */
    @Test
    public void testResolveContextVars() {
        System.out.println("resolveContextVars");
        String in = "this is a {scenario}/{testset} -> {testset}/{release} for {project}.{release}.{testcase} ";
        String expResult = "this is a myscn/ts -> ts/rel for pro.rel.tc ";
        String result = KeyMap.resolveContextVars(in, vMap);
        assertEquals(expResult, result);
    }

    /**
     * Test of resolveEnvVars method, of class KeyMap.
     */
    @Test
    public void testResolveEnvVars() {
        System.out.println("resolveEnvVars");
        String in = "${val.1}-${var.1}-${val.2}-${val.1}-${val.3}-${val.4}-${var.4}-${var.1}-${var.2}-";
        String expResult = "1-x-b-1-c-val.4-var.4-x-y-";
        String result = KeyMap.resolveEnvVars(in);
        assertEquals(expResult, result);

    }

    /**
     * Test of replaceKeys method, of class KeyMap.
     */
    @Test
    public void testReplaceKeysUserVariables() {

        System.out.println("replaceKeys");
        String in = "this is a %scenario%/%testset% -> %testset%/%release% for %project%.%testcase%/%%release%%. ";

        boolean preserveKeys = true;
        String result;
        String expResult = "this is a myscn/ts -> ts/rel for pro.tc/%rel%. ";
        result = KeyMap.replaceKeys(in, KeyMap.USER_VARS, preserveKeys, 1, vMap);
        assertEquals(expResult, result);
        expResult = "this is a myscn/ts -> ts/rel for pro.tc/L2. ";
        result = KeyMap.replaceKeys(in, KeyMap.USER_VARS, preserveKeys, 2, vMap);
        assertEquals(expResult, result);

    }

    /**
     * Test of replaceKeys method, of class KeyMap.
     */
    @Test
    public void testReplaceKeys_String_Pattern() {
        System.out.println("replaceKeys");
        String in = "${val.1}-${var.1}-${val.2}-${val.1}-${val.3}-${val.4}-${var.4}-${var.1}-${var.2}-";
        String expResult = "1-x-b-1-c-val.4-var.4-x-y-";
        String result = KeyMap.replaceKeys(in, KeyMap.ENV_VARS);
        assertEquals(expResult, result);

    }

}
