package de.konfetti.service;

import java.util.ArrayList;
import java.util.List;

import de.konfetti.data.User;
import de.konfetti.data.UserRepository;
import de.konfetti.utils.Helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseService implements UserService {

    public UserServiceImpl() {
    }

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public User create() {
    	
    	// user gets created
        User user = new User();

        // user gets persisted and returned to user  
        User persited = userRepository.saveAndFlush(user);
        
        // return to caller
        return persited;
        
    }

    @Override
    public User findById(long id) {
    	
    	// gets the one with the given id
        return userRepository.findOne(id);
    
    }

	// TODO improve performance
	@Override
	public User findByClientId(long clientId) {
		Long clientID = new Long(clientId);
		List<User> all = userRepository.findAll();
		for (User user : all) {
			if (user.getClientId().equals(clientID)) return user;
		}
		return null;
	}

	@Override
	public User update(User user) {
		return userRepository.saveAndFlush(user);
	}

	// TODO improve performance
	@Override
	public User findByMail(String mail) {
		if (mail==null) return null;
		List<User> all = userRepository.findAll();
		for (User user : all) {
			if (mail.equals(user.geteMail())) return user;
		}
		return null;
	}

	// TODO improve performance
	@Override
	public List<User> getAllUsersAdminOnParty(Long partyID) {
		List<User> result = new ArrayList<User>();
		List<User> all = userRepository.findAll();
		for (User user : all) {
			if (Helper.contains(user.getAdminOnParties(), partyID)) {
				result.add(user);
			}
		}
		return result;
	}

	// TODO improve performance
	@Override
	public List<User> getAllUsersReviewerOnParty(Long partyID) {
		List<User> result = new ArrayList<User>();
		List<User> all = userRepository.findAll();
		for (User user : all) {
			// add when reviewer
			if (Helper.contains(user.getReviewerOnParties(), partyID)) {
				result.add(user);
				continue;
			}
			// admin = reviewer
			if (Helper.contains(user.getAdminOnParties(), partyID)) {
				result.add(user);
				continue;
			}
		}
		return result;
	}
    
}
