# Android Architectures in 14 days.

## The cat app

- Fetching list of cat images from thecatapi.com.
- Display the cat image when choosen.

### Day 1: Basic: Raw kotlin without any external libraries:

This basic project doesn't use any 3rd party frameworks.

### Day 2: Volley + Gson + Picasso:

- Volley is used for Networking
- Gson is used for Deserializing of JSON response
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

### Completed apps:

- https://github.com/android/architecture-samples
- https://github.com/android/sunflower
- https://github.com/Eli-Fox/LEGO-Catalog
- https://github.com/theozgurr/LibraryApp

### Dagger:

- https://stackoverflow.com/questions/30692501/dagger-2-injecting-android-context
