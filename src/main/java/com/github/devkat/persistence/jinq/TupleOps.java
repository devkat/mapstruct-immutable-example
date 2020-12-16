package com.github.devkat.persistence.jinq;

import fj.P2;
import org.jinq.tuples.Pair;

import static fj.P.p;

public class TupleOps {

    public static <A, B> P2<A, B> p2(final Pair<A, B> p) {
        return p(p.getOne(), p.getTwo());
    }
}
