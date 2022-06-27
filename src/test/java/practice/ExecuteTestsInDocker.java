package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ExecuteTestsInDocker {


    @Test(dataProvider = "getData")
    public void test1(String browser) throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName(browser);
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
        driver.get("https://google.com");
        System.out.println("Title is : " + driver.getTitle());
        driver.quit();
    }

    @DataProvider(parallel = true)
    public Object[][]getData(){
        return new Object[][]{
                {"chrome"},
                {"chrome"}
               /* {"firefox"},
                {"firefox"}*/
        };
    }

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");

    }
}
