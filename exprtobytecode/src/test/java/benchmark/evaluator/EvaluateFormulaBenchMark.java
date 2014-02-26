package benchmark.caliper;

import benchmark.formula.Formula;
import com.google.caliper.BeforeExperiment;
import com.google.caliper.Benchmark;
import com.google.caliper.Param;
import com.graphbuilder.math.Expression;
import com.graphbuilder.math.ExpressionTree;
import com.graphbuilder.math.FuncMap;
import com.graphbuilder.math.VarMap;
import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;

/**
 * Created by andrey on 2/26/14.
 */
public final class EvaluateFormulaBenchMark {

    @Param private Formula formula;

    private Calculable exp4j;
    private Expression mesp;

    private final VarMap vm = new VarMap(false);
    private final FuncMap fm = new FuncMap();


    @BeforeExperiment
    public void setUp() {

        try {

            /**
             *
             * Exp4j
             *
             */
            exp4j = new ExpressionBuilder(formula.getFormula()).
                    withVariableNames(formula.getVariables()).
                    build();


            /**
             *
             * MESP
             *
             */

            mesp = ExpressionTree.parse(formula.getFormula());
            fm.loadDefaultFunctions();

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    @Benchmark
    public double exp4j(int reps) {

        Formula f = this.formula;
        double dummy = 0;

        for (int i = 0; i < reps; i++) {
            dummy += exp4j.calculate(f.buildArgs(i));
        }
        return dummy;
    }

    @Benchmark
    public double MESP(int reps) {

        Formula f = this.formula;
        double dummy = 0;

        for (int i = 0; i < reps; i++) {
            f.buildArgs(vm, i);
            dummy += mesp.eval(vm, fm);
        }

        return dummy;
    }
}
