/**
 * 
 */
package com.jufengniao.master.tools;

/**
 * @author ClientE
 *
 */
public class MasterEnum {
	
	public static enum MenuEnum{
		
		ISPARENT(0L);
		private Long pid;
		
		private MenuEnum(Long pid){
			this.pid = pid;
		}
		
		public Long getValue(){
			return pid;
		}
	}
	
	public static enum FunctionEnum{
		
		CHECK(1),SEARCH(2);
		private Integer fid;
		
		private FunctionEnum(Integer fid){
			this.fid = fid;
		}
		public Integer getInteger(){
			return fid;
		}
		
		
	}

}
