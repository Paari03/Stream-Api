import java.util.*;
import java.util.stream.Collectors;

public class Stream {
        public static void main(String[] args) {
            List<String> names = Arrays.asList(
                    "Reflection", "Collection", "Stream",
                    "Structure", "Sorting", "State"
            );

            names.stream().collect(Collectors.toList())
                    .forEach(n ->System.out.print(n + " "));
            System.out.println();
            System.out.println();

            names.stream().sorted()
                    .filter(name -> name.startsWith("S"))
                    .forEach(System.out::println);
            System.out.println();

            names.stream().map(String::toUpperCase).forEach(n -> System.out.print(n + " "));
            System.out.println();

            System.out.println(names.stream().anyMatch(name -> name.startsWith("S")));

            System.out.println(names.stream().allMatch(name -> name.startsWith("S")));

            System.out.println(names.stream().count());

            System.out.println(names.stream().findFirst());

            System.out.println(names.stream().sorted().findFirst());

            System.out.println(names.stream().reduce((string,remaining) -> string + " " + remaining));
        }
 }
