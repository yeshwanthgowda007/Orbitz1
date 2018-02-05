package Script;

import org.testng.annotations.Test;

import Utility.Excel;
import pages.HomePage;
import pages.SearchPage;
import resources.BaseClassTest;


public class TestApp extends BaseClassTest {
	
	
	@Test
	public void testApp() throws InterruptedException
	{
		for(int i=1;i<=Excel.getRowCount(XL_PATH, "Sheet2");i++)
		{
			log.info("Entering the url");
			HomePage home=new HomePage(driver);
			log.info("verifying the home page");
			home.verifyHomePage(driver);
			log.info("clicking on flights");
			home.clickFlights();
			log.info("clicking on One way flights");
			home.clickOneWay();
			log.info("Typing chennai in source");
			home.clickDeparture(Excel.getCellValue(XL_PATH, "Sheet2", i, 0));
			log.info("Typing bangalore in destination");
			home.clickTo(Excel.getCellValue(XL_PATH, "Sheet2", i, 1));
			log.info("Entering date of search");
			home.enterDateCalender("02/06/2018");
			SearchPage search=new SearchPage(driver);
			log.info("verifying the search page");
			search.verifySearchPage(driver);
			log.info("verifying the source and destination in search page");
			search.verifySourceDestination(home.fromString,home.towardsString);
			search.clickHome(driver);
		}
	}
	

}
