package adventofcode.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileDetection {

    public static List<Path> listFiles(Path folder, Predicate<String> nameFilter) {
        return detectedFiles(folder, nameFilter).collect(Collectors.toList());
    }

    private static Stream<Path> detectedFiles(Path folder, Predicate<String> nameFilter) {
        try {
            return Files.walk(folder, 1)
                    .filter(path -> path.toFile().isFile())
                    .filter(path -> nameFilter.test(path.getFileName().toString()))
                    .sorted(Comparator.comparing(path -> path.getFileName().toString().toUpperCase()));
        } catch (IOException e) {
            return Stream.empty();
        }
    }
}
