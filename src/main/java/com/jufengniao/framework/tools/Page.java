/**
 * 
 */
package com.jufengniao.framework.tools;

import java.io.Serializable;

/**
 * @author clientE
 *
 */
public final class Page implements Serializable{

	// 公共变量

    /**
	 * 
	 */
	private static final long serialVersionUID = 5454213913408152068L;

	public static final String ASC = "asc";

    public static final String DESC = "desc";
    
    public static final String ID = "id";

    public static final int MIN_PAGESIZE = 1;                  // 每页显示的最少记录数

    public static final int MAX_PAGESIZE = 50;                  // 每页显示的最大记录数

    // 分页参数
    protected int curPageNo = 1;                                    // 当前所在页码（在第几页）

    protected int pageSize = 20;                        // 当前每页显示的记录数

    protected boolean autoCount = false;                        // 查询对象时是否自动另外执行count查询获取总记录数

    protected int totalCount = 0;                                    // 记录总数

    protected int totalPage = 0;         //总页数
    

    
    /**
     * 默认构造函数
     */
    public Page() {
          super();
    }
    /**
     * 通过设置每页显示多少条记录来构造对象
     * @param pageSize
     */
    public Page(final int pageSize) {
          setPageSize(pageSize);
    }
    
    /**
     * 
     * @param pageSize
     * @param autoCount
     */
    public Page(final int pageSize, final boolean autoCount) {
          setPageSize(pageSize);
          this.autoCount = autoCount;
    }

    // 查询参数函数

    /**
     * 获得当前页的页号,序号从1开始,默认为1.
     */
    public int getCurPageNo() {
          return curPageNo;
    }

    /**
     * 设置当前页的页号,序号从1开始,低于1时自动调整为1.
     * @param curPageNo
     */
    public void setCurPageNo(final int curPageNo) {
          this.curPageNo = curPageNo;
          if (curPageNo < 1) {
                this.curPageNo = 1;
          }
    }

    /**
     * 获得每页的记录数量,默认为10.
     */
    public int getPageSize() {
          return pageSize;
    }

    /**
     * 设置每页的记录数量,超出MIN_PAGESIZE与MAX_PAGESIZE范围时会自动调整.
     * @param pageSize
     */
    public void setPageSize(final int pageSize) {

          this.pageSize = pageSize;

          if (pageSize < MIN_PAGESIZE) {
                this.pageSize = MIN_PAGESIZE;
          }
          else if (pageSize > MAX_PAGESIZE) {
                this.pageSize = MAX_PAGESIZE;
          }
    }



    /**
     * 根据curPageNo和pageSize（每页显示记录数）计算当前页第一条记录在总结果集中的位置,序号从0开始.
     */
    public int getFirst() {
          return ((curPageNo - 1) * pageSize);
    }

    /**
     * 查询对象时是否自动另外执行count查询获取总记录数,默认为false,仅在Criterion查询时有效.
     */
    public boolean isAutoCount() {
          return autoCount;
    }

    /**
     * 查询对象时是否自动另外执行count查询获取总记录数,仅在Criterion查询时有效.
     * @param autoCount
     */
    public void setAutoCount(final boolean autoCount) {
          this.autoCount = autoCount;
    }

    /**
     * 取得总记录数,默认值为0.
     */
    public int getTotalCount() {
          return totalCount;
    }
    

    /**
     * 设置总记录数
     * @param totalCount
     */
    public void setTotalCount(final int totalCount) {
          this.totalCount = totalCount;
    }
    

    public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	/**
     * 根据pageSize与totalCount计算总页数,默认值为-1.
     */
    public int getTotalPages() {
          if (totalCount < 0)
                return -1;
          int count = totalCount / pageSize;
          if (totalCount % pageSize > 0) {
                count++;
          }
          return count;
    }



    /**

     * 是否还有下一页.

     */
    public boolean isHasNext() {
          return (curPageNo + 1 <= getTotalPages());
    }



    /**

     * 取得下页的页号,序号从1开始.

     */
    public int getNextPage() {
          if (isHasNext())
                return curPageNo + 1;
          else
                return curPageNo;
    }


    /**

     * 是否还有上一页.

     */
    public boolean isHasPre() {
          return (curPageNo - 1 >= 1);
    }


    /**

     * 取得上页的页号,序号从1开始.

     */
    public int getPrePage() {
          if (isHasPre())
                return curPageNo - 1;
          else
                return curPageNo;
    }

}
