package com.jiahaowu.gradle.dxconfig;

import org.gradle.api.DefaultTask;
import org.gradle.api.Project;
import org.gradle.api.tasks.TaskAction;

/**
 * GenerateDljconfig Created by jiahao on 10/25/16.
 */
public class GenerateDljconfig extends DefaultTask{
    @TaskAction
    public void write() {
        Project target = getProject();
        System.out.println(target.getAllprojects());
    }
}
