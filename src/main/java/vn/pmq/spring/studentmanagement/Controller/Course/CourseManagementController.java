package vn.pmq.spring.studentmanagement.Controller.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.pmq.spring.studentmanagement.Model.Course;
import vn.pmq.spring.studentmanagement.Model.Prerequisite;
import vn.pmq.spring.studentmanagement.Model.Status;
import vn.pmq.spring.studentmanagement.Repository.CourseRepository;
import vn.pmq.spring.studentmanagement.Repository.StatusRepository;
import vn.pmq.spring.studentmanagement.Repository.prerequisiteRepository;

import java.util.List;

@Controller
@RequestMapping("/CourseManagement")
public class CourseManagementController {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    prerequisiteRepository prerequisiteRepository;

    @Autowired
    StatusRepository statusRepository;
    @GetMapping("/CourseList")
    public String getCourseList(Model model) {
        List<Course> ls = courseRepository.findAll();
        List<Prerequisite> ps = prerequisiteRepository.findAll();
        model.addAttribute("preList", ps);
        model.addAttribute("courseList", ls);
        //add
        Course course = new Course();
        model.addAttribute("newCourse", course);
        return "Course/CourseManagement";
    }

    @PostMapping("/addCourse")
    public String addCourse(@ModelAttribute("newCourse") Course course, @RequestParam Long prerequisiteId) {
        Prerequisite prerequisite = prerequisiteRepository.findById(prerequisiteId).orElse(null);
        if (prerequisite != null) {
            course.setPrerequisite(prerequisite);
        }
    Status status = statusRepository.findById(1).orElse(null);
        if (status != null) {
            course.setStatus(status);
        }
        courseRepository.save(course);
        return "redirect:/CourseManagement/CourseList";

    }

    @PostMapping("/updateCourse")
    public String updateCourse(
            @RequestParam("courseId") Long courseId,
            @RequestParam("courseCode") String courseCode,
            @RequestParam("courseName") String courseName,
            @RequestParam("numberOfSlots") int numberOfSlots,
            @RequestParam("termNo") int termNo,
            @RequestParam("statusId") int statusId
    ) {
        Course course = courseRepository.findById(courseId).orElse(null);
        Status status = statusRepository.findById(statusId).orElse(null);
        course.setCourseCode(courseCode);
        course.setCourseName(courseName);
        course.setNumberOfSlots(numberOfSlots);
        course.setTermNo(termNo);
        course.setStatus(status);
        courseRepository.save(course);
        return "redirect:/CourseManagement/CourseList";
    }

    @GetMapping("/deleteCourse")
    public String changeStatusCourse(@RequestParam("courseId") Long currentCourseId,@RequestParam("statusId") Integer statusId) {
        Course course = courseRepository.findById(currentCourseId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid course Id:" + currentCourseId));
        Status newStatusId = statusRepository.findById(statusId).orElse(null);
        course.setStatus(newStatusId);
        courseRepository.save(course);
        return "redirect:/CourseManagement/CourseList";
    }
}
