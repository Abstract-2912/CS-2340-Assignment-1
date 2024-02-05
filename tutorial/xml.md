## Explore
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

Each fragment also has a layout that defines its user interface. Android Studio has a layout editor 
where you can create and define layouts. To navigate to this layout editor, open the **layout** folder
(**app** > **res** > **layout**) in the **Project** panel. Then, click on `fragment_first.xml`.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/0c5cdca2-4360-4f4c-a485-86b62f781fc3" width="30% "height="30%"></p>

The panels to the right of the Project view make up the _Layout Editor_.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/3783019c-b037-40aa-9752-1340da9b141c" width="60%" height="60%">

1) The **_Palette_** has views you can add to your app
2) The **_Component Tree_** shows the views currently in this file, and how they are arranged in relation to each other.
3) The **_Design Editor_** shows a visual representation of what the contents of the file will look like when compiled 
into an Android app. You can view the visual representation, the XML code, or both.
4) The **_Attributes_** panel has three buttons representing the **Code** (code only), **Split** (both code and design),
and **Design** (design only) views. It is currently set on the **Design** view.

### Design Editor
Depending on your screen size and work style, you may prefer a specific setup that is
easier for you to look at.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/22b25739-6751-49e1-902f-55f3f3e8b6fd" width="50%" height="50%"></p>

1.  At the lower right of the Design editor you may use the **+** and **-** buttons to 
adjust the size of what you see, or click the **zoom-to-fit** button so that both panels fit on your screen.
2. The Design layout on the left shows how your app appears on the device. 
The Blueprint layout, shown on the right, is a schematic view of the layout.
3. Use the **orientation** icon (below &darr;) to change the orientation of the layout. This allows you to 
test how your layout will fit portrait and landscape modes.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/20c8db08-1ebe-4d0c-891a-48134f440339" width="20%" height="20%"></p>

4. Use the **device menu** to view the layout on different devices.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/45498d67-7265-4832-97ff-8bd66baf71e7" width="30%" height="30%"></p>

### Component Tree
This panel shows the view hierarchy in your layout, that is, how the views are arranged in relation to each other. Every layout must have a _root view_ that contains all the other views. The root view is always a _view group_, which is a view that contains other views. Notice that the root of the view hierarchy is a `ConstraintLayout` view.

<figure>
  <p align="center">
  <img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/c16a702f-5cd6-4aaf-8da6-ece435e3edbf" width="20%" height="10%">  
  <figcaption align="center"> Notice that the ConstraintLayout contains a TextView, called textview_first and a Button, called button_first. </figcaption>
  </p>
</figure>

### Code Editor
In the code editor, we can change property values, text display properties, add color resources and more!

<details> <summary> Changing property values </summary>

1. Take a look at the `Text View` element in the code editor.
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
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/9f19710a-914b-4dd4-aa5f-ebe17594d833" width="60%" height="60%"></p>

3. The `strings.xml` should open from the **res** > **values** directory with the full string highlighted.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/1ccb77c7-97dd-4eb8-b138-33b68ef324a9" width="60%" height="60%"></p>

4. Change the value of the **string** property to `"Hello World!`.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/1d8368a7-927d-4c5e-8a6c-3c939e6a4d86" width="30%" height="30%"></p>

5. Navigate back to the `fragment_first.xml` file and select `textview_first` in the **Component Tree**.
Look at **Attributes** panel on the right and open the **Declared Attributes** section. In the **text** field,
notice it still refers to the original string resource `@string/lorem_ipsum`.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/58f6b537-976d-4ef6-a533-e865b21b4208" width="50%" height="50%"></p>

> [!NOTE]
> Having the strings in a resource file has several advantages. You can change the value of string without having to change any other code. This simplifies translating your app to other languages, because your translators don't have to know anything about the app code.

6. Run the app to see the text changes you have made in `string.xml`. It should now show "Hello World!".

Congratulations! You've designed the user interface your first application!
Click [**here**](actions.md)
for **next steps** or alternatively, navigate to the `actions.md` file in this repository, where you
will start add functionality to your application.
