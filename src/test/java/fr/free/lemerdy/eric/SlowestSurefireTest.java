package fr.free.lemerdy.eric;

import static org.fest.assertions.Assertions.assertThat;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.google.common.io.Resources;

public class SlowestSurefireTest {
	@Test
    public void should_read_single_surefire_test_report() throws URISyntaxException
    {
		SlowestSurefireReports slowestSurefireReports = new SlowestSurefireReports();
		List<TestReport> testReports = slowestSurefireReports.slowestTests();
		
		assertThat(testReports.size()).isEqualTo(7);
		assertThat(testReports.get(0).time).isEqualTo(0.014d);
		assertThat(testReports.get(0).classname).isEqualTo("PlainTest");
		assertThat(testReports.get(0).name).isEqualTo("should_test_1");
    }
	
	@Test
	public void should_read_test_dir() {
      URL resource = Resources.getResource("surefire-reports");
      Assert.assertNotNull(resource);
    }
}
