package com.example.dentistoffice;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/PatientUpdateServlet")
public class PatientUpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();

        Patient p = (Patient) session.getAttribute("patient");

        if (p != null) {

            p.setFirstName(request.getParameter("firstName"));
            p.setLastName(request.getParameter("lastName"));
            p.setAddr(request.getParameter("addr"));
            p.setEmail(request.getParameter("email"));
            p.setInsCo(request.getParameter("insCo"));

            p.updateDB();

            session.setAttribute("patient", p);
        }

        RequestDispatcher rd = request.getRequestDispatcher("/patientHome.jsp");

        try {
            rd.forward(request, response);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}