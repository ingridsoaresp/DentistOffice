package com.example.dentistoffice;

public class Appointment {

    //Appointment properties
    private String apptDateTime;
    private String patId;
    private String dentId;
    private String procCode;
    private Procedure proc;

    public Appointment() {
        this.apptDateTime = "";
        this.patId = "";
        this.dentId = "";
        this.procCode = "";
        this.proc = new Procedure();
    }

    public Appointment(String apptDateTime, String patId, String dentId, String procCode) {
        this.apptDateTime = apptDateTime;
        this.patId = patId;
        this.dentId = dentId;
        this.procCode = procCode;
        this.proc = new Procedure();
    }

    //Getters and Setters
    public String getApptDateTime() {

        return apptDateTime;
    }

    public void setApptDateTime(String apptDateTime) {
        this.apptDateTime = apptDateTime;
    }

    public String getPatId() {

        return patId;
    }

    public void setPatId(String patId) {

        this.patId = patId;
    }

    public String getDentId() {

        return dentId;
    }

    public void setDentId(String dentId) {
        this.dentId = dentId;
    }

    public String getProcCode() {

        return procCode;
    }

    public void setProcCode(String procCode) {

        this.procCode = procCode;
    }

    public Procedure getProc() {
        return proc;
    }

    public void setProc(Procedure proc) {
        this.proc = proc;
    }

    //Find appointment by date and time
    public void selectDB(String apptDateTime) {

        this.apptDateTime = apptDateTime;

        String dbPath = "C:/Users/ingri/Desktop/College/JavaIII/DentistOffice/src/main/webapp/WEB-INF/db/DentistOfficeACCDB.accdb";
        String dbUrl = "jdbc:ucanaccess://" + dbPath;

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            java.sql.Connection conn = java.sql.DriverManager.getConnection(dbUrl);

            String sql = "SELECT * FROM Appointments WHERE apptDateTime = ?";
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, apptDateTime);

            java.sql.ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                this.patId = rs.getString("patId");
                this.dentId = rs.getString("dentId");
                this.procCode = rs.getString("procCode");

                this.proc = new Procedure();
                this.proc.selectDB(this.procCode);
            }

            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Find appointment by patient ID
    public void selectDBByPatId(String patId) {

        this.patId = patId;

        String dbPath = "C:/Users/ingri/Desktop/College/JavaIII/DentistOffice/src/main/webapp/WEB-INF/db/DentistOfficeACCDB.accdb";
        String dbUrl = "jdbc:ucanaccess://" + dbPath;

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            java.sql.Connection conn = java.sql.DriverManager.getConnection(dbUrl);

            String sql = "SELECT * FROM Appointments WHERE patId = ?";
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, patId);

            java.sql.ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                this.apptDateTime = rs.getString("apptDateTime");
                this.dentId = rs.getString("dentId");
                this.procCode = rs.getString("procCode");

                this.proc = new Procedure();
                this.proc.selectDB(this.procCode);
            }

            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Update appointment at database
    public void updateDB(String oldApptDateTime) {

        String dbPath = "C:/Users/ingri/Desktop/College/JavaIII/DentistOffice/src/main/webapp/WEB-INF/db/DentistOfficeACCDB.accdb";
        String dbUrl = "jdbc:ucanaccess://" + dbPath;

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            java.sql.Connection conn = java.sql.DriverManager.getConnection(dbUrl);

            String sql = "UPDATE Appointments SET apptDateTime = ?, patId = ?, dentId = ?, procCode = ? WHERE apptDateTime = ?";

            java.sql.PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, this.apptDateTime);
            ps.setString(2, this.patId);
            ps.setString(3, this.dentId);
            ps.setString(4, this.procCode);
            ps.setString(5, oldApptDateTime);

            ps.executeUpdate();

            conn.close();

            this.proc = new Procedure();
            this.proc.selectDB(this.procCode);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Add appointment
    public void addDB() {

        String dbPath = "C:/Users/ingri/Desktop/College/JavaIII/DentistOffice/src/main/webapp/WEB-INF/db/DentistOfficeACCDB.accdb";
        String dbUrl = "jdbc:ucanaccess://" + dbPath;

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            java.sql.Connection conn = java.sql.DriverManager.getConnection(dbUrl);

            String sql = "INSERT INTO Appointments (apptDateTime, patId, dentId, procCode) VALUES (?, ?, ?, ?)";

            java.sql.PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, this.apptDateTime);
            ps.setString(2, this.patId);
            ps.setString(3, this.dentId);
            ps.setString(4, this.procCode);

            ps.executeUpdate();

            conn.close();

            this.proc = new Procedure();
            this.proc.selectDB(this.procCode);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Delete appointment
    public void deleteDB() {

        String dbPath = "C:/Users/ingri/Desktop/College/JavaIII/DentistOffice/src/main/webapp/WEB-INF/db/DentistOfficeACCDB.accdb";
        String dbUrl = "jdbc:ucanaccess://" + dbPath;

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            java.sql.Connection conn = java.sql.DriverManager.getConnection(dbUrl);

            String sql = "DELETE FROM Appointments WHERE apptDateTime = ?";

            java.sql.PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, this.apptDateTime);

            ps.executeUpdate();

            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Check if patient has an appointment
    public boolean patientHasAppointment(String patId) {

        boolean found = false;

        String dbPath = "C:/Users/ingri/Desktop/College/JavaIII/DentistOffice/src/main/webapp/WEB-INF/db/DentistOfficeACCDB.accdb";
        String dbUrl = "jdbc:ucanaccess://" + dbPath;

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            java.sql.Connection conn = java.sql.DriverManager.getConnection(dbUrl);

            String sql = "SELECT * FROM Appointments WHERE patId = ?";
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, patId);

            java.sql.ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                found = true;
            }

            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return found;
    }

    //Check dentist appointments
    public boolean dentistHasAppointment(String dentId, String apptDateTime) {

        boolean found = false;

        String dbPath = "C:/Users/ingri/Desktop/College/JavaIII/DentistOffice/src/main/webapp/WEB-INF/db/DentistOfficeACCDB.accdb";
        String dbUrl = "jdbc:ucanaccess://" + dbPath;

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            java.sql.Connection conn = java.sql.DriverManager.getConnection(dbUrl);

            String sql = "SELECT * FROM Appointments WHERE dentId = ? AND apptDateTime = ?";
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, dentId);
            ps.setString(2, apptDateTime);

            java.sql.ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                found = true;
            }

            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return found;
    }

    //Display informations
    public void display() {
        System.out.println("Appointment:");
        System.out.println("  apptDateTime: " + apptDateTime);
        System.out.println("  patId: " + patId);
        System.out.println("  dentId: " + dentId);
        System.out.println("  procCode: " + procCode);

        if (proc != null) {
            System.out.println("Procedure Details:");
            proc.display();
        }
    }
}