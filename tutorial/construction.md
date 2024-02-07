## Constructing Buttons
First of all, what is a _Button_? In general, it is a widget that performs an event on button click. Let's find out how to construct them!
> For more information on Buttons, click [**here**](information.md) or alternatively, navigate to the `information.md` file in this repository.

### Step 1: Adding a Button
To learn how to use constraints to connect the positions of views to each other, you will add buttons to the layout.
1. From the **_Palette_** panel from the _Layout Editor_, click on the **Common** category.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/07c349e7-900e-4166-ac6e-b1bf06a3c2e8" width="30%" height="30%"></p>

2. Select **Button**, which is near the top, and drag and drop it onto the design view, placing it above the `TextView` and near the **Next** button.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/801384e5-f75b-4df2-a538-6c8e31bdae5d" width="30%" height="30%"></p>

> Notice that a **Button** has been added to the **_Component Tree_** under `ConstraintLayout`.

<br>

### Step 2: Constraining the Button
You will now constrain the right side of the button to the left side of the **Next** button.
1. Move the cursor over the circle at the right of the `Button`.
2. Click and drag the circle at the right of the `Button` onto the circle at the left of the **Next** button. The `Button` should now move down to sit just next to the **Next** button because the side of the button is now _constrained_ to the side of the **Next** button.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/95b502d8-9e50-46eb-996d-ce1e6f718519" width="30%" height="30%"></p>

3. Take a look at the **Constraint Widget** in the **Layout** pane of the **_Attributes_** panel. It shows some constraints for the `Button`, including **End -> StartOf button_first**.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/a38702ab-1f7c-4f60-9518-5ff36f1814a8" width="30%" height="30%"></p>

4. You may see a warning, "**Not Vertically Constrained**". To fix this, add a constraint from the top of the `Button` to the top of the screen. Also add a constraint to constrain the left of the `Button` to the left of the screen.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/185a6c9c-1846-45e3-b13c-f1c8b560e65a" width="30%" height="30%"></p>

5. Before adding another button, relabel this button so things are a little clearer about which button is which. Click on the `Button` in the **Design Layout**.
6. Look at the **_Attributes_** panel on the right, and notice the **id** field.
7. Change the **id** from `button` to `toast_button`.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/d53297e9-15f8-477c-9b41-4e2f80d4103d" width="30%" height="30%"></p>

<br>

### Step 3: Deleting Constraints
#### Single Constraint
You may do any of the following:
- In the design view or blueprint view, hold the `Ctrl` key (`Command` on a Mac) and move the cursor over the circle for the constraint until the circle highlights, then click the circle.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/69aa69ca-9f49-4a6f-bb7f-878844ff8886" width="30%" height="30%"></p>

- OR click on one of the constrained views, then right-click on the constraint and select **Delete** from the menu.
- OR in the **_Attributes_** panel, move the cursor over the circle for the constraint until it shows an x, then click it.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/e74b1d21-224f-44f0-bf91-72156cbf56ed" width="30%" height="30%"></p>

> If you delete a constraint and want it back, either undo the action, or create a new constraint.

#### Chain Constraints
You will adjust the button labeled **Next**, which Android Studio created for you when you created the project. The constraint between it and the `TextView` looks a little different, a wavy line instead of a jagged one, with no arrow. This indicates a _chain_, where the constraints link two or more objects to each other, instead of just one to another. For now, you'll delete the chained constraints and replace them with regular constraints
1. Click on the **Next** button, and then delete the constraint from the top of the button to the `TextView`.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/41de064d-c313-4104-9940-ea6c02d0f15b" width="30%" height="30%"></p>

2. Click on the `TextView`, and then delete the constraint from the bottom of the text to the **Next** button.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/ed0dc2b1-c23b-424e-ab43-9761e02133be" width="30%" height="30%"></p>

<br>

### Step 4: Extracting String Resources
1. In the `fragment_first.xml` layout file, find the text property for the `toast_button` button. 
```angular2html
<Button 
        android:id="@+id/toast_button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Button"
```
Notice that the text "_Button_" is directly in the layout field, instead of referencing a string resource as the `TextView` does. This will make it harder to translate your app to other languages.

2. To fix this, click the highlighted code. A light bulb appears on the left.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/37d21c90-469c-4e4e-b9e2-b008018b6773" width="50%" height="50%"></p>

