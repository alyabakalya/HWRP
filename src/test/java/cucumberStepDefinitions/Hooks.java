package cucumberStepDefinitions;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.epam.reportportal.service.ReportPortal;

import cucumberDriver.DriverManager;
import cucumberLogger.LoggerManager;
import io.cucumber.java.*;

public class Hooks extends DriverManager {
	String extension = "png";
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
	String name = String.format("%s.%s", dateFormat.format(new Date()), extension);

	@Before
	public void executeBeforeScenario() {
		DriverManager.setupDriver();
	}

	@After
	public void executeAfterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			File screenshotFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(screenshotFile, new File("src/main/resources/Screenshots", name));
			} catch (IOException e) {
				e.printStackTrace();
				LoggerManager.getLogger().warning("Screenshot was not taken");
			}
			ReportPortal.emitLog("Screenshot was taken on failed test step", "INFO",
					Calendar.getInstance().getTime(), screenshotFile);
		}
		DriverManager.quitDriver();
	}
}
