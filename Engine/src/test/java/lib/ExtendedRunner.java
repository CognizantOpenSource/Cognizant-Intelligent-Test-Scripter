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
 */
package lib;

import org.junit.Ignore;
import org.junit.runner.Description;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

public class ExtendedRunner extends BlockJUnit4ClassRunner {

    public ExtendedRunner(Class<?> c) throws InitializationError {
        super(c);
    }

    @Override
    protected Description describeChild(FrameworkMethod method) {
        if (method.getAnnotation(Repeat.class) != null
                && method.getAnnotation(Ignore.class) == null) {
            return describeRepeatTest(method);
        }
        return super.describeChild(method);
    }

    private Description describeRepeatTest(FrameworkMethod method) {
        int times = method.getAnnotation(Repeat.class).value();

        Description description = Description.createSuiteDescription(
                testName(method) + " [" + times + " times]",
                method.getAnnotations());

        for (int i = 1; i <= times; i++) {
            description.addChild(Description.createTestDescription(
                    getTestClass().getJavaClass(),
                    "[" + i + "] " + testName(method)));
        }
        return description;
    }

    @Override
    protected void runChild(final FrameworkMethod method, RunNotifier notifier) {
        Description description = describeChild(method);

        if (method.getAnnotation(Repeat.class) != null
                && method.getAnnotation(Ignore.class) == null) {
            runRepeatedly(methodBlock(method), description, notifier);
        }
        super.runChild(method, notifier);
    }

    private void runRepeatedly(Statement statement, Description description,
            RunNotifier notifier) {
        int i = 0;

        System.out.println("running  "+ description);
        for (Description desc : description.getChildren()) {
            runLeaf(statement, desc, notifier);
        }
    }

}
