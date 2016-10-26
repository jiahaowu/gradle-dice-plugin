package com.jiahaowu.gradle.dxconfig

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder

/**
 * CleanupDljconfigTest Created by jiahao on 10/26/16.
 */
class CleanupDljconfigTest extends GroovyTestCase {
    void testCleanup() {
        Project project = ProjectBuilder.builder().build()
        def task = project.task('cleanupDljconfig', type: CleanupDljconfig)
        assertTrue(task instanceof CleanupDljconfig)
    }
}
