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
package com.cognizant.cognizantits.datalib.settings;

import java.util.Objects;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DriverSettingsTest {

    private static DriverSettings ds;
    private static boolean isWin;

    @BeforeClass
    public static void setUpClass() throws Exception {        
        isWin = Objects.toString(System.getProperty("os.name"), "").startsWith("Windows");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        ds = new DriverSettings("tmp");
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of getGeckcoDriverPath method, of class DriverSettings.
     */
    @Test
    public void testGetGeckcoDriverPath() {
        System.out.println("getGeckcoDriverPath");
        String expResult;
        if (isWin) {
            expResult = "./lib/Drivers/geckodriver.exe";
        } else {
            expResult = "./lib/Drivers/geckodriver";
        }
        String result = ds.getGeckcoDriverPath();
        assertEquals(result, expResult);
    }

    /**
     * Test of getChromeDriverPath method, of class DriverSettings.
     */
    @Test
    public void testGetChromeDriverPath() {
        System.out.println("getChromeDriverPath");
        String expResult;
        if (isWin) {
            expResult = "./lib/Drivers/chromedriver.exe";
        } else {
            expResult = "./lib/Drivers/chromedriver";
        }
        String result = ds.getChromeDriverPath();
        assertEquals(result, expResult);
    }

    /**
     * Test of getIEDriverPath method, of class DriverSettings.
     */
    @Test
    public void testGetIEDriverPath() {
        System.out.println("getIEDriverPath");
        String expResult;
        if (isWin) {
            expResult = "./lib/Drivers/IEDriverServer.exe";
        } else {
            expResult = "./lib/Drivers/IEDriverServer";
        }
        String result = ds.getIEDriverPath();
        assertEquals(result, expResult);
    }

    /**
     * Test of getEdgeDriverPath method, of class DriverSettings.
     */
    @Test
    public void testGetEdgeDriverPath() {
        System.out.println("getEdgeDriverPath");
        String expResult;
        if (isWin) {
            expResult = "./lib/Drivers/MicrosoftWebDriver.exe";
        } else {
            expResult = "./lib/Drivers/MicrosoftWebDriver";
        }
        String result = ds.getEdgeDriverPath();
        assertEquals(result, expResult);
    }

    /**
     * Test of setGeckcoDriverPath method, of class DriverSettings.
     */
    @Test
    public void testSetGeckcoDriverPath() {
        System.out.println("setGeckcoDriverPath");
        String path = "./lib/gk";
        ds.setGeckcoDriverPath(path);
        assertEquals(ds.getGeckcoDriverPath(), path);
    }

    /**
     * Test of setChromeDriverPath method, of class DriverSettings.
     */
    @Test
    public void testSetChromeDriverPath() {
        System.out.println("setChromeDriverPath");
        String path = "./lib/chrome";
        ds.setChromeDriverPath(path);
        assertEquals(ds.getChromeDriverPath(), path);
    }

    /**
     * Test of setIEDriverPath method, of class DriverSettings.
     */
    @Test
    public void testSetIEDriverPath() {
        System.out.println("setIEDriverPath");
        String path = "./lib/ie";
        ds.setIEDriverPath(path);
        assertEquals(ds.getIEDriverPath(), path);
    }

    /**
     * Test of setEdgeDriverPath method, of class DriverSettings.
     */
    @Test
    public void testSetEdgeDriverPath() {
        System.out.println("setEdgeDriverPath");
        String path = "./lib/edge";
        ds.setEdgeDriverPath(path);
        assertEquals(ds.getEdgeDriverPath(), path);
    }

}
