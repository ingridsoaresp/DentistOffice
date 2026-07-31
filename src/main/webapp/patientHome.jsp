<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.example.dentistoffice.Patient" %>

<%
    Patient p = (Patient) session.getAttribute("patient");

    if (p == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Patient Home</title>
    <style>
        body { font-family: 'Trebuchet MS', 'Segoe UI', sans-serif; margin: 0; background: linear-gradient(135deg, #0f9aa8, #e9f7f8); color: #222; min-height: 100vh; }
        main { max-width: 700px; margin: 40px auto; padding: 0 18px; }
        .card { background: white; border-radius: 12px; padding: 35px; box-shadow: 0 4px 14px rgba(0,0,0,.08); text-align: center; }
        img { width: 300px; max-width: 100%; height: auto; display: block; margin: 0 auto -50px; }
        h1 { color: #0b3a66; margin-top: 8px; margin-bottom: 8px; font-size: 45px; }
        h2 { color: #0b3a66; margin-top: 35px; margin-bottom: 18px; }
        p { color: #555; margin-bottom: 26px; font-size: 17px; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        td { padding: 12px; border-bottom: 1px solid #d9e1e6; text-align: left; }
        .label { font-weight: bold; color: #0b3a66; width: 30%; }
        .btn-group { margin-top: 30px; display: flex; gap: 12px; justify-content: center; flex-wrap: wrap; }
        a.button { background: #16a6b6; color: white; padding: 12px 22px; text-decoration: none; border-radius: 8px; font-weight: bold; display: inline-block; }
        a.button:hover { background: #118c99; }
        a.button.secondary { background: #0b3a66; color: white; }
        a.button.secondary:hover { background: #082d4f; }
        footer { text-align: center; padding: 18px; color: #666; font-size: 14px; }
    </style>
</head>
<body>

<main>
    <div class="card">

        <img src="images/dentistlogo.png" alt="Dentist Office Logo" />

        <h1>Welcome <%= p.getFirstName() %>!</h1>

        <p>
            Manage your profile, appointments, and insurance information.
        </p>

        <h2>Patient Information</h2>

        <table>
            <tr>
                <td class="label">Patient ID</td>
                <td><%= p.getPatId() %></td>
            </tr>
            <tr>
                <td class="label">First Name</td>
                <td><%= p.getFirstName() %></td>
            </tr>
            <tr>
                <td class="label">Last Name</td>
                <td><%= p.getLastName() %></td>
            </tr>
            <tr>
                <td class="label">Address</td>
                <td><%= p.getAddr() %></td>
            </tr>
            <tr>
                <td class="label">Email</td>
                <td><%= p.getEmail() %></td>
            </tr>
            <tr>
                <td class="label">Insurance</td>
                <td><%= p.getInsCo() %></td>
            </tr>
        </table>

        <div class="btn-group">
            <a class="button" href="updatePatient.jsp">Edit Information</a>
            <a class="button" href="appointmentLookup.jsp">Find Appointment</a>
            <a class="button" href="addAppointment.jsp">Add Appointment</a>
            <a class="button secondary" href="index.jsp">Logout</a>
        </div>

    </div>
</main>

<footer>
    © 2026 Dentist Office. All rights reserved.
</footer>

</body>
</html>