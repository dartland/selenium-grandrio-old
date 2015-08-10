package ru.st.selenium;

import java.io.File;
import java.io.PrintStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.*;
import org.testng.annotations.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.st.selenium.FlashObjectWebDriver;

public class GameList extends ru.st.selenium.TestNgTestBase {
	

  private int Dragger1 = 1;//�������� ��� ����������
  private int Dragger2 = 1;//�������� ����� ����������
  //private StringBuffer verificationErrors = new StringBuffer();
  
 /**
 * @throws Exception
 */
@Test
public void testLoginGame() throws Exception {     
	
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
	driver.get("https://test.grandrio.com/ru");
	
	ExpectedCondition<Boolean> pageLoadFinishedCondition = new ExpectedCondition<Boolean>() {
        public Boolean apply(WebDriver driver) 
        {return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");    }
    };

    WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(pageLoadFinishedCondition);	
	
	
	// ���������� ���� � ������� ����� ������ ���
	System.setErr(new PrintStream(new File("log.txt")));
	System.err.println("����������"); System.out.println("����������");	 	// ������� ��������� 
	// ���� id=casino_btn
	driver.findElement(By.id("casino_btn")).click();
	wait.until(pageLoadFinishedCondition);	
	// 
	
    //------------------------- ������ ����� ��� ��������� �������� ����
	
	
	for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath(".//*[@id='ctlg_menu']/li[2]/a"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }	
	
    driver.findElement(By.xpath("(//a[@onclick='RIO.getGames(this, 997);'])[2]")).click(); //���� ������
    System.out.println("��������� ���� �� ���� '�����'");	
    System.err.println("��������� ���� �� ���� '�����'");	
    wait.until(pageLoadFinishedCondition);	
    //Thread.sleep(2000);
    // ��������� ������ ��� ����� ������ ������	
    String id="";   int i=0;
    List<WebElement> GamesSlot = driver.findElements(By.className("game_cell")); 
    for (WebElement game_cell : GamesSlot) {
    	id= String.format("%s",game_cell.getAttribute("id")); 
    	if(!id.equals("")){
        System.out.println("�������� 'id="+id+"'"); i++;
        openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    	}
    }
    System.out.println("� ������ ����������: "+i+" ���");
    // ����� ����� ��������
    
    
    
      
     
	//���������� �������� ����� � ����� �� ��������
	driver.close();

	try {
	Thread.sleep(5000); driver.quit();
	} catch (Exception e) {
	}

	// ������� ��������� �� ������ � ���-����
	try {
	     throw new Exception("��������� �� ������");
	} catch (Exception e) {
	    e.printStackTrace();
	}
	
   }

public void openGame(ExpectedCondition<Boolean> pageLoadFinishedCondition,
		WebDriverWait wait, String assertName, String byXPathName, String byXPathButtonDemo) throws InterruptedException {
    
	Actions builder = new Actions(driver);
	builder.build();
	if(isElementPresent(By.cssSelector("div.mCSB_dragger_bar"))) {
		System.out.println("������ ������� ���������");	
		
	} else { 
		System.out.println("�� ������ ������� ���������");
    }    
	WebElement Element = driver.findElement(By.cssSelector("div.mCSB_dragger_bar"));
	
	Boolean flag=false;
	
	while (!driver.findElement(By.xpath(byXPathName)).isDisplayed())
	{
	    builder.dragAndDropBy(Element,0,Dragger1).perform();//��������� ������� ������ ���������
		//Thread.sleep(100L);
		flag=true;
	};
	
	if(flag) {
		builder.dragAndDropBy(Element,0,Dragger2).perform(); Thread.sleep(100L);// ��������� ������� ���, ����� �������� ����� ��������� ������
	}
	builder.dragAndDropBy(Element,1,0).perform(); Thread.sleep(100L);
	
	if(isElementPresent(By.xpath(byXPathName))) {

		System.out.println("������ �������: "+byXPathName);	
	    System.out.println("��� ��������: "+driver.findElement(By.xpath(byXPathName)).getText());
	    
		new Actions(driver).moveToElement(    //�������� ��������� ���� � �������� ����, ������ ��������� ������, �������� ����
	            driver.findElement(By
	            		.xpath(byXPathName)))
	            .perform(); Thread.sleep(50L);
	     System.out.println("������� ��������� � �������� ��� ��������� ������");	       
	     System.out.println("���� � ����: "+driver.findElement(By.xpath(byXPathName)).getText());       
	     if(isElementPresent(By.xpath(byXPathButtonDemo))) {
	        		System.out.println("������: "+byXPathButtonDemo);	
	    	 
	    	 		if(driver.findElement(By.xpath(byXPathButtonDemo)).isDisplayed()) {
	    	 			System.out.println("�� �������: "+byXPathButtonDemo);	
	    	 		}
	    	 		else {
	    	 			System.out.println("�� ���������: "+byXPathButtonDemo);
	    	 			System.err.println("������ Demo �� ������� : "+byXPathButtonDemo);
	    	 			return;
	    	 			}
	    	 		
	    	 		
	        	} else { 
	        		System.out.println("�� �����: "+byXPathButtonDemo);
	        		System.err.println("������ Demo ���������� : "+byXPathButtonDemo);
	            }        
	    new Actions(driver).moveToElement(
	            driver.findElement(By
	               		.xpath(byXPathButtonDemo)))
	            .perform(); Thread.sleep(100L);   		
		//assertEquals(assertName, driver.findElement(By.xpath(byXPathName)).getText()); 
	
	} else {  // ����� ���� ��� ������� ������� � ��������� ����
		System.out.println("�� ������� ���� � XPath: "+byXPathName);
		System.err.println("�� ������� ���� � XPath: "+byXPathName);
		return;
    }   
	
    System.err.println("��������� ����:"+driver.findElement(By.xpath(byXPathName)).getText());        
    driver.findElement(By.xpath(byXPathButtonDemo)).click();
    wait.until(pageLoadFinishedCondition);    //���� �������� ����
    Thread.sleep(1000L);
    driver.switchTo().frame("play_box"); // ������� �� ����� � �����, ����� ���� �������� ������
	//������������� �� ����� @class,'egamings_game_frame � ������� ����� ���� ����
	if(isElementPresent(By.xpath("//iframe[contains(@class,'egamings_game_frame')]"))) {
		System.out.println("������ iframe[contains(@class,'egamings_game_frame')]");	
	} else { 
		System.out.println("�� ������ iframe[contains(@class,'egamings_game_frame')]");
		System.err.println("�� ������ iframe[contains(@class,'egamings_game_frame')]");
		   }
	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@class,'egamings_game_frame')]"))); 
	
