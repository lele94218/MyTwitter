<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Detail - MyTwitter</title>

    <!-- Bootstrap Core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/css/metisMenu.min.css" rel="stylesheet">

    <!-- DataTables CSS -->
    <link href="/css/dataTables.bootstrap.css"
          rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <!--<link href="bower_components/datatables-responsive/css/dataTables.responsive.css" rel="stylesheet">-->

    <!-- Custom CSS -->
    <link href="/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/css/font-awesome.min.css" rel="stylesheet" type="text/css">


    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

<div id="wrapper">

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.html">SB Admin v2.0</a>
        </div>
        <!-- /.navbar-header -->

        <ul class="nav navbar-top-links navbar-right">
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-envelope fa-fw"></i> <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-messages">
                    <li>
                        <a class="text-center" href="#">
                            <strong>Read All Messages</strong>
                            <i class="fa fa-angle-right"></i>
                        </a>
                    </li>
                </ul>
                <!-- /.dropdown-messages -->
            </li>
            <!-- /.dropdown -->
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-tasks fa-fw"></i> <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-tasks">

                    <li class="divider"></li>
                    <li>
                        <a class="text-center" href="#">
                            <strong>See All Tasks</strong>
                            <i class="fa fa-angle-right"></i>
                        </a>
                    </li>
                </ul>
                <!-- /.dropdown-tasks -->
            </li>
            <!-- /.dropdown -->
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-bell fa-fw"></i> <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-alerts">
                    <li class="divider"></li>
                    <li>
                        <a class="text-center" href="#">
                            <strong>See All Alerts</strong>
                            <i class="fa fa-angle-right"></i>
                        </a>
                    </li>
                </ul>
                <!-- /.dropdown-alerts -->
            </li>
            <!-- /.dropdown -->
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                    </li>
                    <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                    </li>
                    <li class="divider"></li>
                    <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                    </li>
                </ul>
                <!-- /.dropdown-user -->
            </li>
            <!-- /.dropdown -->
        </ul>
        <!-- /.navbar-top-links -->

        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="sidebar-search">
                        <div class="input-group custom-search-form">
                            <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="button">
                                        <i class="fa fa-search"></i>
                                    </button>
                                </span>
                        </div>
                        <!-- /input-group -->
                    </li>
                    <li>
                        <a href="index.html"><i class="fa fa-dashboard fa-fw"></i> Users</a>
                    </li>

                </ul>
            </div>
            <!-- /.sidebar-collapse -->
        </div>
        <!-- /.navbar-static-side -->
    </nav>

    <!-- Page Content -->
    <div id="page-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">${name} @${screenName}</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="panel-group" id="accordion">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapse2"
                                   aria-expanded="true" class="">
                                    Details
                                </a>
                            </h4>
                        </div>
                        <div id="collapse2" class="panel-collapse collapse in" aria-expanded="true">

                            <div class="panel-body">
                                <div class="row clearfix">
                                    <div class="col-md-2 column">
                                        <img width="120" height="120" src="/img/profile/${imgFileName}"
                                             onerror="this.src = '/img/error.png'"
                                             class="img-thumbnail"/>
                                    </div>
                                    <div class="col-md-10 column">
                                        <div class="row clearfix">
                                            <em>${description}</em>
                                        </div>
                                        <div class="row clearfix">
                                            <div class="col-md-4 column">
                                                <h4></h4>
                                            </div>
                                            <div class="col-md-8 column">
                                                <div class="col-md-2 column">

                                                </div>
                                                <div class="col-md-10 column">
                                                    <h6><strong>Similar users:</strong></h6>
                                                    <c:forEach items="${SimilarUsers}" var="user">
                                                        <a href="/detail/${user.userId}"><img
                                                                src="/img/profile/${user.profileImageUrl}"
                                                                width="58" height="58"
                                                                onerror="this.src = '/img/error.png'"
                                                                class=" img-thumbnail"/></a>
                                                    </c:forEach>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <h3 class="page-header">Similarities</h3>
                </div>
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-md-12 column">
                    <div style="width: 50%">
                        <canvas id="canvas" height="450" width="600"></canvas>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <h3 class="page-header">Tweets</h3>
                </div>
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-md-12 column">
                    <table class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>Tweets</th>
                        </tr>
                        </thead>
                        <tbody id="userTweets">
                        </tbody>
                    </table>
                    <ul id="pagination-demo" class="pagination"></ul>
                </div>
            </div>



        </div>
        <!-- /.container-fluid -->
    </div>
    <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->

