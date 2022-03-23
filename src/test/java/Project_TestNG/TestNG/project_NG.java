package Project_TestNG.TestNG;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class project_NG {
	
	WebDriver driver;
	
	@BeforeMethod
	public void init() {
		try {
			System.setProperty("webdriver.chrome.driver", ".\\lib\\new\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://elearningm1.upskills.in/");
			driver.manage().window().maximize();
		}
		catch(Exception ex) {
			System.out.println("Error in Before Test.");
		}
		
	}
	
	@DataProvider(name = "testcase")
	public Object[][] testdata(){
		
		Object[][] data = new Object[1][2];
		data[0][0]="babuBhai25";
		data[0][1]="babubhai@1234";
		return data;
		
	}
	
	@Test(dataProvider = "testcase",groups = {"first"})
	
	
	public void main(String userid, String password) throws InterruptedException {
		
		try {
		
			WebElement obj = driver.findElement(By.xpath("//input[@id='login']"));
			obj.sendKeys(userid);
		
			obj = driver.findElement(By.xpath("//input[@id='password']"));
			obj.sendKeys(password);
		
			obj = driver.findElement(By.xpath("//button[@type='submit']"));
			obj.click();
		
			obj = driver.findElement(By.xpath("//*[contains(text(),'Social network')]"));
			obj.click();
	    
	    
			obj = driver.findElement(By.xpath("//*[@id=\"sn-sidebar-collapse\"]/div/ul/li[4]/a"));
			obj.click();
	    
			obj = driver.findElement(By.xpath("//textarea[@name='social_wall_new_msg_main']"));
			obj.sendKeys("What day is it?");
	    
			obj = driver.findElement(By.xpath("//button[@type='submit']"));
			obj.click();
	    
			obj = driver.findElement(By.xpath("//textarea[@name='social_wall_new_msg']"));
			obj.sendKeys("Is it Monday?");
			
			obj = driver.findElement(By.xpath("//button[@name='social_wall_new_msg_submit']"));
			obj.click();
	    
	    
			System.out.println("All the tests has been passed");
		}
		catch(Exception ex) {
			System.out.println("Error occurs in Test Annotation part of group First.");
		}
		
	}
	
	@Test(dataProvider = "testcase",groups = {"second"})
	public void newmain(String userid, String password) throws InterruptedException {
		try {
			WebElement obj1 = driver.findElement(By.id("login"));
			obj1.sendKeys(userid);
		
			obj1 = driver.findElement(By.id("password"));
			obj1.sendKeys(password);
		
			obj1 = driver.findElement(By.xpath("//*[@id='formLogin']/fieldset/button"));
			obj1.click();
		
			obj1 = driver.findElement(By.xpath("//*[@id='menuone']/ul[1]/li[2]/a"));
			obj1.click();
		
			obj1 = driver.findElement(By.xpath("//*[@id='page-content']/div/div/div/div/div[2]/h4/a"));
			obj1.click();
		
			String parentHandle = driver.getWindowHandle();
			obj1 = driver.findElement(By.xpath("//img[@id='toolimage_12']"));
			obj1.click();
	    
			Set<String> handles = driver.getWindowHandles();
			for (String handle :handles) {
				if (!handle.equals(parentHandle)) {
					driver.switchTo().window(handle);
					WebElement chat = driver.findElement(By.xpath("//*[@id='chat-users']/li[1]/div/ul/li[1]/button"));
					chat.click();
					String Message = "Good Night!";
					chat = driver.findElement(By.xpath("//div[@class='emoji-wysiwyg-editor']"));
					chat.sendKeys(Message);
	    		
					chat = driver.findElement(By.xpath("//button[@id='chat-send-message']"));
					chat.click();
	    		
					Thread.sleep(3000);
	    		
					chat =driver.findElement(By.xpath("//p[contains(text(),'Good Night!')]")); 
					String expected = chat.getText(); 
					Assert.assertTrue(Message.contains(expected)); 
				}
			}
	    
			System.out.println("All the test cases has been passed");
			 } catch(Exception ex) {
			 System.out.println("Error Occured in Test Group Second"); }
			 
		System.out.println("Done");
	}

}
