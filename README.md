# Foodie 🍔

https://user-images.githubusercontent.com/19487461/155809594-7d1b9211-45c9-439b-88b4-76ea423cfed0.mov

## Yet another Jetpack Compose playground project 

Just like [Macaw](https://github.com/davidmarinangeli/Macaw), Foodie is a Jetpack Compose app built to play with the brand new [Material 3](https://m3.material.io/) libraries and guidelines.

## What does it do? 🤔

The app uses the spectacular [Spoonacular](https://spoonacular.com/food-api) APIs (heh) to fetch some recipes and some food categories with a brand new, adaptive, glamorous, **Material You** dress.

It uses four main modules ( resources, home, network, app ) to split the roles of each part of the app, Compose **1.2.0-alpha04** and Material3 **1.0.0-alpha06**.

## Design

<img src="https://raw.githubusercontent.com/davidmarinangeli/Foodie/master/pawel-czerwinski-ruJm3dBXCqw.jpg" width="300" alignment="center" />

Thanks to the new [Material 3 library](https://developer.android.com/reference/kotlin/androidx/compose/material3/package-summary) ( in alpha right now ) it was possible to create a palette of [Dynamic Colors](https://m3.material.io/styles/color/dynamic-color/overview), that will change the entire app's style basing on the smartphone's wallpaper ( Android 12 and above ).

I also played with the [Material Theme Builder](https://material-foundation.github.io/material-theme-builder/#/dynamic) to easily create and export a default palette, based on a wallpaper of my choice, for devices below Android 12. Check it out! 

Resources for designers: 
[Visualizing dynamic color in your app](https://codelabs.developers.google.com/visualize-dynamic-color#0)
[Material Design 3 Kit](https://www.figma.com/community/file/1035203688168086460)

## Creating Jetpack Compose components 

I used some custom and reusable components such as FoodieSurface and I plan to reuse dimens and shapes in the future, using the LocalComposition tools and other stuff. Read more about building a design system in compose [in this article](https://proandroiddev.com/building-design-system-with-jetpack-compose-1208c250ae75)

    @Composable
    fun FoodieSurface(
      onClick: (() -> Unit)?,
      modifier: Modifier = Modifier,
      content: @Composable () -> Unit,
    ) {
      Surface(
          color = MaterialTheme.colorScheme.surfaceVariant,
          tonalElevation = 8.dp,
          shadowElevation = 8.dp,
          modifier = modifier.clip(RoundedCornerShape(8.dp))
              .let { if (onClick != null) it.clickable(onClick = onClick) else it }
      ) {
          content()
      }
    }
