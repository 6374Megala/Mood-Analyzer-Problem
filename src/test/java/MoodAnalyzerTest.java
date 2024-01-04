import org.example.MoodAnalysisError;
import org.example.MoodAnalysisException;
import org.example.MoodAnalyzer;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class MoodAnalyzerTest {

    @Test
   public  void givenSadMoodInConstructor_ShouldReturnSAD() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);

        try {
            String mood  = moodAnalyzer.analyseMood();
        } catch (MoodAnalysisException e) {
            System.out.println(e.getMessage());
        }

    }
    @Test
    public void givenHappyMoodInConstructor_ShouldReturnHAPPY_WhenNoParams() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();

        try {
            String mood = moodAnalyzer.analyseMood();
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void givenSadMood_ShouldReturnSAD() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in Sad Mood");

        try {
            String mood = moodAnalyzer.analyseMood();
            Assert.assertEquals("SAD", mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void givenHappyMood_ShouldReturnHAPPY() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in Happy Mood");

        try {
           String mood = moodAnalyzer.analyseMood();
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }

    }

    @Test
   public  void givenAnyMood_ShouldReturnHAPPY() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in Any Mood");

        try {
           String mood = moodAnalyzer.analyseMood();
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void givenNullMessage_ShouldThrowMoodAnalysisExceptionWithNullMoodError() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
        try {
            String mood = moodAnalyzer.analyseMood();

        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisError.NULL_MOOD, e.getError());
            Assert.assertEquals("Message is null", e.getMessage());
        }
    }

    @Test
    public void givenEmptyMessage_ShouldThrowMoodAnalysisExceptionWithEmptyMoodError() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("");
        try {
            String mood = moodAnalyzer.analyseMood();

        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisError.EMPTY_MOOD, e.getError());
            Assert.assertEquals("Message is empty", e.getMessage());
        }
    }

    @Test
    public void givenInvalidMood_ShouldThrowMoodAnalysisExceptionWithInvalidMoodError() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in Confused Mood");
        try {
            String mood = moodAnalyzer.analyseMood();

        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisError.INVALID_MOOD, e.getError());
            Assert.assertEquals("Invalid mood", e.getMessage());
        }
    }
    @Test
    public void givenNullMessage_ShouldThrowMoodAnalysisExceptionWithNullMoodError1() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
        assertThrows(MoodAnalysisException.class, () -> {
            moodAnalyzer.analyseMood();
        });
    }

    @Test
    public void givenEmptyMessage_ShouldThrowMoodAnalysisExceptionWithEmptyMoodError1() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("");
        MoodAnalysisException exception = assertThrows(MoodAnalysisException.class, () -> {
            moodAnalyzer.analyseMood();
        });

        Assert.assertEquals(MoodAnalysisError.EMPTY_MOOD, exception.getError());
        Assert.assertEquals("Message is empty", exception.getMessage());
    }


}
