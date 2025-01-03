package vn.pmq.spring.studentmanagement.Service;

import org.springframework.stereotype.Service;
import vn.pmq.spring.studentmanagement.Model.Profile;
import vn.pmq.spring.studentmanagement.Repository.ProfileRepository;

import java.util.List;


public interface ProfileService {
    public List<Profile> getProfiles();
    public Profile addProfile(Profile profile);
}
