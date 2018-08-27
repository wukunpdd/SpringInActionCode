package cn.wukun.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * 拓展 AbstractAnnotationConfigDispatcherServletInitializer 的任意类
 * 都会自动的配置DispatcherServlet和Spring应用上下文
 */
public class SpitterWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 方法返回的带有@Configuration注解的类将会用来配置ContextLoaderListener创建的应用上下文中的bean
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class };
    }

    /**
     * 方法返回的带有@Configuration注解的类将会用来定义DispatcherServlet应用上下文的bean
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }

    /**
     * 将一个或多个路径映射到DispatcherServlet上
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    /**
     * 解决表单提交的乱码问题
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        servletContext.addFilter("name", new CharacterEncodingFilter("UTF-8", true))
                .addMappingForUrlPatterns(null, false, "/*");
    }
}