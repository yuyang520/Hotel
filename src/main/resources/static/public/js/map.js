function MyMarker(text,position,className) {
    this._text = text;
    this._className = className;
    this._position = position;
    this._width = 33;
    this._height = 43;
}
MyMarker.prototype = new BMap.Overlay();
MyMarker.prototype.hovered = function () {
    this._marker.style.background="url(/public/images/marker.png) no-repeat 0px -45px";
}
MyMarker.prototype.unhovered = function () {
    this._marker.style.background="url(/public/images/marker.png) no-repeat 0px 0px";
}
MyMarker.prototype.initialize = function(map) {
    this._map = map;
    var span = document.createElement("span");
    span.style.position = "absolute";
    span.style.width = this._width+'px';
    span.style.height = this._height+'px';
    span.innerHTML = this._text;
    span.className = this._className;
    var that = this;
    span.getPosition =function(){
        return that._position;
    };
    span.onmouseover=function (ev) {
        $($(".hotelMarker")[that._text-1]).css("background","url(/public/images/marker.png) no-repeat 0 -387px");
        $($(".hotelName")[that._text-1]).css("text-decoration","underline");
        that.hovered();
    };
    span.onmouseout=function (ev) {
        $($(".hotelMarker")[that._text-1]).css("background","url(/public/images/marker.png) no-repeat 0 -363px");
        $($(".hotelName")[that._text-1]).css("text-decoration","");
        that.unhovered();
    }
    map.getPanes().markerPane.appendChild(span);
    this._marker = span;
    return span;
}
MyMarker.prototype.draw = function () {
    var position = this._map.pointToOverlayPixel(this._position);
    this._marker.style.left = position.x - this._width / 2 + "px";
    this._marker.style.top = position.y - this._height / 2 + "px";
}
// 实现显示方法
MyMarker.prototype.show = function(){
    if (this._marker){
        this._marker.style.display = "";
    }
}
// 实现隐藏方法
MyMarker.prototype.hide = function(){
    if (this._marker){
        this._marker.style.display = "none";
    }
}
MyMarker.prototype.addEventListener =function (type,fn) {
    this._marker.addEventListener('click',function (event) {fn(event)});
}
function addIntoMap(map,point,text,className) {
    var myMarker = new MyMarker(text,point,className);
    map.addOverlay(myMarker);
    return myMarker;
}
function setZoom(map,bPoints) {
    var view = map.getViewport(eval(bPoints));
    var mapZoom = view.zoom;
    var centerPoint = view.center;
    map.enableScrollWheelZoom(true);
    map.centerAndZoom(centerPoint, mapZoom);
}
function setBPoint(data,topIndex,bottomIndex,direction) {
    //direction 为true表示窗口向下滚动,反之向上
    var bPoint = [];
    var topOffset=$(window).scrollTop();
    var bottomOffset = $(window).scrollTop()+$(window).height();
    var target = false;
    if(direction) {
        var IndexItem = $($(".hotelItem")[topIndex.topIndex]);
        if((IndexItem.offset().top+IndexItem.height())>topOffset) {
            var point = new BMap.Point( data[topIndex.topIndex].hotelLongitude,
                data[topIndex.topIndex].hotelLatitude);
            bPoint.push(point);
            target = true;
        }
        var length = data.length;
        for(let i = topIndex.topIndex+1 ; i<length ; i++) {
            var tableItemTemp = $($(".hotelItem")[i]);
            var tableItemTempTopOffset = tableItemTemp.offset().top;
            var tableItemTempBottomOffset = tableItemTemp.offset().top + tableItemTemp.height();
            if( (tableItemTempTopOffset<bottomOffset&&tableItemTempBottomOffset>topOffset) ) {
                var point = new BMap.Point( data[i].hotelLongitude, data[i].hotelLatitude);
                bPoint.push(point);
                if(!target) {
                    topIndex.topIndex = i;
                    target=true;
                }
                if(i==length-1) {
                    bottomIndex.bottomIndex = i;
                }
            }
            else{
                if(target){
                    bottomIndex.bottomIndex = i-1;
                    break;
                }
            }
        }
    }else {
        var IndexItem = $($(".hotelItem")[bottomIndex.bottomIndex]);
        if(IndexItem.offset().top<bottomOffset) {
            var point = new BMap.Point( data[bottomIndex.bottomIndex].hotelLongitude,
                data[bottomIndex.bottomIndex].hotelLatitude);
            bPoint.push(point);
            target = true;

        }
        for(let i = bottomIndex.bottomIndex-1 ; i >=0 ; i--) {
            var tableItemTemp = $($(".hotelItem")[i]);
            var tableItemTempTopOffset = tableItemTemp.offset().top;
            var tableItemTempBottomOffset = tableItemTemp.offset().top + tableItemTemp.height();
            if( (tableItemTempTopOffset<bottomOffset&&tableItemTempBottomOffset>topOffset) ) {
                var point = new BMap.Point( data[i].hotelLongitude, data[i].hotelLatitude);
                bPoint.push(point);
                if(!target) {
                    bottomIndex.bottomIndex = i;
                    target=true;
                }
                if(i==0) {
                    topIndex.topIndex = 0;
                }
            }
            else{
                if(target){
                    topIndex.topIndex = i+1;
                    break;
                }
            }
        }

    }
    setZoom(map,bPoint);
}
function showMarkers(map,markerHolder,data) {
    for( let i = 0 ; i < data.length ; i ++ ) {
        var new_point = new BMap.Point( data[i].hotelLongitude,
            data[i].hotelLatitude);
        var marker = addIntoMap(map,new_point,i+1,"marker");
        markerHolder.push(marker);
        var content = "";
        content = "酒店名："+ data[i].hotelChineseName + "<br>地址：" +data[i].hotelAddress
            +"<br>描述:" +data[i].hotelProfile+"<br>"
            +"<a  href=\"/circlesearch?hotelLatitude="+data[i].hotelLatitude+"&&hotelLongitude="+data[i].hotelLongitude +"\">周边搜索</a>" ;
        marker.addEventListener("click",
            function(e){
                var p = e.target;
                console.info(p.getPosition());
                var point = new BMap.Point(p.getPosition().lng, p.getPosition().lat);
                var infoWindow = new BMap.InfoWindow(content, opts);
                map.openInfoWindow(infoWindow,point);
            });
    }
}