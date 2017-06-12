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
package com.cognizant.storywriter.bdd.editor;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.function.Function;
import java.util.stream.Stream;
import org.fife.ui.autocomplete.*;
import org.fife.ui.rsyntaxtextarea.AbstractTokenMakerFactory;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.TokenMakerFactory;
import org.fife.ui.rtextarea.RTextScrollPane;
import com.cognizant.storywriter.parser.BDDTokenMaker;

public abstract class StyledEditor extends RSyntaxTextArea {

    DefaultCompletionProvider provider;

    public StyledEditor() {
        provider = new DefaultCompletionProvider();
    }

    static {
        ((AbstractTokenMakerFactory) TokenMakerFactory.getDefaultInstance())
                .putMapping(getStyleDoc(), BDDTokenMaker.class.getName());
    }

    private static String getStyleDoc() {
        return "text/gherkin-bdd";
    }

    private void initProvider() {
        provider.clear();
        addToProvider(keywords());
    }

    private Stream<String> keywords() {
        return Stream.of("Feature: ", "Scenario: ", "Background", "Scenario Outline: ", "Given",
                "When", "Then", "But", "And", "Example");
    }

    private CompletionProvider addToProvider(Stream<String> words) {
        words.map(word -> new BasicCompletion(provider, word))
                .forEach(provider::addCompletion);
        return provider;
    }
    private static boolean isSave(KeyEvent ke) {
        return (ke.isMetaDown() || ke.isControlDown()) && ke.getKeyCode() == KeyEvent.VK_S;
    }

    private static boolean isFormat(KeyEvent ke) {
        return ke.isShiftDown() && ke.getKeyCode() == KeyEvent.VK_F;
    }

    public KeyListener updateProviderOnSave() {
        return new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                if (isSave(ke)) {
                    onSave();
                }
            }
        };
    }

    abstract public void onSave();

    public void updateAutoComplete() {
        initProvider();
        addToProvider(Stream.of(getText().split("\n"))
                .map(line -> line.trim())
                .filter(line -> !line.startsWith("#"))
                .map(line -> keywords()
                        .map(word -> (Function<String, String>) inLine -> inLine.replaceAll(word, ""))
                        .reduce(Function.identity(), Function::andThen)
                        .apply(line).trim()));
    }

    private KeyListener formatListener() {
        return new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                if (isFormat(ke)) {
                }
            }
        };
    }

    public StyledEditor setup() {
        setCodeFoldingEnabled(true);
        setSyntaxEditingStyle(getStyleDoc());
        initProvider();
        installAutoComplete();
        addKeyListener(updateProviderOnSave());
        return this;
    }

    public RTextScrollPane getScrollView() {
        return new RTextScrollPane(this);
    }

    private void installAutoComplete() {
        AutoCompletion ac = new AutoCompletion(provider);
        ac.install(this);
    }

}
