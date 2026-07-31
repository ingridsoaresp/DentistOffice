<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.example.dentistoffice.Appointment" %>
<%@ page import="com.example.dentistoffice.Procedure" %>

<%
    Appointment a = (Appointment) session.getAttribute("appointment");

    if (a == null) {
        response.sendRedirect("appointmentLookup.jsp");
        return;
    }

    Procedure proc = a.getProc();
%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Appointment Details</title>
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
        .label { font-weight: bold; color: #0b3a66; width: 32%; }
        .btn-group { margin-top: 28px; }
        a.button { background: #16a6b6; color: white; padding: 12px 22px; text-decoration: none; border-radius: 8px; font-weight: bold; display: inline-block; }
        a.button:hover { background: #118c99; }
        a.button.danger { background: #b42318; }
        a.button.danger:hover { background: #8f1d14; }
        a.button.secondary { background: #0b3a66; }
        a.button.secondary:hover { background: #082d4f; }
        .delete-box { display: none; margin-top: 25px; padding: 22px; border-radius: 12px; background: #fff5f5; border: 1px solid #f0b4b4; }
        .delete-box h3 { color: #b42318; margin-top: 0; }
        .delete-box p { margin-bottom: 18px; }
        .back-link { display: inline-block; margin-top: 18px; color: #0b3a66; text-decoration: none; font-weight: bold; }
        footer { text-align: center; padding: 18px; color: #666; font-size: 14px; }
    </style>
</head>
<body>

<main>
    <div class="card">

        <img src="images/dentistlogo.png" alt="Dentist Office Logo" />

        <h1>Appointment Details</h1>

        <p>
            Review your appointment and procedure information below.
        </p>

        <table>
            <tr>
                <td class="label">Appointment Date & Time</td>
                <td><%= a.getApptDateTime() %></td>
            </tr>
            <tr>
                <td class="label">Patient ID</td>
                <td><%= a.getPatId() %></td>
            </tr>
            <tr>
                <td class="label">Dentist ID</td>
                <td><%= a.getDentId() %></td>
            </tr>
            <tr>
                <td class="label">Procedure Code</td>
                <td><%= a.getProcCode() %></td>
            </tr>

            <% if (proc != null) { %>

            <tr>
                <td class="label">Procedure Name</td>
                <td><%= proc.getProcName() %></td>
            </tr>
            <tr>
                <td class="label">Description</td>
                <td><%= proc.getProcDesc() %></td>
            </tr>
            <tr>
                <td class="label">Cost</td>
                <td>$<%= proc.getCost() %></td>
            </tr>

            <% } %>

        </table>

        <div class="btn-group">
            <a class="button" href="updateAppointment.jsp">Update Appointment</a>
            <a class="button danger" href="#" onclick="showDeleteBox(); return false;">Delete Appointment</a>
        </div>

        <div id="deleteBox" class="delete-box">
            <h3>Delete Appointment?</h3>
            <p>Are you sure you want to delete this appointment? This action cannot be undone.</p>

            <div class="btn-group">
                <a class="button danger" href="AppointmentDeleteServlet">Yes, Delete</a>
                <a class="button secondary" href="#" onclick="hideDeleteBox(); return false;">Cancel</a>
            </div>
        </div>

        <a class="back-link" href="patientHome.jsp">← Back to Patient Home</a>

    </div>
</main>

<script>
    function showDeleteBox() {
        document.getElementById("deleteBox").style.display = "block";
    }

    function hideDeleteBox() {
        document.getElementById("deleteBox").style.display = "none";
    }
</script>

<footer>
    © 2026 Dentist Office. All rights reserved.
</footer>

</body>
</html>