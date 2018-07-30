import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName SwitchTest
 * @Author ZhengRongZe
 * @Date 2018/7/29 21:00
 **/
public class SwitchTest {
    public static Map<String,List> get(int num){
        Map<String,List> map = new HashMap<String, List>();
        switch (num){
            case 1:
                map.put("风格",new ArrayList());
                break;
            case 2:
                map.put("风格",new ArrayList());
            case 3:
                map.put("风格",new ArrayList());
            case 4:
                map.put("风格",new ArrayList());
            case 5:
                map.put("风格",new ArrayList());
            case 56:
                map.put("风格",new ArrayList());
        }
        return map;
    }
}
