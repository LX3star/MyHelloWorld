package star.myblog.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import star.myblog.dao.DistrictDOMapper;
import star.myblog.pojo.domain.DistrictDO;
import star.myblog.service.DistrictService;
import star.myblog.util.GaoDeRequestUtil;
import star.myblog.util.MyJSONObejctToList;

@Service
public class DistrictServiceImpl implements DistrictService{

	@Autowired
	private DistrictDOMapper districtDOMapper;
	
	
	@Override
	public Integer getDistrictData() throws UnsupportedEncodingException {
		String result = GaoDeRequestUtil.getData();
		JSONObject objResult = JSONObject.parseObject(result);
		List<DistrictDO>  dataList = MyJSONObejctToList.getDistrictList(objResult);
		int nums = 0;
		for (int i = 0; i < dataList.size(); i++) {
			DistrictDO districtDO = dataList.get(i);
			districtDOMapper.insertSelective(districtDO);
			nums++;
		}
		return nums;
	}
	
	public List<String> getCityCodeList(){
		List<String> resultList = new ArrayList<String>();
		resultList = districtDOMapper.selectCityCode();
		
		return resultList;
		
	}
	
	public Integer getStreetData() throws UnsupportedEncodingException {
		List<String> list = getCityCodeList();
		int nums = 0;
		for (int i = 0; i < list.size(); i++) {
			String cityCode = list.get(i).toString();
			String str = GaoDeRequestUtil.getCityData(cityCode);
			JSONObject objResult = JSONObject.parseObject(str);
			List<DistrictDO>  dataList = MyJSONObejctToList.getDistrictList(objResult);
			for (int j = 0; j < dataList.size(); j++) {
				DistrictDO districtDO = dataList.get(j);
				districtDOMapper.insertSelective(districtDO);
				nums++;
			}
			
		}
		return nums;
	}

}
