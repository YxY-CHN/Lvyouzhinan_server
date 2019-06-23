function sendSMSCode() {

    $(".phonecode-a").removeAttr("onclick");
    var mobile = $("#mobile").val();
    if (!mobile) {
        $("#mobile-err span").html("请填写正确的手机号！");
        $("#mobile-err").show();
        $(".phonecode-a").attr("onclick", "sendSMSCode();");
        return;
    }

    $.get("/api/regirsterCode", {
            mobile: mobile
        },
        function (data) {
            // 请求成功后的响应结果
            var $time = $(".phonecode-a");
            var duration = 60;
            var intervalid = setInterval(function () {
                $time.html(duration + "秒");
                if (duration === 1) {
                    // 清除计数器
                    clearInterval(intervalid);
                    $time.html('获取验证码');
                    $(".phonecode-a").attr("onclick", "sendSMSCode();");
                }
                duration = duration - 1;
            }, 1000, 60);
        }, 'json');

    /**
     var $time = $(".phonecode-a");
     var duration = 60;
     var intervalid = setInterval(function() {
		$time.html(duration + "秒");
		if(duration === 1) {
			// 清除计数器
			clearInterval(intervalid);
			$time.html('获取验证码');
			$(".phonecode-a").attr("onclick", "sendSMSCode();");
		}
		duration = duration - 1;
	}, 1000, 60);

     **/

}

$(document).ready(function () {
    $("#mobile").focus(function () {
        $("#mobile-err").hide();
    });
    $("#phonecode").focus(function () {
        $("#phone-code-err").hide();
    });
    $("#password").focus(function () {
        $("#password-err").hide();
        $("#password2-err").hide();
    });
    $("#password2").focus(function () {
        $("#password2-err").hide();
    });
    $(".form-register").submit(function (e) {
        e.preventDefault();
        mobile = $("#mobile").val();
        phoneCode = $("#phonecode").val();
        passwd = $("#password").val();
        passwd2 = $("#password2").val();
        if (!mobile) {
            $("#mobile-err span").html("请填写正确的手机号！");
            $("#mobile-err").show();
            return;
        }
        if (!phoneCode) {
            $("#phone-code-err span").html("请填写短信验证码！");
            $("#phone-code-err").show();
            return;
        }
        if (!passwd) {
            $("#password-err span").html("请填写密码!");
            $("#password-err").show();
            return;
        }
        if (passwd != passwd2) {
            $("#password2-err span").html("两次密码不一致!");
            $("#password2-err").show();
            return;
        }

        $.ajax({
            url:"/api/regirst",
            type:"post",
            dataType:"json",
            data:{
                "mobile":mobile,
                "password":passwd,
                "code":phoneCode
            },
            success:function (data) {
                if(data.flag==0){
                    alert(data.msg)
                }
                if(data.flag==1){
                    alert(data.msg)
                }
            }
        })

    });
})