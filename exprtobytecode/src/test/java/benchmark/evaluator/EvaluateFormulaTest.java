package benchmark.evaluator;

import com.google.caliper.runner.CaliperMain;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by andrey on 2/26/14.
 */
public class EvaluateFormulaTest {

    @Test
    public void formulaEvaluatorBenchmark() {
        CaliperMain.main(new String[]{
                EvaluateFormulaBenchMark.class.getCanonicalName()
        });
        assertTrue(true);
    }
}
