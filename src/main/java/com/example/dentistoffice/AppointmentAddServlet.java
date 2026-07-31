package com.example.dentistoffice;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AppointmentAddServlet")
public class AppointmentAddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String apptDateTime = request.getParameter("apptDateTime");
        String patId = request.getParameter("patId");
        String dentId = request.getParameter("dentId");
        String procCode = request.getParameter("procCode");

        //Create new appointment
        Appointment a = new Appointment();

        //Check if patient has an appointment
        if (a.patientHasAppointment(patId)) {
            request.setAttribute("errorMessage", "This patient already has an appointment scheduled.");

            RequestDispatcher rd = request.getRequestDispatcher("/addAppointment.jsp");

            try {
                rd.forward(request, response);
            } catch (Exception e) {
                throw new IOException(e);
            }

            return;
        }

        //Check if dentist has appointment
        if (a.dentistHasAppointment(dentId, apptDateTime)) {
            request.setAttribute("errorMessage", "This dentist already has an appointment scheduled at this date and time.");

            RequestDispatcher rd = request.getRequestDispatcher("/addAppointment.jsp");

            try {
                rd.forward(request, response);
            } catch (Exception e) {
                throw new IOException(e);
            }

            return;
        }

        a.setApptDateTime(apptDateTime);
        a.setPatId(patId);
        a.setDentId(dentId);
        a.setProcCode(procCode);

        //Add appointment do database
        a.addDB();

        HttpSession session = request.getSession();
        session.setAttribute("appointment", a);

        RequestDispatcher rd = request.getRequestDispatcher("/DisplayAppointment.jsp");

        try {
            rd.forward(request, response);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}