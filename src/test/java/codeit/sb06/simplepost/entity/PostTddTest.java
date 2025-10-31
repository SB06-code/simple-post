package codeit.sb06.simplepost.entity;

import codeit.sb06.simplepost.support.PostFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PostTddTest {

    @Test
    @DisplayName("increaseViewCount 메서드는 호출 시 viewCount를 1 증가시킨다.")
    void increaseViewCount_TDD() {
        Post post = PostFixture.createPost("codeit", "TDD Test");

        post.increaseViewCount();
        post.increaseViewCount();

        assertThat(post.getViewCount()).isEqualTo(2);
    }
}
