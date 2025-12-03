package Main;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {
    private static long counter = 0;
    private static void wasCalled() {
        counter++;
    }
    public static void main(String[] args) {

        Stream<String> myStream = Stream.empty();

        IntStream streamOfChars = "abc".chars();

        Stream<String> streamOfStrings = Pattern.compile(", ")
        .splitAsStream("a, b, c");
            
        Optional<String> firstElement= streamOfStrings.findFirst();

        Stream<String> stream = Stream.of("a", "b", "c").filter(s-> s.contains("b"));

        Optional<String> anyElement = stream.findAny();

        Stream.of(1,2,3,4,5).skip(1).map(n -> n +1).forEach(System.out::println);

        List<String> list = Arrays.asList("a", "b", "c");
        list.stream().filter(s-> {
            wasCalled();
            return s.contains("b");
        });
    }
}
