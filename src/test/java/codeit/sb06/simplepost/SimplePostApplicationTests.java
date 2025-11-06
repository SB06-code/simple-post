package codeit.sb06.simplepost;

import codeit.sb06.simplepost.controller.PostController;
import codeit.sb06.simplepost.service.PostService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Tag("intg")
class SimplePostApplicationTests {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private PostController postController;

    @Autowired
    private PostService postService;

    @Test
    @DisplayName("@SpringBootTest는 모든 Bean을 로드하여 ApplicationContext를 구성한다.")
    void contextLoads() {
        PostController controllerBean = context.getBean(PostController.class);
        PostService serviceBean = context.getBean(PostService.class);

        assertThat(controllerBean).isNotNull();
        assertThat(postController).isNotNull();

        assertThat(serviceBean).isNotNull();
        assertThat(postService).isNotNull();

        assertThat(postController).isSameAs(controllerBean);
        assertThat(postService).isSameAs(serviceBean);
    }
}
