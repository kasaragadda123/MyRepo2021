package MavenTest.Maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginFacebook
{
	public static WebDriver driver;
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com/login");
		driver.manage().window().maximize();
	}
	public void VerifyError()
	{
		driver.findElement(By.name("email")).sendKeys("kasaragadda.ravindrababu@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("Ravindr324");
		driver.findElement(By.name("login")).click();
		
		String Actual_error_message= driver.findElement(By.xpath("//*[@class='_9ay7']")).getText();
		System.out.println(Actual_error_message);
		
		String Expected_error_Message = "the password that you've entered is incorrect. Forgotten password?";
		if (Actual_error_message.equals(Expected_error_Message))
		{
			System.out.println("Both actual and expected error message are same");
		}
		else
		{
			System.out.println("Both actual and expected error message are not same");
		}
	}
	public static void main(String[] args) 
	{
		LoginFacebook f= new LoginFacebook();
		f.setup();
		f.VerifyError();
	}
}
