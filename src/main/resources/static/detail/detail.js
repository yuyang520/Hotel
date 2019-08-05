function typeSelecterInit() {
    for (let i = 0 ; i < roomDetailList.length ; i ++) {
        if ( roomDetailList[i].room.roomNumber > 0) {
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
    var length = roomDetailList[index].room.roomNumber > 5 ? 5 : roomDetailList[index].room.roomNumber;
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
    var datePickerCheck = dateCheck();
    var numbercheck = (numberSelecterJQ.val()!=null);
    var typecheck = (typeSelecterJQ.val()!=null);
    if (!connectPhoneCheck) {
        connectPhoneJQ.css("color","red");
    }
    if (!identifyCheck) {
        identifyJQ.css("color","red");
    }
    if (identifyCheck && connectPhoneCheck && datePickerCheck && numbercheck && typecheck) {
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
                    var href = "/alipay/payout?orderId="+data.orderId;
                    window.location.href = href;
                }
            }
        })

    }

}
function dataChanged() {
    var dateStart = new Date($("#datepickerStart").val());
    var dateEnd = new Date($("#datepickerEnd").val());
    var dayslast = ( dateEnd.getTime()-dateStart.getTime() ) / (24 * 3600 * 1000)
    if(dayslast<=0)
    {
        $("#selecter-type").empty();
        $("#selecter-number").empty();
        return;
    }
    var daysFormNow = (Math.floor(dateStart.getTime()/(24*3600*1000)) - Math.floor(new Date().getTime()/(24*3600*1000)))
    var typeSelect = $("#selecter-type").val();
    if(typeSelect == null) {
        typeSelect = 0;
    }
    var numberSelect = $("#selecter-number").val();
    if( numberSelect == null) {
        numberSelect = 1;
    }
    var leftNumber=[];
    for( let i = 0 ; i < leftNumberDeliver.length ; i ++ ) {
        var length = daysFormNow+dayslast;
        var lest = leftNumberDeliver[i].roomLeftNumberByDate[daysFormNow];
        for (let j = daysFormNow ; j < length ; j++ ) {
            if(leftNumberDeliver[i].roomLeftNumberByDate[j]<lest) {
                lest = leftNumberDeliver[i].roomLeftNumberByDate[j];
            }
        }
        leftNumber.push(lest);
    }

    for (let i = 0 ; i < leftNumber.length ; i ++) {
        $("#selecter-type").empty();
        if ( leftNumber[i] > 0) {
            var option = $("<option>");
            option.html(roomDetailList[i].room.chineseName);
            option.attr("value",i);
            $("#selecter-type").append(option);
        }
    }
    console.info("typeselect"+typeSelect);
    if(leftNumber[typeSelect]>0) {
        $("#selecter-type").val(typeSelect);
        $("#selecter-number").empty();
        var length = leftNumber[typeSelect] > 5 ? 5 : leftNumber[typeSelect];
        for (let k = 1 ; k <= length ; k ++) {
            var option = $("<option>");
            option.html(k);
            option.attr("value",k);
            $("#selecter-number").append(option);
        }
        if(leftNumber[typeSelect]>numberSelect){
            $("#selecter-number").val(numberSelect);
        }else{
            $("#selecter-number").val(leftNumber[typeSelect])
        }
    }else{
        $("#selecter-number").empty();
        var length = leftNumber[$("#selecter-type").val()] > 5 ? 5 : leftNumber[$("#selecter-type").val()];
        for (let k = 1 ; k <= length ; k++) {
            var option = $("<option>");
            option.html(k);
            option.attr("value",k);
            $("#selecter-number").append(option);
        }
    }
}
function dateCheck() {
    var dateStart = new Date($("#datepickerStart").val())
    var dateEnd = new Date($("#datepickerEnd").val())
    if(dateStart.getTime()>=dateEnd.getTime()) {
        return false;
    }else{
        return true;
    }
}
function phoneClick() {
    $("#connectPhone").css("color","black");
}
function identifyClick() {
    $("#identify").css("color","black");
}
function getOffsetDate(offset) {
    var endDate = new Date();
    endDate.setDate(endDate.getDate()+offset);
    return endDate;
}
$(
    function(){
        $(window).scroll(function () {
            var searchBar = $("#searchBar");
            var map = $("#map");
            if($(window).scrollTop()>90) {
                searchBar.css('position','fixed');
                searchBar.css('z-index','10');
                searchBar.css('top','0');

            }else {
                searchBar.css('position','');
                searchBar.css('z-index','');
                searchBar.css('top','');
            }
        });
        $(".form-input-datepicker").datepicker({
            autoclose:true,
            orientation:"bottom",
            todayHighlight:"true",
            format: "yyyy-mm-dd"
        })
        typeSelecterInit();
        for (let i = 0 ; i < roomDetailList.length ; i ++ ) {
            if ( roomDetailList[i].room.roomNumber != 0 ) {
                numberSelecterInit(i);
                break;
            }
        }
        $("#datepickerStart").datepicker('setStartDate',getOffsetDate(0));
        $("#datepickerStart").datepicker('setEndDate',getOffsetDate(29));
        $("#datepickerEnd").datepicker('setStartDate',getOffsetDate(1))
        $("#datepickerEnd").datepicker('setEndDate',getOffsetDate(30));
        $("#datepickerStart").datepicker("setDate",getOffsetDate(0));
        $("#datepickerEnd").datepicker("setDate",getOffsetDate(1));
        $("#datepickerStart").datepicker().on('changeDate',dataChanged);
        $("#datepickerEnd").datepicker().on('changeDate',dataChanged);


})
