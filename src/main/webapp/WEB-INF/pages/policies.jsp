<%--
  Created by IntelliJ IDEA.
  User: Professional
  Date: 18.07.2021
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Policies</title>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>

<table class="style">
    <caption class="heading" style="color: black">Policies</caption>
    <tr>
        <th class="left-side">Id</th>
        <th style="width: 100%">Company</th>
        <th>Lastname</th>
        <th>Name</th>
        <th>Insurance sum</th>
        <th>Currency</th>
        <th>Date of issue</th>
        <th>Validity period</th>
        <th>Type</th>
        <th>Action</th>
    </tr>
    <c:forEach var="policy" items="${policiesList}">
        <tr>
            <td class="left-side">${policy.id}</td>
            <td>${policy.company.name}</td>
            <td>${policy.person.lastName}</td>
            <td>${policy.person.name}</td>
            <td>${policy.insuranceSum}</td>
            <td>${policy.currency.code}</td>
            <td>${policy.dateOfIssue}</td>
            <td>${policy.validityPeriod}</td>
            <td>${policy.policyType.type}</td>
            <td>
                <c:url value="/delete/${policy.id}" var="delete"/>
                     <a href=${delete}>delete</a>

            </td>
        </tr>
    </c:forEach>

    <td colspan="10" class="left-side link right-side">
        <a style="margin-right: 70px; font-size: 100%" href="<c:url value="/add"/>">
            Add new policy
        </a>
    </td>
</table>

</body>
</html>
