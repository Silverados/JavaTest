package useful.programAnalyse;

public class RunTimeNano {
    private final double start;

    public RunTimeNano() {
        start = System.nanoTime();
    }

    public double caculateTime(){
        double end = System.nanoTime();
        return end - start;
    }
}
