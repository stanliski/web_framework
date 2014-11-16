/**
 * 
 */
package com.jufengniao.framework.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author clientE
 *
 */

@Documented 
@Retention(RetentionPolicy.RUNTIME) 
@Target(ElementType.FIELD) 
public @interface Operation {

		String name() default "";
		int type() default 1;//查询条件
		String association() default "";
}
