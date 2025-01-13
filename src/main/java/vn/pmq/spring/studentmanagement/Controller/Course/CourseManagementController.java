package vn.pmq.spring.studentmanagement.Controller.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.pmq.spring.studentmanagement.Model.Course;
import vn.pmq.spring.studentmanagement.Model.Mark;
import vn.pmq.spring.studentmanagement.Model.Prerequisite;
import vn.pmq.spring.studentmanagement.Model.Status;
import vn.pmq.spring.studentmanagement.Repository.CourseRepository;
import vn.pmq.spring.studentmanagement.Repository.StatusRepository;
import vn.pmq.spring.studentmanagement.Repository.prerequisiteRepository;
import vn.pmq.spring.studentmanagement.Service.CourseService;
import vn.pmq.spring.studentmanagement.Service.MarkService;
import vn.pmq.spring.studentmanagement.Service.PrerequisiteService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/CourseManagement")
public class CourseManagementController {
    CourseService courseService;
    PrerequisiteService prerequisiteService;
    MarkService markService;

    @Autowired
    public CourseManagementController(CourseService courseService, PrerequisiteService prerequisiteService, MarkService markService) {
        this.courseService = courseService;
        this.prerequisiteService = prerequisiteService;
        this.markService = markService;
    }

    @Autowired
    StatusRepository statusRepository;

    @GetMapping("/CourseList")
    public String getCourseList(Model model) {
        List<Course> ls = courseService.findAll();
        List<Prerequisite> ps = prerequisiteService.findAll();
        model.addAttribute("preList", ps);
        model.addAttribute("courseList", ls);
        //add
        Course course = new Course();
        model.addAttribute("newCourse", course);


        return "Course/CourseManagement";
    }

    @GetMapping("/showMark")
    public String showMark(@RequestParam("cId") int currentId, RedirectAttributes redirectAttributes) {
        Mark MarkByCourseId = markService.findById(currentId);
        redirectAttributes.addFlashAttribute("markList", MarkByCourseId);
        System.out.println(MarkByCourseId);

        return "redirect:/CourseManagement/CourseList";
    }

    @PostMapping("/addCourse")
    public String addCourse(@ModelAttribute("newCourse") Course newCourse, @RequestParam int prerequisiteId) {
        Prerequisite prerequisite = prerequisiteService.findById(prerequisiteId);
        if (prerequisite != null) {
            newCourse.setPrerequisite(prerequisite);
        }
        Status status = statusRepository.findById(1).orElse(null);
        if (status != null) {
            newCourse.setStatus(status);
        }
        courseService.addCourse(newCourse);
        return "redirect:/CourseManagement/CourseList";

    }

    @PostMapping("/updateCourse")
    public String updateCourse(
            @RequestParam("courseId") int courseId,
            @RequestParam("courseCode") String courseCode,
            @RequestParam("courseName") String courseName,
            @RequestParam("numberOfSlots") int numberOfSlots,
            @RequestParam("termNo") int termNo,
            @RequestParam("statusId") int statusId
    ) {
        Course course = courseService.findById(courseId);
        Status status = statusRepository.findById(statusId).orElse(null);
        course.setCourseCode(courseCode);
        course.setCourseName(courseName);
        course.setNumberOfSlots(numberOfSlots);
        course.setTermNo(termNo);
        course.setStatus(status);
        courseService.updateCourse(course);
        return "redirect:/CourseManagement/CourseList";
    }

    @GetMapping("/changeStatusCourse")
    public String changeStatusCourse(@RequestParam("courseId") int currentCourseId, @RequestParam("statusId") Integer statusId) {
        Course course = courseService.findById(currentCourseId);
        Status newStatusId = statusRepository.findById(statusId).orElse(null);
        course.setStatus(newStatusId);
        courseService.updateCourse(course);
        return "redirect:/CourseManagement/CourseList";
    }

    @GetMapping("/updateMark")
    public String updateMark(@RequestParam("CourseId") int CourseId,
                           @RequestParam("PT1") double PT1,
                           @RequestParam("PT2") double PT2,
                           @RequestParam("LAB1") double Lab1,
                           @RequestParam("LAB2") double Lab2,
                           @RequestParam("ASSIGNMENT") double ASSIGNMENT,
                           @RequestParam("PE") double PE,
                           @RequestParam("FE") double FE
    ) {
        Mark mark = markService.findById(CourseId);
        mark.setAssignment(ASSIGNMENT);
        mark.setPt1(PT1);
        mark.setPt2(PT2);
        mark.setLab1(Lab1);
        mark.setLab2(Lab2);
        mark.setPE(PE);
        mark.setFE(FE);
        markService.updateMark(mark);
        return "redirect:/CourseManagement/CourseList";

    }

}
