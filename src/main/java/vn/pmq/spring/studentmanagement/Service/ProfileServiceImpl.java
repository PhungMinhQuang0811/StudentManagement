package vn.pmq.spring.studentmanagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.pmq.spring.studentmanagement.Model.Profile;
import vn.pmq.spring.studentmanagement.Repository.ProfileRepository;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {
    private ProfileRepository profileRepository;
    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public List<Profile> getProfiles() {
        return profileRepository.findAll();
    }

    @Override
    public Profile addProfile(Profile profile) {
        return profileRepository.save(profile);
    }
}