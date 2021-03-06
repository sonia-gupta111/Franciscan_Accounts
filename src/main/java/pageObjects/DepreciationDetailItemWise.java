package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DepreciationDetailItemWise {
  WebDriver dr;
  Utility u= new Utility();
  String r="DepreciationDetailItemWise";
  
  @FindBy(name="ctl00$ContentPlaceHolder1$SingleButton1$ctl00")WebElement show;
  
  public DepreciationDetailItemWise(WebDriver d)
  {
	  this.dr=d;
	  PageFactory.initElements(d, this);
  }
  public void openDepreciationDetailItemWise()
  {
      ArrayList<String> tabs2 = new ArrayList<String> (dr.getWindowHandles());
      dr.switchTo().window(tabs2.get(1));
      WebElement menu= dr.findElement(By.xpath("//*[contains(text(),'Reports')]"));
	  Actions builder= new Actions(dr);
	  builder.moveToElement(menu).build().perform();
	  dr.findElement(By.linkText("Depreciation Detail Item Wise")).click();
	  dr.switchTo().frame(dr.findElement(By.xpath("//iframe[@src='/Report/Account/RptDepriciationDtl.aspx']")));
  }
  public void clickShow(String str, Collection<String>sc ) throws InterruptedException, IOException
  {
	 show.click();
     u.verifyShow(dr, str, r, sc);
	 Thread.sleep(5000);
	 u.captureScreenshot(dr, str, r,sc);
  }
}
