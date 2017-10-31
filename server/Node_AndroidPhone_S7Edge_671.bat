set "BASE_DIR=%cd%"
appium --session-override --nodeconfig %BASE_DIR%\AndroidPhone_S7Edge_671.json -p 4723 --platform-name Android --platform-version 24 --automation-name Appium --no-reset