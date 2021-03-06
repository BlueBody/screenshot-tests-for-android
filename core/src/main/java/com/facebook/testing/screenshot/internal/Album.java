/**
 * Copyright (c) 2014-present, Facebook, Inc.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */

package com.facebook.testing.screenshot.internal;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import android.graphics.Bitmap;

/**
 * Stores metadata about an album of screenshots during an
 * instrumentation test run.
 */
public interface Album {

  /**
   * Writes the bitmap corresponding to the screenshot with the name
   * {@code name} in the {@code (tilei, tilej)} position.
   */
  public String writeBitmap(String name, int tilei, int tilej, Bitmap bitmap) throws IOException;

  /**
   * Call after all the screenshots are done.
   */
  public void flush();

  /**
   * Cleanup any disk state associated with this album.
   */
  public void cleanup();

  /**
   * Opens a stream to dump the view hierarchy into. This should be
   * called before addRecord() is called for the given name.
   *
   * It is the callers responsibility to call {@code close()} on the
   * returned stream.
   */
  public OutputStream openViewHierarchyFile(String name) throws IOException;

  /**
   * This is called after every record is finally set up.
   */
  public void addRecord(RecordBuilderImpl recordBuilder) throws IOException;
}
