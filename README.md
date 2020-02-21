
# For Your Information
Here is the information that you should know about my project:

## Katalon version
```
KATALON 6.3.3
```
## Node version 
```
8.11.1
```

## Appium version
```
1.8.1
```

## Device Spec 
```
POCOPHONE F1 ( Android 9 PIE )
```


## Scenario that i've tested is 
```
	- Install My homecredit mobile app from play store here
	- Open the app
	- Swipe left / swipe right the page in on boarding page after app installed
 	- Click on button “Daftar” to register
	- Fill in date of birth, phone number, PIN code, and PIN confirmation , then click on button “Lanjutkan”
	- Check existence of consent page (halaman syarat dan ketentuan) then click “I Agree”
	- Read OTP code
	- Click “Daftar” until register sucesss and Homepage of My Homecredit App is opened
```

## HOW TO RUN
How to run the test, there is 2 way to run the test : 
```
	1. You can open the katalon and run the test directly from the apps
	2. I create a bat file to run the test without opening the katalon. If you want run the bat file you need 3 things
		- Device ID 
		- Directory where you keep the project / the test ( make sure folder doesnt have space )
		- Katalon 6.3.3 version because in Katalon v.7 cmd run is not possible without buying the Runtime Engine
```