package codeit.sb06.simplepost;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@Tag("intg")
public class TestProfileTest {

    @Autowired
    private Environment env;

    @Test
    @DisplayName("test 프로파일이 활성화되고, H2 DB 설정이 적용되어야 한다.")
    void profile_activation_test() {
        assertThat(env.getActiveProfiles()).contains("test");
        assertThat(env.getProperty("spring.datasource.url")).isEqualTo("jdbc:h2:mem:testdb");
    }
}
