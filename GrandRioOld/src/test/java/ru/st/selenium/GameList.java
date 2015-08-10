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
	

  private int Dragger1 = 1;//смещение при скроллинге
  private int Dragger2 = 1;//смещение после скроллинга
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
	
	
	// Определяем файл в который будем писать лог
	System.setErr(new PrintStream(new File("log.txt")));
	System.err.println("Результаты"); System.out.println("Результаты");	 	// Выводим сообщения 
	// меню id=casino_btn
	driver.findElement(By.id("casino_btn")).click();
	wait.until(pageLoadFinishedCondition);	
	// 
	
    //------------------------- начало теста игр открываем слотовые игры
	
	
	for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath(".//*[@id='ctlg_menu']/li[2]/a"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }	
	
    driver.findElement(By.xpath("(//a[@onclick='RIO.getGames(this, 997);'])[2]")).click(); //тест слотов
    System.out.println("Открываем игры из меню 'слоты'");	
    System.err.println("Открываем игры из меню 'слоты'");	
    wait.until(pageLoadFinishedCondition);	
    //Thread.sleep(2000);
    // получение списка игр через список класса	
    String id="";   int i=0;
    List<WebElement> GamesSlot = driver.findElements(By.className("game_cell")); 
    for (WebElement game_cell : GamesSlot) {
    	id= String.format("%s",game_cell.getAttribute("id")); 
    	if(!id.equals("")){
        System.out.println("Значение 'id="+id+"'"); i++;
        openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    	}
    }
    System.out.println("В слотах содержится: "+i+" игр");
    // конец теста слотовых
    
    
    
      
     
	//корректное закрытие сайта и выход из драйвера
	driver.close();

	try {
	Thread.sleep(5000); driver.quit();
	} catch (Exception e) {
	}

	// Выводим сообщение об ошибке в лог-файл
	try {
	     throw new Exception("Сообщение об ошибке");
	} catch (Exception e) {
	    e.printStackTrace();
	}
	
   }

public void openGame(ExpectedCondition<Boolean> pageLoadFinishedCondition,
		WebDriverWait wait, String assertName, String byXPathName, String byXPathButtonDemo) throws InterruptedException {
    
	Actions builder = new Actions(driver);
	builder.build();
	if(isElementPresent(By.cssSelector("div.mCSB_dragger_bar"))) {
		System.out.println("Найден элемент прокрутки");	
		
	} else { 
		System.out.println("Не найден элемент прокрутки");
    }    
	WebElement Element = driver.findElement(By.cssSelector("div.mCSB_dragger_bar"));
	
	Boolean flag=false;
	
	while (!driver.findElement(By.xpath(byXPathName)).isDisplayed())
	{
	    builder.dragAndDropBy(Element,0,Dragger1).perform();//понемногу двигаем полосу прокрутки
		//Thread.sleep(100L);
		flag=true;
	};
	
	if(flag) {
		builder.dragAndDropBy(Element,0,Dragger2).perform(); Thread.sleep(100L);// продвинем немного ещё, чтобы сработал метод подсветки кнопок
	}
	builder.dragAndDropBy(Element,1,0).perform(); Thread.sleep(100L);
	
	if(isElementPresent(By.xpath(byXPathName))) {

		System.out.println("Найден локатор: "+byXPathName);	
	    System.out.println("его значение: "+driver.findElement(By.xpath(byXPathName)).getText());
	    
		new Actions(driver).moveToElement(    //подводим указатель мыши к названию игры, должны появиться кнопки, нажимаем демо
	            driver.findElement(By
	            		.xpath(byXPathName)))
	            .perform(); Thread.sleep(50L);
	     System.out.println("Подвели указатель к элементу для появления кнопок");	       
	     System.out.println("Вход в игру: "+driver.findElement(By.xpath(byXPathName)).getText());       
	     if(isElementPresent(By.xpath(byXPathButtonDemo))) {
	        		System.out.println("Найден: "+byXPathButtonDemo);	
	    	 
	    	 		if(driver.findElement(By.xpath(byXPathButtonDemo)).isDisplayed()) {
	    	 			System.out.println("Он видимый: "+byXPathButtonDemo);	
	    	 		}
	    	 		else {
	    	 			System.out.println("Он невидимый: "+byXPathButtonDemo);
	    	 			System.err.println("Кнопка Demo не видимая : "+byXPathButtonDemo);
	    	 			return;
	    	 			}
	    	 		
	    	 		
	        	} else { 
	        		System.out.println("Не наден: "+byXPathButtonDemo);
	        		System.err.println("Кнопка Demo отсутсвует : "+byXPathButtonDemo);
	            }        
	    new Actions(driver).moveToElement(
	            driver.findElement(By
	               		.xpath(byXPathButtonDemo)))
	            .perform(); Thread.sleep(100L);   		
		//assertEquals(assertName, driver.findElement(By.xpath(byXPathName)).getText()); 
	
	} else {  // конец если где смотрим элемент с названием игры
		System.out.println("Не найдена игра с XPath: "+byXPathName);
		System.err.println("Не найдена игра с XPath: "+byXPathName);
		return;
    }   
	
    System.err.println("Открываем игру:"+driver.findElement(By.xpath(byXPathName)).getText());        
    driver.findElement(By.xpath(byXPathButtonDemo)).click();
    wait.until(pageLoadFinishedCondition);    //ждем открытия игры
    Thread.sleep(1000L);
    driver.switchTo().frame("play_box"); // заходим во фрэйм с игрой, чтобы были доступны кнопки
	//переключаемся на фрэйм @class,'egamings_game_frame в котором лежит наша флэш
	if(isElementPresent(By.xpath("//iframe[contains(@class,'egamings_game_frame')]"))) {
		System.out.println("Найден iframe[contains(@class,'egamings_game_frame')]");	
	} else { 
		System.out.println("Не найден iframe[contains(@class,'egamings_game_frame')]");
		System.err.println("Не найден iframe[contains(@class,'egamings_game_frame')]");
		   }
	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@class,'egamings_game_frame')]"))); 
	
	// если фрейм с игрой открылся, то ищем флэш и тестируем ее на 100% загрузку 
	if(isElementPresent(By.xpath(".//*[@id='system']"))) {
		//System.out.println("Мы вошли во фрэйм с игрой");	
		FlashObjectWebDriver flashApp = new FlashObjectWebDriver(driver, "system");

		System.out.println("Статус загрузки игры в плагин: "+((JavascriptExecutor) driver).executeScript("return document.readyState"));
		System.err.println("Статус загрузки игры в плагин: "+((JavascriptExecutor) driver).executeScript("return document.readyState"));
		System.err.println("Игра загружена на:"+flashApp.callFlashObject("PercentLoaded")+"%, управление передано плагину");
		
	} else { 
		System.out.println("Не найден флэш с id=system");
		System.err.println("Не найден флэш с id=system");
		   }
	// выходим из фрэйма в корень
	driver.switchTo().defaultContent();
	Thread.sleep(100L); 
	if(isElementPresent(By.xpath("//*[@id='play_box']"))) {
		System.out.println("Найден элемент с  id=play_box");	
		driver.switchTo().frame("play_box");
		Thread.sleep(100L);
		new Actions(driver).moveToElement(
	            driver.findElement(By
	            		.xpath(".//*[@id='game_close']")))
	            .perform();
		Thread.sleep(300L);
		
		driver.findElement(By.xpath(".//*[@id='game_close']")).click(); 
		driver.switchTo().defaultContent();

		System.out.println("Выход из игры");
		System.err.println("Выход из игры");
		
	} else { 
		System.out.println("НЕ найден iframe  id=play_box");
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
