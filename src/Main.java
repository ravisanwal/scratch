import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ravi.sanwal on 7/25/16.
 */
public class Main {

    public static void main(String[] args) {
        final AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        final Config cfg = ctx.getBean(Config.class);
        final Foo foo = cfg.foo();
        System.out.println(foo);
    }

    static class Foo {
    }

    static class Bar {

    }

    @Configuration
    static class Config {
        @Bean
        public Foo foo() {
            Foo foos = new Foo();
            System.out.println("Created foo " + foos);
            return foos;
        }

        @Bean
        public Bar bar() {
            Bar barr = new Bar();
            System.out.println("Created bar " + barr);
            return barr;
        }
    }
}
