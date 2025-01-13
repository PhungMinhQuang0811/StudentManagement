package vn.pmq.spring.studentmanagement.Controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.pmq.spring.studentmanagement.Model.*;
import vn.pmq.spring.studentmanagement.Service.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/accounts")
public class AccountManagement {
    private AccountService accountService;
    private ProfileService profileService;
    private StaffService staffService;
    private StudentService studentService;
    private ParentService parentService;
    private RoleService roleService;
    @Autowired
    public AccountManagement(AccountService accountService,ProfileService profileService,StaffService staffService,StudentService studentService,ParentService parentService, RoleService roleService) {
        this.accountService = accountService;
        this.profileService = profileService;
        this.staffService = staffService;
        this.studentService = studentService;
        this.parentService = parentService;
        this.roleService = roleService;
    }
    @GetMapping("/list")
    public String listAccounts(Model model) {
        List<Account> listAccounts = accountService.findAll();
        List<Role> roles = roleService.findAll();
        Account account = new Account();
        model.addAttribute("accounts", listAccounts);
        model.addAttribute("roles", roles);
        //add
        model.addAttribute("newAccount", account);
        return "admin/accountManagement";
    }
    //add
    @PostMapping("/addAccount")
    public String addAccount(@ModelAttribute("newAccount") Account account,
                             @RequestParam("roleIds") List<Integer> roles,
                             @RequestParam("idCard") String idCard,
                             @RequestParam("gender") boolean gender,
                             @RequestParam(value = "position", required = false) String position,
                             @RequestParam(value = "majorStaff", required = false) String majorStaff,
                             @RequestParam(value = "majorStudent", required = false) String majorStudent) {
        // Get the list of roles based on the selected roleIds
        List<Role> roleList = roleService.getRolesByIds(roles);
        account.setUserName(account.getFirstName() + account.getFirstCharOfLastName() + (accountService.getMaxId() + 1));
        account.setRoles(roleList);
        account = accountService.addAccount(account);

        // Create and set profile details
        Profile profile = new Profile();
        profile.setAccount(account);
        profile.setidCard(idCard);
        profile.setGender(gender);
        profileService.addProfile(profile);

        // Check if "Staff" role is selected and process accordingly
        if (roles.contains(2)) { // Role ID for Staff (assumed to be 2)
            // Validate position and majorStaff are not null or empty
            if (position != null && !position.isEmpty()) {
                Staff staff = new Staff();
                staff.setAccount(account);
                staff.setPosition(position);

                // Set the major for Staff
                if (majorStaff != null && !majorStaff.isEmpty()) {
                    staff.setMajor(majorStaff);
                    if ("SE".equals(staff.getMajor())) {
                        staff.setStaffCode("SE" + account.getAccountId());
                    }
                    if("MKT".equals(staff.getMajor())) {
                        staff.setStaffCode("MKT" + account.getAccountId());
                    }
                    staff.setMemberCode(account.getFirstName() + account.getFirstCharOfLastName() + staff.getStaffCode());
                }
                staffService.addStaff(staff);
                account.setStaff(staff);
                accountService.updateAccount(account);
            } else {
                // Handle error or throw exception for missing staff fields
                throw new IllegalArgumentException("Position and Major are required for Staff role.");
            }
        }

        // Check if "Student" role is selected and process accordingly
        if (roles.contains(4)) { // Role ID for Student (assumed to be 3)
            // Validate majorStudent is not null or empty
            if (majorStudent != null && !majorStudent.isEmpty()) {
                Student student = new Student();
                student.setAccount(account);
                student.setMajor(majorStudent);

                if ("SE".equals(student.getMajor())) {
                    student.setstudentCode("SE" + account.getAccountId());
                }
                if("MKT".equals(student.getMajor())) {
                    student.setstudentCode("MKT" + account.getAccountId());
                }
                student.setmemberCode(account.getFirstName() + account.getFirstCharOfLastName() + student.getstudentCode());
                student.setcurrentTermNo("0");
                studentService.addStudent(student);
                account.setStudent(student);
                accountService.updateAccount(account);
            } else {
                // Handle error or throw exception for missing student major
                throw new IllegalArgumentException("Major is required for Student role.");
            }
        }
        if (roles.contains(3)) { // Role ID for Parent (assumed to be 3)
            Parent parent = new Parent();
            parentService.addParent(parent);
            account.setParent(parent);
            accountService.updateAccount(account);
        }

        // Redirect to account management page
        return "redirect:/accounts/list";
    }

