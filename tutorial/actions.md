## :twisted_rightwards_arrows: Interactivity
You have added buttons to your app's main screen, but currently the buttons do nothing. So, let's make your buttons respond when the user presses them.


### _Step 1: Enable Auto Imports_
To make your life easier, you can enable auto-imports so that Android Studio automatically imports any classes that are needed by the Java code.

1. In Android Studio, open the settings editor by going to **File** > **Settings** > **Editor** > **General**.
2. Select **Auto Imports**. In the **Java** section, make sure **Add unambiguous imports on the fly** is checked and then close the settings editor by pressing **OK**.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/5857f2e5-bd76-443a-8707-62dcb49fd34a" width="60%" height="60%"></p>

<br>

### _Step 2: Show a 'Toast'_
Now, you will attach a Java method to the Toast button to show a _toast_ when the user presses the button. A _toast_ is a short message that appears briefly at the bottom of the screen.

1. Open FirstFragment.java (**app** > **java** > **com** > **example** > **myfirstapp** > **FirstFragment**). 
        
   - This class has only three methods {`onCreateView()`, `onViewCreated()`, and `onDestroyView()`} which execute when the fragment starts. The `onViewCreated()` method sets up a click listener for the `toastButton`.

```angular2html
public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.toastButton.setOnClickListener(new View.OnClickListener() {
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
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/c8643ce6-7589-4276-933b-c1973455895f" width="30%" height="30%"></p>

> [!IMPORTANT]
> To make a view interactive, you need to set up a click listener for the view which says what to do when the view (button) is clicked on. The click listener can either:
> - Implement a small amount of code directly. 
> - Call a method that defines the desired click behavior in the activity.

<br>


### _Step 3: Add Behavior_
The method that shows the toast is very simple; it does not interact with any other views in the layout. In the next step, you add behavior to your layout to find and update other views.
**Goal**: Update the **Count** button so that when it is pressed, the number on the screen increases by 1.
1. In the `fragment_first.xml` layout file, notice the **id** for the `TextView`:
```angular2html
<TextView
   android:id="@+id/textview_first"
```
<br>

2. In `FirstFragment.java`, add a click listener for the `count_button` below the other click listeners in `onViewCreated()`. Because it has a little more work to do, have it call a new method, `countMe()`.
```angular2html
binding.countButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countMe(view);
            }
        });
```
<br>

3. In the `FirstFragment` class, add the method `countMe()` that takes a single **View** argument. This method will be invoked when the **Count** button is clicked and the click listener called. It is within this method that you will add the code in the following steps.
```angular2html
private void countMe(View view) {
  
}
```
<br>

4. Get the value of the `showCountTextView`. You will define that in the next step.
```angular2html
// Get the value of the text view
    String countString = showCountTextView.getText().toString();
```
<br>

5. Convert the value to a number, and increment it.
```angular2html
// Convert value to a number and increment it
Integer count = Integer.parseInt(countString);
count++;
```
<br>

6. Display the new value in the `TextView` by programmatically setting the **text** property of the `TextView`.
```angular2html
// Display the new value in the text view.
   showCountTextView.setText(count.toString());
```

**Final Code**:
```angular2html
private void countMe(View view) {
        // Get the value of the text view
        String countString = showCountTextView.getText().toString();
        // Convert value to a number and increment it
        Integer count = Integer.parseInt(countString);
        count++;
        // Display the new value in the text view.
        showCountTextView.setText(count.toString());
    }
```

<br>

### _Step 4: Cache for Repeated Use_
1. In the `FirstFragment` class before any methods, add a member variable for `showCountTextView` of type `TextView`.
```angular2html
TextView showCountTextView;
```
<br>

2. In `onCreateView()`, you will get the `TextView` that shows the count. To find where to search for the requested value to find (`textviewFirst`), use the `binding` variable that is assigned the layout view and cache that value in `showCountTextView`.
```angular2html
showCountTextView = binding.textviewFirst;
```

**Final Result**:
```angular2html
public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

      binding = FragmentFirstBinding.inflate(inflater, container, false);
      showCountTextView = binding.textviewFirst;
      return binding.getRoot();

    }
```

3. Run your app and press the **Count** update to confirm functionality.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/c78bfb82-a89a-4749-9574-05535f4df732" width="30%" height="30%"></p>

<br>

### _**Congratulations**!_ You're done with the tutorial :ghost: :tada:!



