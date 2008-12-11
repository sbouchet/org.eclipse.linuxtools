/*******************************************************************************
 * Copyright (c) 2004 Red Hat, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Keith Seitz <keiths@redhat.com> - initial API and implementation
 *******************************************************************************/ 
package org.eclipse.linuxtools.oprofile.core.daemon;


/**
 * This class represents the global launch options for the
 * OProfile daemon.
 */
public class OprofileDaemonOptions {
	// Kernel image file
	private String _kernelImageFile;
	
	// Enable verbose logging?
	private boolean _verboseLogging;
	
	// How to separate profiles (mask)
	private int _separateProfiles;
	
	// the image to profile
	private String _binaryImage;
	
	/**
	 * Sample separation options. Determines how oprofiled will group
	 *   samples for binaries which isn't the main binary being profiled.
	 *   
	 * Currently only properly support:
	 *   -none: ignore all other binaries
	 *   -library: include shared library samples
	 *   -kernel: include kernel module samples (which implicitly includes library)
	 *   
	 *   the others probably wouldn't show nicely in the view
	 */
	public static final int SEPARATE_NONE = 0;
	public static final int SEPARATE_LIBRARY = 1;
	public static final int SEPARATE_KERNEL = 2;
	public static final int SEPARATE_THREAD = 4;
	public static final int SEPARATE_CPU = 8;
	
	public OprofileDaemonOptions() {
		//defaults
//		_kernelImageFile = Oprofile.getKernelImageFile();
		_kernelImageFile = "";
		_verboseLogging = false;
		_separateProfiles = SEPARATE_NONE;	
		_binaryImage = "";
	}
	
	/**
	 * Get the kernel image file
	 * @return the kernel image file
	 */
	public String getKernelImageFile() {
		return _kernelImageFile;
	}
	
	/**
	 * Set the kernel image file
	 * @param image the kernel image
	 */
	public void setKernelImageFile(String image) {
		_kernelImageFile = image;
	}

	/**
	 * Get daemon verbose logging
	 * @return whether verbose logging is enabled
	 */
	public boolean getVerboseLogging() {
		return _verboseLogging;
	}
	
	/**
	 * Set daemon verbose logging
	 * @param logging whether to enable verbose logging
	 */
	public void setVerboseLogging(boolean logging) {
		_verboseLogging = logging;
	}

	/**
	 * Get daemon profile separation mask
	 * @return mask of options
	 */
	public int getSeparateProfilesMask() {
		return _separateProfiles;
	}
	
	/**
	 * Set daemon profile separation mask
	 * @param mask the new separation mask
	 */
	public void setSeparateProfilesMask(int mask) {
		_separateProfiles = mask;
	}

	public String getBinaryImage() {
		return _binaryImage;
	}

	public void setBinaryImage(String _image) {
		this._binaryImage = _image;
	}

}
