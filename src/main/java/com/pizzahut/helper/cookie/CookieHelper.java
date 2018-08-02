package com.pizzahut.helper.cookie;

import java.util.Date;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import com.pizzahut.helper.Logger.LoggerHelper;

public class CookieHelper {
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(CookieHelper.class);

	// Get All the cookie
	public Set<Cookie> getAllCookie() {
		log.info(driver.manage().getCookies());
		return driver.manage().getCookies();
	}

	// Get Cookie name
	public Cookie getCookieName(String name) {
		log.info(driver.manage().getCookieNamed(name));
		return driver.manage().getCookieNamed(name);
	}

	
	public String getValueOfCookieName(String name) {
	    log.info(driver.manage().getCookieNamed(name).getValue());
		return driver.manage().getCookieNamed(name).getValue();
	}

	public void addCookie(String name, String value, String Domain,
			String path, Date Expiry) {
		driver.manage()
				.addCookie(new Cookie(name, value, Domain, path, Expiry));
	}

	public void addCookieToBrowser(Set<Cookie> cookies, String domain,
			String name, String value, String path, Date Expiry) {
		for (Cookie c : cookies) {
			if (c != null) {
				if (c.getDomain().contains(domain)) {
					driver.manage().addCookie(
							new Cookie(name, domain, value, path, Expiry));
				}
			}
		}
	}


   public void deleteCookie(String name){
	   driver.manage().deleteCookieNamed(name);
   }

   public void deleteAllCookie(){
	   driver.manage().deleteAllCookies();
	
   }
	
}
