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
package com.cognizant.cognizantits.ide.main.mainui.components.testexecution.tree.model;

import com.cognizant.cognizantits.datalib.component.Project;
import com.cognizant.cognizantits.datalib.component.Scenario;
import com.cognizant.cognizantits.datalib.component.TestCase;
import com.cognizant.cognizantits.ide.main.mainui.components.testdesign.tree.model.TestPlanNode;
import com.cognizant.cognizantits.ide.main.mainui.components.testdesign.tree.model.TestPlanTreeModel;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 *
 * 
 */
public class FilterableTestPlanTreeModel extends TestPlanTreeModel {

    public FilterableTestPlanTreeModel(Project project, Predicate<Object> accept) {
        super(new FilteredTestPlanNode(accept));
        this.setProject(project);
    }

}

class FilteredTestPlanNode extends TestPlanNode {

    private final Predicate<Object> byPredicate;

    public FilteredTestPlanNode(Predicate<Object> accept) {
        this.byPredicate = accept;
    }

    @Override
    public void filterTestCases() {
        project.getScenarios().stream().flatMap(this::toFilteredTestcases).forEach(this::add);
    }

    public Stream<TestCase> toFilteredTestcases(Scenario scenario) {
        return byPredicate.test(scenario) ? scenario.getTestcasesAlone().stream()
                : scenario.getTestcasesAlone().stream().filter(byPredicate);
    }

}
