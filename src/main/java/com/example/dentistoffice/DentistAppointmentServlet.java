package com.example.dentistoffice;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/DentistAppointmentServlet")
public class DentistAppointmentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();

        Dentist d = (Dentist) session.getAttribute("dentist");

        if (d == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        AppointmentList list = new AppointmentList();

        list.selectDBByDentist(d.getId());

        session.setAttribute("dentistAppointments", list);

        RequestDispatcher rd = request.getRequestDispatcher("/dentistAppointments.jsp");

        try {
            rd.forward(request, response);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}