package com.example.dentistoffice;

import java.util.ArrayList;

public class AppointmentList {

    private ArrayList<Appointment> appointments;
    private int count;

    public AppointmentList() {
        appointments = new ArrayList<>();
        count = 0;
    }

    public void add(Appointment a) {
        appointments.add(a);
        count++;
    }

    public Appointment get(int index) {
        return appointments.get(index);
    }

    public int getCount() {
        return count;
    }

    public void selectDBByDentist(String dentId) {

        String dbPath = "C:/Users/ingri/Desktop/College/JavaIII/DentistOffice/src/main/webapp/WEB-INF/db/DentistOfficeACCDB.accdb";
        String dbUrl = "jdbc:ucanaccess://" + dbPath;

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            java.sql.Connection conn = java.sql.DriverManager.getConnection(dbUrl);

            String sql = "SELECT * FROM Appointments WHERE dentId = ?";
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, dentId);

            java.sql.ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Appointment a = new Appointment();

                a.setApptDateTime(rs.getString("apptDateTime"));
                a.setPatId(rs.getString("patId"));
                a.setDentId(rs.getString("dentId"));
                a.setProcCode(rs.getString("procCode"));

                Procedure proc = new Procedure();
                proc.selectDB(a.getProcCode());

                a.setProc(proc);

                add(a);
            }

            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void display() {
        System.out.println("AppointmentList:");
        System.out.println("Count: " + count);

        for (int i = 0; i < count; i++) {
            appointments.get(i).display();
        }
    }
}