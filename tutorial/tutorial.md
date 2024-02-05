# Android Studio 101: Java

## Introduction

In this tutorial, you'll learn how to build and run your first app in Android Studio using the programming language Java.

#### *Objectives*:
* Familiarize an individual with the basics of the Android Studio SDK
* Develop a simple application that contains with the following features:
  - Multiple pages
  - Buttons
  - Notifications
  - Text

_Let's get started!_

## Installation

To install, download [Android Studio](https://developer.android.com/studio)
for your machine. 
1. From this [page](https://developer.android.com/studio), click on the 
***Download Android Studio button***. ![Screenshot of download button to click on](img.png)

2. Click on the "I have read and agree with the above terms and conditions" 
checkbox followed by the download button. ![Screenshot of checkbox for agreement](https://github.com/Abstract-2912/CS-2340-Assignment-1/blob/tutorials/tutorial/Screenshot%202024-02-04%20125219.png)

3. Open and run the downloaded file. It will prompt the following<sup>1</sup> dialog that
is the setup wizard. Click on next and follow the prompts from the setup wizard 
until you reach the **Finish**<sup>2</sup> button. 
![Screenshot of Android Studio setup wizard](img_3.png)
![img_2.png](img_2.png)

>[!NOTE]
> It is [recommended](https://developer.android.com/studio/install.html) 
> that your system is equipped with 16GB of RAM and 16GB of storage to run the 
> android emulators and develop an application. However, the emulator can be 
> skipped and a physical device may be used. For more information, click 
> [here](https://developer.android.com/studio/run/device).

_You are ready to create your first project!_

## Project Setup
Once Android Studio is installed, open it and:
1. Create a new project by clicking the **_New Project_**
button and select the **_Basic Views Activity_** or **_Empty Views Activity_**. 
![img_4.png](img_4.png)
2. After doing this, give your project a name, such as 'MyFirstApp' or 'TestApp' and select the 
language to be Java instead of Kotlin. ![img_5.png](img_5.png)
3. Select the **Minimum SDK** to be 'API 32 ("SV2"; Android 12L)'
or similar or higher to mitigate compatibility issues. ![img_6.png](img_6.png)
4. Select the **Build Configuration
Language** to be 'Kotlin DSL (build.gradle.kts)'. ![img_7.png](img_7.png)
5. Hit **Finish**.
![img_8.png](img_8.png)

_Congratulations!_ You've just completed the setup for your first Android application!
Now, a default app is created with default files. ![img_9.png](img_9.png)
Click [**here**](gradle.md)
for **next steps** or alternatively, navigate to the `gradle.md` file in this repository.
