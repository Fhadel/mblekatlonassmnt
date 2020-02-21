package common

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory

import io.appium.java_client.MobileElement
import io.appium.java_client.TouchAction
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.touch.WaitOptions
import io.appium.java_client.touch.offset.PointOption
import static java.time.Duration.ofSeconds;


public class calendar {

	AndroidDriver driver = MobileDriverFactory.getDriver()
	TouchAction touchAction = new TouchAction(driver)
	String [] listMonth = [
		"Jan",
		"Feb",
		"Mar",
		"Apr",
		"May",
		"Jun",
		"Jul",
		"Aug",
		"Sep",
		"Oct",
		"Nov",
		"Dec"
	]

	/*format date MM DD YYYY*/
	@Keyword
	public void selectDate(String selectedDate){
		String [] splitSelectedDate = selectedDate.split("\\s+")
		println(splitSelectedDate[0].substring(0, 3))

		List<MobileElement> elementsOne = (List<MobileElement>) driver.findElementsById("android:id/numberpicker_input");
		String [] dates = new String[elementsOne.size()]

		int i = 0
		for(MobileElement a : elementsOne){
			dates[i] = a.getText()
			i++
		}

		String [] currentFullDate = dates
		while (elementsOne.get(0).getText() != splitSelectedDate[0]) {
			if (Arrays.asList(listMonth).indexOf(currentFullDate[0]) < Arrays.asList(listMonth).indexOf(splitSelectedDate[0].substring(0, 3))){
				touchAction.press(PointOption.point(325, 1000)).waitAction(WaitOptions.waitOptions(ofSeconds(5))).moveTo(PointOption.point(325, 900)).release().perform()
				//touchAction.longPress(525, 350).moveTo(525, 200).release().perform()
			}else if (Arrays.asList(listMonth).indexOf(currentFullDate[0]) > Arrays.asList(listMonth).indexOf(splitSelectedDate[0].substring(0, 3))){
				touchAction.press(PointOption.point(325, 1000)).waitAction(WaitOptions.waitOptions(ofSeconds(5))).moveTo(PointOption.point(325, 1300)).release().perform()
				//touchAction.longPress(525, 350).moveTo(525, 400).release().perform()
			}else{
				System.out.print("Month is equals with expected")
			}
		}

		while (elementsOne.get(2).getText() != splitSelectedDate[2]) {
			touchAction.press(PointOption.point(710, 1000)).waitAction(WaitOptions.waitOptions(ofSeconds(5))).moveTo(PointOption.point(710, 1400)).release().perform()
			//touchAction.longPress(710, 350).moveTo(550, 400).release().perform()
		}

		Mobile.tap(findTestObject('Object Repository/Common/By ID', [('id') : 'android:id/button1']), 1)
	}
}

