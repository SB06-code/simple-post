package codeit.sb06.simplepost;

import codeit.sb06.simplepost.controller.PostController;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Tag("intg")
public class SomeIntegrationTest {

    @Autowired
    private ApplicationContext context;

    @Test
    void someTest() {
        assertThat(context.getBean("postController")).isInstanceOf(PostController.class);
    }
}
