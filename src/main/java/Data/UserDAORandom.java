package Data;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import Person.User;

public class UserDAORandom implements NewUser {
	private File userFile = null;

	RandomAccessFile in = null;
	RandomAccessFile out = null;
	
	private int count;

	public UserDAORandom() {
		userFile = new File("users.dat"); //there is
	}

//	private void checkFile() throws IOException {
//		if (!userFile.exists()) {
//			userFile.createNewFile();
//		}
//	}

//	private boolean saveUsers(ArrayList<User> users) {
//		DataOutputStream out = null;
//		try {
//			this.checkFile();
//			out = new DataOutputStream(new FileOutputStream(userFile));
//			for (User u : users) {
//				out.writeUTF(u.getFullName());
//				out.writeInt(u.getId());
//				out.writeChar(u.getRights());
//				out.writeUTF(u.getEmail());
//				out.writeUTF(u.getPassword());
//				out.writeUTF(u.getGender());
//				out.writeUTF(u.getPostalc());
//				out.writeUTF(u.getStreet());
//				out.writeInt(u.getPhoneNumber());
//			}
//		} catch (IOException ioe) {
//			ioe.printStackTrace();
//			return false;
//		}
//		return true;
//	}

//	private void close(Closeable stream) {
//		try {
//			if (stream != null) {
//				stream.close();
//			}
//		} catch (IOException ioe) {
//			ioe.printStackTrace();
//		}
//	}

	private String readString(DataInput in, int length) throws IOException {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			char c = in.readChar();
			if (c != 0)
				sb.append(c);
		}
		return sb.toString();
	}

	private void writeString(DataOutput out, int length, String s) throws IOException {
		for (int i = 0; i < length; i++) {
			if (i < s.length()) {
				out.writeChar(s.charAt(i));
			} else
				out.writeChar(0);
		}
	}

	public User getUser(String fullName) { 
		int i = Integer.parseInt(fullName);
		try {
			in = new RandomAccessFile(userFile, "rw");
			count = (int) in.length() / 25;
			if (i <= count) {
				in.seek((i - 1) * 25);
				User u = new User(readString(in, 25), in.readInt(), in.readChar(), readString(in, 25),
						readString(in, 25), readString(in, 25), readString(in, 25), readString(in, 25), in.readInt());
				return u;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public ArrayList<User> getUsers() { 
		RandomAccessFile in = null;
		ArrayList<User> users = new ArrayList<User>();
		try {
			in = new RandomAccessFile(userFile, "rw");
			int count = (int) in.length() / 25;
			for (int i = 0; i < count; i++) {
				in.seek(i * 25);
				User u = new User(readString(in, 25), in.readInt(), in.readChar(), readString(in, 25),
						readString(in, 25), readString(in, 25), readString(in, 25), readString(in, 25), in.readInt());
				users.add(u);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return users;
	}

	public boolean addUser(User u) { 
		boolean success = false;
		try {
			in = new RandomAccessFile(userFile, "rw");
			int count = (int) in.length() / 25;
			in.seek(count * 25);
			writeString(in, 25, u.getFullName());
			in.writeInt(u.getId());
			in.writeChar(u.getRights());
			writeString(in, 25, u.getEmail());
			writeString(in, 25, u.getPassword());
			writeString(in, 25, u.getStreet());
			writeString(in, 25, u.getGender());
			writeString(in, 25, u.getPostalc());
			in.writeInt(u.getPhoneNumber());
			success = true;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return success;

	}
}