    //update
    @PostMapping("/edit")
    public String updateAccount(@RequestParam("accountId") int accountId,
                                @RequestParam("fullName") String fullName,
                                @RequestParam("email") String email,
                                @RequestParam("phone") String phone,
                                @RequestParam("password") String password,
                                @RequestParam("idCard") String idCard,
                                @RequestParam("gender") boolean gender,
                                @RequestParam(value = "position", required = false) String position,
                                @RequestParam(value = "majorStaff", required = false) String majorStaff,
                                @RequestParam(value = "majorStudent", required = false) String majorStudent) {

        Account account = accountService.findById(accountId);

        // Update account details
        account.setFullName(fullName);
        account.setEmail(email);
        account.setPhone(phone);
        account.setPassword(password);
        account = accountService.updateAccount(account);
        Profile profile = profileService.getProfileByAccountId(accountId);
        profile.setAccount(account);
        profile.setidCard(idCard);
        profile.setGender(gender);
        profileService.updateProfile(profile);
        if(account.getStaff() != null) {
            Staff staff = staffService.findByAccountId(accountId);
            staff.setPosition(position);
            if (majorStaff != null && !majorStaff.isEmpty()) {
                staff.setMajor(majorStaff);
                if ("SE".equals(staff.getMajor())) {
                    staff.setStaffCode("SE" + account.getAccountId());
                }
                if("MKT".equals(staff.getMajor())) {
                    staff.setStaffCode("MKT" + account.getAccountId());
                }
                staff.setMemberCode(account.getFirstName() + account.getFirstCharOfLastName() + staff.getStaffCode());
            }
            staffService.updateStaff(staff);
            account.setStaff(staff);
            accountService.updateAccount(account);
        }
        if(account.getStudent() != null) {
            Student student = studentService.findByAccountId(accountId);
            if (majorStudent != null && !majorStudent.isEmpty()) {
                student.setMajor(majorStudent);
                if ("SE".equals(student.getMajor())) {
                    student.setstudentCode("SE" + account.getAccountId());
                }
                if("MKT".equals(student.getMajor())) {
                    student.setstudentCode("MKT" + account.getAccountId());
                }
                student.setmemberCode(account.getFirstName() + account.getFirstCharOfLastName() + student.getstudentCode());
            }
            studentService.updateStudent(student);
            account.setStudent(student);
            accountService.updateAccount(account);
        }

        return "redirect:/accounts/list"; // Redirect to the accounts list or another page
    }
    @GetMapping("/changeStatus")
    public String changeStatus(@RequestParam("id") int acccountId){
        accountService.changeStatus(acccountId);
        return "redirect:/accounts/list";
    }
    @GetMapping("/search")
    public String search(@RequestParam(value = "username", required = false) String username,
                         @RequestParam(value = "idCard", required = false) String idCard,
                         @RequestParam(value = "role", required = false) Integer roleId,Model model) {
        List<Account> listAccounts = new ArrayList<>();
        if(username != null && !username.isEmpty()) {
            listAccounts = accountService.findByUsername(username);
        }
        else if(idCard != null && !idCard.isEmpty()) {
            Account accountSearchIdCard = accountService.findByIdCard(idCard);
            if (accountSearchIdCard != null) {
                listAccounts.add(accountSearchIdCard);
            }
        }
        else if(roleId != null) {
            listAccounts = accountService.findByRole(roleId);
        }

        else{
            listAccounts = accountService.findAll();
        }
        //List<Account> listAccounts = accountService.searchAccounts(username, idCard, roleId);
        List<Role> roles = roleService.findAll();
        Account account = new Account();
        model.addAttribute("accounts", listAccounts);
        model.addAttribute("roles", roles);
        //add
        model.addAttribute("newAccount", account);
        return "admin/accountManagement";
    }
}
