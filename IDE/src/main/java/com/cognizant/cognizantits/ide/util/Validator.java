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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

  private static final String EXCLUDE_LIST = "\\S*[,|#|$|{|}|^|\\[|\\]|%]\\S*";

    public static boolean isValidName(String text) {
        Pattern pattern = Pattern.compile(
                "# Match a valid Windows filename (unspecified file system).          \n"
                + "^                                    # Anchor to start of string.        \n"
                + "(?!                                  # Assert filename is not: CON, PRN, \n"
                + "  (?:                                # AUX, NUL, COM1, COM2, COM3, COM4, \n"
                + "    CON|PRN|AUX|NUL|                 # COM5, COM6, COM7, COM8, COM9,     \n"
                + "    COM[1-9]|LPT[1-9]                # LPT1, LPT2, LPT3, LPT4, LPT5,     \n"
                + "  )                                  # LPT6, LPT7, LPT8, and LPT9...     \n"
                + "  (?:\\.[^.]*)?                      # followed by optional extension    \n"
                + "  $                                  # and end of string                 \n"
                + ")                                    # End negative lookahead assertion. \n"
                + "[^<>:\"/\\\\|?*\\x00-\\x1F]*         # Zero or more valid filename chars.\n"
                + "[^<>:\"/\\\\|?*\\x00-\\x1F\\ .]      # Last char is not a space or dot.  \n"
                + "$                                    # Anchor to end of string.            ",
                Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE | Pattern.COMMENTS);
        Matcher matcher = pattern.matcher(text);
        return matcher.matches() && !text.matches(EXCLUDE_LIST);
    }
}
