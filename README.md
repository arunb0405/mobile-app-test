# mobile-app-test
Mobile automation tests that can run in Java-Appium and Maven frame-work

1. Download latest appium and run the appium server in port 4723

Check for the message in appium server logs 'Appium REST http interface listener started on localhost:4723'
Note - Appium Desktop UI can be downloaded at https://github.com/appium/appium-desktop/releases/tag/v1.22.3-4

For Appium to work, the values of ANDROID_HOME and JAVA_HOME should be set correctly
e.g ANDROID_HOME - C:\Users\arunb\AppData\Local\Android\Sdk
JAVA_HOME - C:\Program Files\Java\jdk-21

I'm using one of the latest JAVA JDK for this test.

2. Load the given project 'cd mobile-app-test/Calculator-Android' in IDEA Intellij.
Ensure the right JDK is selected in Intellij Settings.
3. Open Android SDK and start emulator, Tools - AVD devices.
'adb devices' command should list the emulator as connected device.
4. Build the project, once the build is successful, right-click on CalculatorTest.java and click run button.
5. We can view the Calculator test running in Android emulator.