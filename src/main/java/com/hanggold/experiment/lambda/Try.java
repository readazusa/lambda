package com.hanggold.experiment.lambda;

/**
 * 这里写代码描述
 *
 * @author smc
 * @date 2019-05-15 22:24
 * @since
 **/
public class Try<Exception, R> {

    private final Exception failure;
    private final R succes;

    public Try(Exception failure, R succes) {
        this.failure = failure;
        this.succes = succes;
    }

}