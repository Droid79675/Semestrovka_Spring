<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <#include "base.ftlh">
    <meta charset="utf-8">
    <title>Your Profile</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<#macro title>Your profile</#macro>
<#macro content>
    <section class="h-100 gradient-custom-2">
        <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col col-lg-9 col-xl-7">
                    <div class="card">
                        <div class="rounded-top text-white d-flex flex-row"
                             style="background-color: #000; height:200px;">
                            <div class="row ms-2 justify-content-start" style="margin-top: 100px;">
                                <div class="col-sm-auto">
                                    <p class="lead fw-normal">First Name: ${buyer.FName}</p>
                                </div>
                                <div class="col-sm-auto">
                                    <p class="lead fw-normal">Second Name: ${buyer.SName}</p>
                                </div>
                            </div>
                            <div class="row ms-2 justify-content-start" style="margin-top: 100px;">
                                <div class="col-sm-auto">
                                    <p class="lead fw-normal">Username: ${buyer.username}</p>
                                </div>
                                <div class="col-sm-auto">
                                    <p class="lead fw-normal">Email: ${buyer.email}</p>
                                </div>
                            </div>
                            <div class="d-flex ms-2" style="margin-top: 100px;">
                                <div class="card-columns">
                                    <#list tickets as t>
                                        <a href="/tickets/${t.id}" class="product-link">
                                            <div class="card text-white bg-dark my-3 product">
                                                <div class="card-body">
                                                    <h5 class="card-title">${t.product}</h5>
                                                    <p class="card-text">${t.price} ₽</p>
                                                    <p class="card-text">${t.date}</p>
                                                </div>
                                                <div class="card-footer">
                                                    ${t.buyer.username}
                                                </div>
                                            </div>
                                        </a>
                                    <#else>
                                        <h1 style="text-align: center">You didn't buy any tickets</h1>
                                    </#list>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</#macro>
</body>
</html>
