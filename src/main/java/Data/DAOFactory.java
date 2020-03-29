package Data;

public class DAOFactory {
	public static UserDAORandom getUserDAO() {
		UserDAORandom uDAO = new UserDAORandom();
		return uDAO;
	}
}
