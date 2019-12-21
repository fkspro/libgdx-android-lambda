Short example trying to get Java 8 lambdas working on libgdx

This is the default libgdx project with a hashmap using a lambda in a
forEach.

Code added:

```
ObjectMap<String, String> testmap;

// in create()
testmap.put("one", "first entry");
testmap.put("two", "another entry");
testmap.put("three", "the last entry");

// in render(), only once
testmap.forEach(e -> Gdx.app.log("test", "element: " + e));
```

This works as expected on desktop but crashes immediately on
Android.  The relevant error from logcat seems to be

`art     : Rejecting re-init on previously-failed class java.lang.Class<com.mygdx.game.-$$Lambda$AndroidTest$xfEPtIpFSYEmXjDtAPiPmn8r3NM>`

The only changes made to the build are in android/build.gradle:

```
compileOptions {
    sourceCompatibility 1.8
    targetCompatibility 1.8
}
```
