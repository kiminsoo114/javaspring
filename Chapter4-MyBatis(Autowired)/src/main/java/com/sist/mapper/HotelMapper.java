package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface HotelMapper {
@Select("SELECT name,address,score from seoul_hotel")
public List<HotelVO> hotelListData();
}
