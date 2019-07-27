function showLayer() {
    console.info("click");
    var left = ($(window).width() - $("#layer").width())/2;
    var top  = ($(window).height() - $("#layer").height())/2;
    var offsetTop = $(window).scrollTop();
    console.info(offsetTop);
    $("#layer").css({"top": top+offsetTop, "left": left, "display": "block"});
}
function hideLayer() {
    $("#layer").css({"display": "none"});
}