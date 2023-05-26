<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
    <header>
        <nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
            <div class="container-fluid">
                <div class="collapse navbar-collapse">
                    <ul class="navbar-nav me-auto mb-2 mb-md-0">
                        <li class="nav-item">
                            <a class="nav-link" href="/login">Login</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/sign_up">Sign Up</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/products">Products</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/profile">Profile</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/chat">Chat</a>
                        </li>
                    </ul>
                    <form class="d-flex" method="get" action="/search">
                        <input class="form-control me-2" name="searchWord" <#if searchWord??>value="${searchWord}"</#if> type="search" placeholder="Search by name" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
            </div>
        </nav>
    </header>
    <script
            src="https://code.jquery.com/jquery-3.6.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
            crossorigin="anonymous"></script>
    <script type="text/javascript"
            src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js"></script>
</head>

<body>

<div class="col-md-12 d-flex justify-content-center fw-bolder">
    <div class="content">
        <h2 style="text-align: center"><@title></@title></h2>
    </div>
</div>

<div class="content1">
    <div class="content"><@content></@content></div>
</div>

</body>

</html>