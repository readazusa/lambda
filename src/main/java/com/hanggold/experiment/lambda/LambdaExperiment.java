package com.hanggold.experiment.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * 这里写代码描述
 *
 * @author smc
 * @date 2019-05-15 21:11
 * @since
 **/
public class LambdaExperiment {


    public void lambda() {
        List<String> myList = new ArrayList<String>();
        myList.stream().map(this::trySomething).forEach(System.out::print);
    }

    public void lambda2() {
        List<String> myList = new ArrayList<String>();
        myList.stream().map(wrap(t -> doSomething(t))).forEach(System.out::print);
    }

    public void lambda3() {
        List<String> myList = new ArrayList<String>();
        myList.stream().map(Either.lift(item -> doSomething(item))).forEach(System.out::println);
    }

    public String trySomething(String target) throws RuntimeException {
        try {
            return doSomething(target);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public String doSomething(String target) throws RuntimeException {
        return target + "hello";
    }

    public static <T, R> Function<T, R> wrap(CheckedFunction<T, R> checkedFunction) {
        return t -> {
            try {
                return checkedFunction.apply(t);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static void main(String[] args) {


    }

}
