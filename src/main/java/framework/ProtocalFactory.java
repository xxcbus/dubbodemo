package framework;

import protocal.dubbo.DubboProtocal;
import protocal.http.HttpProtocal;

/**
 * @author LGS
 *
 * 系统启动时，加上vm options参数： -DprotocalName=dubbo,默认是dubbo协议
 */
public class ProtocalFactory {
    public static Protocal getProtocal(){
        String name = System.getProperty("protocalName");
        if(name==null||name.equals("")){
            return new DubboProtocal();
        }
        switch (name){
            case "http":
                return new HttpProtocal();
            case "dubbo":
                return new DubboProtocal();
            default:
                break;
        }
        return new DubboProtocal();
    }
}
