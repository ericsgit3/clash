# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
go public
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
It is unsupported to use this function to create a context that is suitable to invoke Xray's internal component 
 in third party code, you shouldn't use //go:linkname to alias of this function into your own package and 
 use this function in your third party code. 
  
 For third party code, usage enabled by creating a context to interact with Xray's internal component is unsupported, 
 and may break at any time.
