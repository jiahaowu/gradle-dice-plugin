# Installation

Clone this repository on local machine and run `gradle install`. Then this plugin will be installed on your local maven repository.

# Usage

Add the following code into `build.gradle` script.

```groovy
buildscript {
    repositories {
        mavenLocal()
        jcenter()
    }
    dependencies {
        classpath 'com.jiahaowu.gradle:dxconfigPlugin:1.0-SNAPSHOT'
    }
}
```

and add the following code into project configuration:

```groovy
project('experiment') {
    apply plugin: 'com.jiahaowu.gradle.dxconfig.plugin'
    dependencies {
        compile project(':dif/pub')
    }

    dxconfig{
        dljverbose = "-v"
    }

    sourceSets.main.java.srcDirs =  ['src']
    sourceSets.main.resources.srcDirs = ['src']
}
```