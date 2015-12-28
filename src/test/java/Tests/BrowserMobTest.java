package Tests;

import Common.TestHelper;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.ProxyServer;

import org.junit.*;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileOutputStream;

public class BrowserMobTest {
    public static ProxyServer server;
    private static Proxy proxy;

    @BeforeClass
    public static void setUpProxy() throws Exception {
        server = new ProxyServer(4444);
        server.start();
        proxy = server.seleniumProxy();
    }

    @Before
    public void createNewHar() {
        server.newHar("yandex.ru");
    }

    /**
     * ChromeDriver
     */
    @Test
    public void testChromeDriver() throws Exception {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--proxy-server=localhost:"
                + server.getPort());

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(option);

        driver.get("http://yandex.ru");

        driver.quit();
    }

    /**
     * InternetExplorerDriver
     */
    @Test
    public void testFIrefoxDriver() throws Exception {
        DesiredCapabilities capabilities =
                DesiredCapabilities.firefox();
        capabilities.setCapability(CapabilityType.PROXY, proxy);
        capabilities.setCapability("ie.setProxyByServer", true);
        WebDriver driver = new FirefoxDriver(capabilities);

        driver.get("http://yandex.ru");

        driver.quit();
    }

    @After
    public void saveHAR() throws Exception {
        Har har = server.getHar();
        File file = new File("C:\\results\\"
                + har.getLog().getBrowser().getName() + ".har");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        try {
            har.writeTo(fos);
        } finally {
            fos.close();
        }
    }

    @AfterClass
    public static void stopProxyServer() throws Exception {
        server.stop();
    }
}
