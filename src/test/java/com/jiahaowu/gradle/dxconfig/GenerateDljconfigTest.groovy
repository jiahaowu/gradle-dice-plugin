package com.jiahaowu.gradle.dxconfig

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

/**
 * Created by jiahao on 10/25/16.
 */
class GenerateDljconfigTest extends GroovyTestCase {
    @Test
    void testWrite() {
        Project project = ProjectBuilder.builder().build()
        def task = project.task('generateDljconfig', type: GenerateDljconfig)
        assertTrue(task instanceof GenerateDljconfig)
    }
}
