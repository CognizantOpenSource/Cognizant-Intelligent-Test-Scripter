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
package com.cognizant.cognizantits.engine.commands.galenCommands;

import com.cognizant.cognizantits.engine.core.CommandControl;
import com.cognizant.cognizantits.engine.galenWrapper.PageValidationWrapper;
import com.cognizant.cognizantits.engine.galenWrapper.PageWrapper;
import com.galenframework.specs.Spec;
import com.galenframework.validation.ValidationResult;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.WebElement;

/**
 *
 * 
 */
public class General extends Report {

    public enum RelativeElement {

        WebElement, WebElementList, None;

    };

    public General(CommandControl cc) {
        super(cc);
    }

    private Map<String, WebElement> getRelativeElement(RelativeElement elementType) {
        switch (elementType) {
            case WebElement:
                return getRelativeElement();
            case WebElementList:
                return getRelativeElementList();
            default:
                return new HashMap<>();
        }
    }

    private Map<String, WebElement> getRelativeElement() {
        Map<String, WebElement> elementMap = new HashMap<>();
        if (Condition != null && !Condition.trim().isEmpty()) {
            WebElement element = AObject.findElement(Condition, Reference);
            if (element != null) {
                elementMap.put(Condition, element);
            }
        }
        return elementMap;
    }

    private Map<String, WebElement> getRelativeElementList() {
        if (Condition != null && !Condition.trim().isEmpty()) {
            return getElementsfromList(Reference, Condition);
        }
        return null;
    }

    public Map<String, WebElement> getElementsfromList(String Page, String regexData) {
        return AObject.findElementsByRegex(regexData, Page);
    }

    public List<String> getElementsList() {
        if (Condition != null && !Condition.trim().isEmpty()) {
            return AObject.getObjectList(Reference, Condition);
        }
        return null;
    }

    public PageValidationWrapper getPageValidation(RelativeElement relativeElement) {
        Map<String, WebElement> elementMap = getRelativeElement(relativeElement);
        if (Element != null) {
            elementMap.put(ObjectName, Element);
        }
        return new PageValidationWrapper(getPage(relativeElement), elementMap);
    }

    private PageWrapper getPage(RelativeElement relativeElement) {
        return new PageWrapper(Driver, getRelativeElement(relativeElement));
    }

    public void validate(Spec spec, RelativeElement relativeElement) {
        try {
            PageValidationWrapper pageValidation = getPageValidation(relativeElement);
            ValidationResult result = pageValidation.check(ObjectName, spec);
            if (result.getError() != null) {
                onError(spec, result);
            } else {
                onSuccess(spec, result);

            }
        } catch (Exception ex) {
            Logger.getLogger(General.class
                    .getName()).log(Level.SEVERE, null, ex);
            onError(ex);
        }
    }

    public void validate(Spec spec) {
        validate(spec, RelativeElement.WebElement);
    }

}
