package ssq_website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import util.Switch;
import util.Wait;


public class Zgfcw {
	WebDriver driver = null;
	Switch switch_obj = null;
	Wait wait = null;
	Actions actions = null;
	int timeout = 0;

	
	
	public Zgfcw(String ChromePath, String ChromeDriverPath, int timeout) {
		System.setProperty("webdriver.chrome.bin", ChromePath);
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize(); // ��������
		actions = new Actions(driver);
		switch_obj = new Switch();
		wait = new Wait();
		this.timeout = timeout;
	}

	
	
	public static void main(String[] args) {
		String ChromePath = "D:\\chrome\\Application\\chrome.exe";
		String ChromeDriverPath = "D:\\\\chrome\\\\Application\\chromedriver.exe";
		int timeout = 30;
		
		Zgfcw zgfcw = new Zgfcw(ChromePath, ChromeDriverPath, timeout);
		zgfcw.winning_province_2013_after("http://www.cwl.gov.cn/kjxx/ssq/kjgg/");
		
	}
	
	
	
	public void winning_province_2013_after(String url) {
		driver.get(url);
		System.out.println("�ں�" + "   " + "�н�ʡ��");
		for(int i=0; i<10; i++){
			for(int j=0; j<100; j++){
				int tr_num = j + 1;
				// �ں�
				String xpath = "/html/body/div[1]/div/div[3]/table/tbody/tr[" + tr_num + "]/td[1]";
				WebElement qh_element = driver.findElement(By.xpath(xpath));
				String qh_text = qh_element.getAttribute("innerText");
				// �������
				xpath = "/html/body/div[1]/div/div[3]/table/tbody/tr[" + tr_num + "]/td[13]/a";
				WebElement details_element = driver.findElement(By.xpath(xpath));
				details_element.click();
				// �л� Window
				String targetTitle = "�й�������Ʊ��˫ɫ�򡱵�" + qh_text + "�ڿ�������_���ڿ���_�й�������";
				switch_obj.toWindow(driver, targetTitle, 2);
				// �н�ʡ��
				xpath = "/html/body/div[3]/div/div/div[2]/div/dl/dd";
				WebElement zjsf_element = driver.findElement(By.xpath(xpath));
				String zjsf_text = zjsf_element.getAttribute("innerText");
				System.out.println(qh_text + "   " + zjsf_text);
				driver.close();
				switch_obj.toWindow(driver, "���ڿ���_�й�������", 1);
			}
			// �����һҳ
			String xpath = "//*[@id='pageTool']/li[12]";
			WebElement xyy_element = driver.findElement(By.xpath(xpath));
			xyy_element.click();
		}
	}
	
	
	
	
	
	
}
