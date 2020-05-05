$(function () {
    /*判断上次是否勾选记住密码和自动登录*/
    var autoLogin = localStorage.getItem("autoLogin");
    var rememberMe = localStorage.getItem("rememberMe");
    var oldName = localStorage.getItem("userName");
    var oldPass = localStorage.getItem("passWord");
    var jtoken = localStorage.getItem("jtoken");
    // 如果jwt token不为空，那么直接提交token验证
    if (null != jtoken) {
        //
    }
    if (autoLogin == "true") {
        $("#username").val(oldName);
        $("#password").val(oldPass);
        $("#autoLogin").prop('checked', true);
    } else {
        $("#username").val('');
        $("#password").val('');
        $("#autoLogin").prop('checked', false);
    }
    if (rememberMe == "true") {
        $("#rememberMe").prop('checked', true);
        // $("#loginFrom").submit();
        //location="https://www.baidu.com?userName="+oldName+"&passWord="+oldPass;//添加退出当前账号功能
    } else {
        $("#rememberMe").prop('checked', false);
    }


    /*登录*/
    $("#login").click(function () {
        // 用户名，密码
        var userName = $("#username").val().trim();
        var password = $("#password").val().trim();

        /*获取记住密码  自动登录的 checkbox的值*/
        var autoLogin = $("#autoLogin").prop('checked');
        var rememberMe = $('#rememberMe').prop('checked');

        if (autoLogin == "true") {
            localStorage.setItem("autoLogin", autoLogin);
        }

        if (rememberMe == "true") {
            localStorage.setItem("rememberMe", rememberMe);
        }

        var requestData = {
            phone: userName,
            password: password
        };

        basic.ajax($, {
            method: 'POST'
            , url: basic.getUrl + '/userinfo/login'
            , contentType: 'application/json'
            // , contentType: 'application/x-www-form-urlencoded'
            , data: JSON.stringify(requestData)
        }, function (msg) {
            // TODO
            // 把token放在localStorage里
            localStorage.setItem("jtoken", msg.data.token);
        });

        console.log(userName + "," + password);
    })

    /*$("#check2").click(function(){
        var flag=$('#check2').prop('checked');
        if(flag){
            var userName=$("#login-username").val();
            var passWord=$("#login-password").val();
            $.ajax({
                type:"post",
                url:"http://localhost:8080/powers/pow/regUsers",
                data:{"userName":userName,"passWord":passWord},
                async:true,
                success:function(res){
                    alert(res);
                }
            });
        }
    })*/
});
