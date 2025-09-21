package Bus_Reservation_System;

public class User {

    private final int  userId;
    private String userName;
    private String idProof;

    public User(int userId, String userName, String idProof) {
        this.userId = userId;
        this.userName = userName;
        this.idProof = idProof;
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

    @Override
    public String toString() {
        return "User { " +
                "userId = " + userId +
                ", userName = '" + userName + '\'' +
                ", IdentityProof = '" + idProof + '\'' +
                " } ";
    }
}

