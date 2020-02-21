import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import internal.GlobalVariable


KeywordLogger log = new KeywordLogger()


log.logInfo("Starting Application My Home Credit")
Mobile.startExistingApplication('id.co.myhomecredit')

Mobile.delay(5)

log.logInfo("Swiping until Daftar Button is Displayed")
/* Swipe to the DAFTAR Button is display */
while (Mobile.verifyElementNotExist(findTestObject('Object Repository/WelcomePage/WelcomePage_DaftarButton'), 5, FailureHandling.OPTIONAL)) {
    CustomKeywords.'common.swipe.swipeLeft'(900, 700, 100, 700)
}

Mobile.verifyElementVisible(findTestObject('Object Repository/WelcomePage/WelcomePage_DaftarButton'), 5)

Mobile.tap(findTestObject('Object Repository/WelcomePage/WelcomePage_DaftarButton'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/Common/By XPATH', [('xpath') : '//*[contains(text(),"Tanggal Lahir")]']), 2)

Mobile.tap(findTestObject('Object Repository/Common/By XPATH', [('xpath') : '//*[contains(text(),"Tanggal Lahir")]']), 2)

CustomKeywords.'common.calendar.selectDate'('Jan 15 1995')

String phoneNumber = GlobalVariable.phoneNumber

Mobile.setText(findTestObject('Object Repository/Common/By ID', [('id') : 'id.co.myhomecredit:id/input_phone_no']), phoneNumber, 
    2)

Mobile.setText(findTestObject('Object Repository/Common/By ID', [('id') : 'id.co.myhomecredit:id/setup_pin']), '1212', 2)

Mobile.setText(findTestObject('Object Repository/Common/By ID', [('id') : 'id.co.myhomecredit:id/confirm_pin']), '1212', 
    2)

Mobile.tap(findTestObject('Object Repository/Common/By ID', [('id') : 'id.co.myhomecredit:id/btn_next']), 3)

Mobile.delay(8)

log.logInfo("Scrolling to bottom page until button agree is clickable")
while (true) {
    if (Mobile.verifyElementAttributeValue(findTestObject('Object Repository/Common/By ID', [('id') : 'id.co.myhomecredit:id/agree_button']), 
        'enabled', 'false', 3, FailureHandling.OPTIONAL) == true) {
        CustomKeywords.'common.swipe.swipeUp'(900, 1700, 900, 900)
    } else {
        Mobile.tap(findTestObject('Object Repository/Common/By ID', [('id') : 'id.co.myhomecredit:id/agree_button']), 3)

        break
    }
}

log.logInfo("Waiting for OTP")
Mobile.delay(20)

Mobile.openNotifications()

log.logInfo("Set OTP into textfield")
String TextNotif = Mobile.getText(findTestObject('NotificationText_OTP'), 5)

println(TextNotif.substring(51, 55))

Mobile.delay(5)

Mobile.closeNotifications()

Mobile.setText(findTestObject('Object Repository/Common/By ID', [('id') : 'id.co.myhomecredit:id/pin_et_input_otp']), TextNotif.substring(
        51, 55), 5)

Mobile.tap(findTestObject('Object Repository/Common/By ID', [('id') : 'id.co.myhomecredit:id/btn_next']), 3)

Mobile.delay(5)

Mobile.takeScreenshot()

Mobile.tap(findTestObject('Object Repository/Common/By ID', [('id') : 'android:id/button1']), 1)

log.logInfo("Waiting for OTP")
Mobile.waitForElementPresent(findTestObject('Object Repository/HomePage/HomePage_ImageLogoHCI'), 3)

Mobile.takeScreenshot()

log.logInfo("Verify Landing Page is HomePage")
Mobile.verifyElementVisible(findTestObject('Object Repository/HomePage/HomePage_ImageLogoHCI'), 3)

Mobile.verifyElementExist(findTestObject('Object Repository/HomePage/HomePage_ToolBar_Account'), 3)

Mobile.takeScreenshot('C:\\Users\\Fhadel Fadillah\\Katalon Studio\\AssesmentHCI\\Reports\\Screenshot\\SS.png')

