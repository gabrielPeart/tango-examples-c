/*
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.projecttango.experiments.nativeplanefitting;

import android.app.Activity;

/**
 * Interfaces between native C++ code and Java code.
 */
public class JNIInterface {
    static {
        System.loadLibrary("cpp_plane_fitting_example");
    }

  // Check that the installed version of the Tango API is up to date
  // and initialize other data.
    public static native boolean initialize(Activity activity, int minTangoVersion);

    // Set up the configuration, callbacks, and connect to the Tango Service.
    public static native boolean tangoSetupAndConnect();

    // Disconnect from the Tango Service, release all the resources that
    // the app is holding from the Tango Service.
    public static native void tangoDisconnect();

    // Allocate OpenGL resources for rendering and register the color
    // camera texture.
    public static native boolean initializeGLContent();

    // Release non-gl resources that are allocated.
    public static native void deleteResources();

    // Display debug colors on point cloud.
    public static native void setRenderDebugPointCloud(boolean debugRender);

    // Setup the view port width and height.
    public static native void setViewPort(int width, int height);

    // Main render loop.
    public static native void render();

    // Respond to a touch event.
    public static native void onTouchEvent(float x, float y);
}
