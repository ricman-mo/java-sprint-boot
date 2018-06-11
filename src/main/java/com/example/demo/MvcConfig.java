package com.example.demo;

import com.example.demo.filesystems.PackagesDirConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by M93349 on 2018/6/11.
 */
@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

  @Autowired
  private PackagesDirConfig        packagesDirConfig;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){

      String[] classpathResourcesLocation =
        {
          "classpath:/META-INF/resources/", "classpath:/resources/", "classpath:/static/", "classpath:/public/",
          "file:" + packagesDirConfig.getAppsStaticContentDir(), "file:" + packagesDirConfig.getConsoleDir()
        };

      registry.addResourceHandler( "/**" ).addResourceLocations( classpathResourcesLocation )
        .setCachePeriod(0 );
    }

//  @Override
//  public void addViewControllers( ViewControllerRegistry registry )
//  {
//    registry.addViewController( "/*/" ).setViewName( "forward:/index.html" );
//  }
}
