pause
del C:\Users\linkui\Desktop\log\*.* /s/q
adb wait-for-device
adb root
adb wait-for-device
adb remount
adb wait-for-device
adb shell rm /cache/*.txt
adb wait-for-device
adb shell aplogcat -d -o /cache/
adb wait-for-device
adb pull /cache/ C:\Users\linkui\Desktop\log
adb wait-for-device
adb bugreport >C:\Users\linkui\Desktop\log\bugreport.txt
adb wait-for-device
adb shell dumpsys dropbox --print > C:\Users\linkui\Desktop\log\dropbox.txt
adb wait-for-device
adb pull /data/system/dropbox C:\Users\linkui\Desktop\log\Dropbox_folder
pause