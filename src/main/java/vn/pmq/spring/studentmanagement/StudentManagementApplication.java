package vn.pmq.spring.studentmanagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.pmq.spring.studentmanagement.Model.Account;
import vn.pmq.spring.studentmanagement.Repository.AccountRepository;
import vn.pmq.spring.studentmanagement.Repository.StaffRepository;
import vn.pmq.spring.studentmanagement.Service.AccountService;
import vn.pmq.spring.studentmanagement.Service.AccountServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
public class StudentManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(AccountServiceImpl accountService, AccountRepository accountRepository, StaffRepository staffRepository) {
        return runner ->{
//            Account account = new Account("QuangPM1","123","phungminhquang081104@gmail.com","0886980035","Phung Minh Quang");
//            for(Object[] obj : accountRepository.findRoleIdsByAccountId(1)){
//                System.out.println("Account ID: " + obj[0] + ", Role ID: " + obj[1]);
//            }
//            System.out.println(account.getFirstName() + account.getFirstCharOfLastName() + (account.getAccountId()+1));
//            System.out.println(accountService.findByUsernameContaining("quanht"));
//            List<Integer> listRoles = new ArrayList<>();
//            listRoles.add(1);
//            listRoles.add(2);
//            accountService.addRoles(1,listRoles);
            System.out.println(accountService.findByUsername("quangpm1"));
        };
    }

}