3. Click the lightbulb. In the menu that pops up, select **Extract string resource**.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/c9784477-23e6-4941-a4c2-ffe874711fb2" width="50%" height="50%"></p>

4. In the dialog box that appears, change the resource name to `toast_button_text` and the resource value to **Toast** and click **OK**.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/2799773d-ed47-46c6-a724-126e472d9b80" width="30%" height="30%"></p>

Notice that the value of the `android:text` property has changed to `@string/toast_button_text`.
```angular2html
android:text="@string/toast_button_text"
```
5. Go to the **res** > **values** > **strings.xml** file. Notice that a new string resource has been added, named `toast_button_text`.
```angular2html
<string name="toast_button_text">Toast</string>
```
6. Run the app to make sure it displays as you expect it to.

<br>

### Step 5: Update the Next Button
The **Next** button already has its text in a string resource, but you'll make some changes to the button to match its new role, which will be to generate and display a random number.
1. As you did for the **Toast** button, change the **id** of the **Next** button from `button_first` to `random_button` in the **_Attributes_** panel. (If you get a dialog box asking to update all usages of the button, click **Refactor**. This will fix any other references to the button in the project code.)
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/a058568a-4cbb-494b-88a2-fbf2e4466a69" width="30%" height="30%"></p>

2. In `strings.xml`, right-click on the `next` string resource.
3. Select **Refactor** > **Rename...**. 
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/27c226cc-a313-40f8-9263-e726e531a3b2" width="30%" height="30%"></p>

4. Change the name to `random_button_text`. Click **Refactor** to rename your string and close the dialog.
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/1236f44a-b4eb-4769-88bd-31fa7d6263ae" width="30%" height="30%"></p>

5. Change the value of the string from **Next** to **Random**. (If you want, move `random_button_text` to below `toast_button_text`)

<details><summary>Additional Practice: Adding a Third button</summary>

1. In `fragment_first.xml`, add another button to the layout, and drop it somewhere between the **Toast** button and the **Random** button, above the `TextView`.
2. Add vertical constraints the same as the other two buttons. Constrain the bottom of the third button to the top of TextView; constrain the top of the third button to the top of the screen.
3. Add horizontal constraints from the third button to the other buttons. Constrain the left side of the third button to the right side of the **Toast** button; constrain the right side of the third button to the left side of the **Random** button.
4. Refactor the **id**, text, and value to `count_button`, `count_button_text` and **Count** respectively.

**Final Result**
<p align="center"><img src="https://github.com/Abstract-2912/CS-2340-Assignment-1/assets/156847930/828ea19f-ef35-4823-9dcd-05e11b0f6ccf" width="30%" height="30%"></p>

</details>

> [!NOTE]
> #### Bias Constraints
> Examine the XML code for `fragment_first.xml`. Do any of the buttons have the attribute `app:layout_constraintVertical_bias`?
> <br>
> These "bias" constraints allows you to tweak the position of a view to be more on one side than the other when both sides are constrained in opposite directions. For example, if both the top and bottom sides of a view are constrained to the top and bottom of the screen, you can use a vertical bias to place the view more towards the top than the bottom.

<br>

### Step 6: Prepare UI for Next Task
The next task is to make the buttons do something when they are pressed. First, you need to get the UI ready.
1. Change the text of the TextView to show the number **0** by going to `strings.xml`, finding `<string name="lorem_ipsum">`, and changing `Hello World!`.
2. _(Skip this step if done before)_ Change the **id** of the last button you added, `button`, to `count_button` in the **_Attributes_** panel.
3. _(Skip this step if done before)_ In the XML, extract the string resource to `count_button_text` and set the value to **Count**.

The buttons should now have the following text and ids:

| Button        | text   |           id            |
|---------------|--------|:-----------------------:|
| Left button   | Toast  |    @+id/toast_button    |
| Middle button | Count  |    @+id/count_button    |
| Right button  | Random |   @+id/random_button    |


> [!WARNING]
> If you edited the XML for the layout directly, you might see some errors. The errors occur because the buttons have changed their `id` and now these constraints are referencing non-existent views. 
> If you have these errors, fix them by updating the `id` of the buttons in the constraints that are underlined in red.

<br>

_Congratulations_! You have constructed interactive elements for you application. Click [**here**](actions.md) for **next steps** or alternatively, navigate to the `actions.md` file in this repository, where you will start add functionality to your application.
 
