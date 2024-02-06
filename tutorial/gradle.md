## :office: Structure

Let's familiarize ourselves with the default code and files created and try 
to run this app. 
<img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/110b9b32-ee06-4dbc-bfc8-b4f808516543" width="25%" height="65%" align="right">
On the left side of the window, the app's files are displayed in a hierarchy. The app folder should contain three folders: **manifests**, **java**, and **res**.

_Let's explore each one!_
### manifests
This folder contains the AndroidManifest.xml file. This file describes all the 
components of your Android app, which the Android runtime system when you 
execute your app.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/78f8eb73-2138-4a0c-bfb2-4c4cae79df15" width="50%" height="50%"></p>

### java
This folder contains all your Java language files. This folder contains all your Java language files with three subfolders: **com**, **com** (androidTest), and **com** (test). 
- **com**: This folder contains the Java source code files for your app.
- **com** (androidTest): This folder is where you would put your _instrumented tests_,
tests that run on an Android device. 
- **com** (test): This folder is where you would put your _unit tests_, tests that
don't need an Android device to run.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/ab07f914-9409-4dcc-94c9-fb1d317dc706" width="30%" height="30%"></p>


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
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/9e5a01d7-ee62-42ad-b0b4-cf2cd0bb46ba" width="30%" height="30%">
</p>

> [!CAUTION]
> Never save resource files directly inside the **res/** directory. It causes a compiler error.

<br>

## &#9881; Configuration
In order to simulate the  configuration for a particular type of Android device 
(Android phone, tablet, Wear OS, Android TV, etc.), you will need to use the 
**Android Virtual Device (AVD)** manager to create a virtual device. So, let's create
a configuration that describes the virtual device we want to emulate. 
1. Select **Tools** > **Device Manager** (or click the Device Manager icon in the
toolbar). <p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/673fd9de-8af1-415a-bc42-824cdc20318e" width="50%" height="50%"></p>
2. Click the **+** button or **Create Virtual Device**. <p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/16a70a25-6678-42b6-a0b3-9b0506bb5394" width="40%" height="40%"></p>
3. The **Select Hardware** window should pop up with a list of pre-configured hardware device definitions. Choose any device definition, such as **Medium Phone**, and click **Next**. <p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/36e8d3a4-b850-43bf-82ba-58a390441afe" width="60%" height="60%"></p>
4. Now, you may select a **System Image**. From the **Recommended** tab, choose the latest release.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/d23968c4-2b27-4b36-8a35-3f63fa2ad70d" width= "60%" height="60%"></p>

> [!IMPORTANT]
> If the **Download** symbol is next to the latest release, it has not been installed yet. So, click the link to start the download, and click **Next** when it's done.

<br>

5. In the next dialog box, verify the configuration and select **Finish**.
6. The AVD manager should now display the virtual device just you added.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/32ab2a70-5ae4-4038-bf13-eecaa2ef5d2c" width="40%" height="40%"></p>

<br>

## :arrow_forward: Run Your App
Congratulations! You've just configured your first Android project! Now, let's try running your app on your new emulator.

1. Select **Run** > **Run 'app'** (or the **Run** icon in the toolbar).
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/0f1a61cb-7699-4c76-942b-948dfae9812e" width="70%" height="80%"></p>

2. If you would like to change the virtual device you would like to run on, select **Run** > **Select Device** (or use the dropdown next to the **Run** icon in the 
toolbar).
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/73f12395-d1a3-473d-b6b3-3dc9910090c6" width="30%" height="30%"></p>

> [!NOTE]
> This may take some time depending on the speed of your computer, but you may look at the horizaontal status bar at the very bottom of the window to see progress messages such as:
> - _Gradle Build Running_
> - _Waiting for target device to come on line_
> - _Installing APK_
> -  _Launching activity_

<br>

3. Once your app builds and the emulator is ready, Android Studio uploads the app to the emulator and runs it.You should see a window mimicking the screen of your configured device as shown below:
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/2c296a04-ba70-47bf-88b9-d769443c7b4b" width="40%" height="40%"></p>


You've now configured and run your first Android app - now let's personalize it! Click [**here**](xml.md) for **next steps** or alternatively, navigate to the `xml.md` file in this repository, where you
will start designing your application.
