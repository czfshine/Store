package cn.czfshine.app.store.exception;

/**
 * @author:czfshine
 * @date:2019/3/21 20:31
 */

public class InstProductNotFoundException extends Exception {
    public InstProductNotFoundException(Integer id) {
        super("Can't find inst_product "+id);
    }
}
