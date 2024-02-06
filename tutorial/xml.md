## :mag: Explore
Generally, each screen in your Android app is associated with one or more _fragments_, or sub-activity that represents a reusable portion of your app's UI. A fragment defines and manages its own layout, has its own lifecycle, and can handle its own input events, BUT they can't live on their own. They must be hosted by, or embedded in, an activity or another fragment. The fragment’s view hierarchy becomes part of, or attaches to, the host’s view hierarchy. 

<details> <summary> More Information on Fragment Lifecycle</summary>
<p></p>
The lifecycle of a fragment is like the activity lifecycle. There are 12 lifecycle methods for fragments:

|                     Method                      | Description                                                                                                |
|:-----------------------------------------------:|:-----------------------------------------------------------------------------------------------------------|
|               onAttach(Activity)                | Called only once when it is attached with activity.                                                        |
|                onCreate(Bundle)                 | Initializes the fragment.                                                                                  |
| onCreateView(LayoutInflater, ViewGroup, Bundle) | Creates and returns view hierarchy.                                                                        |
|            onActivityCreated(Bundle)            | It is invoked after the completion of onCreate() method.                                                   |
|           onViewStateRestored(Bundle)           | Provides information to the fragment that all the saved state of fragment view hierarchy has been restored |
|                    onStart()                    | Makes the fragment visible.                                                                                |
|                   onResume()                    | Makes the fragment interactive.                                                                            |
|                    onPause()                    | Called when fragment is no longer interactive.                                                             |
|                    onStop()                     | Called when fragment is no longer visible.                                                                 |
|                 onDestroyView()                 | Allows the fragment to clean up resources.                                                                 |
|                   onDestroy()                   | Allows the fragment to do final clean up of fragment state.                                                |
|                   onDetach()                    | Called immediately prior to the fragment no longer being associated with its activity.                     |
<p align="center"> <img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/0b740d85-ab4b-4d12-b004-33b2ec4058a7" width="30%" height="70%"></p>

</details>

Each fragment also has a layout that defines its user interface. Android Studio has a layout editor where you can create and define layouts. To navigate to this layout editor, open the **layout** folder (**app** > **res** > **layout**) in the **Project** panel. Then, click on `fragment_first.xml`.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/0c5cdca2-4360-4f4c-a485-86b62f781fc3" width="30% "height="30%"></p>

The panels to the right of the **Project** panel make up the _Layout Editor_.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/3783019c-b037-40aa-9752-1340da9b141c" width="60%" height="60%">

1) The **_Palette_** has views you can add to your app
2) The **_Component Tree_** shows the views currently in this file, and how they are arranged in relation to each other.
3) The **_Design Editor_** shows a visual representation of what the contents of the file will look like when compiled 
into an Android app. You can view the visual representation, the XML code, or both.
4) The **_Attributes_** panel has three buttons representing the **Code** (code only), **Split** (both code and design),
and **Design** (design only) views. It is currently set on the **Design** view.

<br>

### Design Editor
Depending on your screen size and work style, you may prefer a specific setup that is easier for you to look at.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/22b25739-6751-49e1-902f-55f3f3e8b6fd" width="50%" height="50%"></p>

1.  At the lower right of the **_Design Editor_** you may use the **+** and **-** buttons to adjust the size of what you see, or click the **zoom-to-fit** button so that both panels fit on your screen.
2. The **Design Layout** on the left shows how your app appears on the device. The **Blueprint Layout**, shown on the right, is a schematic view of the layout.
3. Use the **orientation** icon (below) to change the orientation of the layout. This allows you to test how your layout will fit portrait and landscape modes.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/20c8db08-1ebe-4d0c-891a-48134f440339" width="20%" height="20%"></p>

4. Use the **device menu** to view the layout on different devices.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/45498d67-7265-4832-97ff-8bd66baf71e7" width="30%" height="30%"></p>

<br>

