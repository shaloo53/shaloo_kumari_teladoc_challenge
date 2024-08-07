package StepDefinitionFolder;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import PageObject.MainPage;
import Utility.ReadConfigFile;

public class BaseClass {
	public static  WebDriver driver;
	public MainPage page;
	public ReadConfigFile config;
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static ExtentTest looger;
}
