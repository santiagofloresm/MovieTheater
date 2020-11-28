package Registration;

public class ManageLogin {

    private User user;
    //    private LoginGUI loginGUI;
    private UserSystem userSystem;

    public ManageLogin(User user, UserSystem userSystem) {
        setUser(user);
        setUserSystem(userSystem);
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUserSystem(UserSystem userSystem) {
        this.userSystem = userSystem;
    }
}
