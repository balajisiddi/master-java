package Main;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {

        Stream<String> myStream = Stream.empty();

        IntStream streamOfChars = "abc".chars();

        Stream<String> streamOfStrings = Pattern.compile(", ")
        .splitAsStream("a, b, c");

    }
}
