package com.javaee.hotel.tool;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class RoomItemStaticData {
    public RoomItemContent analyseItemContent(JSONObject jsonObject) {
        RoomItemContent roomItemContent = new RoomItemContent();
        roomItemContent.getRoomItemGroupList().add(analyseItemGroup(jsonObject,"a"));
        roomItemContent.getRoomItemGroupList().add(analyseItemGroup(jsonObject,"b"));
        roomItemContent.getRoomItemGroupList().add(analyseItemGroup(jsonObject,"c"));
        roomItemContent.getRoomItemGroupList().add(analyseItemGroup(jsonObject,"d"));
        roomItemContent.getRoomItemGroupList().add(analyseItemGroup(jsonObject,"e"));
        roomItemContent.getRoomItemGroupList().add(analyseItemGroup(jsonObject,"f"));
        roomItemContent.getRoomItemGroupList().add(analyseItemGroup(jsonObject,"g"));
        return roomItemContent;
    }
    public RoomItemGroup analyseItemGroup(JSONObject jsonObject,String key) {
        RoomItemGroup roomItemGroup = new RoomItemGroup();
        switch (key) {
            case "a": {
                roomItemGroup.setHeader("卫浴间");
                break;
            }
            case "b": {
                roomItemGroup.setHeader("娱乐设施");
                break;
            }
            case "c": {
                roomItemGroup.setHeader("舒适设施服务");
                break;
            }
            case "d": {
                roomItemGroup.setHeader("餐饮服务设施");
                break;
            }
            case "e": {
                roomItemGroup.setHeader("家具");
                break;
            }
            case "f": {
                roomItemGroup.setHeader("洗衣服务");
                break;
            }
            case "g": {
                roomItemGroup.setHeader("安保设施");
                break;
            }
            default:{
                break;
            }
        }
        JSONArray jsonArray = jsonObject.getJSONArray(key);
        int itemNum = jsonArray.size();
        if (itemNum == 0) {
            roomItemGroup.setRoomItemList(null);
        }else {
            for (int i = 1; i <= itemNum; i++) {
                analyseItem(roomItemGroup, i, key);
            }
        }
        return roomItemGroup;


    }
    public void analyseItem(RoomItemGroup group,int value,String key) {
        switch (key) {
            case "a": {
                switch (value) {
                    case 1: {
                        group.getRoomItemList().add(new RoomItem("icon-bath","浴缸"));
                        break;
                    }
                    case 2: {
                        group.getRoomItemList().add(new RoomItem("icon-hairdryer","吹风机"));
                        break;
                    }
                    case 3: {
                        group.getRoomItemList().add(new RoomItem("icon-slippers","拖鞋"));
                        break;
                    }
                    case 4: {
                        group.getRoomItemList().add(new RoomItem("icon-tower","毛巾"));
                        break;
                    }
                    case 5: {
                        group.getRoomItemList().add(new RoomItem("icon-mirror","镜子"));
                        break;
                    }
                    case 6: {
                        group.getRoomItemList().add(new RoomItem("icon-bathrobe","浴袍"));
                        break;
                    }
                    case 7: {
                        group.getRoomItemList().add(new RoomItem("icon-shampoo","洗浴用品"));
                        break;
                    }
                    default:{
                        break;
                    }
                }
                break;
            }
            case "b" : {
                switch (value) {
                    case 1: {
                        group.getRoomItemList().add(new RoomItem("icon-telephone","电话"));
                        break;
                    }
                    case 2: {
                        group.getRoomItemList().add(new RoomItem("icon-wifi","wifi"));
                        break;
                    }
                    case 3: {
                        group.getRoomItemList().add(new RoomItem("icon-television","电视"));
                        break;
                    }
                    default:{
                        break;
                    }

                }
                break;
            }
            case "c": {
                switch (value) {
                    case 1: {
                        group.getRoomItemList().add(new RoomItem("icon-aircondition","空调"));
                        break;
                    }
                    case 2: {
                        group.getRoomItemList().add(new RoomItem("icon-alarm","闹钟"));
                        break;
                    }
                    case 3: {
                        group.getRoomItemList().add(new RoomItem("icon-heating","暖气"));
                        break;
                    }
                    case 4: {
                        group.getRoomItemList().add(new RoomItem("icon-deaden","隔音降噪"));
                        break;
                    }
                    case 5: {
                        group.getRoomItemList().add(new RoomItem("aircondition","空调"));
                        break;
                    }
                    case 6: {
                        group.getRoomItemList().add(new RoomItem("aircondition","空调"));
                        break;
                    }
                    default:{
                        break;
                    }
                }
                break;
            }
            case "d": {
                switch (value) {
                    case 1: {
                        group.getRoomItemList().add(new RoomItem("icon-fridge","冰箱"));
                        break;
                    }
                    case 2: {
                        group.getRoomItemList().add(new RoomItem("icon-coffee","咖啡"));
                        break;
                    }
                    case 3: {
                        group.getRoomItemList().add(new RoomItem("icon-bar","迷你吧"));
                        break;
                    }
                    case 4: {
                        group.getRoomItemList().add(new RoomItem("icon-water","免费瓶装水"));
                        break;
                    }
                    default:{
                        break;
                    }
                }
                break;
            }
            case "e": {
                switch (value) {
                    case 1: {
                        group.getRoomItemList().add(new RoomItem("icon-desk","书桌"));
                        break;
                    }
                    case 2: {
                        group.getRoomItemList().add(new RoomItem("icon-sofa","沙发"));
                        break;
                    }
                    case 3: {
                        group.getRoomItemList().add(new RoomItem("icon-dining","独立用餐区"));
                        break;
                    }
                    default:{
                        break;
                    }
                }
                break;
            }
            case "f": {
                switch (value) {
                    case 1: {
                        group.getRoomItemList().add(new RoomItem("icon-wardrobe","衣柜"));
                        break;
                    }
                    case 2: {
                        group.getRoomItemList().add(new RoomItem("icon-hanger","衣架"));
                        break;
                    }
                    case 3: {
                        group.getRoomItemList().add(new RoomItem("icon-iron","熨斗"));
                        break;
                    }
                    default:{
                        break;
                    }
                }
                break;
            }
            case "g": {
                switch (value) {
                    case 1: {
                        group.getRoomItemList().add(new RoomItem("icon-safe","保险箱"));
                        break;
                    }
                    case 2: {
                        group.getRoomItemList().add(new RoomItem("icon-smoke","烟雾报警器"));
                        break;
                    }
                    default:{
                        break;
                    }
                }
                break;
            }
            default:{
                break;
            }
        }
    }
}
