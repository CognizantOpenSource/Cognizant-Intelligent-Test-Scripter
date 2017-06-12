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
package com.cognizant.storywriter.bdd.renderer;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import com.cognizant.storywriter.bdd.data.Story;

/**
 *
 */
public class StoryListRenderer extends BDDListButton implements ListCellRenderer<Story> {

   
    public StoryListRenderer() {
       super();
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Story> list,
            Story value, int index, boolean isSelected, boolean cellHasFocus) {
        setText(getRenderedLable(value, index));     
        if (isSelected ) {
            this.setBackground(new java.awt.Color(197, 178, 178));
        } else {
            this.setBackground(new java.awt.Color(255, 255, 255));
        }
        return this;
    }

    private String getRenderedLable(Story value, int index) {
        return Template.replace("[-NAME-]", value.type + " " + ++index)
                .replace("[-DESC-]", value.name);
    }

}
