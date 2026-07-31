package com.example.dentistoffice;

public class Procedure {

    private String procCode;
    private String procName;
    private String procDesc;
    private double cost;

    public Procedure() {
        this.procCode = "";
        this.procName = "";
        this.procDesc = "";
        this.cost = 0.0;
    }

    public Procedure(String procCode, String procName, String procDesc, double cost) {
        this.procCode = procCode;
        this.procName = procName;
        this.procDesc = procDesc;
        this.cost = cost;
    }

    //Getters and Setters
    public String getProcCode() {
        return procCode;
    }

    public void setProcCode(String procCode) {
        this.procCode = procCode;
    }

    public String getProcName() {
        return procName;
    }

    public void setProcName(String procName) {
        this.procName = procName;
    }

    public String getProcDesc() {
        return procDesc;
    }

    public void setProcDesc(String procDesc) {
        this.procDesc = procDesc;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void selectDB(String procCode) {

        this.procCode = procCode;

        String dbPath = "C:/Users/ingri/Desktop/College/JavaIII/DentistOffice/src/main/webapp/WEB-INF/db/DentistOfficeACCDB.accdb";
        String dbUrl = "jdbc:ucanaccess://" + dbPath;

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            java.sql.Connection conn = java.sql.DriverManager.getConnection(dbUrl);

            String sql = "SELECT * FROM Procedures WHERE procCode = ?";
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, procCode);

            java.sql.ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                this.procName = rs.getString("procName");
                this.procDesc = rs.getString("procDesc");
                this.cost = rs.getDouble("cost");
            }

            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void display() {
        System.out.println("Procedure:");
        System.out.println("  procCode: " + procCode);
        System.out.println("  procName: " + procName);
        System.out.println("  procDesc: " + procDesc);
        System.out.println("  cost: " + cost);
    }
}