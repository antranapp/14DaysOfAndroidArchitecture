# Pure Kotlin implementation

## Introduction
In this codelab, you learn about one of the Android Architecture Components, ViewModel:

You use the ViewModel class to store and manage UI-related data in a lifecycle-conscious way. The ViewModel class allows data to survive device-configuration changes such as screen rotations and changes to keyboard availability.
You use the ViewModelFactory class to instantiate and return the ViewModel object that survives configuration changes.

## What you should already know
How to create basic Android apps in Kotlin.
How to use the navigation graph to implement navigation in your app.
How to add code to navigate between your app's destinations and pass data between navigation destinations.
How the activity and fragment lifecycles work.
How to add logging information to an app and read logs using Logcat in Android Studio.

## What you'll learn
How to use the recommended Android app architecture.
How to use the Lifecycle, ViewModel, and ViewModelFactory classes in your app.
How to retain UI data through device-configuration changes.
What the factory method design pattern is and how to use it.
How to create a ViewModel object using the interface ViewModelProvider.Factory.

## What you'll do
Add a ViewModel to the app, to save app's data so the data survives configuration changes.
Use ViewModelFactory and the factory-method design pattern to instantiate a ViewModel object with constructor parameters.
