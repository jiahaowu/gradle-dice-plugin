package com.jiahaowu.gradle.dxconfig;


import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * Plugin is Created by jiahao on 10/25/16.
 */
public class DxconfigPlugin implements Plugin<Project>{
    /**
     * Apply this plugin to the given target object.
     *
     * @param target The target object
     */
    @Override
    public void apply(Project target) {
        target.getTasks().create("generateDljconfig", GenerateDljconfig.class);
    }
}
