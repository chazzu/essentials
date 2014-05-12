/*
 * Copyright 2014 Hippo B.V. (http://www.onehippo.com)
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

package org.onehippo.cms7.essentials.dashboard.config;


import javax.xml.bind.annotation.XmlRootElement;

import org.onehippo.cms7.essentials.dashboard.utils.annotations.PersistentNode;
import org.onehippo.cms7.essentials.dashboard.utils.annotations.PersistentProperty;

/**
 * @version "$Id$"
 */

@XmlRootElement(name = "project")
@PersistentNode(type = "essentials:document")
public class ProjectSettingsBean extends BaseDocument {


    @PersistentProperty(name = "projectNamespace")
    private String projectNamespace;
    @PersistentProperty(name = "selectedBeansPackage")
    private String selectedBeansPackage;
    @PersistentProperty(name = "selectedComponentsPackage")
    private String selectedComponentsPackage;
    @PersistentProperty(name = "selectedRestPackage")
    private String selectedRestPackage;
    @PersistentProperty(name = "setupDone")
    private Boolean setupDone;

    public ProjectSettingsBean() {
    }

    public ProjectSettingsBean(final String name) {
        super(name);
    }

    public ProjectSettingsBean(final String name, final String path) {
        super(name, path);
    }


    public Boolean getSetupDone() {
        return setupDone == null ? false : setupDone;
    }

    public void setSetupDone(final Boolean setupDone) {
        if (setupDone == null) {
            this.setupDone = false;
        } else {
            this.setupDone = setupDone;
        }
    }

    public String getProjectNamespace() {
        return projectNamespace;
    }

    public void setProjectNamespace(final String projectNamespace) {
        this.projectNamespace = projectNamespace;
    }

    public String getSelectedRestPackage() {
        return selectedRestPackage;
    }

    public void setSelectedRestPackage(final String selectedRestPackage) {
        this.selectedRestPackage = selectedRestPackage;
    }

    public String getSelectedBeansPackage() {
        return selectedBeansPackage;
    }

    public void setSelectedBeansPackage(final String selectedBeansPackage) {
        this.selectedBeansPackage = selectedBeansPackage;
    }

    public String getSelectedComponentsPackage() {
        return selectedComponentsPackage;
    }

    public void setSelectedComponentsPackage(final String selectedComponentsPackage) {
        this.selectedComponentsPackage = selectedComponentsPackage;
    }
}
