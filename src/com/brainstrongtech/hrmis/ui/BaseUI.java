/**
 * 
 */
package com.brainstrongtech.hrmis.ui;

import java.io.IOException;

import com.brainstrongtech.hrmis.domain.Employee;

/**
 * 
 * UI模块行为接口
 * @author joeyang ong
 *
 */
public interface BaseUI {

	void render() throws IOException;

	void render(Employee e) throws IOException;
	 
}
