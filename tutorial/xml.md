## Explore
Generally, each screen in your Android app is associated with one or more _fragments_, or sub-activity that represents a reusable portion of your app's UI. A fragment defines and manages its own layout, has its own lifecycle, and can handle its own input events, BUT they can't live on their own. They must be hosted by, or embedded in, an activity or another fragment. The fragment’s view hierarchy becomes part of, or attaches to, the host’s view hierarchy. 

<details> <summary> More Information on Fragment Lifecycle</summary>

The lifecycle of android fragment is like the activity lifecycle. There are 12 lifecycle methods for fragment:

<p align="center"> <img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/0b740d85-ab4b-4d12-b004-33b2ec4058a7" width="50%" height="90%"></p>

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


</details>

Each fragment also has a layout that defines its user interface. Android Studio has a layout editor 
where you can create and define layouts. To navigate to this layout editor, open the **layout** folder
(**app** > **res** > **layout**) in the **Project** panel. Then, click on `fragment_first.xml`.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/0c5cdca2-4360-4f4c-a485-86b62f781fc3" width="30% "height="30%"></p>

Congratulations! You've designed the user interface your first application!
Click [**here**](actions.md)
for **next steps** or alternatively, navigate to the `actions.md` file in this repository, where you
will start add functionality to your application.
