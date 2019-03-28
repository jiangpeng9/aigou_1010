package cn.itsource.aigou.common;

/**
 * 封装 返回json对象
 */
public class AjaxResult {
    private boolean success = true;//默认为true
    private String msg = "操作成功";//返回的信息 默认为成功
    private Object object = null;//返回的对象

    public static void main(String[] args) {
        //链式编程
        new AjaxResult().setMsg("ss").setSuccess(true).setObject("痴痴");
    }
    //为了链式编程提供静态方法 所有的set方法需要返回AjaxResult对象
    public static AjaxResult me(){
        return new AjaxResult();
    }
    public boolean isSuccess() {
        return success;
    }

    public AjaxResult setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public AjaxResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getObject() {
        return object;
    }

    public AjaxResult setObject(Object object) {
        this.object = object;
        return  this;
    }

    @Override
    public String toString() {
        return "AjaxResult{" +
                "success=" + success +
                ", msg='" + msg + '\'' +
                ", object=" + object +
                '}';
    }
}
