package cn.itsource.aigou.utils;

public class BaseQuery {

    //int current, int size

    private Integer page=1;// 当前页int ===== integer
    private Integer rows=10;// 每页多少条

    private String keyword;//查询关键字
    public Integer getStart() {

        return (page-1)*rows;
    }
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }


}
