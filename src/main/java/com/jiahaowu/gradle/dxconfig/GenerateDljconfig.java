package com.jiahaowu.gradle.dxconfig;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.gradle.api.DefaultTask;
import org.gradle.api.GradleException;
import org.gradle.api.file.SourceDirectorySet;
import org.gradle.api.internal.file.UnionFileCollection;
import org.gradle.api.plugins.JavaPluginConvention;
import org.gradle.api.tasks.SourceSet;
import org.gradle.api.tasks.TaskAction;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * GenerateDljconfig Created by jiahao on 10/25/16.
 */
public class GenerateDljconfig extends DefaultTask {
    @TaskAction
    public void write() throws Exception {
        JavaPluginConvention javaPlugin = getProject().getConvention().getPlugin(JavaPluginConvention.class);
        DxconfigPluginExtension extension = getProject().getExtensions().findByType(DxconfigPluginExtension.class);
        if (extension == null) {
            extension = new DxconfigPluginExtension();
        }
        if (javaPlugin == null) {
            throw new GradleException("You must apply the java plugin before the dxconfig plugin if you are using the java extension.");
        }
        UnionFileCollection union = new UnionFileCollection();
        for (SourceSet sourceSet : javaPlugin.getSourceSets()) {
            union.add(sourceSet.getJava());
        }

        SourceSet mainSourceSet = javaPlugin.getSourceSets().getByName(SourceSet.MAIN_SOURCE_SET_NAME);
        SourceDirectorySet allJava = mainSourceSet.getAllJava();
        System.out.println(allJava.getSrcDirs());

        Map<String, List<String>> map = new HashMap<>();
        for (File file : allJava.getAsFileTree().getFiles()) {
            String dirName = file.getParent();
            if (!map.containsKey(dirName)) {
                map.put(dirName, new ArrayList<>());
            }
            List<String> list = map.get(dirName);
            list.add(file.getName().replace(".java", ".class"));
        }

        System.out.println(map);

        /* Create and adjust the configuration singleton */
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
        cfg.setClassForTemplateLoading(this.getClass(), "/templates/");
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);

        for (String dirName : map.keySet()) {
            String classNames = map.get(dirName).toString().replace("[", "").replace("]", "").replace(",", " \\\n");
            Map<String, DxconfigPluginExtension> root = new HashMap<>();
            extension.setDljcls(classNames);
            root.put("ext", extension);
            /* Get the template */
            Template temp = cfg.getTemplate("dljconfig.ftl");
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(dirName + "/dljconfig"), "utf-8"))) {
                temp.process(root, writer);
                writer.close();
                File res = new File(dirName + "/dljconfig");
                if (!res.setExecutable(true)) {
                    System.err.println("Failed to set " + dirName + "/dljconfig to executable.");
                }
            }

            temp = cfg.getTemplate("makeme.ftl");
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(dirName + "/makeme"), "utf-8"))) {
                temp.process(root, writer);
                writer.close();
                File res = new File(dirName + "/makeme");
                if (!res.setExecutable(true)) {
                    System.err.println("Failed to set " + dirName + "/makeme to executable.");
                }
            }
        }
    }
}
