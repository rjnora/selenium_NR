package demo.spring.selenium.stepdefinitions;

import demo.spring.selenium.pages.DashboardPage;
import demo.spring.selenium.pages.HomePage;
import io.cucumber.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

public class DashboardPageSteps {
    //    private DashboardPage dashboardPage = new DashboardPage(Hooks.driver);
    @Autowired
    private DashboardPage dashboardPage;

    @And("I should see {string} text")
    public void iShouldSeeText(String displayText) {
        dashboardPage.cekLogin(displayText);
    }
}
