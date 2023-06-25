package swagLabs.functionalTestCases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import swagLabs.commonActions.CommonActions;
import swagLabs.pages.Login;
import swagLabs.pages.Products;

public class LoginTest {
	
	CommonActions action =  new CommonActions();
	Login login;
	Products product;
	
	
	@Test(dataProvider="getData")
	public void loginTest(HashMap<String,String> data) {
		
		login = action.openUrl();
		product = login.userLogin(data.get("username"),data.get("password"));
		
		Assert.assertEquals(product.isProductsDisplayed(), true);
		
		login.quit();
		
	}
	
	
	@DataProvider(parallel=true)
	public Object[][] getData(){
		
		action.setExcelReader(System.getProperty("user.dir")+"\\src\\main\\Resources\\excel\\SwagLabs.xlsx");
		return action.gerExcelReader().getData("loginTest");
		
	}

}
