<!DOCTYPE html>
<html lang="en">
<head>
    <#include "base.ftlh">
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title></title>
    <style>
        body {
            background-image: url("https://images.unsplash.com/photo-1615414047026-802692414b79?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1169&q=80");
            background-repeat: no-repeat;
            background-position: center;
            background-attachment: fixed;
            background-size: cover;
        }

        label {
            color: azure;
        }
    </style>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css">
</head>
<body>
<#macro title>
    <div class="text-white">
        <p>Login</p>
    </div>
</#macro>
<#macro content>

    <div class="container mt-4">
        <form id="login" action="/login" method="post">
            <!-- Email input -->
            <div class="form-group">
                <div class="form-outline mb-4">
                    <input type="email" id="email" class="form-control"/>
                    <label class="form-label" for="email">Email address</label>
                </div>
            </div>
            <!-- Password input -->
            <div class="form-group">
                <div class="form-outline mb-4">
                    <input type="password" id="password" class="form-control"/>
                    <label class="form-label" for="password">Password</label>
                </div>
            </div>
            <!-- Submit button -->
            <button type="submit" style="width: 100%" class="btn btn-light">Sign in</button>
            <div class="text-center text-white">
                <div class="sign-up">
                    Don't have an account? <a href="/sign_up"> Create One </a>
                </div>
            </div>
        </form>
    </div>
    <div class="col-md-12 d-flex justify-content-center m-lg-2">

        <button id="Hits">Popular performances</button>
        <h1> <div class="text-white" id="ajax-div"></div></h1>
    </div>
    <script>
        document.getElementById("Hits").addEventListener("click", function () {
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function () {
                if (this.readyState === 4 && this.status === 200) {
                    var responseText = this.responseText;
                    document.getElementById("ajax-div").innerText = responseText;
                }
            };
            xhttp.open("GET", "http://localhost:8082/ajax/hits", true);
            xhttp.send();
        });
    </script>
</#macro>
</body>
</html>