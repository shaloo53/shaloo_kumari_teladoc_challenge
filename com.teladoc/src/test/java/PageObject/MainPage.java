package PageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MainPage {
	WebDriver driver;

	public MainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@type='add']")
	private WebElement addUserButton;

	@FindBy(xpath = "//form[@name='smartTableValidForm']")
	private WebElement form;

	@FindBy(xpath = "//input[@name='FirstName']")
	private WebElement firstName;

	@FindBy(xpath = "//input[@name='LastName']")
	private WebElement lastName;

	@FindBy(xpath = "//input[@name='UserName']")
	private WebElement userName;

	@FindBy(xpath = "//input[@name='Password']")
	private WebElement password;

	@FindBy(xpath = "//label[text()='Company AAA']/input")
	private WebElement radioButtonCompanyA;

	@FindBy(xpath = "//label[text()='Company BBB']/input")
	private WebElement radioButtonCompanyB;

	@FindBy(xpath = "//select[@name = 'RoleId']")
	private WebElement roleDropdown;

	@FindBy(xpath = "//input[@name='Email']")
	private WebElement email;

	@FindBy(xpath = "//input[@name='Mobilephone']")
	private WebElement cellPhone;

	@FindBy(xpath = "//button[contains(@class,'btn-success')]")
	private WebElement saveButton;

	@FindBy(xpath = "//table[contains(@class,'smart-table')]//tbody/tr")
	private List<WebElement> totalRow;

	@FindBy(xpath = "//table[contains(@class,'smart-table')]//th[not(contains(@class,'ng-hide'))]")
	private List<WebElement> totaColumn;
	
	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okButton;
	
	
	public void clickAddUserButton() {
		addUserButton.click();
	}

	public void enterFirstName(String fname) {
		firstName.clear();
		firstName.sendKeys(fname);
		
	}

	public void enterLastName(String lname) {
		lastName.clear();
		lastName.sendKeys(lname);
	}

	public void enterUserName(String uname) {
		userName.clear();
		userName.sendKeys(uname);
	}

	public void enterPassword(String pswd) {
		password.clear();
		password.sendKeys(pswd);
	}

	public void selectRadioButton(String companyName) {
		if (companyName.equals("Company AAA")) {
			radioButtonCompanyA.click();
		} else if (companyName.equals("Company BBB")) {
			radioButtonCompanyB.click();
		}
	}

	public void selectRole(String roleName) {
		Select s = new Select(roleDropdown);
		s.selectByVisibleText(roleName);
	}

	public void enterEmail(String emailAdd) {
		email.clear();
		email.sendKeys(emailAdd);
	}

	public void enterContactNo(String phnNo) {
		cellPhone.clear();
		cellPhone.sendKeys(phnNo);
		
	}

	public void clickSaveButton() {
		saveButton.click();
	}

	public boolean formVisible() {
		return form.isDisplayed();
		
	}

	public List<String> getUserNameList(){
		List<String> userList = new ArrayList<String>();
		int rowLength = totalRow.size(); 
		for(int i=1;i<=rowLength;i++) {
			WebElement user = driver.findElement(By.xpath("(//table[contains(@class,'smart-table')]//tbody/tr)["+i+"]/td[3]"));
			userList.add(user.getText());
		}
		return userList;
	}
	
	public void deleteUser(String uName) {
		WebElement crossIconOfUSer = driver.findElement(By.xpath("//tbody//*[text()='"+uName+"']/parent::tr//*[contains(@class,'icon-remove')]"));
		crossIconOfUSer.click();
	}
	
	public void clickOnOKDialogBox() {
		okButton.click();
	}
}
