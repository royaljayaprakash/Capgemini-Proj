<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
 <body bgcolor="skyblue">
 <form action="./bookingDetails" method="Post">
 <table>
 <tr>
 <td>Booking_id:</td><td><input type="text" name="u1" placeholder="Enter ur id"/></td>
 </tr>
  <tr>
 <td>Room_id:</td><td><input type="password" name="p1" placeholder="enter your room id"/></td>
 </tr>
  <tr>
 <td>User_id:</td><td><input type="text" name="e1" placeholder="enter your user id "/></td>
 </tr>
  <tr>
        <td>Booked_from:</td><td><input type="text" name="e1" placeholder="enter date "/></td>
 </tr>
 <tr>
        <td>Booked_to:</td><td><input type="text" name="e1" placeholder="enter bookeddate "/></td>
 </tr>
 <tr>
        <td>no.of_adults:</td><td><input type="text" name="e1" placeholder="enter no.of adults "/></td>
 </tr>
 <tr>
        <td>no.of_childrens:</td><td><input type="text" name="e1" placeholder="enter no.of childrens "/></td>
 </tr>
  
 <tr><td align="center" colspan="2">
 <input type="submit" name="s3" value="sub"/>
 <input type="reset" name="r3" value="reset"/>
 </td>
 </tr>
 </table>
 </form>
 </body>
</html>