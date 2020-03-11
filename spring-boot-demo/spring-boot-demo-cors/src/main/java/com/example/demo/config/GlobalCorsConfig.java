package com.example.demo.config;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: GlobalCorsConfig
 * @Description: 跨域配置
 * @Author: zhangdi
 * @Date: 2020年02月23日 14:10
 **/
//@Configuration
public class GlobalCorsConfig {
    // 方法1 ，重写WebMvcConfiturer
   /* @Bean
    public WebMvcConfigurer corsConfig() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                System.out.println("i am here...");
                registry.addMapping("/**");
            }
        };
    }*/
}
