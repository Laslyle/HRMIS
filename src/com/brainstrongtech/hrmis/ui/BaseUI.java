/**
 * 
 */
package com.brainstrongtech.hrmis.ui;

import java.io.IOException;

import com.brainstrongtech.hrmis.domain.Employee;

/**
 * 
 * UIģ����Ϊ�ӿ�
 * @author joeyang ong
 *
 */
public interface BaseUI {

	void render() throws IOException;

	void render(Employee e) throws IOException;
	 
}
