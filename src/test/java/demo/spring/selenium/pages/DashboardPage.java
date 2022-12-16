package demo.spring.selenium.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public class DashboardPage {
    @FindAll(
            {
                    @FindBy(xpath = "//*[@id=\"default_home\"]/div[1]/div/div[2]/div[1]/div[2]/h3"),
                    @FindBy(id = "error-login")

            }
    )
    WebElement listText;

    public DashboardPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void cekLogin(String text) {
        Assertions.assertTrue(listText.getText().contains(text));
    }

}
