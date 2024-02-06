## Constructing Buttons
First of all, what is a _Button_? In general, it is a widget that performs an event on button click. Let's find out how to construct them!
> For more information on Buttons, click [**here**](information.md) or alternatively, navigate to the `information.md` file in this repository.

### Step 1: Adding a Button


### Step 2: Constraining the Button

### Step 3: Deleting Constraints

#### Single Constraint
#### Chain Constraints

### Step 4: Extracting String Resources

### Step 5: Update the Next Button
<details><summary>Additional Practice: Adding a Third button</summary>

</details>

> [!NOTE]
> #### Bias Constraints
> Examine the XML code for `fragment_first.xml`. Do any of the buttons have the attribute `app:layout_constraintVertical_bias`?
> <br>
> These "bias" constraints allows you to tweak the position of a view to be more on one side than the other when both sides are constrained in opposite directions. For example, if both the top and bottom sides of a view are constrained to the top and bottom of the screen, you can use a vertical bias to place the view more towards the top than the bottom.

### Step 6: Prepare UI for Next Task

> [!WARNING]
> If you edited the XML for the layout directly, you might see some errors. The errors occur because the buttons have changed their `id` and now these constraints are referencing non-existent views. 
> If you have these errors, fix them by updating the `id` of the buttons in the constraints that are underlined in red.

<br>

## Button Appearance

_Congratulations_! You have constructed interactive elements for you application. Click [**here**](actions.md) for **next steps** or alternatively, navigate to the `actions.md` file in this repository, where you will start add functionality to your application.
 
