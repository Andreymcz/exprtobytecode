package benchmark.formula;

import com.graphbuilder.math.VarMap;

/**
 * Created by andrey on 2/26/14.
 */
public enum Formula {
    SIMPLE("100-20*x",
            "x"),

    XY_SUM("x+y",
            "x","y"),

    XY_SIN_COS("sin(x+y) * cos(x*y)",
            "x","y"),

    XY_ABS("abs(x-y)",
            "x","y"),

    XYZ_SQRT("z*sqrt(x*x + y*y)",
            "x","y","z")
    ;

    private String formula;
    private String[] vars;
    private double[] args;

    Formula(String formula, String... vars){
        this.formula = formula;
        this.vars = vars;
        this.args = new double[vars.length];
    }

    public String getFormula(){
        return formula;
    }

    public String[] getVariables(){
        return vars;
    }

    public double[] buildArgs(int i){
        for (int j = 0; j < vars.length; j++) {
            args[j] = i+j;
        }
        return args;
    }

    public void buildArgs(VarMap vm, int i) {
        for (int j = 0; j < vars.length; j++) {
            vm.setValue(vars[j], i+j);
        }
    }

}
