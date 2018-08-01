package Date;

import java.time.Instant;
import java.time.LocalDate;

public class InstantLearning {
    public static void main(String[] args){
        Instant instant = Instant.ofEpochSecond(2,2);
        System.out.println(instant);
    }
}
