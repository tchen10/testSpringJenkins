package com.thoughtworks.acit.functional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.*;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(locations = "classpath:/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class FunctionalTests {

    @Test
    public void shouldNavigateToProjectsPage() {
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.phantomjs();
        WebDriver driver = new PhantomJSDriver(desiredCapabilities);

        driver.get("http://localhost:8080");

        WebElement projectLink = driver.findElement(By.linkText("Link to Projects"));

        projectLink.click();

        String pageTitle = driver.findElement(By.id("title")).getText();

        assertEquals(pageTitle, "All Projects");
    }
}
