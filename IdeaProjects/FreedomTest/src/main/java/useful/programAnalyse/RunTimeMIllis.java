package useful.programAnalyse;

public class RunTimeMIllis {
    private final double start;

    public RunTimeMIllis() {
        start = System.currentTimeMillis();
    }

    public double caculateTime(){
        double end = System.currentTimeMillis();
        return end - start;
    }
}
