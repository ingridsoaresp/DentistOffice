package com.example.dentistoffice;

public class Dentist {

    private String id;
    private String passwd;
    private String firstName;
    private String lastName;
    private String email;
    private String office;

    public Dentist() {
        this.id = "";
        this.passwd = "";
        this.firstName = "";
        this.lastName = "";
        this.email = "";
        this.office = "";
    }

    public Dentist(String id, String passwd, String firstName, String lastName,
                   String email, String office) {
        this.id = id;
        this.passwd = passwd;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.office = office;
    }

    //Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    //Find dentist information ny ID
    public void selectDB(String id) {

        this.id = id;

        String dbPath = "C:/Users/ingri/Desktop/College/JavaIII/DentistOffice/src/main/webapp/WEB-INF/db/DentistOfficeACCDB.accdb";
        String dbUrl = "jdbc:ucanaccess://" + dbPath;

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            java.sql.Connection conn = java.sql.DriverManager.getConnection(dbUrl);

            //Select dentist by ID
            String sql = "SELECT * FROM Dentists WHERE id = ?";
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, id);

            java.sql.ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                this.passwd = rs.getString("passwd");
                this.firstName = rs.getString("firstName");
                this.lastName = rs.getString("lastName");
                this.email = rs.getString("email");
                this.office = rs.getString("office");
            }

            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Update dentist informations
    public void updateDB() {

        String dbPath = "C:/Users/ingri/Desktop/College/JavaIII/DentistOffice/src/main/webapp/WEB-INF/db/DentistOfficeACCDB.accdb";
        String dbUrl = "jdbc:ucanaccess://" + dbPath;

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            java.sql.Connection conn = java.sql.DriverManager.getConnection(dbUrl);

            String sql = "UPDATE Dentists SET firstName = ?, lastName = ?, email = ?, office = ? WHERE id = ?";

            java.sql.PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, this.firstName);
            ps.setString(2, this.lastName);
            ps.setString(3, this.email);
            ps.setString(4, this.office);
            ps.setString(5, this.id);

            ps.executeUpdate();

            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void display() {
        System.out.println("Dentist:");
        System.out.println("  id: " + id);
        System.out.println("  passwd: " + passwd);
        System.out.println("  firstName: " + firstName);
        System.out.println("  lastName: " + lastName);
        System.out.println("  email: " + email);
        System.out.println("  office: " + office);
    }
}