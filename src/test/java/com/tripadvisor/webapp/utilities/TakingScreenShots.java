/**
 * 
 */
package com.tripadvisor.webapp.utilities;




import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.tripadvisor.webapp.base.BaseTest;

/**
 * @author Vrushali
 *
 */
public class TakingScreenShots{
	public String takingScreenshot(WebDriver driver) {
		Date today=new Date();
		String todayDate=today.toString().replace(" ", "_").replace(":", "_");
		
//		TakesScreenshot sc = (TakesScreenshot) driver;
//		File source = sc.getScreenshotAs(OutputType.FILE);
//		File dest = new File(PropertyFileReader.readConfigFile().getProperty("screenShotFolderPath"));
//		try {
//			FileUtils.copyFileToDirectory(source, dest);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		String destFileName=currentDir + "/screenshots/" + todayDate+"_"+System.currentTimeMillis()+ ".png";
		try {
			FileUtils.copyFile(scrFile, new File(destFileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destFileName;
		
	}

}
