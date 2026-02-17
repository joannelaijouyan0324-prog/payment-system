# Setup Notes – Spring Boot Payment System
`This file is about how to make this project run`

## Issue
`java: error: release version 5 not supported`

## Context
While running the Spring Boot application, Maven attempted to compile the project using Java 1.5, even though the project SDK was set to Java 17.

## Root Cause
The default `maven-compiler-plugin` configuration did not explicitly define the Java release version.  
As a result, Maven fell back to an outdated default (Java 1.5).

## Fix

### Before

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <configuration>
        <annotationProcessorPaths>
            <path>
                <groupId>org.projectlombok</groupId>
                <artifactId>lombok</artifactId>
            </path>
        </annotationProcessorPaths>
    </configuration>
</plugin>
```

### After

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.11.0</version>
    <configuration>
        <release>17</release>
    </configuration>
</plugin>
```

