package vn.pmq.spring.studentmanagement.Controller.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.pmq.spring.studentmanagement.Model.Course;
import vn.pmq.spring.studentmanagement.Model.Prerequisite;
import vn.pmq.spring.studentmanagement.Repository.CourseRepository;
import vn.pmq.spring.studentmanagement.Repository.prerequisiteRepository;

import java.util.List;

@Controller
@RequestMapping("/CourseManagement")
public class CourseManagementController {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    prerequisiteRepository prerequisiteRepository;

    @GetMapping("/CourseList")
    public String getCourseList(Model model) {
        List<Course> ls = courseRepository.findAll();
        List<Prerequisite> ps = prerequisiteRepository.findAll();
        model.addAttribute("preList", ps);
        model.addAttribute("courseList", ls);
        return "Course/CourseManagement";
    }

    @GetMapping("/addCourse")
    public String addCourse(@ModelAttribute Course course, @RequestParam Long prerequisiteId) {
        Prerequisite prerequisite = prerequisiteRepository.findById(prerequisiteId).orElse(null);
        courseRepository.save(course);
        if (prerequisite != null) {
            course.setPrerequisite(prerequisite);
        }
        courseRepository.save(course);
        return "redirect:/CourseManagement/CourseList";

    }

    @GetMapping("/updateCourse")
    public String updateCourse(@ModelAttribute Course course) {
        courseRepository.save(course);
        return "redirect:/CourseManagement/CourseList";
    }

    @GetMapping("/deleteCourse")
    public String deleteCourse(@ModelAttribute Course course) {
        courseRepository.delete(course);
        return "redirect:/CourseManagement/CourseList";
    }
}
