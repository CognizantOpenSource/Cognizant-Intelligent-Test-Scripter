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
package com.cognizant.cognizantits.ide.util;

import com.cognizant.cognizantits.ide.main.utils.toasterNotification.Toaster;
import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * 
 */
public class Notification {

    public static Boolean deleteConfirmation = true;
    private static final Toaster TOASTER_MANAGER = new Toaster();

    public static void show(String message) {
        show(null, message);
    }

    public static void show(Component parent, String message) {
        TOASTER_MANAGER.showToaster(parent, message);
    }

    public static Boolean showDeleteConfirmation() {
        return showDeleteConfirmation("Are you sure want to delete?");
    }

    public static Boolean showDeleteConfirmation(String message) {
        if (deleteConfirmation) {
            int value = JOptionPane.showConfirmDialog(null, message, "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            return value == JOptionPane.YES_OPTION;
        }
        return true;
    }

}
