package br.com.studiotrek.resilience;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public abstract class ResilienceApplicationTests {

	@Before
	public void setUp() {
		FixtureFactoryLoader.loadTemplates("br.com.studiotrek.resilience");
	}

	@Before
	public abstract void init();
}
