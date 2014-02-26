package benchmark.jassist;

import exprtob.function.Function;
import javassist.*;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by andrey on 2/26/14.
 */
public class JAssistOperationsTest {

    @Test
    public void testTimeToImplement() throws CannotCompileException, NotFoundException, IllegalAccessException, InstantiationException {

        long t1 = System.currentTimeMillis();
        ClassPool pool = ClassPool.getDefault();

        CtClass function = pool.makeClass("UserFunction");
        function.addMethod(CtNewMethod.make("protected double evalArray(double[] args){ return (args[1]); }", function) );
        function.setSuperclass(pool.get("exprtob.function.BaseFunction"));

        Class aClass = function.toClass();
        Function o = (Function) aClass.newInstance();

        assertEquals(10., o.eval(0, 10), 0.0001);

        System.out.println("Time to build = " + (System.currentTimeMillis() - t1));
    }


}
