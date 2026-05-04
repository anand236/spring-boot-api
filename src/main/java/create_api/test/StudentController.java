package create_api.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    //Get all student
    @GetMapping
    public List<Student> getAll(){
        return studentService.getAllStudent();
    }

    // Get by id
    @GetMapping("/{id}")
    public Student getById(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    //POST add student
    @PostMapping
    public Student save(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @DeleteMapping("/{id}")
    public Map<String, String> deleteById(@PathVariable int id){
        studentService.deleteStudent(id);
        return Map.of("message","Deleted Successfully!");
    }

    @GetMapping("/paged")
    public Page<Student> getPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ){
        return studentService.getPagedStudent(page, size);
    }
}