### Component Tree
This panel shows the view hierarchy in your layout, that is, how the views are arranged in relation to each other. Every layout must have a _root view_ that contains all the other views. The root view is always a _view group_, which is a view that contains other views. Notice that the root of the view hierarchy is a `ConstraintLayout` view.

<figure>
  <p align="center">
  <img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/c16a702f-5cd6-4aaf-8da6-ece435e3edbf" width="20%" height="10%">  
  <figcaption align="center"> Notice that the ConstraintLayout contains a TextView, called textview_first and a Button, called button_first. </figcaption>
  </p>
</figure>

<br>

## :pencil: Editing
Now that each part has been briefly introduced, let's learn how to edit it to achieve the desired layout.

### Properties

In the `.xml` file, we can change property values, text display properties, and more! 
Use the dropdowns below &darr; to see examples of two attributes you can edit.

<details> <summary> Property Values </summary>

1. Take a look at the `<TextView>` element in the code editor.
```angular2html
<TextView
    android:id="@+id/textview_first"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_marginTop="16dp"
    android:text="@string/lorem_ipsum"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toBottomOf="@id/button_first" />
```
2. Hover over the string in the **text** property. It will refer to an (absurdly long) string resource, `lorem_ipsum`.
Right-click on the property and click **Go To** > **Declaration and Usages**.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/9f19710a-914b-4dd4-aa5f-ebe17594d833" width="50%" height="50%"></p>

3. The `strings.xml` should open from the **res** > **values** directory with the full string highlighted.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/1ccb77c7-97dd-4eb8-b138-33b68ef324a9" width="50%" height="50%"></p>

4. Change the value of the **string** property to `Hello World!`.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/1d8368a7-927d-4c5e-8a6c-3c939e6a4d86" width="20%" height="20%"></p>

5. Run the app to see the text changes you have made in `string.xml`. It should now show "Hello World!"

6. Navigate back to the `fragment_first.xml` file and select `textview_first` in the **_Component Tree_** panel. Look at **_Attributes_** panel on the right and open the **Declared Attributes** section. In the **text** field, notice it still refers to the original string resource `@string/lorem_ipsum`.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/58f6b537-976d-4ef6-a533-e865b21b4208" width="40%" height="40%"></p>

</details>

> [!TIP]
> Having the strings in a resource file has several advantages. You can change the value of string without having to change any other code. This simplifies translating your app to other languages, because your translators don't have to know anything about the app code.

<details><summary> Text Display Properties</summary>

1. Navigate to the `fragment_first.xml` file and select `textview_first` from the **_Component Tree_** panel.
Look at the **_Attributes_** panel on the right, open the **Common Attributes** section, and
expand the `textAppearance` field.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/6da4065a-7dd3-4cde-8ccb-92afcf7572f7" width="50%" height="60%"></p>

2. From here, you can change some of the text appearance properties. For example, change the font family, increase the text size, and select bold style.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/aca623bd-cb85-48a9-8e86-965fdfcba683" width="25%" height="25%"></p>

3. To change the text color, click in the `textColor` field, and enter '**g**'. A menu will pop
up with possible completion values containing the letter 'g', including predefined colors.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/fb972d98-60c4-4415-a0fd-dff0cf4e9473" width="30%" height="30%"></p>

4. Select `@color/design_default_color_secondary` and press **Enter**.
5. Run your app to see the changes applied to your "Hello World!" string in the **Design Layout**.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/6848c320-923e-499d-abe3-4f0be8a97767" width="25%" height="25%"></p>

6. In the XML file, look for the `<TextView>` element to see the added new properties.
```angular2html
<TextView
            android:id="@+id/textview_first"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="16dp"
            android:text="@string/lorem_ipsum"
            android:textColor="@color/design_default_color_secondary"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@id/button_first" />
```
</details>

