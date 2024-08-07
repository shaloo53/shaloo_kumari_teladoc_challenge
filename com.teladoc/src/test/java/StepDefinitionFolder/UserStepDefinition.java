package StepDefinitionFolder;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import PageObject.MainPage;
import Utility.ReadConfigFile;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserStepDefinition extends BaseClass {
	String userName;
	List<Map<String, String>> listData;

	@Before
	public void setUp(Scenario sc) throws IOException {
		driver = new ChromeDriver();
		config = new ReadConfigFile();
		
		if (extent == null) {
		 extent = new ExtentReports();
         spark = new ExtentSparkReporter(new File(System.getProperty("user.dir") + "/Reports/extentReport.html"));
         extent.attachReporter(spark);
		}
         looger = extent.createTest(sc.getName());

	}

	@Given("Launch url")
	public void launch_url() {
		page = new MainPage(driver);
		driver.get(config.getURL());
		looger.info("url launched");
	}

	@When("Click on add user button")
	public void click_on_add_user_button() {
		page.clickAddUserButton();
		looger.info("user clicked on add button.");
	}

	@Then("Form will open")
	public void form_will_open() {
		if(page.formVisible()) {
		looger.pass("form is visible");	
		}
		else looger.fail("form is not visible.");
	}

	@Then("Enter the user details")
	public void enter_the_user_details(DataTable datatable) {
		listData = datatable.asMaps(String.class, String.class);
		for (Map<String, String> data : listData) {
			page.enterFirstName(data.get("FirstName"));
			page.enterLastName(data.get("LastName"));
			page.enterUserName(data.get("UserName"));
			page.enterPassword(data.get("Password"));
			page.selectRadioButton(data.get("Customer"));
			page.selectRole(data.get("Role"));
			page.enterEmail(data.get("E-mail"));
			page.enterContactNo(data.get("CellPhone"));
		}
		looger.info("user entered the details "+listData);
	}

	@Then("Click on Save button")
	public void click_on_save_button() {
		page.clickSaveButton();
		looger.info("user clicked on save button.");
	}

	@Then("Verify the user has been added to the table")
	public void verify_the_user_has_been_added_to_the_table() {
		if(page.getUserNameList().contains(listData.get(0).get("UserName"))) {
		looger.pass("user added to the table");	
		}
		else {
			looger.fail("user not added to the table.");
		}
		
	}

	@When("click on cross icon corresponding to user {string}")
	public void click_on_cross_icon_corresponding_to_user(String luserName) {
		userName = luserName;
		page.deleteUser(userName);
	}

	@Then("click on ok button of confirmation dialog box")
	public void click_on_ok_button_of_confirmation_dialog_box() {
		page.clickOnOKDialogBox();
		looger.info("user click on ok dialog box.");
	}

	@Then("Verify that user got deleted from the table")
	public void verify_that_user_got_deleted_from_the_table() {
		boolean flag = page.getUserNameList().contains(userName);
		if(!flag) {
			looger.pass("user got deleted");
			
		}
		else {
			looger.fail("user not deleted");
		}
	}

	@After
	public void tearDown(Scenario sc) {
	
		if(sc.isFailed()) {
			File fs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String path = System.getProperty("user.dir")+sc.getName()+".png";
			try {
				FileUtils.copyFile(fs,new File(path));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		driver.quit();
		
	}
	@AfterAll
    public static void cleanUp() {
        if (extent != null) {
            extent.flush();
        }
    }
}
