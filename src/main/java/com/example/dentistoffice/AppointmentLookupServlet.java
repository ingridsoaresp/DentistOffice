package com.example.dentistoffice;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AppointmentLookupServlet")
public class AppointmentLookupServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("appointmentLookup.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        Patient p1 = new Patient();

        if (firstName != null && lastName != null &&
                !firstName.isBlank() && !lastName.isBlank()) {

            p1.selectDBByName(firstName.trim(), lastName.trim());
        }

        Appointment a1 = new Appointment();

        if (p1.getPatId() != null && !p1.getPatId().isBlank()) {
            a1.selectDBByPatId(p1.getPatId());
        }

        HttpSession session = request.getSession();

        session.setAttribute("patientLookup", p1);
        session.setAttribute("appointment", a1);

        RequestDispatcher rd = request.getRequestDispatcher("/DisplayAppointment.jsp");

        try {
            rd.forward(request, response);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}