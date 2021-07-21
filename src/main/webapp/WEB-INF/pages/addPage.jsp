<%--
  Created by IntelliJ IDEA.
  User: Professional
  Date: 18.07.2021
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html lang="en">
<head>
    <c:if test="${empty policy.id}">
        <title>Add policy</title>
    </c:if>

    <c:if test="${!empty policy.id}">
        <title>Edit policy</title>
    </c:if>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<c:if test="${empty policy.id}">
    <c:url value="/add" var="var"/>
</c:if>
<h1 style="margin-left: 650px">Add new policy</h1>
<form:form method="post" modelAttribute="policyDto" cssClass="addForm style">
    <c:if test="${!empty policy.id}">
        <input type="hidden" name="id" value="${policy.id}">
    </c:if>
    <div class="firstLine">
        <div class="personField">
            <spring:bind path="name">
                <div class="field">
                    <label for="name">Name</label>
                    <form:input type="text" path="name" id="name"/>
                </div>
            </spring:bind>

            <spring:bind path="lastName">
                <div class="field">
                    <label for="lastName">Lastname</label>
                    <form:input type="text" path="lastName" id="lastName" title="lastName"/>
                </div>
            </spring:bind>

            <spring:bind path="patronymic">
                <div class="field">
                    <label for="patronymic">Patronymic</label>
                    <form:input type="text" path="patronymic" id="patronymic"/>
                </div>
            </spring:bind>

            <spring:bind path="passportSeries">
                <div class="field">
                    <label for="passportSeries">Passport series</label>
                    <form:input type="text" path="passportSeries" id="passportSeries"/>
                </div>
            </spring:bind>

            <spring:bind path="passportNumber">
                <div class="field">
                    <label for="passportNumber">Passport number</label>
                    <form:input type="text" path="passportNumber" id="passportNumber"/>
                </div>
            </spring:bind>

            <spring:bind path="dateOfBirth">
                <div class="field">
                    <label for="dateOfBirth">Date of birth</label>
                    <form:input type="date" path="dateOfBirth" id="dateOfBirth"/>
                </div>
            </spring:bind>
        </div>

        <div class="carField">
            <spring:bind path="carBrand">
                <div class="field">
                    <label for="carBrand">Car brand</label>
                    <form:input type="text" path="carBrand" id="carBrand"/>
                </div>
            </spring:bind>

            <spring:bind path="carModel">
                <div class="field">
                    <label for="carModel">Car model</label>
                    <form:input type="text" path="carModel" id="carModel"/>
                </div>
            </spring:bind>

            <spring:bind path="year">
                <div class="field">
                    <label for="year">Year</label>
                    <form:input type="number" path="year" id="year"/>
                </div>
            </spring:bind>

            <spring:bind path="vinCode">
                <div class="field">
                    <label for="vinCode">VIN code</label>
                    <form:input type="text" path="vinCode" id="vinCode"/>
                </div>
            </spring:bind>

            <spring:bind path="carNumber">
                <div class="field">
                    <label for="carNumber">Car number</label>
                    <form:input type="text" path="carNumber" id="carNumber"/>
                </div>
            </spring:bind>

            <spring:bind path="policyTypeId">
                <div class="field">
                    <label for="policyTypeId">Policy type</label>
                    <form:select id="policyTypeId" name="policyTypeId" path="policyTypeId">
                        <option value="0">Policy type</option>
                        <c:forEach items="${policyTypes}" var="policyType">
                            <option  value="${policyType.id}">${policyType.type}</option>
                        </c:forEach>
                    </form:select>
                </div>
            </spring:bind>
        </div>

    </div>

    <div class="secondLine">
        <div class="insuranceField">
            <spring:bind path="companyId">
                <div class="field">
                    <label for="company">Company</label>
                    <form:select id="company" name="company" path="companyId">
                        <option value="0">Company</option>
                        <c:forEach items="${companies}" var="company">
                            <option  value="${company.id}">${company.name}</option>
                        </c:forEach>
                    </form:select>
                </div>
            </spring:bind>

            <spring:bind path="currencyId">
                <div class="field">
                    <label for="currency">Currency</label>
                    <form:select id="currency" name="currency" path="currencyId">
                        <option value="0">Currency</option>
                        <c:forEach items="${currencies}" var="currency">
                            <option  value="${currency.id}">${currency.code}</option>
                        </c:forEach>
                    </form:select>
                </div>
            </spring:bind>

            <spring:bind path="insuranceSum">
                <div class="field">
                    <label for="insuranceSum">Insurance sum</label>
                    <form:input type="text" path="insuranceSum" id="insuranceSum"/>
                </div>
            </spring:bind>

            <spring:bind path="dateOfIssue">
                <div class="field">
                    <label for="dateOfIssue">Date of issue</label>
                    <form:input type="date" path="dateOfIssue" id="dateOfIssue"/>
                </div>
            </spring:bind>

            <spring:bind path="validityPeriod">
                <div class="field">
                    <label for="validityPeriod">Validity period</label>
                    <form:input type="date" lang="en-US" path="validityPeriod" id="validityPeriod"/>
                </div>
            </spring:bind>
        </div>

        <div style="width: 350px;margin-left: 100px;">
        <c:if test="${empty policy.id}">
            <button type="submit" class="addButton">Add new policy</button>
        </c:if>
        </div>
    </div>
</form:form>
</div>
</body>
</html>

