var roomDetail = [];
function getDetail(){
    $.each(roomNo, function (i,element) {
        roomDetail.push($.parseJSON(element.roomNo));
    })
    console.info(roomDetail);
}
getDetail();