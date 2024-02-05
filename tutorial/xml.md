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

Congratulations! You've designed the user interface your first application!
Click [**here**](actions.md)
for **next steps** or alternatively, navigate to the `actions.md` file in this repository, where you
will start add functionality to your application.
