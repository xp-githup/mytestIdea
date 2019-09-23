import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestSpringSecurity {
    @Test
      public void fun() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String s = encoder.encode("123");
        System.out.println(s);

@Test
  public void fun() {
        System.out.println();
  }





      }
}
