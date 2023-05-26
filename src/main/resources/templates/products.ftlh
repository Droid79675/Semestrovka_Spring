<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <#include "base.ftlh">
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title></title>
    <style>
        thead tr th {
            color: #4c4b4b
        }
    </style>
</head>
<body>
<#macro title>
    <div class="text-dark">
        <p>Products</p>
    </div>
</#macro>
<#macro content>
    <div class="d-flex justify-content-center align-content-center">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>ID</th>
                <th>Performance</th>
                <th>Price</th>
                <th>Date</th>
                <th>Actors</th>
                <th>Transaction</th>
            </tr>
            </thead>
            <tbody>
            <#list products as product>
                <form action="/buyticket" method="post" th:object="${product}">
                    <tr>

                        <td>${product.id}</td>
                        <td>${product.name}</td>
                        <td>${product.price} ₽</td>
                        <td>${product.date}</td>
                        <td>
                            <p class="lead fw-normal">Actors:</p>
                            <#list product.actors as actors>
                                <p class="text" id="actors">${actors.name}</p>
                            </#list>
                        </td>
                        <td>
                            <button type="button" style="width: 100%" class="btn btn-light">Buy ticket</button>
                        </td>
                    </tr>
                </form>
            </#list>
            </tbody>
        </table>
    </div>
</#macro>
</body>
</html>