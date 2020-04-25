# Learning Android MVVM Architecture in 14 stress free days.

## Introduction:

- Learning Architecture is an important step when learning software development.
- Architectures are hard to learn since there are so many of them. 
- Most of tutorials found in Internet introduce too many concepts at the same time and it is hard to follow for most of beginners.

## What you should already know:

- You should have some basic knowledges of Object-Oriented programming.
- You should have some basic knowledges of Android development.
- You should have installed all required development tools for Android development on your machine.

## What you'll learn:

Hands-on coding:

- Kotlin
    - [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html)
- Android platform:
    - (Navigation component)[https://developer.android.com/guide/navigation]
- Android's Jetpack:
    - [RecyclerView](https://developer.android.com/guide/topics/ui/layout/recyclerview)
- Android's Architecture Components:
    - [ViewB inding](https://developer.android.com/topic/libraries/view-binding)
    - [Handling App Lifecycles](https://developer.android.com/topic/libraries/architecture/lifecycle)
    - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
    - [Paging Library](https://developer.android.com/topic/libraries/architecture/paging)
    - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
    - [Room Persistence Library](https://developer.android.com/topic/libraries/architecture/room)
- Testing

## What you'll do:

We will implement a cat images browsing app with the following features:

- Fetching list of cat images from [TheCatAPI](https://thecatapi.com).
- Displaying the cat image when choosen in a grid layout.
- Using recommended techniques and frameworks from Google to implement the app using MVVM architecture step by step.
- Implementing the app in an incremental process, starting with a pure Kotlin implementation to a full-blown MVVM-based implementation using frameworks in Android's Architecture Components and popular 3rd-party frameworks.


## What's next:

Now you have hopefully learned intuitively how the MVVM Architecture works by implementing a simple app by using different popular frameworks provided by Google and 3rd parties. Depending on your motivation and the level of knowledge, you can follow different paths forward to learn more about Android development.

### A small step: 

Try to apply what you have learnd in another app that uses [the dog api](https://dog.ceo) instead. With this approach, you will have more or less the same structure for you app but you have to deal with a different data model, a different api.

### A medium step: 

There are two options to learn even more:

- Extending the current cat app by implementing additional features such as:
    - user can favourite images, the information of favourite images should be persisted locally in some kinds of database, and there should be an additional screen to show such favourite images

- Implementing a completely different app using public or private APIs to try out different techniqures:
    - Github App using Github API
    - News App using newsapi.org
    - Image browsing apps using Unsplash or Pixabay APIs
    - ....

There are a list of public APIs that you can use to implement your next sample app here [https://github.com/public-apis/public-apis](https://github.com/public-apis/public-apis)

### A gaint step:

Everyone of us has an idea (or multiple ideas) for a killer app (or apps). Go forward and realise your dreams. You will be proud of yourself afterward :)

## Curriculum:

### Day 1: Raw kotlin without any external libraries:

This basic project doesn't use any 3rd party frameworks.

### Day 2: Volley + Gson + Picasso:

- Volley is used for Networking.
- Gson is used for Deserializing of JSON response.
- Picasso is used for displaying & caching of image data.

### Day 3: Retrofit + Moshi + Glide:

- Retrofit is used for Networking. Why? 
- Moshi is used for Deserializing of JSON response. Why?
- Glide is used for displaying & caching of image data. Why?

- https://www.andreasjakl.com/how-to-retrofit-moshi-coroutines-recycler-view-for-rest-web-service-operations-with-kotlin-for-android/
- https://medium.com/@vlonjatgashi/using-glide-with-kotlin-5e345b557547

### Day 4: Retrofit + Moshi + Glide + RxJava:

### Day 5: Retrofit + Moshi + Glide + Coroutines:

- https://android.jlelse.eu/kotlin-coroutines-and-retrofit-e0702d0b8e8f

### Day 6: Retrofit + Moshi + Glide + RxJava + Dagger:

### Day 7: Retrofit + Moshi + Glide + Coroutines + Dagger:

### Day 8: Retrofit + Moshi + Glide + Coroutines + Dagger + ViewModel + LiveData:

- Factory for a specific viewModel: 
    - https://www.strv.com/blog/how-to-set-up-dagger-viewmodel-saved-state-module-engineering
    - https://medium.com/chili-labs/android-viewmodel-injection-with-dagger-f0061d3402ff 
- Factory for generic viewModels: 
    - https://android.jlelse.eu/using-dagger2-intomap-api-for-android-viewmodel-injection-cffeb8dd0cdf
    - https://www.techyourchance.com/dependency-injection-viewmodel-with-dagger-2/

### Day 9: Retrofit + Moshi + Glide + Coroutines + Dagger + ViewModel + LiveData (Refactored):

Inject the repository directly into the ViewModel


### Day 10: Retrofit + Moshi + Glide + Coroutines + Dagger + MVVM:

- Folder structure
- Multiple ViewModels
- Multiple Dagger modules
- Caching using Room
    - https://proandroiddev.com/imagining-your-repository-layer-with-coroutines-7ee052ee4caa

### Day 11: Retrofit + Moshi + Glide + Coroutines + Dagger + MVVM + PagedList

- Provide BaseURL via Dagger in ApplicationComponent.
- PagedList Component.
- NetworkState

### Day 12: Testing

### Day 13: Apply further advanced techniques:

- Inject key from gradle and BuildConfig: https://github.com/PhilippeBoisney/GithubApp/blob/master/app/build.gradle
- View binding.
- MultiBinding with Dagger: (used to inject a viewmodel into its corresponding Activity/Fragment)
    - https://android.jlelse.eu/using-dagger2-intomap-api-for-android-viewmodel-injection-cffeb8dd0cdf
    - https://medium.com/@marco_cattaneo/android-viewmodel-and-factoryprovider-good-way-to-manage-it-with-dagger-2-d9e20a07084c
    - https://www.youtube.com/watch?v=jCYj_MYCgEQ
- Check Internet connection

### Day 14: Use Koin instead of Dagger

- https://medium.com/@gunayadem.dev/boost-your-android-apps-with-koin-and-coroutines-using-mvvm-in-kotlin-d30fe436ab4c

## Additional Resources:

### Architectures:

- [Android Architecture starring Kotlin Coroutines, Jetpack (MVVM, Room, Paging), Retrofit and Dagger 2](https://proandroiddev.com/android-architecture-starring-kotlin-coroutines-jetpack-mvvm-room-paging-retrofit-and-dagger-7749b2bae5f7)
- https://medium.com/@maqsoodzai1989/android-mvvm-using-dagger-room-navigation-controller-rx-livedata-retrofit-c6fbc4fd11a5
- https://android.jlelse.eu/android-mvvm-with-dagger-2-retrofit-rxjava-architecture-components-6f5da1a75135
- https://proandroiddev.com/mvvm-with-kotlin-android-architecture-components-dagger-2-retrofit-and-rxandroid-1a4ebb38c699

### Dagger:

- https://stackoverflow.com/questions/30692501/dagger-2-injecting-android-context

### Completed apps:

- https://github.com/android/architecture-samples
- https://github.com/android/sunflower
- https://github.com/Eli-Fox/LEGO-Catalog
- https://github.com/theozgurr/LibraryApp



