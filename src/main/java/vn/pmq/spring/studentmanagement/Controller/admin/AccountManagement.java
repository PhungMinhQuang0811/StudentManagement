package vn.pmq.spring.studentmanagement.Controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.pmq.spring.studentmanagement.DAO.AccountDAO;
import vn.pmq.spring.studentmanagement.Model.Account;
import vn.pmq.spring.studentmanagement.Model.Role;
import vn.pmq.spring.studentmanagement.Service.AccountService;
import vn.pmq.spring.studentmanagement.Service.RoleService;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/accounts")
public class AccountManagement {
    private AccountService accountService;
    private AccountDAO accountDAO;
    private RoleService roleService;
    @Autowired
    public AccountManagement(AccountService accountService,AccountDAO accountDAO, RoleService roleService) {
        this.accountService = accountService;
        this.accountDAO = accountDAO;
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
    public String addAccount(@ModelAttribute("newAccount") Account account,@RequestParam("roleId") int roleId) {
        Role role = roleService.findById(roleId);
        account.setRoles(Collections.singletonList(role));
        account.setUserName(account.getFirstName() + account.getFirstCharOfLastName() + (accountDAO.getMaxId()+1));
        accountService.addAccount(account);
        return "redirect:/accounts/list"; // Redirect to account management page
    }
    //update
    @PostMapping("/edit")
    public String updateAccount(@RequestParam("accountId") int accountId,
                                @RequestParam("roleIds") List<Integer> roleIds,
                                @RequestParam("fullName") String fullName,
                                @RequestParam("email") String email,
                                @RequestParam("phone") String phone,
                                @RequestParam("password") String password) {

        Account account = accountService.findById(accountId);

        // Update account details
        account.setFullName(fullName);
        account.setEmail(email);
        account.setPhone(phone);
        account.setPassword(password);

        List<Role> selectedRoles = roleService.getRolesByIds(roleIds);

        account.setRoles(selectedRoles);

        accountService.updateAccount(account);

        return "redirect:/accounts/list"; // Redirect to the accounts list or another page
    }
    @GetMapping("/changeStatus")
    public String changeStatus(@RequestParam("id") int acccountId){
        accountService.changeStatus(acccountId);
        return "redirect:/accounts/list";
    }
}
