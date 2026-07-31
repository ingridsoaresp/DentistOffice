<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.example.dentistoffice.AppointmentList" %>
<%@ page import="com.example.dentistoffice.Appointment" %>

<%
    AppointmentList list = (AppointmentList) session.getAttribute("dentistAppointments");

    if (list == null) {
        response.sendRedirect("dentistHome.jsp");
        return;
    }
%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Dentist Appointments</title>
    <style>
        body { font-family: 'Trebuchet MS', 'Segoe UI', sans-serif; margin: 0; background: linear-gradient(135deg, #0f9aa8, #e9f7f8); color: #222; min-height: 100vh; }
        main { max-width: 700px; margin: 40px auto; padding: 0 18px; }
        .card { background: white; border-radius: 12px; padding: 35px; box-shadow: 0 4px 14px rgba(0,0,0,.08); text-align: center; }
        img { width: 300px; max-width: 100%; height: auto; display: block; margin: 0 auto -50px; }
        h1 { color: #0b3a66; margin-top: 8px; margin-bottom: 8px; font-size: 45px; }
        p { color: #555; margin-bottom: 26px; font-size: 17px; }
        table { width: 100%; border-collapse: collapse; margin-top: 25px; }
        th { background: #0b3a66; color: white; padding: 12px; }
        td { padding: 12px; border-bottom: 1px solid #d9e1e6; }
        tr:nth-child(even) { background: #f9fbfc; }
        .back-link { display: inline-block; margin-top: 18px; color: #0b3a66; text-decoration: none; font-weight: bold; }
        footer { text-align: center; padding: 18px; color: #666; font-size: 14px; }
    </style>
</head>
<body>

<main>
    <div class="card">

        <img src="images/dentistlogo.png" alt="Dentist Office Logo" />

        <h1>My Appointments</h1>

        <p>
            See your work schedule.
        </p>

        <table>
            <tr>
                <th>Date & Time</th>
                <th>Patient ID</th>
                <th>Procedure Code</th>
            </tr>

            <%
                for (int i = 0; i < list.getCount(); i++) {
                    Appointment a = list.get(i);
            %>

            <tr>
                <td><%= a.getApptDateTime() %></td>
                <td><%= a.getPatId() %></td>
                <td><%= a.getProcCode() %></td>
            </tr>

            <%
                }
            %>

        </table>

        <a class="back-link" href="dentistHome.jsp">← Back to Dentist Home</a>

    </div>
</main>

<footer>
    © 2026 Dentist Office. All rights reserved.
</footer>

</body>
</html>