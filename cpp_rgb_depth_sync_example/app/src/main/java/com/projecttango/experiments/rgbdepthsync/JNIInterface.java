/*
 * Copyright 2014 Google Inc. All Rights Reserved.
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

package com.projecttango.experiments.rgbdepthsync;

import android.app.Activity;

/**
 * Interfaces between C and Java.
 */
public class JNIInterface {
    static {
      System.loadLibrary("cpp_rgb_depth_sync_example");
    }

    public static native boolean initialize(Activity activity, int minTangoVersion);

    public static native boolean tangoSetupConfig();

    public static native boolean tangoConnectTexture();

    public static native boolean tangoConnect();

    public static native boolean tangoConnectCallbacks();

    public static native boolean tangoSetIntrinsicsAndExtrinsics();

    public static native void tangoDisconnect();

    public static native void initializeGLContent();

    public static native void setViewPort(int width, int height);

    public static native void render();

    public static native void setDepthAlphaValue(float alpha);

    public static native void setGPUUpsample(boolean on);
}
