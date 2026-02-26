
-keepattributes RuntimeVisibleAndInvisibleAnnotations,Signature,InnerClasses,EnclosingMethod,KotlinCompilerVersion
-keep @com.squareup.moshi.JsonClass class *
-keep class * extends com.squareup.moshi.JsonAdapter
-keep class * implements com.squareup.moshi.JsonAdapter
-keep class com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory { *; }

# Preserve Parcelable CREATOR fields
-keepclassmembers class * implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator *;
}
