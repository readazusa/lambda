package com.hanggold.experiment.lambda;

/**
 * 这里写代码描述
 *
 * @author smc
 * @date 2019-05-15 22:22
 * @since
 **/
public class Pair<F, S> {

    public final F fst;
    public final S snd;

    private Pair(F fst, S snd) {
        this.fst = fst;
        this.snd = snd;
    }

    public static <F, S> Pair<F, S> of(F fst, S snd) {
        return new Pair<>(fst, snd);
    }

}


