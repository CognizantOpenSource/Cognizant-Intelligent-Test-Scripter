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
package com.cognizant.storywriter.util;

import java.awt.Event;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 */
public class Keystroke {
    public static final KeyStroke comment = KeyStroke.getKeyStroke(KeyEvent.VK_SLASH, Event.CTRL_MASK);
    public static final KeyStroke delete = KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0);
    public static final KeyStroke rename = KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0);
    public static final KeyStroke cut = KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.CTRL_MASK);
    public static final KeyStroke copy = KeyStroke.getKeyStroke(KeyEvent.VK_C, Event.CTRL_MASK);
    public static final KeyStroke paste = KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK);
    public static final KeyStroke addrow = KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, Event.CTRL_MASK);
    public static final KeyStroke addrowx = KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, Event.CTRL_MASK);
    public static final KeyStroke removerow = KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, Event.CTRL_MASK);
    public static final KeyStroke up = KeyStroke.getKeyStroke(KeyEvent.VK_UP, Event.CTRL_MASK);
    public static final KeyStroke down = KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, Event.CTRL_MASK);
    public static final KeyStroke back = KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, KeyEvent.ALT_MASK);
    public static final KeyStroke next = KeyStroke.getKeyStroke(KeyEvent.VK_UP, KeyEvent.ALT_MASK);
    public static final KeyStroke addcol = KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, Event.ALT_MASK);
    public static final KeyStroke addcolx = KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, Event.ALT_MASK);
    public static final KeyStroke removecol = KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, Event.ALT_MASK);
    
}
