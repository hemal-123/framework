package Reader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Seleniumassessment.Driverconnection;

public class Datadriven {

	static	WebDriver driver;

	@BeforeClass
	public void openBrowser() {
		String url="https://www.facebook.com/";
		WebDriver driver= Driverconnection.getDriver(url);
	}
	@Test(dataProvider =   "dp")
	public void logintest(String email, String pass) throws InterruptedException {
		System.out.println(email + " " + pass);
		WebElement username = driver.findElement(By.id("email"));
		username.clear();
		username.sendKeys(email);
		WebElement password = driver.findElement(By.id("pass"));
		password.clear();
		password.sendKeys(pass);
		Thread.sleep(3000);

	}

	@Test
	@DataProvider(name = "dp")
	public static Object[][] data() {
		Excelreader ex = new Excelreader("C:\\Users\\user\\Documents\\FACEBOOK CREATE ACCOUNT HLR & TEST CASE.xlsx", "LoginData");
		int row = ex.rowCount();
		System.out.println("row : "+row);
		int col = ex.colCount();
		System.out.println("col : "+col);

		Object obj[][] = new Object[row-1][col];

		for (int i = 1;	 i < row; i++) {
			for (int j = 0; j < col; j++) {
				String data = ex.getData(i, j);
				System.out.println(data+" : "+i+" : "+j);
				obj[i - 1][j] = data;
			}
		}
		return obj;

}
}
