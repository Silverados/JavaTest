package stream_learning;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.stream.Stream;

public class CreatingStreams {

    public static void main(String[] args){
        //Collection调用stream(),parallelStream()创建Stream
        Stream<String> colle = new ArrayList<String>().stream();
        //调用static<T> Stream<T> of(T... values)本质上调用：Arrays.stream(values)
        Stream<String> character = Stream.of("a","b","c");
        //构建空的Stream
        Stream<String> silence = Stream.empty();
        //常量Stream
        Stream<String> echos = Stream.generate(() -> "Echo");
        //随机数Stream
        Stream<Double> randoms = Stream.generate(Math::random);
        //无限Stream
        Stream<BigInteger> integers = Stream.iterate(BigInteger.ONE, n -> n.add(BigInteger.ONE));

    }
}
