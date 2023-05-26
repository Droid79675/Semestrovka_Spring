<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <#include "base.ftlh">
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title></title>
</head>
<body>
<#macro title>${searchWord}</#macro>
<#macro content>
    <ul class="list-group">
        <div class="col-md-12 d-flex justify-content-center m-lg-2">
            <div class="row m-lg-1">
                <div class="col-md-auto">
                    <p class="lead fw-normal">Name: ${product.name}</p>
                </div>
                <div class="col-md-auto">
                    <p class="lead fw-normal">Date: ${product.date}</p>
                </div>
                <div class="col-md-auto">
                    <p class="lead fw-normal">Price: ${product.price}</p>
                </div>
            </div>
        </div>
        <div class="col-md-12 d-flex justify-content-center">
            <p class="lead fw-normal">Actors:</p>
            <#list product.actors as actors>
                <p class="lead fw-normal">${actors.name } </p>
            </#list>
        </div>
    </ul>
</#macro>
</body>
</html>