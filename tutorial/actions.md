## Interactivity
You have added buttons to your app's main screen, but currently the buttons do nothing. So, let's make your buttons respond when the user presses them.

### Step 1: Enable Auto Imports
To make your life easier, you can enable auto-imports so that Android Studio automatically imports any classes that are needed by the Java code.

1. In Android Studio, open the settings editor by going to **File** > **Other Settings** > **Preferences for New Projects**.
2. Select **Auto Imports**. In the **Java** section, make sure **Add Unambiguous Imports on the fly** is checked and then close the settings editor by pressing **OK**.

### Step 2: Show a 'Toast'
Now, you will attach a Java method to the Toast button to show a _toast_ when the user presses the button. A _toast_ is a short message that appears briefly at the bottom of the screen.

1. Open FirstFragment.java (**app** > **java** > **com** > **example** > **myfirstapp** > **FirstFragment**). 
        
   - This class has only three methods {`onCreateView()`, `onViewCreated()`, and `onDestroyView()`} which execute when the fragment starts. The `onViewCreated()` method sets up a click listener for the `button_first` (aka the **Next** button).

```angular2html
public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }
```

<br>

2. Just below that click listener, add code to set up a click listener for the `toast_button`. 
```angular2html
@Override
public void onClick(View view) {
    Toast myToast = Toast.makeText(getActivity(), "Hello toast!", Toast.LENGTH_SHORT);
    myToast.show();
}
```

<br>

3. Run the app and press the **Toast** button. (If you want, you can extract the message string into a resource as done for the button labels.)

> [!IMPORTANT]
> To make a view interactive, you need to set up a click listener for the view which says what to do when the view (button) is clicked on. The click listener can either:
> - Implement a small amount of code directly. 
> - Call a method that defines the desired click behavior in the activity.

<br>

### Step 3: Add Behavior
