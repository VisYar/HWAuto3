package ru.netilogy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApplicationForCardNegativeTest {
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
        driver.findElement(By.cssSelector("[data-test-id = name] input")).sendKeys("Tim Irina");
        driver.findElement(By.cssSelector("[data-test-id = phone] input")).sendKeys("+79109105566");
        driver.findElement(By.cssSelector("[data-test-id = agreement]")).click();
        driver.findElement(By.className("button")).click();
        String expected = "Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.";
        String actual = driver.findElement(By.cssSelector("[data-test-id = name].input_invalid .input__sub")).getText().trim();
        assertEquals(expected, actual);
    }

    @Test
    void test1() {
        driver.findElement(By.cssSelector("[data-test-id = name] input")).clear();
        driver.findElement(By.cssSelector("[data-test-id = phone] input")).sendKeys("+79109105566");
        driver.findElement(By.cssSelector("[data-test-id = agreement]")).click();
        driver.findElement(By.className("button")).click();
        String expected = "Поле обязательно для заполнения";
        String actual = driver.findElement(By.cssSelector("[data-test-id = name].input_invalid .input__sub")).getText().trim();
        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        driver.findElement(By.cssSelector("[data-test-id = name] input")).sendKeys("Тим Ирина");
        driver.findElement(By.cssSelector("[data-test-id = phone] input")).sendKeys("+791091055666");
        driver.findElement(By.cssSelector("[data-test-id = agreement]")).click();
        driver.findElement(By.className("button")).click();
        String expected = "Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.";
        String actual = driver.findElement(By.cssSelector("[data-test-id = phone].input_invalid .input__sub")).getText().trim();
        assertEquals(expected, actual);
    }

    @Test
    void test3() {
        driver.findElement(By.cssSelector("[data-test-id = name] input")).sendKeys("Тим Ирина");
        driver.findElement(By.cssSelector("[data-test-id = phone] input")).clear();
        driver.findElement(By.cssSelector("[data-test-id = agreement]")).click();
        driver.findElement(By.className("button")).click();
        String expected = "Поле обязательно для заполнения";
        String actual = driver.findElement(By.cssSelector("[data-test-id = phone].input_invalid .input__sub")).getText().trim();
        assertEquals(expected, actual);
    }

    @Test
    void test4() {
        driver.findElement(By.cssSelector("[data-test-id = name] input")).sendKeys("Тим Ирина");
        driver.findElement(By.cssSelector("[data-test-id = phone] input")).sendKeys("+79109105566");
        driver.findElement(By.className("button")).click();
        boolean actual = driver.findElement(By.cssSelector("[data-test-id = agreement].input_invalid .checkbox__text")).isDisplayed();
        assertTrue(actual);
    }
}
