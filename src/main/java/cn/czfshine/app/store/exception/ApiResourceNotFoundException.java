package cn.czfshine.app.store.exception;

/**所有在/api下的*查询*，如果没找到都会抛出这个异常.
 * 不需要额外的信息，因为我们给前端返回404的语义就行
 * todo ：写入日志分析，理论上不应当有大量的找不到资源，在请求之前要验证
 * @author:czfshine
 * @date:2019/3/26 11:29
 */

public class ApiResourceNotFoundException extends Exception {

}
