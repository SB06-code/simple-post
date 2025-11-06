package codeit.sb06.simplepost;

import codeit.sb06.simplepost.entity.Post;
import codeit.sb06.simplepost.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@Tag("intg")
public class DataInitializationTest {

    @Autowired
    private PostRepository postRepository;

    @BeforeEach
    void setUp() {
        // 이 코드가 활성화되면, @Sql 실행 후에 입력된 데이터가 모두 삭제되기 때문에, 테스트 코드 수행 실패.
        // postRepository.deleteAll();
    }

    @Test
    @DisplayName("@Sql: SQL 스크립트로 준비된 데이터를 검증한다.")
    @Sql("/test-data.sql")
    void sql_test() {
        long count = postRepository.count();
        Post post = postRepository.findAll().get(0);

        assertThat(count).isEqualTo(2);
        assertThat(post.getAuthor()).isEqualTo("sql-tester");
    }

}
