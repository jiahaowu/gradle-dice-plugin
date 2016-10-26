package com.jiahaowu.gradle.dxconfig;

/**
 * DxconfigPluginExtension Created by jiahao on 10/26/16.
 */
public class DxconfigPluginExtension {
    private String dljroot = "";
    private String dljclasspath = "";
    private String dljtargetfile = "";
    private String dljinstalldir = "";
    private String dljverbose = "";
    private String dljcls = "";

    public String getDljroot() {
        return dljroot;
    }

    public void setDljroot(String dljroot) {
        this.dljroot = dljroot;
    }

    public String getDljclasspath() {
        return dljclasspath;
    }

    public void setDljclasspath(String dljclasspath) {
        this.dljclasspath = dljclasspath;
    }

    public String getDljtargetfile() {
        return dljtargetfile;
    }

    public void setDljtargetfile(String dljtargetfile) {
        this.dljtargetfile = dljtargetfile;
    }

    public String getDljinstalldir() {
        return dljinstalldir;
    }

    public void setDljinstalldir(String dljinstalldir) {
        this.dljinstalldir = dljinstalldir;
    }

    public String getDljverbose() {
        return dljverbose;
    }

    public void setDljverbose(String dljverbose) {
        this.dljverbose = dljverbose;
    }

    public String getDljcls() {
        return dljcls;
    }

    public void setDljcls(String dljcls) {
        this.dljcls = dljcls;
    }
}
