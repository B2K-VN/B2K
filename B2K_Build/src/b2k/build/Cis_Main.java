package b2k.build;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Properties;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;

public class Cis_Main {

	private Project project;

	public void setProject(Project proj) {
		project = proj;
	}

	public void execute() throws BuildException, FileNotFoundException {
		project.setProperty("keycis", "CIS0001");
		System.out.println(project.getProperty("keycis"));
		Properties properties = System.getProperties();
		Iterator<Object> iterator = properties.keySet().iterator();
		// SystemColor.
		System.setErr(new PrintStream(new File("Error.log")));
		// PrintWriter sys = new PrintWriter(new
		// FileWriter("Debug.log"),true);
		System.setOut(new PrintStream("Debug.log"));
	}

}
