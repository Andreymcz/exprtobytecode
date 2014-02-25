package benchmark.evals.javassist;

import benchmark.evals.MathEvaluator;

/**
 * Created by andrey on 2/25/14.
 */
public class SimpleJavassistEvaluator extends MathEvaluator{

    @Override
    protected void doSetup(String formula, String... variables) {

    }

    @Override
    public double evaluate(double... variables) {
        return 0;
    }
}
