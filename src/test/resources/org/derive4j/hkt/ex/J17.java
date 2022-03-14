package org.derive4j.hkt.ex;

import org.derive4j.hkt.__;

public final class J17 {
  private J17() {}

  record TestRec<A>() implements __<TestRec.µ, A> {
    enum µ {}
  }

  sealed interface AList<A> extends __<AList<?>, A> {
    record Nil<A>() implements AList<A> {}
    record Cons<A>(A a, AList<A> tail) implements AList<A> {}
  }
}
