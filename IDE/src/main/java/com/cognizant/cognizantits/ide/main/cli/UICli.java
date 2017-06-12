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
package com.cognizant.cognizantits.ide.main.cli;

import com.cognizant.cognizantits.engine.cli.CLI.Op;
import static com.cognizant.cognizantits.engine.cli.LookUp.OPTIONS;
import com.cognizant.cognizantits.ide.main.ui.About;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.ParseException;

/**
 *
 * 
 */
public class UICli {

    public static Boolean exe(String[] args) {
        Boolean handled = true;
        try {
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(OPTIONS, args);
            for (Option op : cmd.getOptions()) {
                switch (op.getOpt()) {
                    case Op.B_DATE:
                    case Op.B_TIME:
                        System.out.println(About.getBuildDate());
                        break;
                    case Op.B_VERSION:
                        System.out.println(About.getBuildVersion());
                        break;
                    case Op.V:
                    case Op.VERSION:
                        System.out.println(String.format("%s %s",
                                About.getBuildVersion(), About.getBuildDate()));
                        break;
                    default:
                        handled = false;
                }
            }

        } catch (ParseException ex) {
            Logger.getLogger(UICli.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UICli.class.getName()).log(Level.SEVERE, null, ex);
        }
        return handled;
    }

}
