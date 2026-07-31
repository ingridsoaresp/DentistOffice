package com.example.dentistoffice;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/DentistUpdateServlet")
public class DentistUpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();

        Dentist d = (Dentist) session.getAttribute("dentist");

        if (d != null) {

            d.setFirstName(request.getParameter("firstName"));
            d.setLastName(request.getParameter("lastName"));
            d.setEmail(request.getParameter("email"));
            d.setOffice(request.getParameter("office"));

            d.updateDB();

            session.setAttribute("dentist", d);
        }

        RequestDispatcher rd = request.getRequestDispatcher("/dentistHome.jsp");

        try {
            rd.forward(request, response);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}