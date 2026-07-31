package com.example.dentistoffice;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();

        Patient p1 = new Patient();
        p1.selectDB(userId);

        if (password != null && password.equals(p1.getPasswd())) {

            session.setAttribute("patient", p1);

            RequestDispatcher rd = request.getRequestDispatcher("/patientHome.jsp");

            try {
                rd.forward(request, response);
            } catch (Exception e) {
                throw new IOException(e);
            }

            return;
        }

        Dentist d1 = new Dentist();
        d1.selectDB(userId);

        if (password != null && password.equals(d1.getPasswd())) {

            session.setAttribute("dentist", d1);

            RequestDispatcher rd = request.getRequestDispatcher("/dentistHome.jsp");

            try {
                rd.forward(request, response);
            } catch (Exception e) {
                throw new IOException(e);
            }

            return;
        }

        RequestDispatcher rd = request.getRequestDispatcher("/errorPage.jsp");

        try {
            rd.forward(request, response);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}