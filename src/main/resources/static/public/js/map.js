function MyMarker(text,position,className) {
    this._text = text;
    this._className = className;
    this._position = position;
    this._width = 33;
    this._height = 43;
}
MyMarker.prototype = new BMap.Overlay();
MyMarker.prototype.initialize = function(map) {
    this._map = map;
    var span = document.createElement("span");
    span.style.position = "absolute";
    span.style.width = this._width+'px';
    span.style.height = this._height+'px';
    span.innerHTML = this._text;
    span.className = this._className;
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
function addIntoMap(map,point,text,className) {
    console.info("add a marker")
    var myMarker = new MyMarker(text,point,className);
    map.addOverlay(myMarker);
    return myMarker;
}