> [!TIP]
> You can also customize your color by clicking on the color block next to the `textColor` field or by 
> editing this property directly in the XML file. For example, in the editor, you can reassign 
> the `textColor` field to the intended value:
> ```
> android:textColor="@color/design_default_color_primary"
> ````

To display all attributes you could set for a component, select the component from
the **_Component Tree_** panel (such as `button_first`). From the **_Attributes_** panel, 
select the last expandable section: **All Attributes**.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/27e29f44-bcbf-4f4b-af92-c4e71d1f081c" width="60%" height="60%"></p>

<br>

### Resources
So far you have learned how to change property values. Next, you will learn how to create more resources like the string resources you worked with earlier. Using resources enables you to use the same values in multiple places, or to define values and have the UI update automatically whenever the value is changed.
#### Adding Color Resources

1. In the **Project** panel on the left, follow the path **res** > **values** > **colors.xml** to open the color resource file. The `colors.xml` file opens in the editor. So far, two colors have been defined, _black_ and _white_, which are the colors you can see in your app layout.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/203a5462-54be-49b5-98e3-393e60f21ed4" width="40%" height="40%"></p>

2. Navigate back to `fragment_first.xml` that has the XML code for the layout. Add a new property to the `<TextView>` called `android:background` and type **@color**. Now, a menu should pop up with predefined color resources.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/71b97f7b-2f9b-4b42-871f-f847911a3c3d" width="50%" height="50%"></p>

3. Choose **@color/black**.

4. Find the property `android:textColor` (which was referred to in the previoius section) and give it the value **@android:color/white**. 
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/1cec2d56-6a79-4fd7-a406-872e7e9dbae2" width="50%" height="50%"></p>

> [!NOTE]
> The Android framework defines a range of colors, including white, so you don't have to define white yourself.

<br>

5. Navigate to the **_Design Editor_**; you can see that the `<TextView>` now has a black background, and the text is displayed in white.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/ca587e0a-5c00-42fd-ad91-843c80c99cf3" width="30%" height="30%"></p>

<br>

#### Adding a Background Color
A _Color_ can be defined as 3 hexadecimal numbers (#00-#FF, or 0-255) representing the red, blue, and green (RGB) components.

1. Back in `colors.xml`, create a new color resource under `<resources>` called `screenBackground` and define it as **#FFEE58**, he color you just added is yellow. Notice that the colors corresponding to the code are displayed in the left margin of the editor. In this case, you just added the color yellow.
```angular2html
<color name="screenBackground">#FFEE58</color>
```
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/15cbfcbb-851d-46f7-bf69-f1ef21aaa683" width="40%" height="40%"></p>

> [!NOTE]
> A color can also be defined including an _alpha value_ (#00-#FF), which is a measure of transparency:  _(#00 = 0% = fully transparent, #FF = 100% = fully opaque)_.
> 
> _Examples_:
> - #88FFEE58 makes the color semi-transparent. 
> - If you use #00FFEE58, it's fully transparent and disappears from the left-hand bar.

<br>

2. Go back to `fragment_first.xml`. In the **_Component Tree_**, select the `ConstraintLayout`.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/4da4f137-379d-4023-8552-af9046b1eeb2" width="40%" height="40%"></p>

3. In the **_Attributes_** panel, go to **All Attributes**, and select the **background** property. Type "**c**" in the appearing field.
   
4. In the menu of colors that appears, select **@color/screenBackground**. Press **Enter** to complete the selection.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/de4a2ed7-7d06-4b08-9b11-9161f79158de" width="40%" height="40%"></p>

5. Click on the yellow patch to the left of the color value in the **background** field. It shows a list of colors defined in `colors.xml`. Click the **Custom** tab to choose a custom color with an interactive color chooser.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/b13a5044-62f0-41a3-9981-c88e95af19a7" width="30%" height="30%"></p>

6. Feel free to change the value of the `screenBackground` color, but make sure that the final color is noticeably different from the `colorPrimary` and `colorPrimaryDark` colors.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/988da9c3-ccef-4917-8b1f-9441567d6dad" width="30%" height="30%"></p>

<br>

_Congratulations_! You've designed the user interface your first application! Click [**here**](actions.md) for **next steps** or alternatively, navigate to the `actions.md` file in this repository, where you will start add functionality to your application.

