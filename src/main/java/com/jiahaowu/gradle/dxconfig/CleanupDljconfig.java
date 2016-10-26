package com.jiahaowu.gradle.dxconfig;

import org.gradle.api.DefaultTask;
import org.gradle.api.GradleException;
import org.gradle.api.file.SourceDirectorySet;
import org.gradle.api.plugins.JavaPluginConvention;
import org.gradle.api.tasks.SourceSet;
import org.gradle.api.tasks.TaskAction;

import java.io.File;

/**
 * CleanupDljconfig Created by jiahao on 10/26/16.
 */
public class CleanupDljconfig extends DefaultTask {
    @TaskAction
    public void cleanup() {
        JavaPluginConvention javaPlugin = getProject().getConvention().getPlugin(JavaPluginConvention.class);
        if (javaPlugin == null) {
            throw new GradleException("You must apply the java plugin before the dxconfig plugin if you are using the java extension.");
        }
        SourceSet mainSourceSet = javaPlugin.getSourceSets().getByName(SourceSet.MAIN_SOURCE_SET_NAME);
        SourceDirectorySet allOther = mainSourceSet.getResources();
        for (File file : allOther.getAsFileTree().getFiles()) {
            System.out.print(file.getName());
            if (file.getName().equals("dljconfig") || file.getName().equals("makeme")) {
                if (!file.delete()) {
                    System.err.println("Failed to delete " + file.getAbsolutePath());
                }
            }
        }
        System.out.println("dxconfig has been removed");
    }
}
