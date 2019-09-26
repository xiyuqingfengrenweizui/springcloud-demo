package weizuiren.cloud.weizuirencloudsboot.common;

/**
 * @PackageName:weizuiren.cloud.weizuirencloudsboot.common
 * @ClassName:BaseEndPoint
 * @Description:
 * @Author: justin zheng
 * @Date: 2019/9/23 13:40
 */
public class BaseEndPoint {

    protected DataResponse success() {
        return new DataResponse();
    }

    protected <T> DataResponse<T> success(T data) {
        return new DataResponse(data);
    }

}
