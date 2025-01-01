package vn.pmq.spring.studentmanagement.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "parent")
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parent_id")
    private int parentId;
    @Column(name = "address",length = 256)
    private String address;
    @Column(name = "job",length = 25)
    private String job;
    @Column(name = "place_of_work",length = 256)
    private String placeOfWork;
    @OneToOne(mappedBy = "parent",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private Account account;
    @OneToMany(mappedBy = "parent",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private List<Student> students;

    public Parent(int parentId, String address, String job, String placeOfWork) {
        this.parentId = parentId;
        this.address = address;
        this.job = job;
        this.placeOfWork = placeOfWork;
    }

    public Parent() {
    }

    public int getparentId() {
        return parentId;
    }

    public void setparentId(int parentId) {
        this.parentId = parentId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getplaceOfWork() {
        return placeOfWork;
    }

    public void setplaceOfWork(String placeOfWork) {
        this.placeOfWork = placeOfWork;
    }
}
