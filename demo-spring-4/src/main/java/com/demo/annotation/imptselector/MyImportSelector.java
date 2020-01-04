package com.demo.annotation.imptselector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {

	/**
	 * 返回值即是要导入到容器中的组件全类名的数组; 可以返回空数组，不能返回 null.
	 * AnnotationMetadata：获取@Import注解的值和当前标注@Import注解的类的所有注解信息
	 */
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		
		System.out.println(importingClassMetadata);
		
		return new String[] {"com.demo.annotation.imptselector.Tiger"};
	}

}
