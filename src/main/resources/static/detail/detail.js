function typeSelecterInit() {
    for (let i = 0 ; i < roomDetailList.length ; i ++) {
        if ( roomDetailList[i].room.leftNumber > 0) {
            var option = $("<option>");
            option.html(roomDetailList[i].room.chineseName);
            option.attr("value",i);
            $("#selecter-type").append(option);
        }
    }
}

function typeChange() {
    numberSelecterInit( $("#selecter-type").val());

}

function numberSelecterInit(index) {
    $("#selecter-number").empty();
    var length = roomDetailList[index].room.leftNumber > 5 ? 5 : roomDetailList[index].room.leftNumber;
    for (let i = 1 ; i <= length ; i ++) {
        var option = $("<option>");
        option.html(i);
        option.attr("value",i);
        $("#selecter-number").append(option);
    }
}

function check() {
    var nameJQ = $("#name");
    var identifyJQ = $("#identify");
    var connectPhoneJQ = $("#connectPhone");
    var startDateJQ = $("#datepickerStart");
    var endDateJQ = $("#datepickerEnd");
    var typeSelecterJQ = $("#selecter-type");
    var numberSelecterJQ = $("#selecter-number");

    var name = nameJQ.val();
    var identify = identifyJQ.val();
    var connectPhone = connectPhoneJQ.val();
    var checkIn = startDateJQ.val();
    var checkOut = endDateJQ.val();
    var roomId = roomDetailList[typeSelecterJQ.val()].room.roomId;
    var roomNumber = numberSelecterJQ.val();
    console.info($("#datepickerStart").datepicker('getData'));
    var connectPhoneCheck = /^((13[0-9])|(14[579])|(15([0-3,5-9]))|(16[6])|(17[0135678])|(18[0-9]|19[89]))\d{8}$/.test(connectPhone);
    var identifyCheck = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/.test(identify);
    if (!connectPhoneCheck) {
        connectPhoneJQ.css("color","red");
    }
    if (!identifyCheck) {
        identifyJQ.css("color","red");
    }
    if (identifyCheck && connectPhoneCheck) {
        var Url = "/welcome/details/postOrder?"
            + "&&name=" + name
            + "&&hotelId=" + hotelId
            + "&&identify=" + identify
            + "&&connectPhone=" + connectPhone
            + "&&checkIn=" + checkIn
            + "&&checkOut=" + checkOut
            + "&&roomId=" + roomId
            + "&&roomNumber=" + roomNumber;
        console.info(Url);
        $.ajax({
            url: Url,
            type: "post",
            success:function (data) {
                console.info(data);
                if(!data.isLogin) {
                    alert("请登录");
                }else if (data.roomNoReceive.length == 0) {
                    alert(data.error);
                } else {
                    console.info(data);
                    $('#order').modal('hide');
                    var info = "预定成功，房间号为" + data.roomNoReceive;
                    setTimeout("alert(\'"+info+"\')", 1000);
                }
            }
        })

    }

}

function phoneClick() {
    $("#connectPhone").css("color","black");
}
function identifyClick() {
    $("#identify").css("color","black");
}
$(
    function(){
        $(".form-input-datepicker").datepicker({
            autoclose:true,
            orientation:"top",
            todayHighlight:"true"
        })
        typeSelecterInit();
        numberSelecterInit(0);
})
