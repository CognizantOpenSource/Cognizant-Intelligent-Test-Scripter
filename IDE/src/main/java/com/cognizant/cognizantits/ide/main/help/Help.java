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
package com.cognizant.cognizantits.ide.main.help;

import com.cognizant.cognizantits.ide.main.utils.Utils;
import com.cognizant.cognizantits.ide.settings.AppSettings;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 *
 */
public class Help {

    public static void openHelp() {
        Help.openInBrowser("Couldn't Open Help in default Browser", asURI(AppSettings.getHelpLoc()));
    }

    public static void openSchedulerHelp() {
        Help.openInBrowser(
                "Couldn't Open Help in default Browser",
                asURI(AppSettings.getHelpLoc() + "/faq/thingsushdknow/index.html#how-to-schedule-tasks-with-cognizant-intelligent-test-scripter"));
    }

    public static void openEnvBasedExec() {
        Help.openInBrowser(
                "Couldn't Open Help in default Browser",
                asURI(AppSettings.getHelpLoc() + "/faq/thingsushdknow/index.html#environment-based-execution"));
    }

    public static void openTMHelp() {
        Help.openInBrowser(
                "Couldn't Open Help in default Browser",
                asURI(AppSettings.getHelpLoc() + "/faq/thirdpartytool/index.html#how-to-configure-your-test-management-tool"));
    }

    private static URI asURI(String url) {
        try {
            return new URI(url);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Help.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * If possible this method opens the default browser to the specified web
     * page. If not it notifies the user of webpage's url so that they may
     * access it manually.
     *
     * @param message Error message to display
     * @param uri
     */
    public static void openInBrowser(String message, URI uri) {
        try {
            java.util.logging.Logger.getLogger(Help.class.getName()).log(Level.INFO, "Opening url {0}", uri);
            Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
            if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                desktop.browse(uri);
            } else {
                throw new UnsupportedOperationException("Desktop Api Not supported in this System");
            }
        } catch (Exception e) {
            java.util.logging.Logger.getLogger(Help.class.getName()).log(Level.WARNING, null, e);
            // Copy URL to the clipboard so the user can paste it into their browser
            Utils.copyTextToClipboard(uri.toString());
            // Notify the user of the failure
            JOptionPane.showMessageDialog(null, message + "\n"
                    + "The URL has been copied to your clipboard, simply paste into your browser to access.\n"
                    + "Webpage: " + uri);
        }
    }

}
