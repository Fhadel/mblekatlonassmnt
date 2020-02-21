@echo off
    echo ---------------------ATTENTION--------------------------------
    echo.											  
    echo THIS COMMAND WILL RUN KATALON PROJECT  
    echo MY ENVIRONMENT SETTING :  
    ECHO - APPIUM 1.8
    ECHO - KATALON 6.3.3
    ECHO - DEVICE POCOPHONE F1 ANDROID 9  
    ECHO.
    ECHO.
    echo PLEASE INPUT DIRECTORY KATALON EXECUTABLE FILE,				  
    echo PLEASE INPUT YOUR DEVICE ID, CHECK IN ADB-DEVICES
    echo PLEASE INPUT PROJECTPATH ( DIRECTORY YOU EXTRACTED THE PROJECT )
    echo.
    echo.
    set /p katalonExecutable=ENTER DIRECTORY KATALON EXECUTABLE PATH:
    echo %katalonExecutable%
    cd %katalonExecutable%
    set /p deviceId=ENTER YOUR DEVICE ID :
    echo %deviceId%
    set /p projectPath=ENTER YOUR PROJECTPATH :
    echo %projectPath%
    katalon -noSplash  -runMode=console -consoleLog -projectPath=%projectPath% -retry=0 -testSuitePath="Test Suites/Register New Account" -executionProfile="default" -deviceId=%deviceId% -browserType="Android" -summaryReport -reportFolder=%projectPath% 
    pause