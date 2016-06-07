package com.devonfw.devcon.common.utils;

import java.nio.file.Path;

import com.devonfw.devcon.common.api.utils.FolderIterceptor;

/**
 * Class which offesr a single method which allows for a filesystem path to be climbed "upward" from a leave node to the
 * Root node. Instread of a recursive downward "walker", this implementation climbed vertally without traversing
 * siblings.
 *
 */
public class TreeClimber {

  /**
   * calls {@link FolderIterceptor} for each folder encounters while "climbing" upward from {@link path} to the Root
   * node
   * 
   * @param path Path to climb from
   * @param interceptor delegate to call for each folder
   */
  public static void climb(Path path, FolderIterceptor interceptor) {

    Path _path = path.toAbsolutePath();
    Path root = path.getRoot();

    while (interceptor.onFolder(_path)) {
      if (_path.equals(root)) {
        break;
      }
      _path = _path.getParent();
    }

  }
}