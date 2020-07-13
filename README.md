# SuperExtensions

![Android CI](https://github.com/mhtmalpani/superextensions/workflows/Android%20CI/badge.svg)

## Download:

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Step 2. Add the dependency

```gradle
dependencies {
    implementation 'com.github.mhtmalpani:superextensions:0.2.0'
}
```


---



<br/>



# Docs:

---


## SharedPreferences


`.execute {}`

Run a series of shared preferences methods asynchronously

Usage:
```kotlin
sharedPreferences.execute {
    putString(KEY, VALUE)
}
```

```kotlin
sharedPreferences.execute(commit = true) {
    putString(KEY, VALUE)
}
```

---

`.executeSynchronous {}`

Run a series of shared preferences methods synchronously

Usage:
```kotlin
val commit = sharedPreferences.executeSynchronous {
    putString(KEY, VALUE)
}
```
@return commit value of the execution by SharedPreferences


<br/>



## Lifecycle

`observe()`

Make a observable in a Lifecycle owner that will listen to changes in a live data

Usage:

Inside Activity:
```kotlin
observe(viewModel.someLiveData) {
	//Custom Logic to handle the live data
}
```

OR

```kotlin
observe(viewModel.someLiveData, ::onLiveDataChanged)
--
private fun onLiveDataChanged(data: String) {
   //Custom Logic to handle the live data
   //Updated content is the value passed in the variable [data]
}
```


<br/>


## Boolean

`.orFalse()`

@return false when the boolean is null, else the value of the boolean is returned

Usage:
```kotlin
val isLoggedIn: Boolean? = null
isLoggedIn.orFalse()
```
The above returns false

---

`.orTrue()`

@return true when the boolean is null, else the value of the boolean is returned

Usage:
```kotlin
val isLoggedIn: Boolean? = null
isLoggedIn.orTrue()
```
The above returns true

---

`.flip()`

@return false when the boolean is true
@return true when boolean is false

Usage:
```kotlin
val isLoggedIn: Boolean = true
isLoggedIn.flip()
```
The above returns false


<br/>



## Number

`.orZero()`

@return 0 when the Integer is null, else the value of the Integer is returned

Usage:

```kotlin
val data: Int? = null
data.orZero()
```
The above will return 0

The above extension will work for:
1. Int
2. Float
3. Long
4. Double


<br/>



## String

`String.hash256()`

Generates a Hash 256 of a String

Usage:
```kotlin
data.hash256()
```


<br/>



## Activity

`intentOf<>`

Create an intent of the Activity in demand from the invoked Context

```kotlin
context.intentOf<LoginActivity>()
```

We can pass custom parameters within the intent.

```kotlin
context.intentOf<LoginActivity>(
	HEADER to "header"
)
```

We can pass custom bundle within the intent.

```kotlin
context.intentOf<LoginActivity>(
	Bundle()
)
```

---

`Activity.intentExtra()`

Gets the relevant intent extra parameter into a variable lazily

Usage:

```kotlin
private val username: String by intentExtra<String>(USERNAME)
```


---

`Activity.extra()`

`extra` would get the extra at runtime when accessing the data.

Usage:
```kotlin
private val id by extra<String>(EXTRA_ID_KEY, "some_default_value")
```


---

`Activity.extraNotNull()`

`extraNotNull` behaves like `extra`, but would crash at runtime if the value was null

Usage:

```kotlin
private val id by extraNotNull<String>(EXTRA_ID_KEY)
```


---

`Activity.bindStringArgument()`

Binds a String Argument

Usage:

```kotlin
private val data by bindStringArgument(DATA)
```


---

`Activity.bindStringArgument()`

Binds a String Argument

Usage:

```kotlin
private val data by bindStringArgument(DATA)
```


---

`Activity.bindIntArgument()`

Binds a Int Argument

Usage:

```kotlin
private val data by bindIntArgument(DATA)
```


---

`Activity.bindLongArgument()`

Binds a Long Argument

Usage:

```kotlin
private val data by bindLongArgument(DATA)
```


---

`Activity.bindFloatArgument()`

Binds a Float Argument

Usage:

```kotlin
private val data by bindFloatArgument(DATA)
```


---

`Activity.bindDoubleArgument()`

Binds a Double Argument

Usage:

```kotlin
private val data by bindDoubleArgument(DATA)
```


---

`Activity.bindBooleanArgument()`

Binds a Boolean Argument

Usage:

```kotlin
private val data by bindBooleanArgument(DATA)
```


---

`Activity.bindCharArgument()`

Binds a Char Argument

Usage:

```kotlin
private val data by bindCharArgument(DATA)
```


---

`Activity.bindParcelableArgument()`

Binds a Parcelable Argument

Usage:

```kotlin
private val data by bindParcelableArgument(DATA)
```


---

`Activity.bindSerializableArgument()`

Binds a Serializable Argument

Usage:

```kotlin
private val data by bindSerializableArgument(DATA)
```


---

`fragmentTransaction {}`

Creates a fragment transaction smoothly

Usage:

```kotlin
fragmentTransaction {
	replace(R.id.fragment_container, YourFragment(), YourFragment.TAG)
}
```


<br/>



## Fragment

`instanceOf`

Create a new instance of a Fragment smoothly.
This should be generally used as a new instance creation from within the fragment.

Prefer to use a companion object and invoke this:

Usage:

```kotlin
companion object {
	fun getIntent(): MyFragment = instanceOf<MyFragment>()
}
```

We can add custom data as arguments as a Pair.

Usage:

```kotlin
companion object {
	private const val USERNAME = "username"
	private const val AGE = "age"

	fun getIntent(username: String, age: Int): MyFragment = instanceOf<MyFragment>(
		USERNAME to username,
		AGE to age
	)
}
```


---

`bindArgument`

A simple Delegate to bind an argument passed to a Fragment

@param key: The name of the argument passed

Usage:

```kotlin
private val username by bindArgument<String>(USERNAME)
```

---

`bindSerializableArgument`

A simple Delegate to bind a Serializable argument passed to a Fragment

@param key: The name of the argument passed

Usage:
```kotlin
private val username by bindSerializableArgument<String>(USERNAME)
```
---

`bindParcelableArgument`

A simple Delegate to bind a Parcelable argument passed to a Fragment

@param key: The name of the argument passed

Usage:
```kotlin
private val userdata by bindParcelableArgument<String>(USERDATA)
```


---

`transaction`

Creates a fragment transaction smoothly.
This can be used from within a Fragment Manager

Usage:
```kotlin
supportFragmentManager.transaction {
	replace(R.id.fragment_container, YourFragment(), YourFragment.TAG)
}
```

---

`fragmentTransaction`

Creates a fragment transaction smoothly.
This can be used from within an Activity of Fragment

Usage:
```kotlin
fragmentTransaction {
	replace(R.id.fragment_container, YourFragment(), YourFragment.TAG)
}
```


<br/>



##RecyclerView

`setScrollListener`


Sets scroll listener to a recycler view

Usage:
```kotlin
your_recycler_view.setScrollListener {
	//Do some operation on scroll
}
```
```kotlin
your_recycler_view.setScrollListener { view ->
	//Do some operation on scroll
}
```
```kotlin
your_recycler_view.setScrollListener { view, dx, dy ->
	//Do some operation on scroll
}
```

---

setOnScrollStateChangeListener

Sets scroll state change listener to a recycler view

Usage:
```kotlin
your_recycler_view.setOnScrollStateChangeListener {
	//Do some operation on scroll state change
}
```
```kotlin
your_recycler_view.setOnScrollStateChangeListener { view ->
	//Do some operation on scroll state change
}
```
```kotlin
your_recycler_view.setOnScrollStateChangeListener { view, newState ->
	//Do some operation on scroll state change
}
```


<br/>



## SearchView

`setOnQueryTextSubmit`

Sets the callback listener when the submit is clicked for a Search View

Usage:
```kotlin
your_search_view.setOnQueryTextSubmit { query ->
	//Your custom logic to handle the query
}
```


---


`setOnQueryTextChange`

Sets the callback listener when the text changes for a Search View

Usage:
```kotlin
your_search_view.setOnQueryTextChange { newText ->
	//Your custom logic to handle the new text
}
```


<br/>



## TextView

`setTextResource`

Sets a text resource to a view

Usage:
```kotlin
username.setTextResource(R.string.name)
```


<br/>


## View


`bindView`

This can be used under various context:
1. Activity
2. Fragment
3. View

Binds a view with @param id to variable
This can be used within Activity Scope

@param id the XML id that needs to be bound

Usage:
```kotlin
private val profileImage by bindView<ImageView>(R.id.profile_image)
```
```kotlin
private val profileImage: ImageView by bindView(R.id.profile_image)
```
```kotlin
private val profileImage: ImageView by bindView(profile_image)
```

From a view:
```kotlin
root_view.bindView<TextView>(R.id.username)
```


---

`toggleVisibility`

Toggles the visibility of a view
Change from Visible to Invisible and vice versa

Usage:
```kotlin
submit_button.toggleVisibility()
```


<br/>



## ViewGroup

`iterateChildren`

Iterate through each child of a ViewGroup and runs a lambda on them

Usage:
```kotlin
root_view.iterateChildren { index, child ->
	//Your custom logic
}
```


<br/>


## ViewModel

`get`

Gets a view model for a defined type

Usage:
```kotlin
ViewModelProviders.of(activity, MyViewModelFactory()).get()
```


<br/>


## EditText

`afterTextChanged`

Sets a listener to Edit Text after a text has changed

Usage:
```kotlin
usernameEditText.afterTextChanged { data ->
	//Your custom logic to do after text changed
}
```


---


`onTextChanged`

Sets a listener to Edit Text on text change

Usage:
```kotlin
usernameEditText.onTextChanged { charSequence, start, before, end ->
	//Your custom logic to do on text changed
}
```

---

`beforeTextChanged`

Sets a listener to Edit Text before text changes

Usage:
```kotlin
usernameEditText.beforeTextChanged { charSequence, start, before, end ->
	//Your custom logic to do afbeforeter text changed
}
```


<br/>


## String

`encodeToUTF8`

Encodes a given string to UTF-8

Usage:
```kotlin
val url = "https://www.example.com?ref=www.github.com&hash=123456789"
println(url.encodedToUTF8)
```

The above will print:
https%3A%2F%2Fwww.example.com%3Fref%3Dwww.github.com%26hash%3D123456789



---


`sha1`

Generates a Hash SHA-1 of a String

Usage:
```kotlin
val text = "Hello"
println(text.sha1())
```
This will print:
f7ff9e8b7bb2e09b70935a5d785e0cc5d9d0abf0


---

`sha256`

Generates a Hash SHA-256 of a String

Usage:
```kotlin
val text = "Hello"
println(text.sha1())
```
This will print:
185f8db32271fe25f561a6fc938b2e264306ec304eda518007d1764826381969


---


`sha512`

Generates a Hash SHA-512 of a String

Usage:
```kotlin
val text = "Hello"
println(text.sha1())
```
This will print:
3615f80c9d293ed7402687f94b22d58e529b8cc7916f8fac7fddf7fbd5af4cf777d3d795a7a00a16bf7e7f3fb9561ee9baae480da9fe7a18769e71886b03f315


---


`convertToTitleCase`

Convert a given string to TitleCase

Usage:
```kotlin
val sentence = "This is an example sentence for string title case"
println(sentence.convertToTitleCase())
```
This will print:
"This Is An Example Sentence For String Title Case"


We can add an exclude list to eliminate the words we do not want to capitalise

```kotlin
val sentence = "This is an example sentence for string title case"
println(sentence.convertToTitleCase(listOf("for", "is", "an")))
```
This will print:
"This is an Example Sentence for String Title Case"


<br/>


## Asset Helper

`assetToJsonObject`

Can be called from:
1. Activity
2. Fragment
3. Any other Context

Converts a file to a Json object of given type
@param filePath the path of the file under the assets directory
@param clazz the Model that it needs to be converted to

Usage:
```kotlin
val fileAsObject: LibraryModel = assetToJsonObject("sample.json", LibraryModel::class.java)
```


---


`readAssetAsString`

Converts an asset file to a String

@param filePath the path of the file under the assets directory

```kotlin
val fileAsObject: String = readAssetAsString("sample.json")
```


<br/>


## Toast

Can be called from:
1. Activity
2. Fragment
3. Any other Context


Usage:
```kotlin
toast("Upload Success")
```
```kotlin
toast(R.string.upload_success)
```
```kotlin
toast("Success", Toast.LENGTH_LONG)
```


<br/>


## Vibrate

`vibrate`

Can be called from:
1. Activity
2. Fragment
3. Any other Context

Creates a vibration

Default amplitude is DEFAULT_AMPLITUDE
Default duration is 100ms

Usage:

```kotlin
vibrate()
```

```kotlin
vibrate(milliseconds = 500)
```
