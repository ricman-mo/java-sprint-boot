package com.example.demo.filesystems;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import static com.example.demo.filesystems.Constants.SEPARATOR;


/**
 * Created by M93349 on 2018/6/11.
 */
@Component
public class PackagesDirConfig {
  /** The Constant SYSTEM_DATA_DIR. */
  public static final String SYSTEM_DIR             = "system";

  /** The Constant DATA_DIR. */
  public static final String DATA_DIR               = SYSTEM_DIR + SEPARATOR + "data";

  /** The Constant CONSOLE_UI_STATIC_DIR. */
  public static final String CONSOLE_UI_STATIC_DIR     = SYSTEM_DIR + SEPARATOR + "console";

  /** The Constant APPS_UI_STATIC_DIR. */
  public static final String APPS_UI_STATIC_DIR     = SYSTEM_DIR + SEPARATOR + "ui";

  /** The Constant APPS_HOT_DEPLOY_DIR. */
  public static final String APPS_HOT_DEPLOY_DIR    = "applications";

  /** The Constant PLUGINS_HOT_DEPLOY_DIR. */
  public static final String PLUGINS_HOT_DEPLOY_DIR = "plugins";

  /** The Constant EXPLODED_IMPORT_DIR. */
  public static final String EXPLODED_IMPORT_DIR    = DATA_DIR + SEPARATOR + "p3";

  /** The Constant EXPLODED_APPS_DIR. */
  public static final String EXPLODED_APPS_DIR      = DATA_DIR + SEPARATOR + "p2";

  /** The Constant DEFAULT_APPS_DIR. */
  public static final String DEFAULT_APPS_DIR       = SYSTEM_DIR + SEPARATOR + "default_applications";

  /** The Constant EXPLODED_PLUGINS_DIR. */
  public static final String EXPLODED_PLUGINS_DIR   = DATA_DIR + SEPARATOR + "p1";

  /** The Constant DEFAULT_PLUGINS_DIR. */
  public static final String DEFAULT_PLUGINS_DIR    = SYSTEM_DIR + SEPARATOR + "default_plugins";

  /** The system data dir. */
  @Value( "${ricman.system.data.directory}" )
  private String             platformExternalDataLocation;

  /**
   * Gets the platform external data location.
   *
   * @return the platform external data location
   */
  public String getPlatformExternalDataLocation()
  {
    return platformExternalDataLocation;
  }

  /**
   * Sets the platform external data location.
   *
   * @param platformExternalDataLocation
   *            the new platform external data location
   */
  public void setPlatformExternalDataLocation( String platformExternalDataLocation )
  {
    this.platformExternalDataLocation = platformExternalDataLocation;
  }

  /**
   * Gets the apps hot deploy dir.
   *
   * @return the apps hot deploy dir
   */
  public String getAppsHotDeployDir()
  {
    return getSystemDataDirectory() + APPS_HOT_DEPLOY_DIR;
  }

  /**
   * Gets the plugins hot deploy dir.
   *
   * @return the plugins hot deploy dir
   */
  public String getPluginsHotDeployDir()
  {
    return getSystemDataDirectory() + PLUGINS_HOT_DEPLOY_DIR;
  }

  /**
   * Gets the apps exploded dir.
   *
   * @return the apps exploded dir
   */
  public String getAppsExplodedDir()
  {
    return getSystemDataDirectory() + EXPLODED_APPS_DIR;
  }

  /**
   * Gets the Import exploded dir.
   *
   * @return the Import exploded dir
   */
  public String getImportExplodedDir()
  {
    return getSystemDataDirectory() + EXPLODED_IMPORT_DIR;
  }

  /**
   * Gets the apps default dir.
   *
   * @return the apps default dir
   */
  public String getAppsDefaultDir()
  {
    return getSystemDataDirectory() + DEFAULT_APPS_DIR;
  }

  /**
   * Gets the plugins exploded dir.
   *
   * @return the plugins exploded dir
   */
  public String getPluginsExplodedDir()
  {
    return getSystemDataDirectory() + EXPLODED_PLUGINS_DIR;
  }

  /**
   * Gets the plugins default dir.
   *
   * @return the plugins default dir
   */
  public String getPluginsDefaultDir()
  {
    return getSystemDataDirectory() + DEFAULT_PLUGINS_DIR;
  }

  /**
   * Gets the console content dir.
   *
   * @return the console static content dir
   */
  public String getConsoleDir()
  {
    return getSystemDataDirectory() + CONSOLE_UI_STATIC_DIR + SEPARATOR;
  }


  /**
   * Gets the apps static content dir.
   *
   * @return the apps static content dir
   */
  public String getAppsStaticContentDir()
  {
    return getSystemDataDirectory() + APPS_UI_STATIC_DIR + SEPARATOR;
  }



  public String getSystemDataDirectory()
  {
    if ( StringUtils.isEmpty( getPlatformExternalDataLocation() ) )
    {
      return "";
    }
    else if ( StringUtils.endsWithIgnoreCase( getPlatformExternalDataLocation(), SEPARATOR ) )
    {
      return getPlatformExternalDataLocation();
    }
    else
    {
      return getPlatformExternalDataLocation() + SEPARATOR;
    }
  }
}
