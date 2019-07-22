function checkUsername() {
    console.info("lost")
    $.ajax({
        url:"/register/checkUsername?username="+$("#username").val(),
        type:"POST",
        success:function (data) {
            if(data.length!=0) {
                $(".tip").text("用户名已存在");
                $(".tip").show();
            }else {
                $(".tip").text("");
                $(".tip").hide();
            }
        }
    })
}
