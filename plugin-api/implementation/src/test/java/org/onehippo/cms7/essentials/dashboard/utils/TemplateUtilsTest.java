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

package org.onehippo.cms7.essentials.dashboard.utils;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.onehippo.cms7.essentials.BaseTest;
import org.onehippo.cms7.essentials.dashboard.ctx.PluginContext;
import org.onehippo.cms7.essentials.dashboard.utils.beansmodel.MemoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * @version "$Id$"
 */
public class TemplateUtilsTest extends BaseTest {

    public static final int EXPECTED_PROPERTY_SIZE = 7;
    private static Logger log = LoggerFactory.getLogger(TemplateUtilsTest.class);
    private List<MemoryBean> memoryBeans;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        populateExistingBeans();

    }

    @Test
    public void testParseBeanProperties() throws Exception {
        assertTrue(memoryBeans != null);
        for (MemoryBean memoryBean : memoryBeans) {
            final Path beanPath = memoryBean.getBeanPath();
            if (beanPath != null && memoryBean.getName().equals("newsdocument")) {
                final List<TemplateUtils.PropertyWrapper> propertyWrappers = TemplateUtils.parseBeanProperties(beanPath);
                final int size = propertyWrappers.size();
                assertEquals(String.format("Expected %d methods but got, %d", EXPECTED_PROPERTY_SIZE, size), EXPECTED_PROPERTY_SIZE, size);
                for (TemplateUtils.PropertyWrapper propertyWrapper : propertyWrappers) {
                    final String propertyExpression = propertyWrapper.getFormattedJspProperty("document");
                    assertNotEquals(String.format("Expected property expression to be populated: %s", propertyWrapper.getPropertyName()),"", propertyExpression);
                }
            }
        }


    }

    @Test
    public void testInjectTemplate() throws Exception {

        final Map<String, Object> data = new HashMap<>();
        data.put("beanReference", "com.test.MyBean");
        final Collection<String> listObject = new ArrayList<>();
        listObject.add("repeatable item");
        data.put("repeatable", listObject);
        String result = TemplateUtils.injectTemplate("test_template.ftl", data, getClass());
        log.info("result {}", result);
        assertTrue(result.contains("com.test.MyBean"));
        assertTrue(result.contains("repeatable item"));
    }

    private void populateExistingBeans() {
        final PluginContext context = getContext();
        context.setProjectNamespacePrefix(HIPPOPLUGINS_NAMESPACE);
        memoryBeans = BeanWriterUtils.buildBeansGraph(getProjectRoot(), context, "txt");

    }

}