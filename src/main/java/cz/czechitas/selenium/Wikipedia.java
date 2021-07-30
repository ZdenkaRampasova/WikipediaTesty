package cz.czechitas.selenium;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Wikipedia {

    WebDriver prohlizec;

    @BeforeEach
    public void setUp() {
//      System.setProperty("webdriver.gecko.driver", System.getProperty("user.home") + "/Java-Training/Selenium/geckodriver");
        System.setProperty("webdriver.gecko.driver", "C:\\Java-Training\\Selenium\\geckodriver.exe");
        prohlizec = new FirefoxDriver();
        prohlizec.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void notAllRoadsLeadToPhilosophy() {
        prohlizec.navigate().to("https://cs.wikipedia.org/wiki/Testov%C3%A1n%C3%AD_softwaru");

        int pocetPrechodu = 0;

        while (!prohlizec.getCurrentUrl().endsWith("/Filosofie")) {
            WebElement prvniOdkaz = prohlizec.findElement(By.xpath("//div/p/a[@href]"));
            prvniOdkaz.click();
            pocetPrechodu = ++pocetPrechodu;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("K filosofii vedlo " + pocetPrechodu + " klikanců.");

        Assertions.assertTrue(prohlizec.getCurrentUrl().endsWith("//Filosofie"));
    }

    @Test
    public void allRoadsLeadToRoads() {
        prohlizec.navigate().to("https://cs.wikipedia.org/wiki/Plat%C3%B3n");

        int pocetPrechodu = 0;

        while (!prohlizec.getCurrentUrl().endsWith("/Filosofie")) {
            WebElement prvniOdkaz = prohlizec.findElement(By.xpath("//div/p/a[@href]"));
            prvniOdkaz.click();
            pocetPrechodu = ++pocetPrechodu;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("K filosofii vedlo " + pocetPrechodu + " klikanců.");

        Assertions.assertTrue(prohlizec.getCurrentUrl().endsWith("//Filosofie"));
    }

    @Test
    public void atLeastOneRoadLeadsToPhilosophy() {
        prohlizec.navigate().to("https://cs.wikipedia.org/wiki/Filosof");

        int pocetPrechodu = 0;

        while (!prohlizec.getCurrentUrl().endsWith("/Filosofie")) {
            WebElement prvniOdkaz = prohlizec.findElement(By.xpath("//div/p/a[@href]"));
            prvniOdkaz.click();
            pocetPrechodu = ++pocetPrechodu;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("K filosofii vedlo " + pocetPrechodu + " klikanců.");

        Assertions.assertTrue(prohlizec.getCurrentUrl().endsWith("/Filosofie"));
    }

    @AfterEach
    public void tearDown() {
        prohlizec.close();
    }
}
