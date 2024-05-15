package shankar;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Capstoneproject.ebayloginPage;




@Test
public class EbayLogintestcases {
	
	static WebDriver driver;
	static ebayloginPage ebay;

	boolean res;
	
	@AfterClass
	public void closeDriver()
	{
		
		driver.quit();
	}
	@BeforeClass
	
	
	public void intiDriver(){
		
		ChromeOptions options = new ChromeOptions();
		options.setBrowserVersion("124");
		driver = new ChromeDriver();
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ebay = new Capstoneproject.ebayloginPage(driver);
	}
		
		
//	@Test
//	public void doLogin()
//	{
//		ebay.filesignin();
	//	ebay.fileusername("shankar.kurupudi1@gmail.com");
		//ebay.Clickcontinuebtn();
		//ebay.filepassword("psps@1111");
		//ebay.Clickloginbtn();
		
	
 //}
	public void ClickSearchLens() {
		
		
		ebay.SearchLens();
	}
	
	public void ChkSearchBox() {
			
			AssertJUnit.assertEquals(true, ebay.ChSearchBox());
	}
			
		
			
			
			
			@DataProvider
			  public Object[][] dp() {
			    return new Object[][] {
			      new Object[] { "laptop"+Keys.ENTER},
			     
			    
			   
			      
			    };
			  }
			@Test(dataProvider = "dp")
			public void dosearch(String s)
			{
				
				ebay.enterSearch(s);


				Assert.assertEquals(true, ebay.ChkSearch());
			}


		
		
		@Test(dependsOnMethods = "dosearch")
		public void AddItem() {
			ebay.clickaddTocart();;
		}
			
			
			

			

	
		
		
	}

