package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.Entity.QuizResult;
import com.example.demo.Repository.QuizResultRepository;

import java.util.List;

@Controller
public class QuizController {

    @Autowired
    private QuizResultRepository quizResultRepository;

    @GetMapping("/quiz")
    public void showQuizForm(Model model) {
        model.addAttribute("question", "What is the capital of France?");
        model.addAttribute("options", List.of("Berlin", "Madrid", "Paris", "Rome"));
        model.addAttribute("quizResult", new QuizResult());
        model.addAttribute("quizCategories", getQuizCategories());
        model.addAttribute("quizLevels", getQuizLevels());

        return ;
    }

    private List<String> getQuizCategories() {
        // Implement logic to retrieve quiz categories
        return List.of("Category 1", "Category 2", "Category 3");
    }

    private List<String> getQuizLevels() {
        // Implement logic to retrieve quiz levels
        return List.of("Easy", "Medium", "Hard");
    }
    
    
    
    
    @GetMapping("/quiz/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        // Retrieve the QuizResult by id from the database
        QuizResult quizResult = quizResultRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid quiz result id: " + id));

        // Add the quizResult to the model
        model.addAttribute("quizResult", quizResult);

        return "edit"; // Assuming your edit.html template is named "edit.html"
    }

    @PostMapping("/quiz/update")
    public String processUpdateForm(@ModelAttribute("quizResult") QuizResult quizResult) {
        // Perform the update operation, e.g., save the updated quiz result to the database
        quizResultRepository.save(quizResult);

        return "redirect:/result";
    }


    // Delete operation
    @GetMapping("/quiz/delete/{id}")
    public String deleteQuizResult(@PathVariable Long id) {
        quizResultRepository.deleteById(id);
        return "redirect:/result";
    }


    @PostMapping("/quiz")
    public String processQuizForm(@ModelAttribute("quizResult") QuizResult quizResult) {
        quizResultRepository.save(quizResult);
        return "redirect:/result";
    }

    @GetMapping("/result")
    public String showResult(Model model) {
        List<QuizResult> quizResults = quizResultRepository.findAll();
        model.addAttribute("quizResults", quizResults);
        return "result";
    }
}
