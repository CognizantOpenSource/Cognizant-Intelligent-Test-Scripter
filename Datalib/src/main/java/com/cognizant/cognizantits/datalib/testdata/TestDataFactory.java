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
package com.cognizant.cognizantits.datalib.testdata;

import com.cognizant.cognizantits.datalib.component.Project;
import com.cognizant.cognizantits.datalib.component.TestData;
import eu.infomas.annotation.AnnotationDetector;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 *
 */
public class TestDataFactory {

    private final static List<String> DATA_PROVIDER_CLASSES = new ArrayList<>();

    private final static List<String> DATA_PROVIDER_NAMES = new ArrayList<>();

    private static final AnnotationDetector.TypeReporter ANNOTATION_REPORTER = new AnnotationDetector.TypeReporter() {

        @Override
        public void reportTypeAnnotation(Class<? extends Annotation> type, String string) {
            DATA_PROVIDER_CLASSES.add(string);
            DATA_PROVIDER_NAMES.add(getTypeFromClass(string));
        }

        @Override
        public Class<? extends Annotation>[] annotations() {
            return new Class[]{DataProvider.class};
        }

    };

    private static final AnnotationDetector ANNOTATION_DETECTER = new AnnotationDetector(ANNOTATION_REPORTER);

    public static void load() {
        try {
            if (DATA_PROVIDER_CLASSES.isEmpty()) {
                ANNOTATION_DETECTER.detect(getDataProviders());
            }
        } catch (IOException ex) {
            Logger.getLogger(TestDataFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static TestData get(String testdataType, Project sProject, String env) {
        Object testdata = getTestDataFromClassLoader(getTypeFromAnnotation(testdataType), sProject, env);
        if (testdata != null) {
            return (TestData) testdata;
        }
        throw new IllegalArgumentException("Testdata Provider " + testdataType + " not available."
                + "Please give any of the following " + DATA_PROVIDER_CLASSES);

    }

    private static String getTypeFromClass(String clazz) {
        try {
            Class aclass = Class.forName(clazz);
            return ((DataProvider) aclass.getAnnotation(DataProvider.class)).type();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestDataFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private static Class getTypeFromAnnotation(String testDataType) {
        for (String clazz : DATA_PROVIDER_CLASSES) {
            try {
                Class aclass = Class.forName(clazz);
                String type = ((DataProvider) aclass.getAnnotation(DataProvider.class)).type();
                if (type.equals(testDataType)) {
                    return aclass;
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TestDataFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    private static Object getTestDataFromClassLoader(Class dpClass, Project sProject, String env) {
        if (dpClass != null) {
            try {
                Class[] types = {Project.class, String.class};
                Constructor constructor = dpClass.getConstructor(types);
                Object[] parameters = {sProject, env};
                return constructor.newInstance(parameters);
            } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(TestDataFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    private static String[] getDataProviders() {
        String packages[] = null;
        try {
            Properties prop = new Properties();
            File file = new File("Configuration", "package.properties");
            if (file.exists()) {
                prop.load(new FileInputStream(file));
                if (prop.containsKey("dataprovider")) {
                    packages = prop.getProperty("dataprovider").split(",");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(TestDataFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (packages == null) {
            packages = new String[]{"com.cognizant.cognizantits.testdata.csv"};
        }
        return packages;
    }

    public static List<String> getDATA_PROVIDER_NAMES() {
        return DATA_PROVIDER_NAMES;
    }

}
