package controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pojo.Student;
import service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
//
    private StudentService studentService;

    private static final String Cls = "1";
    private static final String NAME = "2";

    @RequestMapping("/list/{pageNum}/{pageSize}")
    @ResponseBody
    public PageInfo list(@PathVariable int pageNum, @PathVariable int pageSize) {
        PageInfo pageInfo = studentService.findStudentList(pageNum,pageSize);
        return pageInfo;
    }

    @RequestMapping("/toStudentPage")
    public String list() {
        return "student";
    }

    @RequestMapping("/add")
    public String toAddPage() {
        return "addStudent";
    }

    @RequestMapping("/insert")
    public String addPaper(Student student) {
        studentService.addStudent(student);
        return "redirect:/student/toStudentPage";
    }

    @RequestMapping("/edit/{id}")
    public String toUpdateStudent(Model model,@PathVariable("id") int id) {
        Student student = studentService.findStudentById(id);
        model.addAttribute("student", student);
        return "updateStudent";
    }

    @RequestMapping("/update")
    public String updateStudent(Student student) {
        studentService.updateStudent(student);
        return "redirect:/student/toStudentPage";
    }

    @RequestMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudentById(id);
        return "redirect:/student/toStudentPage";
    }

    @RequestMapping("/search")
    @ResponseBody
    public PageInfo search(int pageNum, int pageSize, String select, String content) {
        PageInfo pageInfo = null;

        switch (select){
            case Cls:
                pageInfo = studentService.findByClsContaining(pageNum,pageSize,content);
                break;
            case NAME:
                pageInfo = studentService.findByNameContaining(pageNum,pageSize,content);
                break;
        }

        return pageInfo;
    }
}
