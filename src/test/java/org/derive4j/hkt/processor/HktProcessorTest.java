package org.derive4j.hkt.processor;

import com.google.common.truth.Truth;
import com.google.testing.compile.CompileTester;
import com.google.testing.compile.JavaFileObjects;
import org.derive4j.hkt.processor.HktProcessor;
import org.junit.Test;

import javax.tools.JavaFileObject;

import static com.google.testing.compile.JavaSourceSubjectFactory.javaSource;

public class HktProcessorTest {

  @Test
  public void testMaybe() {
    testThat("org/derive4j/hkt/ex/Maybe.java").compilesWithoutError();
  }

  @Test
  public void testEither() {
    testThat("org/derive4j/hkt/ex/Either.java").compilesWithoutError();
  }

  @Test
  public void bad_encodings() {
    testThat("dummy/dumb/Bar.java")
        .failsToCompile()
        .withErrorCount(12);
  }

  @Test
  public void testJ17() {
    testThat("org/derive4j/hkt/ex/J17.java").compilesWithoutError();
  }

  private CompileTester testThat(String path) {
    return Truth.assert_()
      .about(javaSource())
      .that(JavaFileObjects.forResource(path))
      .processedWith(new HktProcessor());
  }
}
