package ui_automation.hawk;


import org.openqa.selenium.WebDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
public class PageObjectBase {
	WebDriver driver;
	//////////////////////////////////////////////
	// clickImage
	//  Clicks the image input present in the
	//	screen via SikuliX api.
	///////////////////////////////////////////////
	public void clickImage(String inputPath) {
		Pattern imgPath = new Pattern(inputPath);
		Screen currentScreen = new Screen();
		try {
			currentScreen.click(imgPath);
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/////////////////////////////////////////////////
	// isImagePresent
	//	Checks if the given image is present in the
	//	present in the current screen via sikulix
	//	api.
	/////////////////////////////////////////////////
	public boolean isImagePresent(String inputPath){
		Pattern imgPath = new Pattern(inputPath);
		Screen currentScreen = new Screen();
		return currentScreen.exists(imgPath) != null;	
	}

	// public WebElement FindElementByCSS(String name, String type) {
	//
	// String selector = null;
	// if (type == "id") {
	// selector = "[" + "id=" + name + "]";
	// } else if (type == "class") {
	// selector = "[" + "class=" + name + "]";
	// }
	// return this.driver.findElement(By.cssSelector(selector));
	// }
	//
	// public WebElement FindElementByXpath(String name, String type) {
	// String selector = null;
	// if (type == "id") {
	// selector = ".//[\"@id =" + name + "\"]";
	// } else if (type == "class") {
	// selector = ".//[\"@class =" + name + "\"]";
	// } else if (type == "value") {
	// selector = ".//[\"@value =" + name + "\"]";
	// } else if (type == "raw") {
	// selector = name;
	// }
	// return this.driver.findElement(By.xpath(selector));
	// }
	//
	// public WebElement FindElementById(String name) {
	// // By.id("ctl00_uxPgCPH_password")
	// return this.driver.findElement(By.id(name));
	// }
	//
	// public WebElement FindElementByName(String name) {
	// // By.id("ctl00_uxPgCPH_password")
	// return this.driver.findElement(By.name(name));
	// }

	// Need to add similar functions for the below stuffs as well

	// Custom xpath format or syntax: (".//tagname[@attributeName=value]")
	// Custom xpath format or syntax:
	// (".//tagname[@attributeName=value]/following-sibling::arrayElements(eg:li[1])")
	// Custom xpath format or syntax:
	// (".//tagname[@attributeName=value]/parent::ElementsName(eg:li[1])")=
	// for css for id selector we can use # => for id eg: id = 'Login' can be
	// written as '#login'
	// for css for id selector we can use '.' => for class eg: class = 'Login'
	// can be written as '.login'
}