<!-- jQuery -->
<script src="/js/jquery.min.js"></script>
<script src="/js/Chart.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="/js/metisMenu.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="/js/sb-admin-2.js"></script>

<!-- DataTables JavaScript -->
<script src="/js/jquery.dataTables.min.js"></script>
<script src="/js/dataTables.bootstrap.min.js"></script>
<script src="/js/jquery.min.js"></script>


<script src="/js/jquery.twbsPagination.min.js"></script>

<!-- 分页并同步数据 -->
<script type="text/javascript">
    var barChartData = {
        labels: [],
        datasets: [
            {
                fillColor: "rgba(220,220,220,0.5)",
                strokeColor: "rgba(220,220,220,0.8)",
                highlightFill: "rgba(220,220,220,0.75)",
                highlightStroke: "rgba(220,220,220,1)",
                data: []
            }
        ]

    };
    function add(str) {
        $('#userTweets').append("<tr><td>" + str + "</tr></td>");
    }

    $(function () {

        var hrefStr = window.location.pathname;
        var pathNames = hrefStr.split('/');
        var idStr = pathNames[pathNames.length - 1];

        var userCt = {};
        userCt["userId"] = idStr;
        userCt["number"] = 10;
        userCt["top"] = 8;
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/recommend-users",
            data: JSON.stringify(userCt),
            dataType: 'json',
            timeout: 100000,
            success: function (data) {
                console.log("SUCCESS: ", data);
                doIt(data);
            },
            error: function (e) {
                console.log("ERROR: ", e);
            },
            done: function (e) {
                console.log("DONE");
            }
        });

        var userCriteria = {};
        userCriteria["page"] = 0;
        userCriteria["size"] = 15;
        userCriteria["userId"] = idStr;

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/tweets-by-id",
            data: JSON.stringify(userCriteria),
            dataType: 'json',
            timeout: 100000,
            success: function (data) {
                console.log("SUCCESS: ", data);
                display(data);
                var pageNum = data.totalPages;
                addPage(pageNum);
            },
            error: function (e) {
                console.log("ERROR: ", e);
            },
            done: function (e) {
                console.log("DONE");
            }
        });

    });
    function callback(pageNo, pageSize) {
        var userCriteria = {};
        userCriteria["page"] = pageNo;
        userCriteria["size"] = pageSize;
        var hrefStr = window.location.pathname;
        var pathNames = hrefStr.split('/');
        var idStr = pathNames[pathNames.length - 1];
        userCriteria["userId"] = idStr;
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/tweets-by-id",
            data: JSON.stringify(userCriteria),
            dataType: 'json',
            timeout: 100000,
            success: function (data) {
                console.log("SUCCESS: ", data);
                display(data);
            },
            error: function (e) {
                console.log("ERROR: ", e);
            },
            done: function (e) {
                console.log("DONE");
            }
        });
    }

    function doIt(data) {
        for (var i = 0; i < data.length; ++ i) {
            barChartData.labels[i] = data[i].userEntity.userId;
            barChartData.datasets[0].data[i] = data[i].similarity;
        }
        var ctx = document.getElementById("canvas").getContext("2d");
        window.myBar = new Chart(ctx).Bar(barChartData, {
            responsive: true
        });
    }

    function addPage(pageNum) {
        $('#pagination-demo').twbsPagination({
            totalPages: pageNum,
            visiblePages: 7,
            onPageClick: function (event, page) {
                $('#userTweets').empty();
//                var imgHtml = "<tr id='loding'><td><img src='/img/loading.gif' height='30' width='30'></td></tr>";
//                $('#userTweets').append(imgHtml);
                callback(page - 1, 15);
            }
        });
    }

    function display(data) {
//        $('#loading').remove();
        for (var i = 0; i < data.content.length; ++i) {
            add("<em>" + data.content[i].createdAt + "</em>" + "<br>" + data.content[i].text);
        }
    }
</script>

</body>

</html>
