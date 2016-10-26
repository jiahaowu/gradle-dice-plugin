package com.jiahaowu.gradle.dxconfig

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

/**
 * DxconfigPluginTest Created by jiahao on 10/25/16.
 */
class DxconfigPluginTest extends GroovyTestCase {
    @Test
    void testApply() {
        Project project = ProjectBuilder.builder().build()
        project.getPlugins().apply 'com.jiahaowu.gradle.dxconfig.plugin'
        assertTrue(project.tasks.generateDljconfig instanceof GenerateDljconfig)

    }
}
