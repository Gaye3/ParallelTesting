package swagLabs.functionalTestCases;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import swagLabs.commonActions.CommonActions;
import swagLabs.pages.Cart;
import swagLabs.pages.Login;
import swagLabs.pages.OverView;
import swagLabs.pages.Products;
import swagLabs.pages.YourInformation;

public class EndToEndFunctionality {
	
	CommonActions action =  new CommonActions();
	Login login;
	Products product;
	Cart cart;
	YourInformation information;
	OverView overview;
	
	@Test(dataProvider="getData")
	public void endToEndTestCase(HashMap<String,String> data) {
		
		login = action.openUrl();
		product = login.userLogin(data.get("username"),data.get("password"));
		product.addProdToCart(data.get("product"));
		cart = product.goToCart();
		information = cart.clickCheckout();
		information.setFirstName(data.get("firstname"));
		information.setLastName(data.get("lastname"));
		information.setPostCode(data.get("postcode"));
		overview = information.clickContinue();
		overview.clickFinish();
		overview.quit();
		
	}
	
	@DataProvider(parallel=true)
	public Object[][] getData(){
		
		action.setExcelReader(System.getProperty("user.dir")+"\\src\\main\\Resources\\excel\\SwagLabs.xlsx");
		return action.gerExcelReader().getData("endToEndTestCase");
		
	}

}
