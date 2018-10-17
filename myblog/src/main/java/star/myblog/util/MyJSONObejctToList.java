package star.myblog.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import star.myblog.pojo.domain.DistrictDO;

/**
 * 将jsonObject 转化为list
 * TODO
 * @author huangzq
 * @time 2018年9月26日
 * @project_name myblog
 * @mailbox 1375529585@qq.com
 */
public class MyJSONObejctToList {
	
	private static String keyStr = "districts";
	
	public static List<DistrictDO> getDistrictList(JSONObject objParam){
		
		List<DistrictDO> result = new ArrayList<DistrictDO>();
		
		if (objParam.size() == 0) {
			return null;
		} else {
			JSONArray node = objParam.getJSONArray(keyStr);
			getListFromJsonArry(node, result);
			return result;
		}
		
	}

	private static void getListFromJsonArry(JSONArray node, List<DistrictDO> resultList) {

		if (node.size() > 0) {
			for (int i = 0; i < node.size(); i++) {
				JSONObject obj = node.getJSONObject(i);
				DistrictDO districtDO = new DistrictDO();
				districtDO.setAdcode(obj.get("adcode").toString());
				districtDO.setCenter(obj.get("center").toString());
				districtDO.setLevel(obj.get("level").toString());
				districtDO.setCitycode(obj.get("citycode").toString());
				districtDO.setName(obj.get("name").toString());
				JSONArray jsonArry = obj.getJSONArray(keyStr);
				resultList.add(districtDO);
				
				getListFromJsonArry(jsonArry, resultList);
				
			}
		} 
	}

}
