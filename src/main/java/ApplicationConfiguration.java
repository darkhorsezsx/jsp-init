import com.zsx.demo.jsp.BarServlet;
import com.zsx.demo.jsp.FooFilter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This is {@link ApplicationConfiguration}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
@SpringBootApplication(scanBasePackages = "com.zsx.demo.jsp")
@ServletComponentScan(basePackages = "com.zsx.demo.jsp")
public class ApplicationConfiguration extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ApplicationConfiguration.class);
    }

    public static void main(String[] args) throws Exception {
        new SpringApplicationBuilder(ApplicationConfiguration.class)
                .run(args);
    }

    @Bean
    ServletRegistrationBean barServletA() {
        BarServlet barServlet = new BarServlet();
        ServletRegistrationBean bean = new ServletRegistrationBean(barServlet, "/bar/a");
        bean.setInitParameters(new HashMap<String, String>(){{put("type", "A");}});
        bean.setName("barServletA");
        return bean;
    }

    @Bean
    ServletRegistrationBean barServletB() {
        BarServlet barServlet = new BarServlet();
        ServletRegistrationBean bean = new ServletRegistrationBean(barServlet, "/bar/b");
        bean.setInitParameters(new HashMap<String, String>(){{put("type", "B");}});
        bean.setName("barServletB");
        return bean;
    }

    @Bean
    FilterRegistrationBean filterRegistrationBean() {
        FooFilter filter = new FooFilter();
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(filter);
        registrationBean.setUrlPatterns(new ArrayList<String>(){{
            add("/bar/*");
            add("/foo/*");
        }});
        return registrationBean;
    }

}
