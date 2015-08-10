package ru.st.selenium;

import static org.junit.Assert.fail;  

import java.io.File;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit; 

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory; 
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LoginGame extends ru.st.selenium.TestNgTestBase { 
	
  private static Log log = LogFactory.getLog(LoginGame.class); 
  private boolean acceptNextAlert = true;
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
        {
            return ((JavascriptExecutor) driver).executeScript(
                    "return document.readyState").equals("complete");
        }
    };

    WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(pageLoadFinishedCondition);	
	
	System.out.println("Результаты");	 
	// Определяем файл в который будем писать лог
	System.setErr(new PrintStream(new File("log.txt")));
	System.err.println("Результаты");	// Выводим сообщения
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
    Thread.sleep(2000);
    	
    String id="";
    
    id = "175474"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
   // id = "175473"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    
    openGame(pageLoadFinishedCondition, wait,"SPELL OF ODIN",".//*[@id='99767']/b","//a[contains(@href, '/997/SpellOfOdin/Demo')]");
    openGame(pageLoadFinishedCondition, wait,"VIKING QUEST",".//*[@id='99766']/b","//a[contains(@href, '/997/VikingQuest/Demo')]");
    openGame(pageLoadFinishedCondition, wait,"VOLCANO ERUPTION",".//*[@id='99765']/b","//a[contains(@href, '/997/VolcanoEruption/Demo')]");
    openGame(pageLoadFinishedCondition, wait,"FAERIES FORTUNE",".//*[@id='99764']/b","//a[contains(@href, '/997/FaeriesFortune/Demo')]");
    
    openGame(pageLoadFinishedCondition, wait,"FORSAKEN KINGDOM",".//*[@id='99763']/b","//a[contains(@href, '/997/ForsakenKingdom/Demo')]");
    openGame(pageLoadFinishedCondition, wait,"LUCKY LEPRECHAUN",".//*[@id='95450']/b","//a[contains(@href, '/997/luckyLeprechaun/Demo')]");
    openGame(pageLoadFinishedCondition, wait,"LUCKY FIRECRACKER",".//*[@id='92473']/b","//a[contains(@href, '/997/LuckyFirecracker/Demo')]");
    openGame(pageLoadFinishedCondition, wait,"CRICKET STAR",".//*[@id='92471']/b","//a[contains(@href, '/997/cricketStar/Demo')]");
    
    openGame(pageLoadFinishedCondition, wait,"GOLDEN ERA",".//*[@id='92470']/b","//a[contains(@href, '/997/GoldenEra/Demo')]");
    openGame(pageLoadFinishedCondition, wait,"MERMAIDS MILLIONS",".//*[@id='115']/b","//a[contains(@href, '/997/MermaidsMillions/Demo')]");
    openGame(pageLoadFinishedCondition, wait,"BREAK AWAY",".//*[@id='369']/b","//a[contains(@href, '/997/BreakAway/Demo')]");
    openGame(pageLoadFinishedCondition, wait,"THE TWISTED CIRCUS",".//*[@id='317']/b","//a[contains(@href, '/997/TheTwistedCircus/Demo')]");
    
    openGame(pageLoadFinishedCondition, wait,"BUST THE BANK",".//*[@id='233']/b","//a[contains(@href, '/997/BustTheBank/Demo')]");
    openGame(pageLoadFinishedCondition, wait,"BIG BAD WOLF",".//*[@id='8663']/b","//a[contains(@href, '/997/bigbadwolf/Demo')]");
    openGame(pageLoadFinishedCondition, wait,"BIG TOP",".//*[@id='319']/b","//a[contains(@href, '/997/BigTop/Demo')]");
    openGame(pageLoadFinishedCondition, wait,"BURNING DESIRE",".//*[@id='299']/b","//a[contains(@href, '/997/BurningDesire/Demo')]");
    
    openGame(pageLoadFinishedCondition, wait,"RETRO REELS DIAMOND GLITZ",".//*[@id='490']/b","//a[contains(@href, '/997/RetroReelsDiamondGlitz/Demo')]");
    openGame(pageLoadFinishedCondition, wait,"LUCKY KOI",".//*[@id='316']/b","//a[contains(@href, '/997/LuckyKoi/Demo')]");
    openGame(pageLoadFinishedCondition, wait,"THE FINER REELS OF LIFE",".//*[@id='255']/b","//a[contains(@href, '/997/TheFinerReelsOfLife/Demo')]");
    openGame(pageLoadFinishedCondition, wait,"LUCKY RABBITS LOOT",".//*[@id='144']/b","//a[contains(@href, '/997/LuckyRabbitsLoot/Demo')]");   
    
    openGame(pageLoadFinishedCondition, wait,"BURGLIN BOB",".//*[@id='8664']/b","//a[contains(@href, '/997/BurglinBob/Demo')]");
    openGame(pageLoadFinishedCondition, wait,"UNTAMED CROWNED EAGLE",".//*[@id='4244']/b","//a[contains(@href, '/997/UntamedCrownedEagle/Demo')]");
    openGame(pageLoadFinishedCondition, wait,"RETRO REELS",".//*[@id='304']/b","//a[contains(@href, '/997/RetroReels/Demo')]");
    openGame(pageLoadFinishedCondition, wait,"UNTAMED GIANT PANDA",".//*[@id='463']/b","//a[contains(@href, '/997/UntamedGiantPanda/Demo')]");   
    
    openGame(pageLoadFinishedCondition, wait,"RETRO REELS EXTREME HEAT",".//*[@id='252']/b","//a[contains(@href, '/997/RetroReelsExtremeHeat/Demo')]");
    openGame(pageLoadFinishedCondition, wait,"GOLD",".//*[@id='8679']/b","//a[contains(@href, '/997/Gold/Demo')]");
    openGame(pageLoadFinishedCondition, wait,"UNTAMED BENGAL TIGER",".//*[@id='181']/b","//a[contains(@href, '/997/UntamedBengalTiger/Demo')]");
    openGame(pageLoadFinishedCondition, wait,"UNTAMED WOLF PACK",".//*[@id='374']/b","//a[contains(@href, '/997/UntamedWolfPack/Demo')]");    
    
    openGame(pageLoadFinishedCondition, wait,"JASON AND THE GOLDEN FLEECE",".//*[@id='394']/b","//a[contains(@href, '/997/JasonAndTheGoldenFleece/Demo')]");
    openGame(pageLoadFinishedCondition, wait,"BREAK DA BANK AGAIN",".//*[@id='441']/b","//a[contains(@href, '/997/BreakDaBankAgain/Demo')]");
    openGame(pageLoadFinishedCondition, wait,"CASHAPILLAR",".//*[@id='231']/b","//a[contains(@href, '/997/Cashapillar/Demo')]");
    openGame(pageLoadFinishedCondition, wait,"KARATE PIG",".//*[@id='397']/b","//a[contains(@href, '/997/KaratePig/Demo')]");    
    
    openGame(pageLoadFinishedCondition, wait,"SCROOGE",".//*[@id='261']/b","//a[contains(@href, '/997/Scrooge/Demo')]");
    openGame(pageLoadFinishedCondition, wait,"MAX DAMAGE SLOT",".//*[@id='58203']/b","//a[contains(@href, '/997/MaxDamageSlot/Demo')]");
    openGame(pageLoadFinishedCondition, wait,"STARLIGHT KISS",".//*[@id='499']/b","//a[contains(@href, '/997/StarlightKiss/Demo')]");
    openGame(pageLoadFinishedCondition, wait,"PURE PLATINUM",".//*[@id='433']/b","//a[contains(@href, '/997/PurePlatinum/Demo')]");    
    
    id = "17492"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "17491"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "17489"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "265"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");    
    
    id = "117"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "284"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "479"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "292"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");       
    
    id = "201"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "408"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "413"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "446"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");      
    
    id = "148"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "185"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "4277"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "503"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");       
    
    id = "414"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "4271"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "4268"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "4262"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");     
    
    id = "4260"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "4258"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "4255"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "4252"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");         

    id = "4250"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "4245"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "190"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "4242"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");      
    
    id = "4239"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "541"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "538"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "536"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");     
    
    id = "535"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "534"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "533"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "532"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");     
    
    id = "530"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "528"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "527"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "526"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");      
    
    id = "522"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "519"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "517"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "516"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");     
 
    id = "514"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "508"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "507"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "505"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");     
    
    id = "504"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "500"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "496"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "492"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");      
    
    id = "488"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "484"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "477"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "476"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");      
    
    id = "475"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "468"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "467"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "465"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");       
    
    id = "464"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "462"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "461"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "453"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");   
    
    id = "451"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "450"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "448"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "447"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");       
    
    id = "444"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "443"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "440"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "438"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");       
    
    id = "437"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "436"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "429"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "426"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");       
      
    id = "423"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "422"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "420"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "419"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");       
  
    id = "417"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "416"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "410"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "404"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");  
    
    id = "403"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "400"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "398"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "396"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");       
    
    id = "393"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "391"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "389"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "384"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");       
      
    id = "383"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "378"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "370"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "368"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");       
  
    id = "363"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "361"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "358"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "354"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");      
      
    id = "353"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "352"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "347"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "345"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");       
    
    id = "344"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "338"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "336"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "334"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");       
      
    id = "332"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "326"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "320"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "318"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");       
  
    id = "315"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "314"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "313"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "312"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");         
    
    id = "305"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "302"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "298"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "296"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");       
    
    id = "293"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "290"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "287"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "286"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");       
      
    id = "285"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "283"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "279"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "278"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");       
  
    id = "277"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "275"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "272"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "271"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");         
        
    id = "268"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "257"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "254"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "249"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");       
    
    id = "246"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "245"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "243"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "242"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");       
      
    id = "236"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "235"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "230"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "228"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");       
  
    id = "226"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "220"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "219"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "217"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");         
    
    id = "215"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "214"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "212"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "209"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");       
    
    id = "208"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "206"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "205"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "203"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");       
      
    id = "200"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "198"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "194"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "192"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");       
  
    id = "191"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "187"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "186"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "183"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");          
    
    id = "182"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "180"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "176"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "174"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");       
    
    id = "172"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "171"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "169"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "168"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");       
      
    id = "166"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "165"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "163"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "161"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");       
  
    id = "156"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "155"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "153"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "150"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");          
    
    id = "147"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "146"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "141"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "137"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");       
    
    id = "135"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "134"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "133"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "129"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");       
      
    id = "126"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "124"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "119"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "112"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");       
  
    id = "106"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "105"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "104"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "102"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");          
        
    id = "101"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "99"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "125"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "8658"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");       
    
    id = "8659"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "8661"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "8662"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "8665"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");       
      
    id = "8666"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "8667"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "8668"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "8669"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");       
  
    id = "8670"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "8672"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "8674"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "8676"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");             
    
    id = "8677"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "8680"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "8681"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "8682"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");       
    
    id = "8683"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "8684"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "8685"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "8686"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");       
      
    id = "8687"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "8688"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "8689"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "8690"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");       
  
    id = "8691"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "8692"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "8693"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "8694"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");        
    
    id = "8695"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "8696"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "8697"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "8698"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");       
    
    id = "8699"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "8701"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "8702"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "8703"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");       
      
    id = "8704"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "8705"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "8706"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "8707"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");       
  
    id = "8708"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "8709"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "8710"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "8711"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");        
    
    id = "8712"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "8713"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "8714"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "8715"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");       
      
    id = "8716"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "8717"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "9743"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "9744"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");       
  
    id = "9745"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "17488"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "17490"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]"); 
       
    
	//------------------------- конец теста слотов
    System.out.println("-----------------конец теста слотов");
    System.err.println("-----------------конец теста слотов");
    System.out.println("Открываем игры из меню 'настольные'");	
    System.err.println("Открываем игры из меню 'настольные'");	
	for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath(".//*[@id='ctlg_menu']/li[3]/a"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }	
	
    driver.findElement(By.xpath("(//a[@onclick='RIO.getGames(this, 997);'])[3]")).click(); //тест слотов
    
    wait.until(pageLoadFinishedCondition);	
    //System.out.println("Зашли в тест настольных");		
	Dragger1 = 6; Dragger2 = 3;
    
    id = "145"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "521"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "455"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "501"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]"); 
    id = "525"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "497"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "456"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "415"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");   
    id = "411"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "409"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "401"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "399"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");  
    id = "390"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "381"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "379"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "377"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]"); 
    id = "367"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "362"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "351"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "330"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");   
    id = "324"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "291"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "289"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "274"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");       
    id = "269"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "248"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "234"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "221"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");   
    id = "210"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "195"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "193"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "184"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");  
    id = "167"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "162"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "152"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "143"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]"); 
    id = "122"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "111"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "109"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "98"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");   
   
	//------------------------- конец теста настольных
    System.out.println("-----------------конец теста настольные");
    System.err.println("-----------------конец теста настольные");
    System.out.println("Открываем игры из меню 'стретч-карты'");	
    System.err.println("Открываем игры из меню 'стретч-карты'");	
    
	for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath(".//*[@id='ctlg_menu']/li[4]/a"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }	
	
    driver.findElement(By.xpath("(//a[@onclick='RIO.getGames(this, 997);'])[4]")).click(); //тест стретч-карты
    //System.out.println("Попытка зайти в тест стретч-карты");	
    wait.until(pageLoadFinishedCondition);	
    	
	
    id = "4282"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "540"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "537"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "510"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]"); 
    id = "506"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "491"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "489"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "469"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");   
    id = "428"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "405"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "388"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "380"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");  
    id = "359"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "356"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "339"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "333"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]"); 
    id = "331"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "310"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "282"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "244"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");   
    id = "237"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "232"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "225"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "170"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");       
    id = "158"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "139"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "131"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "130"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");   
    id = "116"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "100"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
   
	//------------------------- конец теста стретч-карт  
    System.out.println("-----------------конец теста стретч-карт");
    System.err.println("-----------------конец теста стретч-карт");
    System.out.println("Открываем игры из меню 'джек-поты'");	
    System.err.println("Открываем игры из меню 'джек-поты'");    
    
 	for (int second = 0;; second++) {
     	if (second >= 60) fail("timeout");
     	try { if (isElementPresent(By.xpath(".//*[@id='ctlg_menu']/li[5]/a"))) break; } catch (Exception e) {}
     	Thread.sleep(1000);
     }	
 	
     driver.findElement(By.xpath("(//a[@onclick='RIO.getGames(this, 997);'])[5]")).click(); //тест джек-поты
     System.out.println("Попытка зайти в тест джек-поты");	
     wait.until(pageLoadFinishedCondition);	
     	
 	
     id = "132"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
     id = "337"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
     id = "522"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
     id = "457"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]"); 
     id = "361"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
     id = "311"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
     id = "295"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
     id = "271"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");   
     id = "239"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
     id = "221"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
     id = "138"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
     id = "129"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");  
   
 	//------------------------- конец теста джек-поты       
     System.out.println("-----------------конец теста джек-поты");
     System.err.println("-----------------конец теста джек-поты");
     System.out.println("Открываем игры из меню 'рулетки'");	
     System.err.println("Открываем игры из меню 'рулетки'");  	
     
  	for (int second = 0;; second++) {
      	if (second >= 60) fail("timeout");
      	try { if (isElementPresent(By.xpath(".//*[@id='ctlg_menu']/li[6]/a"))) break; } catch (Exception e) {}
      	Thread.sleep(1000);
      }	
  	
  	
      driver.findElement(By.xpath("(//a[@onclick='RIO.getGames(this, 997);'])[6]")).click(); //тест рулетки

      wait.until(pageLoadFinishedCondition);	
      	
  	
      id = "127"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
      id = "501"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
      id = "525"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
      id = "399"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]"); 
      id = "381"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
      id = "362"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
   
  	//------------------------- конец теста рулетки    
      System.out.println("-----------------конец теста рулетки");
      System.err.println("-----------------конец теста рулетки");
      System.out.println("Открываем игры из меню 'другие'");	
      System.err.println("Открываем игры из меню 'другие'");  	      
 
    System.out.println("Ищем элемент другие");	
  	for (int second = 0;; second++) {
      	if (second >= 60) fail("timeout");
      	try { if (isElementPresent(By.xpath(".//*[@id='ctlg_menu']/li[7]/a"))) break; } catch (Exception e) {}
      	Thread.sleep(1000);
      }	
  	
     System.out.println("Клик по меню другие");	
     System.err.println("Клик по меню "+driver.findElement(By.xpath("(//a[@onclick='RIO.getGames(this, 997);'])[7]")).getText());		
  	
      driver.findElement(By.xpath("(//a[@onclick='RIO.getGames(this, 997);'])[7]")).click(); //тест другие

      wait.until(pageLoadFinishedCondition);	
      	
  	
      id = "260"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
      id = "4280"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
      id = "520"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
      id = "518"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]"); 
      id = "511"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
      id = "498"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
      id = "493"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
      id = "486"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");   
      id = "470"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
      id = "439"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
      id = "365"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
      id = "355"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");  
      id = "343"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
      id = "329"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
      id = "327"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
      id = "309"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]"); 
      id = "306"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
      id = "281"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
      id = "264"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
      id = "224"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");   
      id = "154"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
      id = "118"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
      id = "97"; openGame(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
     
  	//------------------------- конец теста другие  
      System.out.println("-----------------конец теста другие");
      System.err.println("-----------------конец теста другие");
      System.err.println("конец теста казино микрогейминг ");	  
      System.out.println("конец теста казино микрогейминг ");	
// конец теста казино микрогейминг 
      Dragger1 = 6; Dragger2 = 3; 
    //Начало теста 3Д казино NETENT  
  	System.err.println("------Начало теста 3Д казино NETENT----------");	// Выводим сообщения
  	// меню id=casino_btn
  	driver.findElement(By.id("casino_3d_btn")).click();
  	wait.until(pageLoadFinishedCondition);	
  	//       
     
 	//------------------------- начало теста слоты          
    System.out.println("Открываем игры из меню 'слоты'");	
    System.err.println("Открываем игры из меню 'слоты'");	
	for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath(".//*[@id='ctlg_menu']/li[2]/a"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }	
	
    driver.findElement(By.xpath("(//a[@onclick='RIO.getGames(this, 992);'])[2]")).click(); //тест слоты
    System.out.println("Попытка зайти в тест слоты");	
    wait.until(pageLoadFinishedCondition);	
    	
    id = "98038"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "98037"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "93332"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3103"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");   
    id = "3090"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3086"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]"); 
    id = "3152"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3070"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");   
    id = "3092"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3986"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3091"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");   
    id = "3067"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3042"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3119"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3984"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");  
    id = "3056"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3182"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3142"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3065"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]"); 
    id = "3097"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3172"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3053"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3031"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");   
    id = "3150"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3988"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
   
	//------------------------- конец теста слоты    	3D
    
    //------------------------- начало теста настольные  3D
	System.out.println("Попытка найти элемент настольные");	
	for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath(".//*[@id='ctlg_menu']/li[3]/a"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }	
	
    System.out.println("-----------------конец теста слотов");
    System.err.println("-----------------конец теста слотов");
    System.out.println("Открываем игры из меню 'настольные'");	
    System.err.println("Открываем игры из меню 'настольные'");		
	
    driver.findElement(By.xpath("(//a[@onclick='RIO.getGames(this, 992);'])[3]")).click(); //тест настольных
    
    wait.until(pageLoadFinishedCondition);	
    //System.out.println("Зашли в тест настольных");		
	
    id = "142597"; openGame3dTable(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3147"; openGame3dTable(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3149"; openGame3dTable(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3148"; openGame3dTable(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]"); 
    id = "3068"; openGame3dTable(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3139"; openGame3dTable(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3135"; openGame3dTable(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3136"; openGame3dTable(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");   
    id = "3039"; openGame3dTable(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3041"; openGame3dTable(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3040"; openGame3dTable(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3114"; openGame3dTable(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");  
    id = "3116"; openGame3dTable(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3115"; openGame3dTable(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3063"; openGame3dTable(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3062"; openGame3dTable(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]"); 
    id = "3061"; openGame3dTable(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3991"; openGame3dTable(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3173"; openGame3dTable(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3175"; openGame3dTable(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");   
    id = "3174"; openGame3dTable(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3157"; openGame3dTable(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3140"; openGame3dTable(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3137"; openGame3dTable(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");       
    id = "3138"; openGame3dTable(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3127"; openGame3dTable(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3124"; openGame3dTable(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3126"; openGame3dTable(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");   
    id = "3125"; openGame3dTable(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3121"; openGame3dTable(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3123"; openGame3dTable(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3122"; openGame3dTable(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");  
    id = "3051"; openGame3dTable(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3033"; openGame3dTable(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3035"; openGame3dTable(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3034"; openGame3dTable(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]"); 
    id = "3026"; openGame3dTable(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3028"; openGame3dTable(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3027"; openGame3dTable(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3025"; openGame3dTable(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");   
 
	//------------------------- конец теста настольных  3D
    System.out.println("-----------------конец теста настольные");
    System.err.println("-----------------конец теста настольные");
    System.out.println("Открываем игры из меню 'стретч-карты'");	
    System.err.println("Открываем игры из меню 'стретч-карты'");	    
    
    
	for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath(".//*[@id='ctlg_menu']/li[4]/a"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }	
	
    driver.findElement(By.xpath("(//a[@onclick='RIO.getGames(this, 992);'])[4]")).click(); //тест стретч-карты
    
    wait.until(pageLoadFinishedCondition);	
    	
	
    id = "3185"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3168"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3169"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3166"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]"); 
    id = "3096"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3165"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3158"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3144"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");   
    id = "3105"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3104"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3101"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3087"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");  
    id = "3075"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3045"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3023"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
    id = "3022"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]"); 
   
	//------------------------- конец теста стретч-карт  3D
    System.out.println("-----------------конец теста стретч-карт");
    System.err.println("-----------------конец теста стретч-карт");
    System.out.println("Открываем игры из меню 'джек-поты'");	
    System.err.println("Открываем игры из меню 'джек-поты'");	     
    
    
 	for (int second = 0;; second++) {
     	if (second >= 60) fail("timeout");
     	try { if (isElementPresent(By.xpath(".//*[@id='ctlg_menu']/li[5]/a"))) break; } catch (Exception e) {}
     	Thread.sleep(1000);
     }	
 	
     driver.findElement(By.xpath("(//a[@onclick='RIO.getGames(this, 992);'])[5]")).click(); //тест джек-поты
     System.out.println("Попытка зайти в тест джек-поты");	
     wait.until(pageLoadFinishedCondition);	
     	
     id = "3048"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
     id = "3047"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
     id = "3049"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]"); 
     id = "3164"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
     id = "3155"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");   
     id = "3106"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
     id = "3089"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
     id = "3046"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
   
 	//------------------------- конец теста джек-поты  3d       
     System.out.println("-----------------конец теста джек-поты");
     System.err.println("-----------------конец теста джек-поты");
     System.out.println("Открываем игры из меню 'рулетки'");	
     System.err.println("Открываем игры из меню 'рулетки'");	     
     

  	 for (int second = 0;; second++) {
      	if (second >= 60) fail("timeout");
      	try { if (isElementPresent(By.xpath(".//*[@id='ctlg_menu']/li[6]/a"))) break; } catch (Exception e) {}
      	Thread.sleep(1000);
      }	
  	
      driver.findElement(By.xpath("(//a[@onclick='RIO.getGames(this, 992);'])[6]")).click(); //тест рулетки
      System.out.println("Попытка зайти в тест рулетки");	
      wait.until(pageLoadFinishedCondition);	
      	
  	
      id = "3068"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
      id = "3135"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
      id = "3136"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
      id = "3157"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]"); 
      id = "3140"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
      id = "3137"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
      id = "3138"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
      id = "3025"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");   
  	//------------------------- конец теста рулетки   3d           
      System.out.println("-----------------конец теста рулетки");
      System.err.println("-----------------конец теста рулетки");
      System.out.println("Открываем игры из меню 'другие'");	
      System.err.println("Открываем игры из меню 'другие'");	       
      

    	for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.xpath(".//*[@id='ctlg_menu']/li[7]/a"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }	
    	
        driver.findElement(By.xpath("(//a[@onclick='RIO.getGames(this, 992);'])[7]")).click(); //тест другие
        System.out.println("Попытка зайти в тест другие");	
        wait.until(pageLoadFinishedCondition);	
        	
        id = "1111"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");   	
        id = "3043"; openGame3d(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");
        id = "133487"; openGame3dTable(pageLoadFinishedCondition, wait,"",".//*[@id='"+id+"']/b",".//*[@id='"+id+"']/div[2]/a[2]");

    	//------------------------- конец теста другие  
        System.err.println("конец теста казино 3d netent ");	  
        System.out.println("конец теста казино 3d netent ");	
  // конец теста казино 3d netent    
      
     
	//корректное закрытие сайта и выход из драйвера
	driver.close();

	try {
	Thread.sleep(5000);
	driver.quit();
	} catch (Exception e) {
	}
	// конец коррекции
	
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
		//driver.findElement(By.cssSelector("div.mCSB_dragger_bar")).click();   
	} else { 
		System.out.println("Не найден элемент прокрутки");
    }    
	WebElement Element = driver.findElement(By.cssSelector("div.mCSB_dragger_bar"));
	
	Boolean flag=false;
	//while (!driver.findElement(By.xpath(byXPathName)).getText().equals(assertName))
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
	    	 			}
	    	 		
	    	 		
	        	} else { 
	        		System.out.println("Не наден: "+byXPathButtonDemo);
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
		//FlashObjectWebDriver flashApp = new FlashObjectWebDriver(driver, "system");

		System.out.println("Статус загрузки игры в плагин: "+((JavascriptExecutor) driver).executeScript("return document.readyState"));
		System.err.println("Статус загрузки игры в плагин: "+((JavascriptExecutor) driver).executeScript("return document.readyState"));
		//System.err.println("Игра загружена на:"+flashApp.callFlashObject("PercentLoaded")+"%, управление передано плагину");
		
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

public void openGame3d(ExpectedCondition<Boolean> pageLoadFinishedCondition,
		WebDriverWait wait, String assertName, String byXPathName, String byXPathButtonDemo) throws InterruptedException {
    
	Boolean Scroll = false;
	Actions builder = new Actions(driver);
	builder.build();	
	
	if(isElementPresent(By.cssSelector("div.mCSB_dragger_bar"))) {
		System.out.println("Найден элемент прокрутки");	
		if(driver.findElement(By.cssSelector("div.mCSB_dragger_bar")).isDisplayed())
				{Scroll = true;} else {System.out.println("Скроллбар не виден, игр меньше 8 штук");}
	} else { 
		System.out.println("Не найден элемент прокрутки");
    }    
	
	if(Scroll){
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
	} 
	
	if(isElementPresent(By.xpath(byXPathName))) {
		System.out.println("Найден локатор: "+byXPathName);	
	    System.out.println("его значение: "+driver.findElement(By.xpath(byXPathName)).getText());
	    
		new Actions(driver).moveToElement(    //подводим указатель мыши к названию игры, должны появиться кнопки, нажимаем демо
           driver.findElement(By
           		.xpath(byXPathName)))
           .perform(); Thread.sleep(100L);
           System.out.println("Подвели указатель к элементу для появления кнопок");	       
           System.out.println("Запуск игры: "+driver.findElement(By.xpath(byXPathName)).getText());       
	     if(isElementPresent(By.xpath(byXPathButtonDemo))) {
	        		System.out.println("Найден: "+byXPathButtonDemo);	
	    	 
	    	 		if(driver.findElement(By.xpath(byXPathButtonDemo)).isDisplayed()) {
	    	 			System.out.println("Он видимый: "+byXPathButtonDemo);	
	    	 		}
	    	 		else {
	    	 			System.out.println("Он невидимый: "+byXPathButtonDemo);
	    	 			}

	      } else { 
	        		System.out.println("Мы не нашли: "+byXPathButtonDemo);
	      }        
  	    new Actions(driver).moveToElement(driver.findElement(By.xpath(byXPathButtonDemo))).perform(); Thread.sleep(100L);   		
			//assertEquals(assertName, driver.findElement(By.xpath(byXPathName)).getText()); 
	
	} else {  // конец если где смотрим элемент с названием игры
		System.out.println("Не найдена игра с XPath: "+byXPathName);
		System.err.println("Не найдена игра с XPath: "+byXPathName);
		return;
    }   
	
    System.err.println("Запуск игры: "+driver.findElement(By.xpath(byXPathName)).getText());        
    driver.findElement(By.xpath(byXPathButtonDemo)).click();
    wait.until(pageLoadFinishedCondition);    //ждем открытия игры
    Thread.sleep(1000L);
    driver.switchTo().frame("play_box"); // заходим во фрэйм с игрой, чтобы были доступны кнопки
		
	// если фрейм с игрой открылся, то ищем флэш и тестируем ее на 100% загрузку 
    //        .//*[@id='egamings_container']
	if(isElementPresent(By.xpath(".//*[@id='egamings_container']"))) {
		
		WebElement Tag = driver.findElement(By.xpath(".//*[@id='egamings_container']"));
		System.out.println("Имя тэга:"+Tag.getTagName());
		FlashObjectWebDriver flashApp = new FlashObjectWebDriver(driver, "egamings_container");
		System.out.println("Игра загружена на:"+flashApp.callFlashObject("PercentLoaded")+"%, управление передано плагину");
		System.out.println("Статус загрузки игры в плагин: "+((JavascriptExecutor) driver).executeScript("return document.readyState"));
		System.err.println("Игра загружена на:"+flashApp.callFlashObject("PercentLoaded")+"%, управление передано плагину");
		System.err.println("Статус загрузки игры в плагин: "+((JavascriptExecutor) driver).executeScript("return document.readyState"));		
		
		} 
	else { 
		System.out.println("Не найден локатор с id='egamings_container'");
		System.err.println("Не найден локатор с id='egamings_container'");
		   }
	

	new Actions(driver).moveToElement(
	            driver.findElement(By
	            		.xpath(".//*[@id='game_close']")))
	            .perform();
	Thread.sleep(300L);
		
	driver.findElement(By.xpath(".//*[@id='game_close']")).click(); 
	driver.switchTo().defaultContent();

	System.out.println("Выход из игры");
	System.err.println("Выход из игры");
}

public void openGame3dTable(ExpectedCondition<Boolean> pageLoadFinishedCondition,
		WebDriverWait wait, String assertName, String byXPathName, String byXPathButtonDemo) throws InterruptedException {
    
	Boolean Scroll = false;
	Actions builder = new Actions(driver);
	builder.build();	
	
	if(isElementPresent(By.cssSelector("div.mCSB_dragger_bar"))) {
		System.out.println("Найден элемент прокрутки");	
		if(driver.findElement(By.cssSelector("div.mCSB_dragger_bar")).isDisplayed())
				{Scroll = true;} else {System.out.println("Скроллбар не виден, игр меньше 8 штук");}
	} else { 
		System.out.println("Не найден элемент прокрутки");
    }    
	
	if(Scroll){
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
	} 
	
	if(isElementPresent(By.xpath(byXPathName))) {
		System.out.println("Найден локатор: "+byXPathName);	
	    System.out.println("его значение: "+driver.findElement(By.xpath(byXPathName)).getText());
	    
		new Actions(driver).moveToElement(    //подводим указатель мыши к названию игры, должны появиться кнопки, нажимаем демо
	            driver.findElement(By
	            		.xpath(byXPathName)))
	            .perform(); Thread.sleep(50L);
	            System.out.println("Указатель подведен к элементу для появления кнопок");	       
	     System.out.println("Вход в игру: "+driver.findElement(By.xpath(byXPathName)).getText());       
	     if(isElementPresent(By.xpath(byXPathButtonDemo))) {
	        		System.out.println("Найден: "+byXPathButtonDemo);	
	    	 
	    	 		if(driver.findElement(By.xpath(byXPathButtonDemo)).isDisplayed()) {
	    	 			System.out.println("Он видимый: "+byXPathButtonDemo);	
	    	 		}
	    	 		else {
	    	 			System.out.println("Он невидимый: "+byXPathButtonDemo);
	    	 			}
	    	 		
	    	 		
	        	} else { 
	        		System.out.println("Не найден: "+byXPathButtonDemo);
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
	
    System.err.println("Запуск игры: "+driver.findElement(By.xpath(byXPathName)).getText());        
    driver.findElement(By.xpath(byXPathButtonDemo)).click();
    wait.until(pageLoadFinishedCondition);    //ждем открытия игры
    Thread.sleep(1000L);
    driver.switchTo().frame("play_box"); // заходим во фрэйм с игрой, чтобы были доступны кнопки
		

  //переключаемся на фрэйм id='egamings_container в котором лежит наша флэш
  	if(isElementPresent(By.xpath(".//*[@id='egamings_container']"))) {
  		System.out.println("Найден локатор .//*[@id='egamings_container']");	
  	} else { 
  		System.out.println("Не найден локатор .//*[@id='egamings_container']");
  		System.err.println("Не найден локатор .//*[@id='egamings_container']");
  		//return;
  		   }
  	WebElement Tag = driver.findElement(By.xpath(".//*[@id='egamings_container']"));
	System.out.println("Имя тэга:"+Tag.getTagName());
	
	if(Tag.getTagName().equals("iframe")){   //если тэг фрэйм то входим, иначе это тестируем загрузку в текущем фрэйме
	
	  	driver.switchTo().frame(driver.findElement(By.xpath(".//*[@id='egamings_container']"))); 
		
	  	System.out.println("Статус загрузки игры в плагин: "+((JavascriptExecutor) driver).executeScript("return document.readyState"));
	  	System.err.println("Статус загрузки игры в плагин: "+((JavascriptExecutor) driver).executeScript("return document.readyState"));
	  	
	  	driver.switchTo().defaultContent();
	  	Thread.sleep(100L); 
	  	if(isElementPresent(By.xpath("//*[@id='play_box']"))) {
	  		System.out.println("Найден фрэйм с  id=play_box");	
	  		driver.switchTo().frame("play_box");
	  		Thread.sleep(100L);
  		} else { 
  			System.out.println("Не найден фрэйм с  id=play_box");
  				}
										} 
	else
  	{
  		
		//FlashObjectWebDriver flashApp = new FlashObjectWebDriver(driver, "egamings_container");
		//System.out.println("Игра загружена на:"+flashApp.callFlashObject("PercentLoaded")+"%, управление передано плагину");
		System.out.println("Статус загрузки игры в плагин: "+((JavascriptExecutor) driver).executeScript("return document.readyState"));	
		System.err.println("Статус загрузки игры в плагин: "+((JavascriptExecutor) driver).executeScript("return document.readyState"));
  	}
	  	
	new Actions(driver).moveToElement(
            driver.findElement(By
            		.xpath(".//*[@id='game_close']")))
            .perform();
	Thread.sleep(300L);
  		
	driver.findElement(By.xpath(".//*[@id='game_close']")).click(); 
	driver.switchTo().defaultContent();

	System.out.println("Выход из игры");
	System.err.println("Выход из игры");
  		
     
      
}



  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}


	//builder.dragAndDropBy(Element,0,1).perform();
	//Thread.sleep(500L);
	
	//builder.moveToElement(Element).dragAndDropBy(Element,0,1).perform();
	//Thread.sleep(2000L);


//driver.findElement(By.cssSelector("div.mCSB_draggerContainer")).click();        
//int x = Element.getLocation().getX();
//int y = Element.getLocation().getY(); 

	// если фрейм с игрой открылся, то ищем флэш и тестируем ее на 100% загрузку 
/*  	if(isElementPresent(By.xpath(".//*[@id='canvasAnimationManager']"))) {

		System.out.println("Статус загрузки игры в плагин: "+((JavascriptExecutor) driver).executeScript("return document.readyState"));
		//System.err.println("Игра загружена на:"+flashApp.callFlashObject("PercentLoaded")+"%, управление передано плагину");
		
	} else { 
		System.out.println("Не найден фрейм с id='canvasAnimationManager'");
		System.err.println("Не найден фрэйм с id='canvasAnimationManager'");
		
		   }*/
	// выходим из фрэйма в корень