	// ���� ����� � ����� ��������, �� ���� ���� � ��������� �� �� 100% �������� 
	if(isElementPresent(By.xpath(".//*[@id='system']"))) {
		//System.out.println("�� ����� �� ����� � �����");	
		FlashObjectWebDriver flashApp = new FlashObjectWebDriver(driver, "system");

		System.out.println("������ �������� ���� � ������: "+((JavascriptExecutor) driver).executeScript("return document.readyState"));
		System.err.println("������ �������� ���� � ������: "+((JavascriptExecutor) driver).executeScript("return document.readyState"));
		System.err.println("���� ��������� ��:"+flashApp.callFlashObject("PercentLoaded")+"%, ���������� �������� �������");
		
	} else { 
		System.out.println("�� ������ ���� � id=system");
		System.err.println("�� ������ ���� � id=system");
		   }
	// ������� �� ������ � ������
	driver.switchTo().defaultContent();
	Thread.sleep(100L); 
	if(isElementPresent(By.xpath("//*[@id='play_box']"))) {
		System.out.println("������ ������� �  id=play_box");	
		driver.switchTo().frame("play_box");
		Thread.sleep(100L);
		new Actions(driver).moveToElement(
	            driver.findElement(By
	            		.xpath(".//*[@id='game_close']")))
	            .perform();
		Thread.sleep(300L);
		
		driver.findElement(By.xpath(".//*[@id='game_close']")).click(); 
		driver.switchTo().defaultContent();

		System.out.println("����� �� ����");
		System.err.println("����� �� ����");
		
	} else { 
		System.out.println("�� ������ iframe  id=play_box");
	}     
}

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
}
