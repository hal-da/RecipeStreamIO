import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Main {
    private static final Path INGREDIENTPATH = Path.of("ingredient.csv");
    private static final Path OUTPUTPATH = Path.of("output.csv");

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = Files.newBufferedReader(INGREDIENTPATH);
                BufferedWriter bufferedWriter = Files.newBufferedWriter(OUTPUTPATH)) {

            Stream<String> stringStream = bufferedReader.lines();

            Stream<Ingredient> ingredientStream = stringStream
                    .map(line -> line.replaceAll("\\s",""))
                    .filter(RegexMatcher::matchIngredient)
                    .map(line -> line.split(","))
                    .map(arr -> new Ingredient(Integer.parseInt(arr[0]),arr[1],Integer.parseInt(arr[2]),arr[3], arr[4]))
                    .peek(System.out::println);

            bufferedWriter.write(bufferedReader.readLine());
            bufferedWriter.newLine();

            ingredientStream.forEach(ingredient -> {
                try {
                    bufferedWriter.write(ingredient.toString());
                    bufferedWriter.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}