package demo.spring.selenium.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
        final String DOCKER_HOST = "https://fab8-182-0-243-179.ap.ngrok.io";
        String remote = String.format("%s/wd/hub",DOCKER_HOST);
        return new RemoteWebDriver(new URL(remote),new ChromeOptions());
    }
}
