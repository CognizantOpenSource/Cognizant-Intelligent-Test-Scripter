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
package com.cognizant.cognizantits.datalib.settings;

import com.cognizant.cognizantits.datalib.settings.emulators.Emulator;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 */
public class Emulators {

    private List<Emulator> emulators;

    private String location;

    private final ObjectMapper objMapper;

    public Emulators(String location) {
        this.location = location;
        this.objMapper = new ObjectMapper();
        emulators = new ArrayList<>();
        load();
    }

    private void load() {
        File emFile = new File(getLocation());
        if (emFile.exists()) {
            try {
                emulators = objMapper.readValue(emFile, objMapper.getTypeFactory().constructCollectionType(List.class, Emulator.class));
            } catch (IOException ex) {
                Logger.getLogger(Emulators.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void addAppiumEmulator(String emulatorName, String url) {
        addEmulator(emulatorName);
        getEmulator(emulatorName).setType("Remote URL");
        getEmulator(emulatorName).setRemoteUrl(url);
    }

    public void addEmulator(String emulatorName) {
        if (getEmulator(emulatorName) == null) {
            emulators.add(new Emulator(emulatorName));
        }
    }

    public void deleteEmulator(String emulatorName) {
        Emulator emul = getEmulator(emulatorName);
        if (emul != null) {
            emulators.remove(emul);
        }
    }

    public Boolean renameEmulator(String oldName, String newName) {
        Emulator old = getEmulator(oldName);
        if (old != null) {
            Emulator emul = getEmulator(newName);
            if (emul == null) {
                old.setName(newName);
                return true;
            }
        }
        return false;
    }

    public List<Emulator> getEmulators() {
        return emulators;
    }

    public List<String> getAppiumEmulatorNames() {
        List<String> emulatorNames = new ArrayList<>();
        for (Emulator emulator : emulators) {
            if (Objects.equals(emulator.getType(), "Remote URL")) {
                emulatorNames.add(emulator.getName());
            }
        }
        return emulatorNames;
    }

    public List<String> getEmulatorNames() {
        List<String> emulatorNames = new ArrayList<>();
        for (Emulator emulator : emulators) {
            emulatorNames.add(emulator.getName());
        }
        return emulatorNames;
    }

    public Emulator getEmulator(String emulatorName) {
        for (Emulator emulator : emulators) {
            if (emulator.getName().equals(emulatorName)) {
                return emulator;
            }
        }
        return null;
    }

    public void save() {
        File emFile = new File(getLocation());
        if (!emFile.getParentFile().exists()) {
            emFile.getParentFile().mkdirs();
        }
        try {
            objMapper.writeValue(emFile, emulators);
        } catch (IOException ex) {
            Logger.getLogger(Emulators.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getLocation() {
        return location + File.separator + "Emulators.json";
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
