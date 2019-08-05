function turnClickable(index) {
    $($(".hotelMarker")[index]).css("background","url(/public/images/marker.png) no-repeat 0 -387px");
    $($(".hotelName")[index]).css("text-decoration","underline");
    markerHolder[index].hovered();
}
function turnUnClickable(index) {
    $($(".hotelMarker")[index]).css("background","url(/public/images/marker.png) no-repeat 0 -363px");
    $($(".hotelName")[index]).css("text-decoration","");
    markerHolder[index].unhovered();
}

