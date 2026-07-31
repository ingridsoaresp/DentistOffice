package com.example.dentistoffice;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AppointmentUpdateServlet")
public class AppointmentUpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();

        Appointment a = (Appointment) session.getAttribute("appointment");

        if (a != null) {

            String oldApptDateTime = a.getApptDateTime();

            a.setApptDateTime(request.getParameter("apptDateTime"));
            a.setPatId(request.getParameter("patId"));
            a.setDentId(request.getParameter("dentId"));
            a.setProcCode(request.getParameter("procCode"));

            a.updateDB(oldApptDateTime);

            session.setAttribute("appointment", a);
        }

        RequestDispatcher rd = request.getRequestDispatcher("/DisplayAppointment.jsp");

        try {
            rd.forward(request, response);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}