# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.4.1)
#set (CMAKE_CXX_STANDARD 11)

ADD_DEFINITIONS(-D__WXQT__)

SET(wxQt_Base /home/dsr/Projects/wxqt/wxWidgets)
SET(wxQt_Build build_android_gles2_so_clang_qt_64)

SET(Qt_Base /home/dsr/Projects/qt5)
SET(Qt_Build build_arm64/qtbase)

SET(OCPN_Base /home/dsr/Projects/opencpn_clone/OpenCPN)
SET(OCPN_Build build_android_clang_dynamic_64)

INCLUDE_DIRECTORIES( ${wxQt_Base}/include )
INCLUDE_DIRECTORIES( ${wxQt_Base}/${wxQt_Build}/lib/wx/include/arm-linux-androideabi-qt-unicode-3.1 )

INCLUDE_DIRECTORIES( ${Qt_Base}/${Qt_Build}/include)
INCLUDE_DIRECTORIES( ${Qt_Base}/${Qt_Build}/include/QtOpenGL)
INCLUDE_DIRECTORIES( ${Qt_Base}/${Qt_Build}/include/QtWidgets)
INCLUDE_DIRECTORIES( ${Qt_Base}/${Qt_Build}/include/QtGui)
INCLUDE_DIRECTORIES( ${Qt_Base}/${Qt_Build}/include/QtCore)

INCLUDE_DIRECTORIES( ${OCPN_Base}/include)
INCLUDE_DIRECTORIES( ${OCPN_Base}/src/nmea0183)

#SET(CMAKE_CXX_FLAGS "-pthread -fPIC -s -O2")
SET(CMAKE_CXX_FLAGS " -g -O0 -pthread -fPIC -Wno-inconsistent-missing-override -Wno-potentially-evaluated-expression -Wl,-Bsymbolic ")
#SET(CMAKE_SHARED_LINKER_FLAGS "-Wl -rpath .")
#SET(CMAKE_SHARED_LINKER_FLAGS "-Wl, -latomic")
#SET(CMAKE_SHARED_LINKER_FLAGS "-Wl,Bsymbolic")


# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

#add_library( # Sets the name of the library.
#             native-lib

             # Sets the library as a shared library.
#             SHARED

             # Provides a relative path to your source file(s).
#             src/main/cpp/native-lib.cpp )

add_library( # Sets the name of the library.
        wrapper

        # Sets the library as a shared library.
        SHARED

        # Provides a relative path to your source file(s).
        src/main/cpp/ocpn_wrapper.cpp
        )

add_library( wxbase-lib SHARED IMPORTED )
set_target_properties( wxbase-lib PROPERTIES IMPORTED_LOCATION ${wxQt_Base}/${wxQt_Build}/lib/libwx_baseu-3.1.so )

add_library( wxcore-lib SHARED IMPORTED )
set_target_properties( wxcore-lib PROPERTIES IMPORTED_LOCATION ${wxQt_Base}/${wxQt_Build}/lib/libwx_qtu_core-3.1.so )

add_library( wxhtml-lib SHARED IMPORTED )
set_target_properties( wxhtml-lib PROPERTIES IMPORTED_LOCATION ${wxQt_Base}/${wxQt_Build}/lib/libwx_qtu_html-3.1.so )

add_library( ocpncore-lib SHARED IMPORTED )
set_target_properties( ocpncore-lib PROPERTIES IMPORTED_LOCATION ${OCPN_Base}/${OCPN_Build}/libgorp.so
        )

#add_library( QT5core-lib SHARED IMPORTED )
#set_target_properties( QT5core-lib PROPERTIES IMPORTED_LOCATION "${Qt_Base}/${Qt_Build}/lib/libQt5Core.so" )

#add_library( QT5GUI-lib SHARED IMPORTED )
#set_target_properties( QT5GUI-lib PROPERTIES IMPORTED_LOCATION ${Qt_Base}/${Qt_Build}/lib/libQt5Gui.so )

#add_library( QT5Widgets-lib SHARED IMPORTED )
#set_target_properties( QT5Widgets-lib PROPERTIES IMPORTED_LOCATION ${Qt_Base}/${Qt_Build}/lib/libQt5Widgets.so )

#add_library( QT5Test-lib SHARED IMPORTED )
#set_target_properties( QT5Test-lib PROPERTIES IMPORTED_LOCATION ${Qt_Base}/${Qt_Build}/lib/libQt5Test.so )



# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( # Sets the name of the path variable.
              log-lib

              # Specifies the name of the NDK library that
              # you want CMake to locate.
              log )


#find_library(atomic-lib atomic )

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

#target_link_libraries( # Specifies the target library.
#                       native-lib
                       # Links the target library to the log library
                       # included in the NDK.
#                       ${log-lib} )

target_link_libraries( # Specifies the target library.

        wrapper
        ocpncore-lib
        wxcore-lib
        wxbase-lib
        wxhtml-lib
        #/home/dsr/Projects/wxqt/wxWidgets/build_android_gles2_so_clang_qt_static/lib/libwx_qtu_core-3.1-arm-linux-androideabi.a
        #/home/dsr/Projects/wxqt/wxWidgets/build_android_gles2_so_clang_qt_static/lib/libwx_baseu-3.1-arm-linux-androideabi.a
        #QT5core-lib
        #QT5GUI-lib
        #QT5Widgets-lib
        #QT5Test-lib
        # Links the target library to the log library
        # included in the NDK.
        ${log-lib}
        ${gnu-lib}

        )
