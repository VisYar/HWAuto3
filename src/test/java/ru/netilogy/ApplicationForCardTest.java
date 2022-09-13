package ru.netilogy;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplicationForCardTest {
    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("http://localhost:9999/");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }
    @Test
    void test0() {
        driver.findElement(By.cssSelector("[data-test-id = name] input")).sendKeys("Тим Ирина");
        driver.findElement(By.cssSelector("[data-test-id = phone] input")).sendKeys("+79109105566");
        driver.findElement(By.cssSelector("[data-test-id = agreement]")).click();
        driver.findElement(By.className("button")).click();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("[data-test-id = order-success]")).getText().trim();
        assertEquals(expected, actual);
    }

    @Test
    void test1() {
        driver.findElement(By.cssSelector("[data-test-id = name] input")).sendKeys("Тим-Ким Ирина");
        driver.findElement(By.cssSelector("[data-test-id = phone] input")).sendKeys("+79109105566");
        driver.findElement(By.cssSelector("[data-test-id = agreement]")).click();
        driver.findElement(By.className("button")).click();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("[data-test-id = order-success]")).getText().trim();
        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        driver.findElement(By.cssSelector("[data-test-id = name] input")).sendKeys("Тим Ким Ирина");
        driver.findElement(By.cssSelector("[data-test-id = phone] input")).sendKeys("+79109105566");
        driver.findElement(By.cssSelector("[data-test-id = agreement]")).click();
        driver.findElement(By.className("button")).click();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("[data-test-id = order-success]")).getText().trim();
        assertEquals(expected, actual);
    }

    @Test
    void test3() {
        driver.findElement(By.cssSelector("[data-test-id = name] input")).sendKeys("Тим-ким Ирина");
        driver.findElement(By.cssSelector("[data-test-id = phone] input")).sendKeys("+79109105566");
        driver.findElement(By.cssSelector("[data-test-id = agreement]")).click();
        driver.findElement(By.className("button")).click();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("[data-test-id = order-success]")).getText().trim();
        assertEquals(expected, actual);
    }

    @Test
    void test4() {
        driver.findElement(By.cssSelector("[data-test-id = name] input")).sendKeys("Тим Анна-Мария");
        driver.findElement(By.cssSelector("[data-test-id = phone] input")).sendKeys("+79109105566");
        driver.findElement(By.cssSelector("[data-test-id = agreement]")).click();
        driver.findElement(By.className("button")).click();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("[data-test-id = order-success]")).getText().trim();
        assertEquals(expected, actual);
    }

    @Test
    void test5() {
        driver.findElement(By.cssSelector("[data-test-id = name] input")).sendKeys("Тим Анна Мария");
        driver.findElement(By.cssSelector("[data-test-id = phone] input")).sendKeys("+79109105566");
        driver.findElement(By.cssSelector("[data-test-id = agreement]")).click();
        driver.findElement(By.className("button")).click();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("[data-test-id = order-success]")).getText().trim();
        assertEquals(expected, actual);
    }

    @Test
    void test6() {
        driver.findElement(By.cssSelector("[data-test-id = name] input")).sendKeys("О И");
        driver.findElement(By.cssSelector("[data-test-id = phone] input")).sendKeys("+79109105566");
        driver.findElement(By.cssSelector("[data-test-id = agreement]")).click();
        driver.findElement(By.className("button")).click();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("[data-test-id = order-success]")).getText().trim();
        assertEquals(expected, actual);
    }
}
