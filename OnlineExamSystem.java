import java.util.*;

// Question Class
class Question {
    private String question;
    private String answer;

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public boolean checkAnswer(String userAns) {
        return answer.equalsIgnoreCase(userAns);
    }

    public String getQuestion() {
        return question;
    }
}

// Exam Class
class Exam {
    private ArrayList<Question> questions = new ArrayList<>();

    public void addQuestion(Question q) {
        questions.add(q);
    }

    public void startExam() {
        Scanner sc = new Scanner(System.in);
        int score = 0;

        System.out.println("\n===== EXAM STARTED =====");

        for (Question q : questions) {
            System.out.println(q.getQuestion());
            String ans = sc.nextLine();

            if (q.checkAnswer(ans)) {
                score++;
            }
        }

        System.out.println("\n===== RESULT =====");
        System.out.println("Score: " + score + "/" + questions.size());

        double percentage = (score * 100.0) / questions.size();

        if (percentage >= 75) {
            System.out.println("Result: PASS");
        } else {
            System.out.println("Result: FAIL");
        }
    }
}

// Main Class
public class OnlineExamSystem {
    public static void main(String[] args) {
        Exam exam = new Exam();

        // Adding questions
        exam.addQuestion(new Question("Capital of India?", "Delhi"));
        exam.addQuestion(new Question("5 + 3 = ?", "8"));
        exam.addQuestion(new Question("Java is platform independent? (yes/no)", "yes"));

        exam.startExam();
    }
}