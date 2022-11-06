package CheckQuestions;


import main.BrowserChoice;
import org.junit.Rule;
import org.junit.Test;
import PageObject.MainPageSamokat;

public class CheckQuestion {

    @Rule
    public BrowserChoice browserChoice = new BrowserChoice();

    @Test
    public void checkAnswer() {

        MainPageSamokat objCheckAnswerToQuestion = new MainPageSamokat(browserChoice.driver);

        objCheckAnswerToQuestion.open();
        objCheckAnswerToQuestion.checkAnswerToQuestionFirst();
        objCheckAnswerToQuestion.checkAnswerToQuestionTwo();
        objCheckAnswerToQuestion.checkAnswerToQuestionThree();
        objCheckAnswerToQuestion.checkAnswerToQuestionFour();
        objCheckAnswerToQuestion.checkAnswerToQuestionFive();
        objCheckAnswerToQuestion.checkAnswerToQuestionSix();
        objCheckAnswerToQuestion.checkAnswerToQuestionSeven();
        objCheckAnswerToQuestion.checkAnswerToQuestionEight();
    }
}