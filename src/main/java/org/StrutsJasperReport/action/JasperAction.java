package org.StrutsJasperReport.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.JasperCompileManager;

import org.StrutsJasperReport.entity.Person;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("personDefault")
public class JasperAction extends ActionSupport {

	private static final long serialVersionUID = -4960821401206062907L;

	private List<Person> personList;

	public String execute() throws Exception {

		Person p1 = new Person("Mafalda", "Landeiro", 22);
		Person p2 = new Person("Isabel", "Ferreira", 19);
		Person p3 = new Person("Struts", "2", 25);
		Person p4 = new Person("Jasper", "Report", 20);

		this.personList = new ArrayList<Person>();
		this.personList.add(p1);
		this.personList.add(p2);
		this.personList.add(p3);
		this.personList.add(p4);

		try {
			JasperCompileManager
					.compileReportToFile(
							"C:\\Tools\\Tomcat\\apache-tomcat-7.0.62\\wtpwebapps\\StrutsJasperReport\\jasper\\person_jasper_template.jrxml",
							"C:\\Tools\\Tomcat\\apache-tomcat-7.0.62\\wtpwebapps\\StrutsJasperReport\\jasper\\person_compiled_template.jasper");
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}

		return SUCCESS;
	}

	public List<Person> getPersonList() {
		return personList;
	}
}
