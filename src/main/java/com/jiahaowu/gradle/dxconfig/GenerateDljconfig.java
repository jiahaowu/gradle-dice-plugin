package com.jiahaowu.gradle.dxconfig;

import org.gradle.api.DefaultTask;
import org.gradle.api.GradleException;
import org.gradle.api.internal.file.UnionFileCollection;
import org.gradle.api.plugins.JavaPluginConvention;
import org.gradle.api.tasks.SourceSet;
import org.gradle.api.tasks.TaskAction;

/**
 * GenerateDljconfig Created by jiahao on 10/25/16.
 */
public class GenerateDljconfig extends DefaultTask {
    @TaskAction
    public void write() throws Exception {
        JavaPluginConvention javaPlugin = getProject().getConvention().getPlugin(JavaPluginConvention.class);
        if (javaPlugin == null) {
            throw new GradleException("You must apply the java plugin before the dxconfig plugin if you are using the java extension.");
        }
        UnionFileCollection union = new UnionFileCollection();
        for (SourceSet sourceSet : javaPlugin.getSourceSets()) {
            union.add(sourceSet.getJava());
        }
    }
}
