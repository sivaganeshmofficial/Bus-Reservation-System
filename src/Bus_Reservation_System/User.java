package Bus_Reservation_System;

public class User {

    private final int  userId;
    private String userName;
    private String idProof;
    private String password;

    public User(int userId, String userName, String idProof,String password) {
        this.userId = userId;
        this.userName = userName;
        this.idProof = idProof;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIdProof() {
        return idProof;
    }

    public void setIdProof(String proof) {
        this.idProof = proof;
    }

    public String getPassword() {
        return password;
    }

    public boolean validatePassword(String inpPassword) {
        return this.password.equals(inpPassword);
    }

    @Override
    public String toString() {
        return "User { " +
                "userId = " + userId +
                ", userName = '" + userName + '\'' +
                ", IdentityProof = '" + idProof + '\'' +
                " } ";
    }
}

