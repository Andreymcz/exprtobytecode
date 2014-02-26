package benchmark;

import benchmark.caliper.EvaluateFormulaBenchMark;
import com.google.caliper.runner.CaliperMain;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by andrey on 2/26/14.
 */
public class ExecuteAllBenchmarkTest {

    @Test
    public void testExecuteAll() {
        CaliperMain.main(new String[]{
                EvaluateFormulaBenchMark.class.getCanonicalName()
        });
        assertTrue(true);

    }
}
