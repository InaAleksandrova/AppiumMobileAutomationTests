import com.swaglabs.util.PropertiesHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductsTests extends BaseTests {

    private PropertiesHelper propertiesHelper;

    @BeforeMethod
    public void setUpProperties() {
        propertiesHelper = new PropertiesHelper();
        propertiesHelper.loadProperties("properties/login.properties");
        loginPage().enterUsername(propertiesHelper.getProperty("standard_user"));
        loginPage().enterPassword(propertiesHelper.getProperty("password"));
        loginPage().clickLoginButton();
        Assert.assertTrue(productsPage().isProductsPageVisible());
    }

    @Test
    public void addOneProductToCart() {
        productsPage().addProductToCartByIndex(1);
        Assert.assertEquals(Integer.parseInt(productsPage().getItemsInCartNumber()), 1);
        productsPage().tapProductsCart();
    }

    @Test
    public void addProductsToCart() {
        productsPage().addProductToCartByIndex(1);
        productsPage().addProductToCartByIndex(2);
        Assert.assertEquals(Integer.parseInt(productsPage().getItemsInCartNumber()), 2);
        productsPage().tapProductsCart();
        cartPage().tapContinueShopping();
    }
}
