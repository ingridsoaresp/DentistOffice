package com.example.dentistoffice;

public class Patient {

    private String patId;
    private String passwd;
    private String firstName;
    private String lastName;
    private String addr;
    private String email;
    private String insCo;

    public Patient() {
        this.patId = "";
        this.passwd = "";
        this.firstName = "";
        this.lastName = "";
        this.addr = "";
        this.email = "";
        this.insCo = "";
    }

    public Patient(String patId, String passwd, String firstName, String lastName,
                   String addr, String email, String insCo) {
        this.patId = patId;
        this.passwd = passwd;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addr = addr;
        this.email = email;
        this.insCo = insCo;
    }

    //Getters and Setters
    public String getPatId() {
        return patId;
    }

    public void setPatId(String patId) {
        this.patId = patId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInsCo() {
        return insCo;
    }

    public void setInsCo(String insCo) {
        this.insCo = insCo;
    }

    //Find patient by ID
    public void selectDB(String patId) {

        this.patId = patId;

        String dbPath = "C:/Users/ingri/Desktop/College/JavaIII/DentistOffice/src/main/webapp/WEB-INF/db/DentistOfficeACCDB.accdb";
        String dbUrl = "jdbc:ucanaccess://" + dbPath;

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            java.sql.Connection conn = java.sql.DriverManager.getConnection(dbUrl);

            //Select patient by ID
            String sql = "SELECT * FROM Patients WHERE patId = ?";
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, patId);

            java.sql.ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                this.passwd = rs.getString("passwd");
                this.firstName = rs.getString("firstName");
                this.lastName = rs.getString("lastName");
                this.addr = rs.getString("addr");
                this.email = rs.getString("email");
                this.insCo = rs.getString("insCo");
            }

            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Select patient by name for appointments lookup
    public void selectDBByName(String firstName, String lastName) {

        String dbPath = "C:/Users/ingri/Desktop/College/JavaIII/DentistOffice/src/main/webapp/WEB-INF/db/DentistOfficeACCDB.accdb";
        String dbUrl = "jdbc:ucanaccess://" + dbPath;

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            java.sql.Connection conn = java.sql.DriverManager.getConnection(dbUrl);

            String sql = "SELECT * FROM Patients WHERE firstName = ? AND lastName = ?";
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, firstName);
            ps.setString(2, lastName);

            java.sql.ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                this.patId = rs.getString("patId");
                this.passwd = rs.getString("passwd");
                this.firstName = rs.getString("firstName");
                this.lastName = rs.getString("lastName");
                this.addr = rs.getString("addr");
                this.email = rs.getString("email");
                this.insCo = rs.getString("insCo");
            }

            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Update patient informations
    public void updateDB() {

        String dbPath = "C:/Users/ingri/Desktop/College/JavaIII/DentistOffice/src/main/webapp/WEB-INF/db/DentistOfficeACCDB.accdb";
        String dbUrl = "jdbc:ucanaccess://" + dbPath;

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            java.sql.Connection conn = java.sql.DriverManager.getConnection(dbUrl);

            String sql = "UPDATE Patients SET firstName = ?, lastName = ?, addr = ?, email = ?, insCo = ? WHERE patId = ?";

            java.sql.PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, this.firstName);
            ps.setString(2, this.lastName);
            ps.setString(3, this.addr);
            ps.setString(4, this.email);
            ps.setString(5, this.insCo);
            ps.setString(6, this.patId);

            ps.executeUpdate();

            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void display() {
        System.out.println("Patient:");
        System.out.println("  patId: " + patId);
        System.out.println("  passwd: " + passwd);
        System.out.println("  firstName: " + firstName);
        System.out.println("  lastName: " + lastName);
        System.out.println("  addr: " + addr);
        System.out.println("  email: " + email);
        System.out.println("  insCo: " + insCo);
    }
}