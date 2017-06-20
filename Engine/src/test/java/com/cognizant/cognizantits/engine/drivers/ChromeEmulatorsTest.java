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
package com.cognizant.cognizantits.engine.drivers;

import com.cognizant.cognizantits.engine.support.DesktopApi;
import java.io.File;
import java.util.List;
import java.util.stream.Stream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assume.assumeFalse;

/**
 *
 *
 */
public class ChromeEmulatorsTest {

    private static final boolean IS_TRAVIS_LINUX = isTravisLinux();

    public ChromeEmulatorsTest() {
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
     * Test of getPrefLocation method, of class ChromeEmulators.
     */
    @Test
    public void testGetPrefLocation() {
        assumeFalse(IS_TRAVIS_LINUX);
        System.out.println("getPrefLocation");
        File file = new File(ChromeEmulators.getPrefLocation(), "Preferences");
        if (!file.exists()) {
            System.out.println(file.getAbsolutePath());
            System.out.println("------------------------");
            Stream.of(file.listFiles())
                    .map(File::getAbsolutePath).forEach(System.out::println);
            fail("Unable to fine preference file");
        }
    }

    /**
     * Test of sync method, of class ChromeEmulators.
     */
    @Test
    public void testSync() {
        assumeFalse(IS_TRAVIS_LINUX);
        System.out.println("sync");
        ChromeEmulators.sync();
        assertEquals("EmulatorsList is Empty",
                false, ChromeEmulators.getEmulatorsList().isEmpty());

    }

    /**
     * Test of getEmulatorsList method, of class ChromeEmulators.
     */
    @Test

    public void testGetEmulatorsList() {
        assumeFalse(IS_TRAVIS_LINUX);
        System.out.println("getEmulatorsList");
        List<String> result = ChromeEmulators.getEmulatorsList();
        assertEquals("Some/all emulators missing in the EmulatorsList", true,
                Stream.of("Nexus 5", "Galaxy S5", "Nexus 6P", "iPhone 5", "iPhone 6 Plus")
                        .allMatch(result::contains)
        );

    }

    private static boolean isTravisLinux() {
        return DesktopApi.getOs().isLinux()
                && Boolean.valueOf(System.getenv("TRAVIS"));
    }
}
