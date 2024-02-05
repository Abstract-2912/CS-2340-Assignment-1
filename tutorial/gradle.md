## Structure

Let's familiarize ourselves with the default code and files created and try 
to run this app. 

On the left side of the window, the app's files are displayed in a hierarchy. 
The app folder should contain three folders: **manifests**, **java**, and **res**.

![img_11.png](img_11.png)


_Let's explore each one!_
### manifests
This folder contains the AndroidManifest.xml file. This file describes all the 
components of your Android app, which the Android runtime system when you 
execute your app.
![img_12.png](img_12.png)

### java
This folder contains all your Java language files. This folder contains all your 
Java language files with three subfolders: **com**, **com** (androidTest), and 
**com** (test).
- **com**: This folder contains the Java source code files for your app.
- **com** (androidTest): This folder is where you would put your _instrumented tests_,
tests that run on an Android device.
- **com** (test): This folder is where you would put your _unit tests_, tests that
don't need an Android device to run.

![img_10.png](img_10.png)


### res
This folder is where you store all non-code resources, such as images, strings, 
and XML layouts. These resources are maintained separately from your source code
so they can be updated independently. It contains the following subfolders:
- **drawable**: This folder contains all your app's images as bitmap or XML files.
- **layout**: This folder contains XML files that define a user interface layout.
Currently, your app has one activity that has a layout file called `activity_main.xml` 
as well as `content_main.xml`, `fragment_first.xml`, and `fragment_second.xml`.
- **menu**: This folder contains XML files that define app menus, such as an 
options menu, context menu, or submenu.
- **mipmap**: This folder contains drawable files for different launcher icons for your app.
- **navigation**: This folder contains the navigation graph, which tells Android
Studio how to navigate between different parts of your app.
- **values**: This folder contains XML files with values, such as strings, integers, 
and colors, used in your app.
- **xml**: This folder contains arbitrary XML files that can be read at runtime 
by calling Resources.getXML(). Various XML configuration files must be saved here,
such as a Search configuration.

> [!CAUTION]
> Never save resource files directly inside the **res/** directory. It causes a compiler error.

![img_13.png](img_13.png)

## Configuration
In order to simulate the  configuration for a particular type of Android device 
(Android phone, tablet, Wear OS, Android TV, etc.), you will need to use the 
**Android Virtual Device (AVD)** manager to create a virtual device. So, let's create
a configuration that describes the virtual device we want to emulate. 
1. Select **Tools** > **Device Manager** (or click the Device Manager icon in the
toolbar).![img_14.png](img_14.png)
2. Click the **+** button or **Create Virtual Device**.
![img_15.png](img_15.png)
3. The **Select Hardware** window should pop up with a list of pre-configured hardware 
device definitions. Choose any device definition, such as **Medium Phone**, and click **Next**.
![img_16.png](img_16.png)
4. Now, you may select a **System Image**. From the **Recommended** tab, choose the latest release.
![img_20.png](img_20.png)
> [!IMPORTANT]
> If the **Download** symbol is next to the latest release, it has not been installed yet. So, 
click the link to start the download, and click **Next** when it's done.
5. In the next dialog box, verify the configuration and select **Finish**.
6. The AVD manager should now display the virtual device just you added.
![img_21.png](img_21.png)

## Run Your App
Congratulations! You've just configured your first Android project! Now, let's try
running your app on your new emulator and/or a device.
### Emulator
Select **Run** > **Run 'app'** (or the **Run** icon in the toolbar).
![img_18.png](img_18.png)

If you would like to change the virtual device you would like to run on, select
**Run** > **Select Device** (or use the dropdown next to the **Run** icon in the 
toolbar).
![img_19.png](img_19.png)

This may take some time depending on the speed of your computer, but you may look 
at the horizaontal status bar at the very bottom of the window to see progress messages such as:
- _Gradle Build Running_
- _Waiting for target device to come on line_
- _Installing APK_
- _Launching activity_

Once your app builds and the emulator is ready, Android Studio uploads the app to the emulator and runs it.
You should see a window mimicking the screen of your configured device as shown below:
![img_22.png](img_22.png)

### Device
[comment]: <> (add how to run on a device)

You've now configured and run your first Android app - now let's personalize it! Click [**here**](xml.md) for **next steps** or alternatively, navigate to the `xml.md` file in this repository, where you
will start designing your application.
