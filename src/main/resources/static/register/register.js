var checkUsernameFlag = false;
var checkPasswordFlag = false;
var tipPassword = $("#tipPassword");
var tipUsername = $("#tipUsername");
function checkUsername() {
    console.info("lost");

    var string = $("#username").val();
    if(string.length<1) {
        tipUsername.text("用户名不为空");
        checkUsernameFlag = false;
        return 0;
    }else {
        var i = 0;
        var length = string.length;
        for ( ; i < length ; i++ ) {
            var char = string.charCodeAt(i);
            if(char<33 || char>126) {
                tipUsername.text("用户名仅为数字，字母和常用符号");
                checkUsernameFlag = false;
                return 0;
            }
        }
    }

    $.ajax({
        url:"/register/checkUsername?username="+$("#username").val(),
        type:"POST",
        success:function (data) {
            if(data.length!=0) {
                $("#tipUsername").text("用户名已存在");
                checkUsernameFlag = false;
            }else {
                $("#tipUsername").text("");
                checkUsernameFlag = true;
            }
        }
    })
}
function checkPassword() {
    var string = $("#password").val();
    var length = string.length;
    console.info(string);
    if ( string != $("#confirmPassword").val() ) {
        tipPassword.text("密码输入不一致");
        checkPasswordFlag = false;
        return 0;
    }else if( length < 8 ) {
        tipPassword.text("密码长度应不小于8位");
        checkPasswordFlag = false;
        return 0;
    }else {
        var i = 0;
        for ( ; i < length ; i++ ) {
            var char = string.charCodeAt(i);
            if(char<33 || char>126) {
                tipPassword.text("密码仅为数字，字母和常用符号");
                checkPasswordFlag = false;
                return 0;
            }
        }
    }
    checkPasswordFlag = true;
    tipPassword.text("");
}
function check() {
    console.log("check");
    return checkPasswordFlag && checkUsernameFlag;
}
