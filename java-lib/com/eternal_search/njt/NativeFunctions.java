package com.eternal_search.njt;

import com.eternal_search.njt.geom.Rect;

import java.io.File;

final class NativeFunctions {
	
	private NativeFunctions() {
	}
	
	static void loadLibrary() {
		final String toolkitLibrary = PlatformInfo.getToolkitDirectory() + File.separator +
				"libtoolkit-" + PlatformInfo.getPlatformId() + PlatformInfo.getNativeLibrarySuffix();
		System.err.println("Loading native library: " + toolkitLibrary);
		System.load(toolkitLibrary);
	}
	
	static native boolean init();
	
	static native void deInit();
	
	static native void runEventLoop();
	
	static native void quitEventLoop();
	
	static native long createWindow(String title, int x, int y, int width, int height, int flags,
									int parent);
	
	static native void destroyWindow(long window);
	
	static native void showWindow(long window);
	
	static native void hideWindow(long window);
	
	static native void setWindowTitle(long window, String title);
	
	static native void moveWindow(long window, int x, int y, int width, int height);
	
	static native Rect getWindowRect(long window);
	
	static native long createOpenGLContext(long window);
	
	static native long destroyOpenGLContext(long window, long context);
	
	static native long beginUseOpenGLContext(long window, long context);
	
	static native long endUseOpenGLContext(long window, long context);
	
}
