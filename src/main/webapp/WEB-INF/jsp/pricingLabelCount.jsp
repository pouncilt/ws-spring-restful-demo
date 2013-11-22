<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Pricing Label Count</title>
</head>
<body>
    <table border=1>
        <thead><tr>
            <th>Location Number</th>
            <th>Location Type</th>
            <th>Pricing Label Count</th>
        </tr></thead>
        <tr>
            <td>${corporatePricingLabel.locationNumber}</td>
            <td>${corporatePricingLabel.locationType}</td>
            <td>${corporatePricingLabel.count}</td>
        </tr>
        <c:forEach var="divisionPricingLabel" items="${corporatePricingLabel.children}">
            <tr>
                <td>${divisionPricingLabel.locationNumber}</td>
                <td>${divisionPricingLabel.locationType}</td>
                <td>${divisionPricingLabel.count}</td>
            </tr>
            <c:forEach var="regionPricingLabel" items="${divisionPricingLabel.children}">
                <tr>
                    <td>${regionPricingLabel.locationNumber}</td>
                    <td>${regionPricingLabel.locationType}</td>
                    <td>${regionPricingLabel.count}</td>
                </tr>
                <c:forEach var="districtPricingLabel" items="${regionPricingLabel.children}">
                    <tr>
                        <td>${districtPricingLabel.locationNumber}</td>
                        <td>${districtPricingLabel.locationType}</td>
                        <td>${districtPricingLabel.count}</td>
                    </tr>
                    <c:forEach var="storePricingLabel" items="${districtPricingLabel.children}">
                        <tr>
                            <td>${storePricingLabel.locationNumber}</td>
                            <td>${storePricingLabel.locationType}</td>
                            <td>${storePricingLabel.count}</td>
                        </tr>
                    </c:forEach>
                </c:forEach>
            </c:forEach>
        </c:forEach>
    </table>
</body>
</html>