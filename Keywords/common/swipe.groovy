package common

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory

import io.appium.java_client.AppiumDriver
import io.appium.java_client.TouchAction
import io.appium.java_client.touch.WaitOptions
import io.appium.java_client.touch.offset.PointOption
import static java.time.Duration.ofSeconds;

public class swipe {
	AppiumDriver<?> driver = MobileDriverFactory.getDriver()
	TouchAction actions = new TouchAction(driver)

	@Keyword
	def swipeLeft(int x, int y, int ax, int ay){
		actions.press(PointOption.point(x, y)).waitAction(WaitOptions.waitOptions(ofSeconds(2))).moveTo(PointOption.point(ax, ay)).release().perform()
	}

	@Keyword
	def swipeUp(int x, int y, int ax, int ay){
		actions.press(PointOption.point(x, y)).waitAction(WaitOptions.waitOptions(ofSeconds(2))).moveTo(PointOption.point(ax, ay)).release().perform()
	}
}
