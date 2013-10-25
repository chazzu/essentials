/*
 * Copyright 2013 Hippo B.V. (http://www.onehippo.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.onehippo.cms7.essentials.dashboard.instruction;

import java.util.Set;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.onehippo.cms7.essentials.dashboard.instructions.InstructionSet;
import org.onehippo.cms7.essentials.dashboard.instructions.Instructions;
import org.onehippo.cms7.essentials.dashboard.model.PluginScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @version "$Id$"
 */
@XmlRootElement(name = "instructions", namespace = "http://www.onehippo.org/essentials/instructions")
public class PluginInstructions implements Instructions {

    private static Logger log = LoggerFactory.getLogger(PluginInstructions.class);

    private Set<InstructionSet> instructionSets;

    @Override
    public void setInstructionSets(final Set<InstructionSet> instructionSets) {
        this.instructionSets = instructionSets;
    }


    @XmlElementRefs({@XmlElementRef(type = PluginInstructionSet.class)})
    @Override
    public Set<InstructionSet> getInstructionSets() {
        return instructionSets;
    }
}