package guava_learning;

import com.google.common.collect.ImmutableSet;

import java.util.HashSet;

public class test1 {

    public static final ImmutableSet<String> COLOR = ImmutableSet.of("red","yellow");
    public static void main(String[] args){
        HashSet<String> myhash = new HashSet<>();
        myhash.add("blue");
    }
}
