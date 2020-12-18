package lib_book.lib.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ITemplateResolver;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
public class Config {
    public int PAGE_LIMIT = 10;

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }

    @Bean
    public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver,
            LayoutDialect layout) {
        final SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        templateEngine.addDialect(layout);
        return templateEngine;
    }
}
