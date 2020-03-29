package Data;

import java.util.ArrayList;

import Person.User;

public interface NewUser {
	User getUser(String fullName);
		ArrayList<User> getUsers();
}
