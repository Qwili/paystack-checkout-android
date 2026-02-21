
-keepattributes RuntimeVisibleAndInvisibleAnnotations,Signature,InnerClasses,EnclosingMethod
-keep @com.squareup.moshi.JsonClass class *
-keep class * extends com.squareup.moshi.JsonAdapter
-keep class * implements com.squareup.moshi.JsonAdapter
-keep class com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory { *; }