package com.javaee.hotel.tool;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.javaee.hotel.domain.Icon;
import com.javaee.hotel.domain.IconExample;
import com.javaee.hotel.mapper.IconMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class RoomItemStaticData {

    private Set<String> keys;
    private static RoomItemStaticData roomItemStaticData;
    @Autowired
    private IconMapper iconMapper;
    private List<Icon> iconGrouper;
    private HashMap iconGrouperMap;

    @PostConstruct
    public void init() {
        roomItemStaticData = this;
        roomItemStaticData.iconMapper = this.iconMapper;
    }

    public void initDate() {
        IconExample example = new IconExample();
        IconExample.Criteria criteria = example.createCriteria();
        criteria.andIconIdLessThan(0);
        iconGrouper = roomItemStaticData.iconMapper.selectByExample(example);
        iconGrouperMap = new HashMap();
        int size = iconGrouper.size();
        for( int i = 0 ; i < size ; i ++ ) {
            iconGrouperMap.put(iconGrouper.get(i).getGroupType(),iconGrouper.get(i).getIconText());
        }
    }

    public RoomItemStaticData () {

    }
    public RoomItemContent analyseItemContent(JSONObject jsonObject) {
        keys = jsonObject.keySet();
        List list = new ArrayList(keys);
        int length = list.size();
        RoomItemContent roomItemContent = new RoomItemContent();
        for ( int i = 0 ; i < length ; i ++ ) {
            roomItemContent.getRoomItemGroupList().add(analyseItemGroup(jsonObject,list.get(i).toString()));
        }
        return roomItemContent;
    }
    public RoomItemGroup analyseItemGroup(JSONObject jsonObject,String key) {
        initDate();
        RoomItemGroup roomItemGroup = new RoomItemGroup();
        roomItemGroup.setHeader(iconGrouperMap.get(key).toString());
        roomItemGroup.setType(key);
        JSONArray jsonArray = jsonObject.getJSONArray(key);
        int itemNum = jsonArray.size();
        if (itemNum == 0) {
//            roomItemGroup.setRoomItemList(null);
        }else {
            for (int i = 0; i < itemNum; i++) {
                analyseItem(roomItemGroup, jsonArray.getIntValue(i));
            }
        }
        return roomItemGroup;

    }
    public void analyseItem(RoomItemGroup group,int value) {
        Icon icon = roomItemStaticData.iconMapper.selectByPrimaryKey(value);
        group.getRoomItemList().add(new RoomItem(icon.getIconClass(),icon.getIconText()));
    }

    public RoomItemContent getDatabaseRoomItemContent() {
        initDate();
        RoomItemContent roomItemContent= new RoomItemContent();
        int grouperNumber = iconGrouper.size();
        HashMap typeMap = new HashMap();
        for ( int i = grouperNumber - 1 ; i >= 0 ; i -- ) {
            String header = iconGrouper.get(i).getIconText();
            RoomItemGroup roomItemGroup = new RoomItemGroup();
            roomItemGroup.setHeader(header);
            roomItemGroup.setType(iconGrouper.get(i).getGroupType());
            roomItemContent.getRoomItemGroupList().add(roomItemGroup);
            typeMap.put(iconGrouper.get(i).getGroupType(),grouperNumber-1-i);
        }
        IconExample example = new IconExample();
        IconExample.Criteria criteria = example.createCriteria();
        criteria.andIconIdGreaterThan(0);
        List<Icon> AllIcon = roomItemStaticData.iconMapper.selectByExample(example);
        int AllIconLength = AllIcon.size();
        for( int i = 0 ; i < AllIconLength ; i ++ ) {
            String type = AllIcon.get(i).getGroupType();
            int index =(Integer) typeMap.get(type);
            RoomItem roomItem = new RoomItemExtend();
            roomItem.setIcon(AllIcon.get(i).getIconClass());
            roomItem.setText(AllIcon.get(i).getIconText());
            ((RoomItemExtend) roomItem).setIconId(AllIcon.get(i).getIconId());
            roomItemContent.getRoomItemGroupList().get(index).getRoomItemList().add(roomItem);
        }
        return roomItemContent;

    }
}
