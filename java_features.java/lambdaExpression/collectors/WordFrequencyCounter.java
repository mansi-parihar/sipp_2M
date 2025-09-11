package lambdaExpression.collectors;

import java.util.*;
import java.util.stream.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String paragraph = "Java is powerful and Java is versatile";
        String[] words = paragraph.split("\\s+");
        Map<String, Long> wordCount = Arrays.stream(words)
                .collect(Collectors.toMap(
                        word -> word,
                        word -> 1L,
                        Long::sum));
        wordCount.forEach((word, count) -> System.out.println(word + " -> " + count));
    }
}
