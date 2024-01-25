import java.util.Random;
import java.util.Scanner;

public class RandomSentencesGenerator {
    private String[] names = {"David", "Alice", "John", "Emma", "Tom", "John", "Angelina"};
    private String[] places = {"London", "New York", "Paris", "Tokyo", "Sofia", "Dubai", "Barcelona"};
    private String[] verbs = {"watched", "ran", "ate", "read", "plays with", "builds", "dances with"};
    private String[] nouns = {"sunset", "book", "pizza", "cat", "guitar", "painting", "tomato"};
    private String[] adverbs = {"calmly", "quickly", "happily", "silently", "unexpectedly", "gracefully", "enthusiastically"};
    private String[] details = {"on the rooftop", "under the bridge", "at the cafe", "inside the cave", "during the sunset", "amidst the chaos", "in the enchanted forest"};

    // get a random word
    private String getRandomWord(String[] array) {
        Random random = new Random();
        int index = random.nextInt(array.length);
        return array[index];
    }

    // generate a random sentence
    private String generateRandomSentence() {
        Random random = new Random();
        int sentenceType = random.nextInt(3); // Normal, Question, Complex

        if (sentenceType == 0) {
            // Normal sentence
            String whoFromWhere = getRandomWord(names) + " from " + getRandomWord(places);
            String action = getRandomWord(adverbs) + " " + getRandomWord(verbs);
            String detail = getRandomWord(details);
            String object = getRandomWord(nouns);

            return whoFromWhere + " " + action + " " + object + " " + detail + ".";
        } else if (sentenceType == 1) {
            // Question
            String questionWord = getRandomWord(new String[]{"When", "Where", "Why", "How"});
            String action = getRandomWord(verbs);
            String subject = getRandomWord(names);
            String object = getRandomWord(nouns);

            return questionWord + " does " + subject + " " + action + " the " + object + "?";
        } else {
            // Complex sentence
            String whoFromWhere = getRandomWord(names) + " from " + getRandomWord(places);
            String action = getRandomWord(adverbs) + " " + getRandomWord(verbs) + " " + getRandomWord(nouns);
            String detail = getRandomWord(details);

            String connector = getRandomWord(new String[]{"although", "because", "while"});
            String condition = getRandomWord(new String[]{"it was raining", "the sun was shining", "it started to snow"});

            return whoFromWhere + " " + action + " " + detail + ", " + connector + " " + condition + ".";
        }
    }

    public static void main(String[] args) {
        RandomSentencesGenerator sentenceGenerator = new RandomSentencesGenerator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Random Sentence Generator By Ivelina Ivanova!");

        while (true) {
            String randomSentence = sentenceGenerator.generateRandomSentence();
            System.out.println("Generated Sentence: " + randomSentence);

            System.out.println("\nPress [Enter] to generate a new sentence...");
            scanner.nextLine();
        }
    }
}