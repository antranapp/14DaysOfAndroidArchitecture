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
    - [Navigation component](https://developer.android.com/guide/navigation)
- Android's Jetpack:
    - [RecyclerView](https://developer.android.com/guide/topics/ui/layout/recyclerview)
- Android's Architecture Components:
    - [View Binding](https://developer.android.com/topic/libraries/view-binding)
    - [Handling App Lifecycles](https://developer.android.com/topic/libraries/architecture/lifecycle)
    - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
    - [Paging Library](https://developer.android.com/topic/libraries/architecture/paging)
    - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
    - [Room Persistence Library](https://developer.android.com/topic/libraries/architecture/room)
- Testing

## What you'll do:


![the cat app](docs/app.gif)

We will implement a cat images browsing app with the following features:

- Fetching list of cat images from [TheCatAPI](https://thecatapi.com).
- Displaying fetched images in a grid layout.
- Using recommended techniques and frameworks from Google to implement the app using MVVM architecture step by step.
- Implementing the app in an incremental process, starting with a pure Kotlin implementation to a full-blown MVVM-based implementation using frameworks in Android's Architecture Components and popular 3rd-party frameworks.


## What's next:

After finishing the course, you'll have hopefully learned intuitively how the MVVM Architecture works by implementing a simple app by using different popular frameworks provided by Google and 3rd parties. Depending on your motivation and the level of knowledge, you can follow different paths forward to learn more about Android development.

### A small step: 

Try to apply what you have learnd in another app that uses [the dog api](https://dog.ceo) instead. With this approach, you will have more or less the same structure for you app but you have to deal with a different data model, a different api.

### A medium step: 

There are two options to learn even more:

- Extending the current cat app by implementing additional features such as:
    - users can favorite images, the information of favorite images should be persisted locally in some kinds of database, and there should be an additional screen to show such favorite images

- Implementing a completely different app using public or private APIs to try out different techniqures:
    - Github App using Github API
    - News App using newsapi.org
    - Image browsing apps using Unsplash or Pixabay APIs
    - ....

There are a list of public APIs that you can use to implement your next sample app here [https://github.com/public-apis/public-apis](https://github.com/public-apis/public-apis)

### A giant step:

Everyone of us has an idea (or multiple ideas) for a killer app (or apps). Go forward and realize your dreams. You will be proud of yourself afterward :)

## Curriculum:

### [Day 1: Raw kotlin without any external libraries](https://github.com/antranapp/14DaysOfAndroidArchitecture/tree/master/01-TheCatGallery-Basic)

This basic project is implemented in pure Kotlin and built-in frameworks from the Android SDK and doesn't use any 3rd party frameworks.

---
### [Day 2: Volley + Gson + Picasso](https://github.com/antranapp/14DaysOfAndroidArchitecture/tree/master/02-TheCatGallery-Volley-Gson-Picasso)

- [Volley](https://developer.android.com/training/volley) is used for **Networking**.
- [Gson](https://github.com/google/gson) is used for **Deserializing of JSON response**.
- [Picasso](https://square.github.io/picasso/) is used for **displaying & caching of image data**.

---
### [Day 3: Retrofit + Moshi + Glide](https://github.com/antranapp/14DaysOfAndroidArchitecture/tree/master/03-TheCatGallery-Retrofit-Moshi-Glide)

- [Retrofit](https://square.github.io/retrofit/) is used for **Networking**.
- [Moshi](https://github.com/square/moshi) is used for **Deserializing of JSON response**.
- [Glide](https://github.com/bumptech/glide) is used for **displaying & caching of image data**.

**Resources**:

- [How-To: Retrofit, Moshi, Coroutines & Recycler View for REST Web Service Operations with Kotlin for Android](https://www.andreasjakl.com/how-to-retrofit-moshi-coroutines-recycler-view-for-rest-web-service-operations-with-kotlin-for-android/)
- [Using Glide with Kotlin](https://medium.com/@vlonjatgashi/using-glide-with-kotlin-5e345b557547)

---
### [Day 4: Retrofit + Moshi + Glide + RxJava](https://github.com/antranapp/14DaysOfAndroidArchitecture/tree/master/04-TheCatGallery-Retrofit-Moshi-Glide-RxJava)

---
### [Day 5: Retrofit + Moshi + Glide + Coroutines](https://github.com/antranapp/14DaysOfAndroidArchitecture/tree/master/05-TheCatGallery-Retrofit-Moshi-Glide-Coroutines)

**Resources:**

- [Kotlin Coroutines and Retrofit](https://android.jlelse.eu/kotlin-coroutines-and-retrofit-e0702d0b8e8f)

---
### [Day 6: Retrofit + Moshi + Glide + RxJava + Dagger](https://github.com/antranapp/14DaysOfAndroidArchitecture/tree/master/06-TheCatGallery-Retrofit-Moshi-Glide-RxJava-Dagger)

---
### [Day 7: Retrofit + Moshi + Glide + Coroutines + Dagger](https://github.com/antranapp/14DaysOfAndroidArchitecture/tree/master/07-TheCatGallery-Retrofit-Moshi-Glide-Coroutines-Dagger)

---
### [Day 8: Retrofit + Moshi + Glide + Coroutines + Dagger + ViewModel + LiveData](https://github.com/antranapp/14DaysOfAndroidArchitecture/tree/master/08-TheCatGallery-Retrofit-Moshi-Glide-Coroutines-Dagger-ViewModel)

**Resources:**

- [HOW TO SET UP DAGGER WITH VIEWMODEL & SAVED STATE MODULE](https://www.strv.com/blog/how-to-set-up-dagger-viewmodel-saved-state-module-engineering)
- [Android ViewModel injection with Dagger](https://medium.com/chili-labs/android-viewmodel-injection-with-dagger-f0061d3402ff)

---
### [Day 9: Retrofit + Moshi + Glide + Coroutines + Dagger + ViewModel + LiveData (Refactored)](https://github.com/antranapp/14DaysOfAndroidArchitecture/tree/master/09-TheCatGallery-Retrofit-Moshi-Glide-Coroutines-Dagger-ViewModel2)

Inject the repository directly into the ViewModel

---
### [Day 10: Retrofit + Moshi + Glide + Coroutines + Dagger + MVVM](https://github.com/antranapp/14DaysOfAndroidArchitecture/tree/master/10-TheCatGallery-Retrofit-Moshi-Glide-Coroutines-Dagger-MVVM)

- Folder structure
- Multiple ViewModels
- Multiple `Dagger` modules
- Caching using `Room`

**Resources:**

- [Imagining your Repository Layer with Coroutines](https://proandroiddev.com/imagining-your-repository-layer-with-coroutines-7ee052ee4caa)

---
### [Day 11: Retrofit + Moshi + Glide + Coroutines + Dagger + MVVM + PagedList](https://github.com/antranapp/14DaysOfAndroidArchitecture/tree/master/11-TheCatGallery-Retrofit-Moshi-Glide-Coroutines-Dagger-MVVM-PagedList)

- PagedList Component.
- NetworkState in ImageDataSource

**Resources:**

- [Android Paging Library with Kotlin Coroutines](https://medium.com/@harunwangereka/android-paging-library-with-kotlin-coroutines-b96602e3fae3)
- [Exploring Paging Library from Jetpack](https://proandroiddev.com/exploring-paging-library-from-jetpack-c661c7399662)

---
### Day 12: Testing

---
### Day 13: Apply further advanced techniques:

- Clean architecture with interfaces for use cases.
- Inject key from gradle and BuildConfig: https://github.com/PhilippeBoisney/GithubApp/blob/master/app/build.gradle
- View binding.
- MultiBinding with Dagger: (used to inject a viewmodel into its corresponding Activity/Fragment)
    - [Using Dagger2 IntoMap API for Android ViewModel Injection](https://android.jlelse.eu/using-dagger2-intomap-api-for-android-viewmodel-injection-cffeb8dd0cdf)
    - [Dependency Injection of ViewModel with Dagger 2](https://www.techyourchance.com/dependency-injection-viewmodel-with-dagger-2/)
    - [Android ViewModel and FactoryProvider: good way to manage it with Dagger Multibindings](https://medium.com/@marco_cattaneo/android-viewmodel-and-factoryprovider-good-way-to-manage-it-with-dagger-2-d9e20a07084c)
    - [Dagger 2 MultiBinding - Inject into ViewModels using MVVM,Dagger and Kotlin](https://www.youtube.com/watch?v=jCYj_MYCgEQ)
- Check Internet connection
	+ https://proandroiddev.com/android-architecture-components-network-awareness-using-livedata-1a8d3749734d
- Multi-modules
- Add SurpervisorJob into ImageDataSource 
    - https://github.com/PhilippeBoisney/GithubApp/blob/master/app/src/main/java/io/github/philippeboisney/githubapp/pagination/datasource/UserDataSource.kt
    - https://proandroiddev.com/playing-with-4f21bc67a7f9 
- Cache the list in `Room`

---
### [Day 14: Use Koin instead of Dagger](https://github.com/antranapp/14DaysOfAndroidArchitecture/tree/master/14-TheCatGallery-Retrofit-Moshi-Glide-Coroutines-Koin-MVVM-PagedList)

- Build-time code generation (Dagger) vs Runtime dependency injection.

**Resources:**

- [Playing with… Paging Library, Retrofit, Coroutines, Koin & Testing.](https://proandroiddev.com/playing-with-4f21bc67a7f9)
- [Boost your Android apps with Koin and Coroutines using MVVM in Kotlin](https://medium.com/@gunayadem.dev/boost-your-android-apps-with-koin-and-coroutines-using-mvvm-in-kotlin-d30fe436ab4c)

## Additional Resources:

### Architectures:

- [Android Architecture starring Kotlin Coroutines, Jetpack (MVVM, Room, Paging), Retrofit and Dagger 2](https://proandroiddev.com/android-architecture-starring-kotlin-coroutines-jetpack-mvvm-room-paging-retrofit-and-dagger-7749b2bae5f7)
- [Android - MVVM using Dagger,room,navigation controller,Rx,Livedata,Retrofit](https://medium.com/@maqsoodzai1989/android-mvvm-using-dagger-room-navigation-controller-rx-livedata-retrofit-c6fbc4fd11a5)
- [Android MVVM with Dagger 2, Retrofit, RxJava, Architecture Components](https://android.jlelse.eu/android-mvvm-with-dagger-2-retrofit-rxjava-architecture-components-6f5da1a75135)
- [MVVM with Kotlin — Android Architecture Components, Dagger 2, Retrofit and RxAndroid](https://proandroiddev.com/mvvm-with-kotlin-android-architecture-components-dagger-2-retrofit-and-rxandroid-1a4ebb38c699)

### Dagger:

- [LearnDagger](https://github.com/abhiank/LearnDagger)
- [Awesome Dagger](https://github.com/andyiac/awesome-dagger)

### Completed apps:

- https://github.com/android/architecture-samples
- https://github.com/android/sunflower
- https://github.com/Eli-Fox/LEGO-Catalog
- https://github.com/theozgurr/LibraryApp



