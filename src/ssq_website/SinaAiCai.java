package ssq_website;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import org.openqa.selenium.By;
import util.Switch;
import util.Wait;


public class SinaAiCai {
	WebDriver driver = null;
	Switch switch_obj = null;
	Wait wait = null;
	Actions actions = null;
	int timeout = 0;

	
	

	public SinaAiCai(String ChromePath, String ChromeDriverPath, int timeout) {
		System.setProperty("webdriver.chrome.bin", ChromePath);
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize(); // 最大化浏览器
		actions = new Actions(driver);
		switch_obj = new Switch();
		wait = new Wait();
		this.timeout = timeout;
	}
	
	

	public static void main(String[] args) {
		String ChromePath = "D:\\chrome\\Application\\chrome.exe";
		String ChromeDriverPath = "D:\\\\chrome\\\\Application\\chromedriver.exe";
		int timeout = 30;
		String url = "http://zst.aicai.com/ssq/";
		
		SinaAiCai sinaAiCai = new SinaAiCai(ChromePath, ChromeDriverPath, timeout);
//		sinaAiCai.lhzs(url + "lhzs/");
		sinaAiCai.clg(url + "clg/");
		
	}
	
	
	
	public void lhzs(String url) {
		driver.get(url);
		System.out.println("期号" + "," + "连号组数" + "," + "连号个数");
		for(int i=0; i<10000; i++){
			int tr_num = i + 1;
			if (tr_num % 6 == 0) {
				continue;
			}
			// 期号
			String xpath = "//*[@id='tdata']/tr[" + tr_num + "]/td[1]";
			WebElement qh_element = driver.findElement(By.xpath(xpath));
			String qh_text = qh_element.getAttribute("innerText");
			// 连号组数
			xpath = "//*[@id='tdata']/tr[" + tr_num + "]/td[43]";
			WebElement lhzs_element = driver.findElement(By.xpath(xpath));
			String lhzs_text = lhzs_element.getAttribute("innerText");
			// 连号个数
			xpath = "//*[@id='tdata']/tr[" + tr_num + "]/td[44]";
			WebElement lhgs_element = driver.findElement(By.xpath(xpath));
			String lhgs_text = lhgs_element.getAttribute("innerText");
			
			System.out.println(qh_text + "  " + lhzs_text + "   " + lhgs_text);
		}
		
	}
	
	
	
	public void clg(String url) {
		driver.get(url);
		System.out.println("期号" + "," + "重号个数" + "," + "邻号个数" + "," + "孤号个数");
		for(int i=0; i<10000; i++){
			int tr_num = i + 1;
			if (tr_num % 6 == 0) {
				continue;
			}
			// 期号
			String xpath = "//*[@id='tdata']/tr[" + tr_num + "]/td[1]";
			WebElement qh_element = driver.findElement(By.xpath(xpath));
			String qh_text = qh_element.getAttribute("innerText");
			// 重号个数
			xpath = "//*[@id='tdata']/tr[" + tr_num + "]/td[37]";
			WebElement chgs_element = driver.findElement(By.xpath(xpath));
			String chgs_text = chgs_element.getAttribute("innerText");
			// 邻号个数
			xpath = "//*[@id='tdata']/tr[" + tr_num + "]/td[39]";
			WebElement lhgs_element = driver.findElement(By.xpath(xpath));
			String lhgs_text = lhgs_element.getAttribute("innerText");
			// 孤号个数
			xpath = "//*[@id='tdata']/tr[" + tr_num + "]/td[41]";
			WebElement ghgs_element = driver.findElement(By.xpath(xpath));
			String ghgs_text = ghgs_element.getAttribute("innerText");
			
			
			System.out.println(qh_text + "  " + chgs_text + "   " + lhgs_text + "   " + ghgs_text);
		}
		
	}
	
		
	
	
	
}
