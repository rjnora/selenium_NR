package demo.spring.selenium.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;

@Component
public class WebDriverManager {
    //    @Autowired
//    private ConfigProperties properties;
    @Value("${browser}")
    private String browser;

    @Bean
    @Scope("cucumber-glue")
    public WebDriver webDriverFactory() throws MalformedURLException {
//        return new ChromeDriver();
//        if (browser.equalsIgnoreCase("chrome")) {
//            return new ChromeDriver();
//        } else if (browser.equalsIgnoreCase("firefox")) {
//            return new FirefoxDriver();
//        }
//        return null;
//        final String DOCKER_HOST = "https://96fe-202-165-38-66.ap.ngrok.io";
        final String DOCKER_HOST = "http://localhost:4444";
        String remote = String.format("%s/wd/hub",DOCKER_HOST);
        return new RemoteWebDriver(new URL(remote),new ChromeOptions());
//        return new RemoteWebDriver(new URL(remote),new EdgeOptions());
    }
}