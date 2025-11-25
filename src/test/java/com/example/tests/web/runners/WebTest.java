package com.example.tests.web.runners;
import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/web")
@ConfigurationParameter(key = "cucumber.glue", value = "com.example.tests.web.steps")
public class WebTest {
}
