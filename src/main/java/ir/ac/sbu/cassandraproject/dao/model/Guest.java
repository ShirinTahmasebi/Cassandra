package ir.ac.sbu.cassandraproject.dao.model;

public class Guest {

    public String phone;
    public String fname;
    public String lname;
    public String email;

    public Guest(String phone, String fname,
            String lname, String email) {
        this.phone = phone;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
    }

    @Override
    public String toString() {
        return "( '"
                + phone + "', '"
                + fname + "', '"
                + lname + "', '"
                + email + "') ";
    }
}
